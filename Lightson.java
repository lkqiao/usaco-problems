import java.util.*;
import java.io.*;

public class Lightson {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = 0;
        grid[0][0] = 1;
        int[][] switches = new int[m][4];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            for (int j = 0; j < 4; j++)
                switches[i][j] = Integer.parseInt(st.nextToken()) - 1;
        }
        out.println(turnOn(grid, switches));
        out.close();
    }

    public static int turnOn(int[][] grid, int[][] switches) {
        int ans = 1;
        for (int i = 0; i < switches.length; i++) {
            int currx = switches[i][0];
            int curry = switches[i][1];
            int onx = switches[i][2];
            int ony = switches[i][3];
            if (grid[currx][curry] == 1) {
                grid[onx][ony] = 1;
                ans++;
            }
        }
        return ans;
    }
}
