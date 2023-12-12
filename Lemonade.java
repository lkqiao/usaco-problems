import java.util.*;
import java.io.*;

public class Lemonade {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("lemonade.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
        StringTokenizer a = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(a.nextToken());

        ArrayList<Integer> w = new ArrayList<Integer>();
        StringTokenizer b = new StringTokenizer(f.readLine());
        for (int i = 0; i < n; i++) {
            w.add(Integer.parseInt(b.nextToken()));
        }

        Collections.sort(w);
        Collections.reverse(w);

        out.println(formQueue(w));
        out.close();
    }

    public static int formQueue(ArrayList<Integer> w) {
        ArrayList<Integer> queue = new ArrayList<Integer>();
        for (int i = 0; i < w.size(); i++) {
            if (w.get(i) >= queue.size()) {
                queue.add(w.get(i));
            }
        }
        return queue.size();
    }
}
