import java.util.*;
import java.io.*;

public class OutOfSorts {

    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("sort.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());

        int ans = 0;
        A = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] > A[i]) {
                    temp++;
                }
            }

            ans = Math.max(ans, temp);
        }

        out.println(++ans);
        out.close();
    }
}
