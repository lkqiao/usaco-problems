import java.util.*;
import java.io.*;

public class Crossroad1 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("crossroad.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crossroad.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int ans = 0;
        ArrayList<Integer> seen = new ArrayList<>();
        ArrayList<Integer> status = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            int curr = Integer.parseInt(st.nextToken());
            int stat = Integer.parseInt(st.nextToken());
            if (seen.contains(curr))
                if (status.get(seen.lastIndexOf(curr)) != stat)
                    ans++;
            seen.add(curr);
            status.add(stat);
        }
        out.println(ans);
        out.close();
    }
}
