import java.util.*;
import java.io.*;

public class Snowboots {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("snowboots.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

        int[] l = new int[10000];
        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < n; i++) {
            l[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> depth = new LinkedList<>();
        Deque<Integer> dist = new LinkedList<>();
        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(f.readLine());
            depth.addLast(Integer.parseInt(st.nextToken()));
            dist.addLast(Integer.parseInt(st.nextToken()));
        }

        int i = 0;
        int disc = 0;

        while (i < n) {
            int currDepth = depth.peekFirst();
            int currDist = dist.peekFirst();

            if (currDepth < l[i]) {
                disc++;
                depth.removeFirst();
                dist.removeFirst();
                continue;
            }

            boolean ok = false;
            for (int j = i + currDist; j > i; j--) {
                if (currDepth > l[j]) {
                    i = j;
                    ok = true;
                    break;
                }
            }

            if (!ok) {
                disc++;
                depth.removeFirst();
                dist.removeFirst();
            }
        }

        out.println(disc);
        out.close();
    }
}
