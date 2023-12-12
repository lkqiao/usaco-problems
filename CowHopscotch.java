import java.util.*;
import java.io.*;

public class CowHopscotch {

    static char[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("hopscotch.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hopscotch.out")));

        int r, c;
        StringTokenizer st = new StringTokenizer(f.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        grid = new char[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(f.readLine());
            String s = st.nextToken();

            for (int j = 0; j < c; j++) {
                grid[i][j] = s.charAt(j);
            }
        }

        out.println(count(0, 0));
        out.close();
    }

    public static int count(int x, int y) {
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return 1;
        }

        int ans = 0;
        for (int i = x + 1; i < grid.length; i++) {
            for (int j = y + 1; j < grid[0].length; j++) {
                if (grid[x][y] != grid[i][j]) {
                    ans += count(i, j);
                }
            }
        }
        return ans;
    }
}
