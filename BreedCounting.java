import java.util.*;
import java.io.*;

public class BreedCounting {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("bcount.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] line = new int[n];
        int[][] ranges = new int[q][2];

        int[] h = new int[n];
        int[] g = new int[n];
        int[] j = new int[n];

        int[] presum_h = new int[n];
        int[] presum_g = new int[n];
        int[] presum_j = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            line[i] = Integer.parseInt(st.nextToken());

            if (line[i] == 1) {
                h[i] = 1;
            } else {
                h[i] = 0;
            }

            if (line[i] == 2) {
                g[i] = 1;
            } else {
                g[i] = 0;
            }

            if (line[i] == 3) {
                j[i] = 1;
            } else {
                j[i] = 0;
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(f.readLine());
            ranges[i][0] = Integer.parseInt(st.nextToken()) - 1;
            ranges[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        presum_h[0] = h[0];
        presum_g[0] = g[0];
        presum_j[0] = j[0];

        for (int i = 1; i < n; i++) {
            presum_h[i] = presum_h[i - 1] + h[i];
            presum_g[i] = presum_g[i - 1] + g[i];
            presum_j[i] = presum_j[i - 1] + j[i];
        }

        for (int i = 0; i < q; i++) {
            int hol = 0, gue = 0, jer = 0;
            if (ranges[i][0] - 1 < 0) {
                hol = presum_h[ranges[i][1]];
                gue = presum_g[ranges[i][1]];
                jer = presum_j[ranges[i][1]];
            } else {
                hol = presum_h[ranges[i][1]] - presum_h[ranges[i][0] - 1];
                gue = presum_g[ranges[i][1]] - presum_g[ranges[i][0] - 1];
                jer = presum_j[ranges[i][1]] - presum_j[ranges[i][0] - 1];
            }

            out.println(hol + " " + gue + " " + jer);
        }
        out.close();
    }
}
