import java.util.*;
import java.io.*;

public class RestStops {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("reststops.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int r_f = Integer.parseInt(st.nextToken());
        int r_b = Integer.parseInt(st.nextToken());

        int[] s = new int[n];
        int[] c = new int[n];
        boolean[] stop = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (c[i] > max) {
                stop[i] = true;
                max = c[i];
            }
        }

        long t_b, t_f;
        long last = 0, ans = 0;

        for (int i = 0; i < n; i++) {
            if (stop[i]) {
                t_b = (s[i] - last) * r_b;
                t_f = (s[i] - last) * r_f;
                ans += (t_f - t_b) * c[i];
                last = s[i];
            }
        }

        out.println(ans);
        out.close();
    }
}
