import java.io.*;
import java.util.*;

public class LostCow {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("lostcow.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int start = Integer.parseInt(st.nextToken());
        int cow = Integer.parseInt(st.nextToken());
        int totalDist = 0;
        int distance = 0;
        int currPos = 0;
        int lastPos = start;
        int step = 1;
        int finalMove = 0;

        for (int i = 0; i < 9 * Math.abs(start - cow); i++) {
            //move to search
            currPos = start + step;
            distance = Math.abs(lastPos - currPos);
            totalDist += distance;
            step *= -2;

            if (between(cow, lastPos, currPos)) {
                finalMove = Math.abs(lastPos - cow);
                totalDist = totalDist - distance + finalMove;
                break;
            }
            if (between(cow, currPos, lastPos)) {
                finalMove = Math.abs(lastPos - cow);
                totalDist = totalDist - distance + finalMove;
                break;
            }
            lastPos = currPos;
        }
        out.println(totalDist);
        out.close();
    }

    public static boolean between(int x, int min, int max) {
        return x > min && x < max;
    }
}
