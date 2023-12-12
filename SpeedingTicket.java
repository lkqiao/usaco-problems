import java.util.*;
import java.io.*;

public class SpeedingTicket {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] roadLimit = new int[n][2];
        int[][] bessieSpeed = new int[m][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            for (int j = 0; j < 2; j++)
                roadLimit[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            for (int j = 0; j < 2; j++)
                bessieSpeed[i][j] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        for (int i = 1; i <= 100; i++) {
            int a = getInterval(roadLimit, i);
            int b = getInterval(bessieSpeed, i);
            if (bessieSpeed[b][1] > roadLimit[a][1])
                ans = Math.max(ans, bessieSpeed[b][1] - roadLimit[a][1]);
        }
        out.println(ans);
        out.close();
    }

    public static int getInterval(int[][] arr, int x) {
        int d = 0;
        for (int i = 0; i < arr.length; i++) {
            d += arr[i][0];
            if (d >= x)
                return i;
        }
        return -1;
    }
}
