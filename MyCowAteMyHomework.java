import java.io.*;
import java.util.*;

public class MyCowAteMyHomework {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("homework.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));

        int n = Integer.parseInt(br.readLine());
        int[] l = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            l[i] = Integer.parseInt(st.nextToken());
        }

        long min = Integer.MAX_VALUE;
        long sum = 0;
        long bestSum = 0;
        long bestLeft = 1;
        LinkedList<Integer> allValid = new LinkedList<>();
        for (int i = n - 1; i > 0; i--) {
            sum += l[i];
            min = Math.min(min, l[i]);
            if (i <= n - 2 && (sum - min) * bestLeft > bestSum * (n - i - 1)) {
                allValid.clear();
                bestSum = sum - min;
                bestLeft = n - i - 1;
            }
            if (i <= n - 2 && (sum - min) * bestLeft == bestSum * (n - i - 1)) {
                allValid.addFirst(i);
            }
        }

        for (int i : allValid) {
            out.println(i);
        }
        out.close();
    }
}