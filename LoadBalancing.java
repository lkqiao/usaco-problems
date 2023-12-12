import java.util.*;
import java.io.*;

public class LoadBalancing {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("balancing.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] xCoord = new int[n];
        int[] yCoord = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            xCoord[i] = Integer.parseInt(st.nextToken());
            yCoord[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int xDiv = xCoord[i] + 1;
                int yDiv = yCoord[j] + 1;

                int quad1 = 0, quad2 = 0, quad3 = 0, quad4 = 0;

                for (int k = 0; k < n; k++) {
                    if (xCoord[k] > xDiv && yCoord[k] > yDiv) {
                        quad1++;
                    }
                    if (xCoord[k] < xDiv && yCoord[k] > yDiv) {
                        quad2++;
                    }
                    if (xCoord[k] < xDiv && yCoord[k] < yDiv) {
                        quad3++;
                    }
                    if (xCoord[k] > xDiv && yCoord[k] < yDiv) {
                        quad4++;
                    }
                }

                int maxCows = Math.max(quad1, Math.max(quad2, Math.max(quad3, quad4)));
                ans = Math.min(ans, maxCows);
            }
        }

        out.println(ans);
        out.close();
    }
}
