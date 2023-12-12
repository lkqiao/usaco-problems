import java.util.*;
import java.io.*;

public class CowTipping {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cowtip.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int lastRow = n - 1;
        int lastCol = n - 1;
        int ans = 0;
        ArrayList<String> grid = new ArrayList<>();
        ArrayList<String> fixedGrid = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            grid.add(st.nextToken());
            fixedGrid.add(fixedGridRow(n));
        }
        while (!compare(grid, fixedGrid)) {
            if (done(grid.get(lastRow))) {
                lastRow--;
                lastCol = n - 1;
                continue;
            }
            if(grid.get(lastRow).charAt(lastCol) == '1') {
                grid = untipperator(grid, lastRow, lastCol);
                ans++;
            }
            else lastCol--;
        }
        out.println(ans);
        out.close();
    }

    public static ArrayList<String> untipperator(ArrayList<String> grid, int y, int x) {
        for (int i = 0; i <= y; i++) {
            String row = grid.get(i);
            for (int j = 0; j <= x; j++) {
                if (row.charAt(j) == '1') row = row.substring(0, j) + '0' + row.substring(j + 1);
                else row = row.substring(0, j) + '1' + row.substring(j + 1);
                grid.set(i, row);
            }
        }
        return grid;
    }

    public static String fixedGridRow(int n) {
        String row = "";
        for (int i = 0; i < n; i++) {
            row += "0";
        }
        return row;
    }

    public static boolean compare(ArrayList<String> grid1, ArrayList<String> grid2) {
        for (int i = 0; i < grid1.size(); i++)
            if (!grid1.get(i).equals(grid2.get(i))) return false;
        return true;
    }

    public static boolean done(String str) {
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == '1') return false;
        return true;
    }
}
