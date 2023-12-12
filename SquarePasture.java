import java.util.*;
import java.io.*;

public class SquarePasture {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("square.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));
        StringTokenizer a = new StringTokenizer(f.readLine());
        int ax1 = Integer.parseInt(a.nextToken());
        int ay1 = Integer.parseInt(a.nextToken());
        int ax2 = Integer.parseInt(a.nextToken());
        int ay2 = Integer.parseInt(a.nextToken());

        StringTokenizer b = new StringTokenizer(f.readLine());
        int bx1 = Integer.parseInt(b.nextToken());
        int by1 = Integer.parseInt(b.nextToken());
        int bx2 = Integer.parseInt(b.nextToken());
        int by2 = Integer.parseInt(b.nextToken());

        boolean right = true;
        boolean above = true;

        int xdist = 0;
        int ydist = 0;
        int s = 0;

        if (ax1 >= bx1) {
            right = false;
        }

        if (ax2 <= bx2) {
            right = true;
        }

        if (by1 <= ay1) {
            above = false;
        }

        System.out.println(above);
        System.out.println(right);

        if (right && above) {
            xdist = Math.abs(bx2 - ax1);
            ydist = Math.abs(by2 - ay1);
            s = Math.max(xdist, ydist);
            out.println(s * s);
        }
        if (right && !above) {
            xdist = Math.abs(ax1 - bx2);
            ydist = Math.abs(ay2 - by1);
            s = Math.max(xdist, ydist);
            out.println(s * s);
        }
        if (!right && above) {
            xdist = Math.abs(bx1 - ax2);
            ydist = Math.abs(by2 - ay1);
            s = Math.max(xdist, ydist);
            out.println(s * s);
        }
        if (!right && !above) {
            xdist = Math.abs(ax2 - bx1);
            ydist = Math.abs(ay2 - by1);
            s = Math.max(xdist, ydist);
            out.println(s * s);
        }

        out.close();
    }
}
