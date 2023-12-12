import java.util.*;
import java.io.*;

public class Photoshoot {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("photo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());

        ArrayList<Integer> b = new ArrayList<>();
        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < n - 1; i++)
            b.add(Integer.parseInt(st.nextToken()));

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> aSorted = new ArrayList<>();
        for (int i = 1; i <= n; i++) aSorted.add(i);

        for (int s = 1; s <= n; s++) {
            for (int i = 0; i < n; i++) {
                if (i == 0) a.add(s);
                else a.add(b.get(i - 1) - a.get(i - 1));
            }
            if (a.containsAll(aSorted)) break;
            a.clear();
        }
        for (int i = 0; i < a.size(); i++)
            if (i == a.size() - 1) out.print(a.get(i));
            else out.print(a.get(i) + " ");
        out.close();
    }
}
