import java.util.*;
import java.io.*;

public class BucketList {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("blist.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] list = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            for (int j = 0; j < 3; j++)
                list[i][j] = Integer.parseInt(st.nextToken());
        }
        int b, ans = Integer.MIN_VALUE;
        for (int t = 1; t <= 1000; t++) {
            b = 0;
            for (int[] i : list) {
                if (i[0] <= t && i[1] >= t) {
                    b += i[2];
                }
            }
            ans = Math.max(b, ans);
        }
        out.println(ans);
        out.close();
    }
}
