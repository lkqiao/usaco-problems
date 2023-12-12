import java.util.*;
import java.io.*;

public class TheGreatRevegetationSilver {

    public static int[] g;
    public static String[] res;
    public static int[][] e;

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("revegetate.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        g = new int[n];
        res = new String[m];
        e = new int[m][2];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            res[i] = st.nextToken();
            for (int j = 0; j < 2; j++) {
                e[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        int cycles = 0;
        for (int i = 0; i < n; i++) {
            if (g[i] == 0) {
                dfs(i);
                cycles++;
            } else {
                break;
            }
        }

        String ans = "1";
        for (int i = 0; i < cycles; i++) {
            ans += "0";
        }
        out.println(ans);
        out.close();
    }

    public static void dfs(int v) {
        Stack<Integer> s = new Stack<>();
        s.add(v);
        while (!s.isEmpty()) {
            int v_temp = s.pop();
            if (g[v_temp] == 0) {
                g[v_temp] = 1;
            }

            ArrayList<Integer> neighbours = getNeighbours(v_temp);
            for (int n : neighbours) {
                if (g[n] == 0) {
                    s.add(n);
                }
            }
        }
    }

    public static ArrayList<Integer> getNeighbours(int v) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int[] i : e) {
            if (i[0] == v) {
                ans.add(i[1]);
            } else if (i[1] == v) {
                ans.add(i[0]);
            }
        }
        return ans;
    }
}
