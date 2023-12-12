import java.util.*;
import java.io.*;

public class BessieGetsEven {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("geteven.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("geteven.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] list = new int[256][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            char c = st.nextToken().charAt(0);
            int val = Integer.parseInt(st.nextToken());

            if (even(val)) {
                list[c][0]++;
            } else {
                list[c][1]++;
            }
        }

        int ans = 0;
        for (int B = 0; B < 2; B++) {
            for (int E = 0; E < 2; E++) {
                for (int S = 0; S < 2; S++) {
                    for (int I = 0; I < 2; I++) {
                        for (int G = 0; G < 2; G++) {
                            for (int O = 0; O < 2; O++) {
                                for (int M = 0; M < 2; M++) {
                                    if (even((B + E + S + S + I + E) * (G + O + E + S) * (M + O + O))) {
                                        ans += list['B'][B] * list['E'][E] * list['S'][S] * list['I'][I] * list['G'][G] * list['O'][O] * list['M'][M];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        out.println(ans);
        out.close();
    }

    public static boolean even(int i) {
        return i % 2 == 0;
    }
}
