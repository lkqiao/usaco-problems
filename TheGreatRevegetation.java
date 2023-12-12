import java.util.*;
import java.io.*;

public class TheGreatRevegetation {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("revegetate.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] pairs = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            for (int j = 0; j < pairs[0].length; j++)
                pairs[i][j] = Integer.parseInt(st.nextToken()) - 1;
        }
        ArrayList<Integer> pastures = new ArrayList<>();
        for (int i = 0; i < n; i++)
            pastures.add(1);
        ArrayList<Integer> rows;
        for (int i = 0; i < n; i++) {
            rows = search(pairs, i);
            for (int j : rows) {
                int val1 = pairs[j][0];
                int val2 = pairs[j][1];
                int change = Math.max(val1, val2);
                if (pastures.get(val1).equals(pastures.get(val2)))
                    pastures.set(change, pastures.get(change) + 1);
            }
        }
        for (int i : pastures)
            out.print(i);
        out.close();
    }

    public static ArrayList<Integer> search(int[][] arr, int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
                if (x == arr[i][j])
                    ans.add(i);
        return ans;
    }
}
