import java.util.*;
import java.io.*;

public class CircularBarn {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] r = new int[n];
        for(int i = 0; i < n ; i++) {
            st = new StringTokenizer(f.readLine());
            r[i] = Integer.parseInt(st.nextToken());
        }
        int totalDist = 0;
        int min = Integer.MAX_VALUE;
        int roomsVisited;
        int room;

        for (int start = 0; start < n; start++) {
            roomsVisited = 0;
            room = start;
            while (roomsVisited < n) {
                totalDist += r[room % n] * roomsVisited;
                room++;
                roomsVisited++;
            }
            min = Math.min(min, totalDist);
            totalDist = 0;
        }

        out.println(min);
        out.close();
    }
}
