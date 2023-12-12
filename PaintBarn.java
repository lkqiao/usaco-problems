import java.util.*;
import java.io.*;

public class PaintBarn {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("paintbarn.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] wall = new int[1001][1001];
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            x1[i] = Integer.parseInt(st.nextToken());
            y1[i] = Integer.parseInt(st.nextToken());
            x2[i] = Integer.parseInt(st.nextToken());
            y2[i] = Integer.parseInt(st.nextToken());

            for (int r = y1[i]; r < y2[i]; r++) {
                for (int c = x1[i]; c < x2[i]; c++) {
                    wall[r][c]++;
                }
            }
        }

        for (int[] i : wall) {
            for (int j : i) {
                if (j == k) {
                    ans++;
                }
            }
        }

        out.println(ans);
        out.close();
    }
}
