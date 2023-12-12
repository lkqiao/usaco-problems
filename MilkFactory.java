import java.util.*;
import java.io.*;

public class MilkFactory {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("factory.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("factory.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] paths = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(f.readLine());
            for (int j = 0; j < 2; j++) {
                paths[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<Integer> locationi = new ArrayList<>();
        int counter = 0;

        for (int i = 0; i < n; i++) {
            if (search(paths, i + 1) == -1) {
                locationi.add(i + 1);
                counter++;
            }
        }

        if(counter == n) {
            locationi.add(-1);
        }

        out.println(Collections.min(locationi));
        out.close();
    }

    public static int search(int[][] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == x) {
                return i;
            }
        }
        return -1;
    }
}
