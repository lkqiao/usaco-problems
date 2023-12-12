import java.util.*;
import java.io.*;

public class Triangles {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("triangles.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] x = new int[n];
        int[] y = new int[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        int ret = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j || x[i] != x[j]) continue;
                for(int k = 0; k < n; k++) {
                    if(i == k || y[i] != y[k]) continue;
                    ret = Math.max(ret, Math.abs(x[k] - x[i]) * Math.abs(y[j] - y[i]));
                }
            }
        }
        out.println(ret);
        out.close();
    }
}
