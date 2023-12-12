import java.util.*;
import java.io.*;

public class MilkSum {

    public static int n, T;
    public static int[] a, sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        sorted = a.clone();
        Arrays.sort(sorted);
        T = 0;
        for (int i = 0; i < n; i++) {
            T += (i + 1) * sorted[i];
        }

        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken());
            System.out.println(solve(c, r));
        }
    }

    public static int solve(int c, int r) {
        int sub = (search(a[c]) + 1) * a[c];
        int ind = 0;
        for (int i = 0; i < n; i++) {
            if (r < a[i] && i != c) ind++;
        }
        ind = n - ind;
        int add = ind * r;

        if (r < a[c]) {
            for (int i = ind - 1; i < n; i++) {
                if (sorted[i] == a[c]) break;
                add += sorted[i];
            }
        } else {
            for (int i = ind - 1; i >= 0; i--) {
                if (sorted[i] == a[c]) break;
                sub += sorted[i];
            }
        }

        return T - sub + add;
    }

    public static int search(int t) {
        int l = 0, r = sorted.length - 1;
        while (r - l > 1) {
            int mid = (r + l) / 2;
            if (sorted[mid] < t) l = mid + 1;
            else r = mid;
        }
        if (sorted[l] == t) return l;
        else if (sorted[r] == t) return r;
        return -1;
    }
}
