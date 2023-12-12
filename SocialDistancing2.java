import java.util.*;
import java.io.*;

public class SocialDistancing2 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("socdist2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist2.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            for (int j = 0; j < 2; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }
        int minDist = Integer.MAX_VALUE;
        sortbyColumn(grid, 0);
        for (int i = 0; i < n - 1; i++) {
            if (grid[i][1] != grid[i + 1][1]) {
                minDist = Math.min(minDist, grid[i + 1][0] - grid[i][0]);
            }
        }
        int r = minDist - 1;
        int ans = 0;
        int s;
        for (int i = 0; i < n - 1; i++) {
            s = i;
            if (grid[i][1] == 1) {
                for (int j = s; j < n - 1; j++) {
                    if (grid[j + 1][0] - grid[j][0] > r) {
                        ans++;
                        i = j;
                        break;
                    }
                }
            }
        }
        if (((grid[n - 2][1] == 0 || grid[n - 2][1] == 1) && grid[n - 1][1] == 1) && grid[n - 1][0] - grid[n - 2][0] > r) {
            ans++;
        }
        out.println(ans);
        out.close();
    }

    public static void sortbyColumn(int[][] arr, int col) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(final int[] entry1, final int[] entry2) {
                if (entry1[col] > entry2[col]) return 1;
                else return -1;
            }
        });
    }
}
