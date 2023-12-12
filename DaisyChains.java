import java.util.*;
import java.io.*;

public class DaisyChains {

    public static int n;
    public static int[] p, presum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int ans = n;

        p = new int[n];
        presum = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
            if (i > 0) {
                presum[i] = presum[i - 1] + p[i];
            } else {
                presum[i] = p[i];
            }
        }


        for (int r = 2; r <= n; r++) {
            ans += num_ranges(r);
        }

        System.out.println(ans);
    }

    public static int num_ranges(int r) {
        int ans = 0;

        for (int i = r - 1; i < n; i++) {
            int sum;
            if (i - r + 1 == 0) {
                sum = presum[i];
            } else {
                sum = presum[i] - presum[i - r];
            }

            for (int j = i; j >= i - r + 1; j--) {
                if (sum == p[j] * r) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
