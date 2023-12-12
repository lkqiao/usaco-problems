import java.util.*;
import java.io.*;

public class BovineShuffle {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer> shuffle = new ArrayList<>();
        ArrayList<Integer> fin = new ArrayList<>();
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        ArrayList<Integer> third = new ArrayList<>();
        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < n; i++)
            shuffle.add(Integer.parseInt(st.nextToken()) - 1);
        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < n; i++)
            fin.add(Integer.parseInt(st.nextToken()));
        for (int i = 0; i < n; i++) {
            first.add(-1);
            second.add(-1);
            third.add(-1);
        }
        for (int i = 0; i < n; i++) {
            int curr = shuffle.get(i);
            int m = fin.get(curr);
            first.set(i, m);
        }
        for (int i = 0; i < n; i++) {
            int curr = shuffle.get(i);
            int m = first.get(curr);
            second.set(i, m);
        }
        for (int i = 0; i < n; i++) {
            int curr = shuffle.get(i);
            int m = second.get(curr);
            third.set(i, m);
        }
        for (int i : third)
            out.println(i);
        out.close();
    }
}
