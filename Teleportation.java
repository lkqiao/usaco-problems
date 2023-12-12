import java.util.*;
import java.io.*;

public class Teleportation {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("teleport.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int ans = Integer.MAX_VALUE;
        int temp = 0;
        temp = Math.abs(b - a);
        ans = Math.min(ans, temp);
        temp = Math.abs(a - x) + Math.abs(b - y);
        ans = Math.min(ans, temp);
        temp = Math.abs(y - a) + Math.abs(b - x);
        ans = Math.min(ans, temp);
        out.println(ans);
        out.close();
    }
}
