import java.util.*;
import java.io.*;

public class MyCowAteMyHomework2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("homework.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long[] l = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            l[i] = Long.parseLong(st.nextToken());
        }

        long min = l[n - 1], sum = l[n - 1];
        long bestS = -1, bestL = 1;

        ArrayList<Integer> ans = new ArrayList<>();

        for (int k = n - 2; k >= 1; k--) {
            sum += l[k];
            min = Math.min(min, l[k]);
            int d = n - k - 1;;

            if ((sum - min) * bestL > bestS * d) {
                bestS = sum - min;
                bestL = d;
                ans.clear();
            }
            if ((sum - min) * bestL == bestS * d) {
                ans.add(k);
            }
        }

        Collections.sort(ans);
        for (int i : ans) {
            out.println(i);
        }
        out.close();
    }
}
