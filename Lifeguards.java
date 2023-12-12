import java.util.*;
import java.io.*;

public class Lifeguards {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
        int n = Integer.parseInt(br.readLine());
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
        }
        int[] numCover = new int[1000];
        for (int i = 0; i < n; i++)
            for (int t = start[i]; t < end[i]; t++)
                numCover[t]++;
        int maxCover = 0;
        for (int i = 0; i < n; i++) {
            for (int t = start[i]; t < end[i]; t++)
                numCover[t]--;
            int covered = 0;
            for (int t = 0; t < 1000; t++)
                if (numCover[t] > 0)
                    covered++;
            maxCover = Math.max(maxCover, covered);
            for (int t = start[i]; t < end[i]; t++)
                numCover[t]++;
        }
        out.println(maxCover);
        out.close();
    }
}
