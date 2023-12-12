import java.util.*;
import java.io.*;

public class Marathon {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("marathon.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("marathon.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        int total = 0;
        for (int i = 1; i < n; i++)
            total += Math.abs(x[i] - x[i - 1]) + Math.abs(y[i] - y[i - 1]);
        int largestSkip = 0;
        for (int i = 1; i < n - 1; i++) {
            int dir = Math.abs(x[i + 1] - x[i]) + Math.abs(x[i] - x[i - 1]) + Math.abs(y[i + 1] - y[i]) + Math.abs(y[i] - y[i - 1]);
            int skip = Math.abs(x[i + 1] - x[i - 1]) + Math.abs(y[i + 1] - y[i - 1]);
            largestSkip = Math.max(largestSkip, dir - skip);
        }
        out.println(total - largestSkip);
        out.close();
    }
}
