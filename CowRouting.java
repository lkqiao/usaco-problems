import java.util.*;
import java.io.*;

public class CowRouting {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cowroute.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowroute.out")));

        int ans = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            boolean flag = false;

            st = new StringTokenizer(f.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int numCities = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(f.readLine());
            for (int j = 0; j < numCities; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == a) {
                    flag = true;
                }
                if (temp == b && flag) {
                    ans = Math.min(ans, cost);
                }
            }
        }

        if (ans == Integer.MAX_VALUE) {
            out.println(-1);
        } else {
            out.println(ans);
        }
        out.close();
    }
}
