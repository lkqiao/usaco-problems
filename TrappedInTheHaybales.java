import java.util.*;
import java.io.*;

public class TrappedInTheHaybales {

    static int n;
    static int[][] bales;


    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("trapped.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("trapped.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());

        int ans = 0;
        int curr_range;

        bales = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            bales[i][0] = Integer.parseInt(st.nextToken());
            bales[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(bales, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                Integer x = a[1];
                Integer y = b[1];
                return x.compareTo(y);
            }
        });

        for (int i = 0; i < n - 1; i++) {
            int rightEndPoint = i + 1;
            int leftEndPoint = i;

            int range = bales[rightEndPoint][1] - bales[leftEndPoint][1];

            while (rightEndPoint < n && leftEndPoint >= 0) {
                boolean broke = false;
                curr_range = bales[rightEndPoint][1] - bales[leftEndPoint][1];

                if (curr_range > bales[rightEndPoint][0]) { rightEndPoint++; broke = true; }
                if (curr_range > bales[leftEndPoint][0]) { leftEndPoint--; broke = true; }

                if (!broke) {
                    break;
                }
            }

            if(leftEndPoint >= 0 && rightEndPoint < n) {
                ans += range;
            }
        }

        out.println(ans);
        out.close();
    }
}
