import java.awt.*;
import java.util.*;
import java.io.*;

public class Race {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("race.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("race.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer> x = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x.add(Integer.parseInt(st.nextToken()));
        }
        long max, attempt;
        long p = 1;
        boolean reached = false;
        while (p * (p + 1) <= 2 * k) p++;
        p--;
        if (2 * k == p * (p + 1)) reached = true;
        for (int i : x) {
            if (i >= p) {
                if (reached) out.println(p);
                else out.println(p + 1);
                continue;
            }
            max = maxSpeed(k, i);
            attempt = findAttempt(max, i);
            if (k - attempt == 0) out.println(2 * max - i);
            else if (k - attempt <= max) out.println(2 * max - i + 1);
            else out.println(2 * max - i + 2);
        }
        out.close();
    }

    public static long maxSpeed(long k, long x) {
        return (long) Math.sqrt((2 * k + x * x - x) / 2);
    }

    public static long findAttempt(long s, long x) {
        return (2 * s * s - x * x + x) / 2;
    }
}
