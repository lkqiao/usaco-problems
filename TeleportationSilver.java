import java.util.*;
import java.io.*;

public class TeleportationSilver {

    static TreeMap<Integer, Integer> slope;


    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("teleport.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());

        slope = new TreeMap<>();

        long curr_f = 0, curr_slope = 0, curr_y = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            curr_f += Math.abs(a - b);
            if (Math.abs(a - b) < Math.abs(a)) { continue; }
            add(b, 2);
            if (a >= 0 && a >= b) {add(0, -1); add(2 * b, -1);}
            if (a >= 0 && a < b) {add(2 * b - 2 * a, -1); add(2 * a, -1);}
            if (a < 0 && a < b) {add(0, -1); add(2 * b, -1);}
            if (a < 0 && a >= b) {add(2 * b - 2 * a, -1); add(2 * a, -1);}
        }

        long min_f = curr_f;
        for (int i : slope.keySet()) {
            int new_y = i;
            curr_f += curr_slope * (new_y - curr_y);
            curr_y = new_y;
            curr_slope += slope.get(new_y);
            min_f = Math.min(min_f, curr_f);
        }

        out.println(min_f);
        out.close();
    }

    public static void add(int k, int v) {
        if (slope.get(k) != null) {
            slope.put(k, slope.get(k) + v);
        } else {
            slope.put(k, v);
        }
    }
}