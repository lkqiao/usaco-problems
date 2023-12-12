import java.util.*;
import java.io.*;

public class LifeguardsSilver {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("lifeguards.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] S = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            S[i][0] = Integer.parseInt(st.nextToken());
            S[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(S, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                Integer x = a[0];
                Integer y = b[0];
                if (x.equals(y)) {
                    Integer x2 = a[1];
                    Integer y2 = b[1];
                    return x2.compareTo(y2);
                } else {
                    return x.compareTo(y);
                }
            }
        });

        int minLoss = Integer.MAX_VALUE;

        for (int i = 1; i < n - 1; i++) {
            int intersection = S[i][1] - S[i + 1][0] + S[i - 1][1] - S[i][0];
            int size = S[i][1] - S[i][0];
            minLoss = Math.min(minLoss, size - intersection);
        }

        int start = S[0][1];
        int range = start - S[0][0];

        for (int i = 0; i < n - 1; i++) {
            if (S[i][1] > S[i + 1][0]) {
                range += S[i + 1][1] - start;
            } else {
                range += S[i + 1][1] - S[i + 1][0];
            }
            start = S[i + 1][1];
        }

        int ans = range - minLoss;
        out.println(ans);
        out.close();
    }
}
