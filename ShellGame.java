import java.util.*;
import java.io.*;

public class ShellGame {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("shell.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));

        StringTokenizer a = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(a.nextToken());

        int[][] swaps = new int[n][2];
        int[] guess = new int[n];
        for (int i = 0; i < swaps.length; i++) {
            StringTokenizer b = new StringTokenizer(f.readLine());
            for (int j = 0; j < swaps[0].length; j++) {
                swaps[i][j] = Integer.parseInt(b.nextToken());
            }
            guess[i] = Integer.parseInt(b.nextToken());
        }

        ArrayList<Integer> pebble = new ArrayList<>();
        pebble.add(0);
        pebble.add(0);
        pebble.add(0);

        int guessRight;
        int max = 0;

        for (int i = 0; i < pebble.size(); i++) {
            pebble.set(i, 1);
            guessRight = 0;
            for (int j = 0; j < n; j++) {
                Collections.swap(pebble, swaps[j][1] - 1, swaps[j][0] - 1);
                if (pebble.get(guess[j] - 1) == 1) {
                    guessRight++;
                }
            }

            max = Math.max(max, guessRight);

            for (int j = 0; j < pebble.size(); j++) {
                pebble.set(j, 0);
            }
        }
        out.println(max);
        out.close();
    }
}
