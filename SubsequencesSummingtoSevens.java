import java.util.*;
import java.io.*;

public class SubsequencesSummingtoSevens {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("div7.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));

        int[] seq = new int[50000];
        int[] prefix = new int[50000];

        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int ans = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int[] first = new int[1000001];
        for (int i = 0; i < first.length; i++) {
            first[i] = Integer.MAX_VALUE;
        }

        prefix[0] = seq[0] % 7;
        first[prefix[0]] = 0;
        for (int i = 1; i < n; i++) {
            prefix[i] = (seq[i] + prefix[i - 1]) % 7;
            first[prefix[i]] = Math.min(first[prefix[i]], i);
            ans = Math.max(ans, i - first[prefix[i]]);
        }

        out.println(ans);
        out.close();
    }
}
