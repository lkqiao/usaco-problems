import java.io.*;
import java.util.*;

public class MilkPails {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("pails.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        out.println(dump(x, y, m));
        out.close();
    }

    public static int dump(int x, int y, int m) {
        int max = 0;
        int temp = 0;
        for (int i = 1; i <= m / x; i++) {
            for (int j = 0; j <= m / y; j++) {
                if (x * i + y * j <= m)
                    temp = x * i + y * j;
                max = Math.max(temp, max);
            }
        }
        return max;
    }
}
