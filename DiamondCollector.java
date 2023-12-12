import java.util.*;
import java.io.*;

public class DiamondCollector {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Integer> size = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            size.add(Integer.parseInt(st.nextToken()));
        }
        int max = -1;
        for(int i = 0; i < n; i++) {
            int amt = 0;
            for(int j = 0; j < n; j++)
                if(size.get(j) >= size.get(i) && size.get(j) <= size.get(i) + k) amt++;
            max = Math.max(max, amt);
        }
        out.println(max);
        out.close();
    }
}
