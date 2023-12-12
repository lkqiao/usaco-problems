import java.util.*;
import java.io.*;

public class JustStalling {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int[] b = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        int max = 0;
        for (int j = 0; j < n; j++) {
            if (b[j] >= a[n - 1]) {
                max++;
            }
        }

        long ans = max;

        for (int i = 1; i < n; i++) {
            int temp_h = a[n - i - 1];
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (b[j] >= temp_h) {
                    cnt++;
                }
            }

            cnt -= i;
            ans *= cnt;
        }

        System.out.println(ans);
    }
}
