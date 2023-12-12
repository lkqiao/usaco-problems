import java.util.*;
import java.io.*;

public class SleepSort {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("sleepy.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        ArrayList<Integer> line = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            line.add(Integer.parseInt(st.nextToken()));
        }
        int ans = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (line.get(i) < line.get(i + 1))
                ans = i;
            else
                break;
        }
        out.println(ans);
        out.close();
    }
}
