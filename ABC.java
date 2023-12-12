import java.util.*;
import java.io.*;

public class ABC {

    public static long[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new long[7];
        for (int i = 0; i < 7; i++) {
            num[i] = Long.parseLong(st.nextToken());
        }

        long[] ans = new long[3];

        for (int a = 0; a < 7; a++) {
            for (int b = a + 1; b < 7; b++) {
                for (int c = b + 1; c < 7; c++) {
                    if (ok(num[a], num[b], num[c])) {
                        ans[0] = num[a];
                        ans[1] = num[b];
                        ans[2] = num[c];
                    }
                }
            }
        }

        Arrays.sort(ans);
        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }

    public static boolean ok(long a, long b, long c) {
        boolean[] cond = new boolean[7];

        for (int i = 0; i < 7; i++) {
            if (num[i] == a && !cond[0]) {
                cond[0] = true;
            } else if (num[i] == b && !cond[1]) {
                cond[1] = true;
            } else if (num[i] == c && !cond[2]) {
                cond[2] = true;
            } else if (num[i] == a + b && !cond[3]) {
                cond[3] = true;
            } else if (num[i] == b + c && !cond[4]) {
                cond[4] = true;
            } else if (num[i] == a + c && !cond[5]) {
                cond[5] = true;
            } else if (num[i] == a + b + c && !cond[6]) {
                cond[6] = true;
            }
        }

        for (boolean bool : cond) {
            if (!bool) {
                return false;
            }
        }
        return true;
    }
}
