import java.util.*;
import java.io.*;

public class EvenMoreOddPhotos {

    public static int e, o;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        e = 0;
        o = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp % 2 == 0) e++;
            else o++;
        }

        if (e < o) {
            int ans = 2 * e;
            o -= e;
            int ans1 = numGroups(ans, true);

            if (e > 0) {
                o++;
                int ans2 = numGroups(ans - 1, false);
                System.out.println(Math.max(ans1, ans2));
            } else {
                System.out.println(ans1);
            }
        } else if (e > o) {
            System.out.println(2 * o + 1);
        } else {
            System.out.println(e + o);
        }

    }

    public static int numGroups(int s, boolean getEvenNext) {
        int ans = s;
        for (int a = 1; a <= o; a++) {
            for (int b = 1; b <= o; b++) {
                for (int x = 0; x * a <= o; x++) {
                    for (int y = 0; y * b <= o; y++) {
                        int temp_ans = s;

                        if (getEvenNext) {
                            if (a % 2 == 0 && b % 2 == 1 && x <= y + 1 && x >= y) {
                                if (a * x + b * y == o) {
                                    temp_ans += x + y;
                                }
                            }
                        } else {
                            if (a % 2 == 0 && b % 2 == 1 && y <= x + 1 && y >= x) {
                                if (a * x + b * y == o) {
                                    temp_ans += x + y;
                                }
                            }
                        }

                        ans = Math.max(ans, temp_ans);
                    }
                }
            }
        }
        return ans;
    }
}
