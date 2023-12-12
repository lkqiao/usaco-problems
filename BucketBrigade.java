import java.util.*;
import java.io.*;

public class BucketBrigade {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("buckets.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("buckets.out")));

        String[] grid = new String[10];

        for (int i = 0; i < grid.length; i++) {
            StringTokenizer a = new StringTokenizer(f.readLine());
            grid[i] = a.nextToken();
        }

        int xL = searchSX(grid, "L");
        int yL = searchSY(grid, "L");

        int xR = searchSX(grid, "R");
        int yR = searchSY(grid, "R");

        int xB = searchSX(grid, "B");
        int yB = searchSY(grid, "B");

        int path = 0;

        if ((xL == xR && xB == xR) && ((yR > yB && yL > yR) || (yR > yL && yB > yR))) {
            path = Math.abs(yB - yL) + 1;
        } else if (yL == yR && yR == yB && ((xR > xB && xL > xR) || (xR > xL && xB > xR))) {
            path = Math.abs(xB - xL) + 1;
        } else {
            path = Math.abs(xB - xL) + Math.abs(yB - yL) - 1;
        }

        out.println(path);
        out.close();
    }

    public static int searchSX(String grid[], String s) {
        for (int i = 0; i < grid.length; i++) { //rows
            if (grid[i].contains(s)) {
                return grid[i].indexOf(s);
            }
        }
        return -1;
    }

    public static int searchSY(String grid[], String s) {
        for (int i = 0; i < grid.length; i++) { //rows
            if (grid[i].contains(s)) {
                return i;
            }
        }
        return -1;
    }
}
