import java.util.*;
import java.io.*;

public class StuckInARut {

    public static int n;
    public static int[] d;
    public static int[][] pos, pos_n, pos_e;
    public static String[] dir;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        dir = new String[n];
        pos = new int[n][2];
        pos_n = new int[n][2];
        pos_e = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            dir[i] = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pos[i][0] = x;
            pos[i][1] = y;

            if (dir[i].equals("N")) {
                pos_n[i][0] = x;
                pos_n[i][1] = y;
            } else {
                pos_e[i][0] = x;
                pos_e[i][1] = y;
            }
        }

        Arrays.sort(pos_n, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                Integer x = a[0];
                Integer y = b[0];
                return x.compareTo(y);
            }
        });

        Arrays.sort(pos_e, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                Integer x = a[1];
                Integer y = b[1];
                return x.compareTo(y);
            }
        });

        d = new int[n];

        for (int i = 0; i < n; i++) {
            if (dir[i].equals("N"))
                d[i] = find_dist_n(i);
            else
                d[i] = find_dist_e(i);
        }

        for (int i : d) {
            if (i == 2000000000)
                System.out.println("Infinity");
            else
                System.out.println(i);
        }
    }

    public static int find_dist_n(int c) {
        int curr_x = pos[c][0], curr_y = pos[c][1];
        int ans = 2000000000;

        for (int i = 0; i < n; i++) {
            int temp_x = pos_e[i][0], temp_y = pos_e[i][1];

            if (temp_x > 0 && temp_y > 0) {
                if (temp_x < curr_x && temp_y > curr_y) {
                    if (temp_y - curr_y > curr_x - temp_x) {
                        ans = Math.min(ans, temp_y - curr_y);
                    }
                }
            }
        }
        return ans;
    }

    public static int find_dist_e(int c) {
        int curr_x = pos[c][0], curr_y = pos[c][1];
        int ans = 2000000000;

        for (int i = 0; i < n; i++) {
            int temp_x = pos_n[i][0], temp_y = pos_n[i][1];

            if (temp_x > 0 && temp_y > 0) {
                if (temp_x > curr_x && temp_y < curr_y) {
                    if (temp_x - curr_x > curr_y - temp_y) {
                        ans = Math.min(ans, temp_x - curr_x);
                    }
                }
            }
        }
        return ans;
    }
}
