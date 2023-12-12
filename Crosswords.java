import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.io.*;

public class Crosswords {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("crosswords.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crosswords.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<String> grid = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            grid.add(st.nextToken());
        }

        int numClue = 0;
        ArrayList<ArrayList<Integer>> cluePos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean hor = false;
                boolean ver = false;

                if (grid.get(i).charAt(j) == '.') {
                    if (j < m - 2) {
                        if (j == 0 && grid.get(i).charAt(j + 1) == '.' && grid.get(i).charAt(j + 2) == '.') {
                            hor = true;
                        } else if (j > 0 && grid.get(i).charAt(j - 1) == '#' && grid.get(i).charAt(j + 1) == '.' && grid.get(i).charAt(j + 2) == '.') {
                            hor = true;
                        }
                    }
                    if (i < n - 2) {
                        if (i == 0 && grid.get(i + 1).charAt(j) == '.' && grid.get(i + 2).charAt(j) == '.') {
                            ver = true;
                        } else if (i > 0 && grid.get(i - 1).charAt(j) == '#' && grid.get(i + 1).charAt(j) == '.' && grid.get(i + 2).charAt(j) == '.') {
                            ver = true;
                        }
                    }
                    if (hor || ver) {
                        numClue++;
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(i + 1);
                        temp.add(j + 1);
                        cluePos.add(temp);
                    }
                }
            }
        }
        out.println(numClue);
        for (ArrayList<Integer> i : cluePos) {
            out.println(i.get(0) + " " + i.get(1));
        }
        out.close();
    }
}
