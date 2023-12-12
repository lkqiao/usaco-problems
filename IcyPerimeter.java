import java.util.*;
import java.io.*;

public class IcyPerimeter {

    static char[][] grid;
    static boolean[][] visited;
    static int[][] region;
    static int n;
    static int[] a = new int[1000000], p = new int[1000000];

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("perimeter.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());

        grid = new char[n][n];
        visited = new boolean[n][n];
        region = new int[n + 2][n + 2];
        int bestA = 0, bestP = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            String s = st.nextToken();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }

        int r = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '#') {
                    bfs(i, j, ++r);
                }
            }
        }

        perimeter();

        for (int i = 0; i < a.length; i++) {
            if (a[i] > bestA || (a[i] == bestA && p[i] < bestP)) {
                bestA = a[i];
                bestP = p[i];
            }
        }

        out.println(bestA + " " + bestP);
        out.close();
    }

    public static void bfs(int x, int y, int r) {

        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();

        queueX.add(x);
        queueY.add(y);

        while (!queueX.isEmpty() && !queueY.isEmpty()) {

            int row = queueX.poll();
            int col = queueY.poll();

            if (row < 0 || col < 0 || row >= n || col >= n || visited[row][col] || grid[row][col] == '.') {
                a[r]--;
            } else {
                visited[row][col] = true;
                region[row + 1][col + 1] = r;

                queueX.add(row);
                queueY.add(col - 1);
                a[r]++;

                queueX.add(row);
                queueY.add(col + 1);
                a[r]++;

                queueX.add(row - 1);
                queueY.add(col);
                a[r]++;

                queueX.add(row + 1);
                queueY.add(col);
                a[r]++;
            }
        }

        a[r]++;
    }

    public static void perimeter() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int r = region[i][j];
                if (r == 0) continue;
                if (region[i - 1][j] == 0) p[r]++;
                if (region[i + 1][j] == 0) p[r]++;
                if (region[i][j - 1] == 0) p[r]++;
                if (region[i][j + 1] == 0) p[r]++;
            }
        }
    }
}
