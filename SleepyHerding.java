import java.util.*;
import java.io.*;

public class SleepyHerding {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("herding.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (b > c) {
            int temp = b;
            b = c;
            c = temp;
        }
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (c == a + 2)
            out.println(0);
        else if (b == a + 2 || c == b + 2)
            out.println(1);
        else
            out.println(2);
        out.println(Math.max(b - a, c - b) - 1);
        out.close();
    }
}
