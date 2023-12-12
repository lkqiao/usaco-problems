import java.util.*;
import java.io.*;

public class MilkingOrder {
    static ArrayList<Integer> ordered = new ArrayList<>();
    static int[][] pos;
    static int[] line;

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milkorder.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkorder.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        pos = new int[k][2];
        line = new int[n];
        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < m; i++)
            ordered.add(Integer.parseInt(st.nextToken()));
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(f.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }
        int s;
        if (ordered.contains(1)) s = ordered.indexOf(1);
        else s = 0;
        for (int i = s; i < line.length; i++) {
            if (ok(i)) {
                out.println(i + 1);
                break;
            }
        }
        out.close();
    }

    public static boolean ok(int p) {
        for (int[] i : pos) {
            if (i[1] == p)
                return false;
        }
        int d1, d2;
        if (!ordered.contains(1)) {
            if (compare(p) == -1) {
                return true;
            } else {
                int temp = 0;
                for (int[] i : pos) {
                    if (compare(p) == i[1])
                        temp = i[0];
                }
                d1 = ordered.indexOf(temp);
                d1 -= removeDuplicates(d1);
                d2 = unused(p);
            }
        } else {
            d1 = ordered.indexOf(1);
            d1 -= removeDuplicates(d1);
            d2 = unused(p) + 1;
        }
        return d2 > d1;
    }

    public static int compare(int p) {
        for (int i = p; i < line.length; i++)
            for (int[] j : pos)
                if (i == j[1])
                    return i;
        return -1;
    }

    public static int removeDuplicates(int x) {
        int ans = 0;
        for (int[] i : pos)
            if (ordered.contains(i[0]))
                ans++;
        return ans;
    }

    public static int unused(int p) {
        int ans = 0;
        boolean ok = true;
        for (int i = 0; i < p; i++) {
            for (int[] j : pos)
                if (i == j[1])
                    ok = false;
            if (ok)
                ans++;
            else
                ok = true;
        }
        return ans;
    }
}
