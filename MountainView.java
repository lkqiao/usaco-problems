import java.util.*;
import java.io.*;

public class MountainView {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("mountains.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());

        int ans = 1;

        int[][] base = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            base[i][0] = x - y;
            base[i][1] = x + y;
        }

        Arrays.sort(base, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                Integer x = a[0];
                Integer y = b[0];
                if (x.equals(y)) {
                    Integer x2 = a[1];
                    Integer y2 = b[1];
                    return -x2.compareTo(y2);
                } else {
                    return x.compareTo(y);
                }
            }
        });

        for (int[] i : base) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        int max = base[0][1];
        int k = 1;
        for (int i = 1; i < n; i++) {
            if (base[i][1] > max) {
                ans++;
                max = base[i][1];
            }
        }

        out.println(ans);
        out.close();
    }
}
