import java.util.*;
import java.io.*;

public class HighCard {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("highcard.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));

        StringTokenizer a = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(a.nextToken());
        int wins = 0;

        ArrayList<Integer> elsie = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            StringTokenizer b = new StringTokenizer(f.readLine());
            elsie.add(Integer.parseInt(b.nextToken()));
        }

        //make consecutive int arraylist up to 2n
        ArrayList<Integer> bessie = new ArrayList<Integer>();
        for (int i = 0; i < 2 * n; i++) {
            bessie.add(i + 1);
        }

        //remove elsie's integers to get bessie's cards
        for (int i = 0; i < n; i++) {
            bessie.remove(Collections.binarySearch(bessie, elsie.get(i)));
        }

        Collections.sort(bessie);
        Collections.sort(elsie);

        while (elsie.size() > 0) {
            //if max of elsie > max of bessie
            if (Collections.max(elsie) > Collections.max(bessie)) {
                elsie.remove(Collections.max(elsie));
            }
            //if max of bessie > max of elsie
            if (Collections.max(elsie) < Collections.max(bessie)) {
                elsie.remove(Collections.max(elsie));
                bessie.remove(Collections.max(bessie));
                wins++;
            }
        }

        out.println(wins);
        out.close();
    }
}
