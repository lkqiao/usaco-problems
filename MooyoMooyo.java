import java.util.*;
import java.io.*;

public class MooyoMooyo {

    static char[][] board;
    static boolean[][] visited;
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("mooyomooyo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new char[n][10];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            String s = st.nextToken();
            for (int j = 0; j < 10; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        boolean done = false;

        while (!done) {
            visited = new boolean[n][10];
            done = true;

            shiftDown();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 10; j++) {
                    if (!visited[i][j] && board[i][j] != '0' && bfs(i, j, board[i][j]) >= k) {
                        done = false;
                        replace(i, j, board[i][j]);
                    }
                }
            }
        }

        for (char[] i : board) {
            for (char j : i) {
                out.print(j);
            }
            out.println();
        }

        out.close();
    }

    public static int bfs(int x, int y, char c) {
        int size = 1;

        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();

        queueX.add(x);
        queueY.add(y);

        while (!queueX.isEmpty() && !queueY.isEmpty()) {
            int row = queueX.poll();
            int col = queueY.poll();

            if (row < 0 || col < 0 || row >= n || col >= 10 || visited[row][col] || board[row][col] != c) {
                size--;
                continue;
            }

            visited[row][col] = true;

            queueX.add(row);
            queueY.add(col - 1);
            size++;
            queueX.add(row);
            queueY.add(col + 1);
            size++;
            queueX.add(row - 1);
            queueY.add(col);
            size++;
            queueX.add(row + 1);
            queueY.add(col);
            size++;
        }

        return size;
    }

    public static void replace(int x, int y, char c) {
        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();

        queueX.add(x);
        queueY.add(y);

        while (!queueX.isEmpty() && !queueY.isEmpty()) {
            int row = queueX.poll();
            int col = queueY.poll();

            if (row < 0 || col < 0 || row >= n || col >= 10 || board[row][col] != c) {
                continue;
            }

            board[row][col] = '0';

            queueX.add(row);
            queueY.add(col - 1);
            queueX.add(row);
            queueY.add(col + 1);
            queueX.add(row - 1);
            queueY.add(col);
            queueX.add(row + 1);
            queueY.add(col);
        }
    }

    public static void shiftDown() {
        for (int col = 0; col < 10; col++) {

            int bound = 0;
            int start = 100;
            int shift = -1;

            while (start > bound) {
                for (int i = 0; i < n; i++) {
                    if (board[i][col] != '0') {
                        bound = i;
                        break;
                    }
                }

                for (int i = n - 1; i >= 1; i--) {
                    if (board[i][col] == '0') {
                        start = i;
                        break;
                    }
                }

                if (start == 100) {
                    break;
                }

                for (int i = start - 1; i >= 0; i--) {
                    if (board[i][col] != '0') {
                        shift = start - i;
                        break;
                    }
                }

                if (shift == -1) {
                    break;
                }

                for (int i = start - shift; i >= 0; i--) {
                    board[i + shift][col] = board[i][col];
                    board[i][col] = '0';
                }
            }
        }
    }
}
