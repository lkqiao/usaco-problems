import java.io.*;
import java.util.*;

public class CowGymnastics {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("gymnastics.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));

        StringTokenizer line1 = new StringTokenizer(f.readLine());
        int k = Integer.parseInt(line1.nextToken()); //practice sessions
        int n = Integer.parseInt(line1.nextToken()); //num of cows


        int[][] grid = new int[k][n];
        for (int i = 0; i < k; i++) {
            StringTokenizer newline = new StringTokenizer(f.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(newline.nextToken());
            }
        }

        int[] currpair = new int[2];
        int counter = 0;
        ArrayList<Integer> pairsfound = new ArrayList<Integer>();
        int pairs = 0;

        for (int i = 0; i < k; i++) { //first start on row 0, then 1, etc.
            for (int start = 0; start < n - 1; start++) { //first start on col 0, then 1, etc.
                for (int j = 0; j < n - start - 1; j++) { //how many runs per row
                    currpair[0] = grid[i][start];
                    currpair[1] = grid[i][start + j + 1];

                    for (int row = 0; row < k; row++) {
                        if (sFront(grid, n, currpair[0], row) < sAfter(grid, n, currpair[1], row)) {
                            counter++;
                        }
                    }

                    if (counter == k) {
                        pairs++;
                    }

                    counter = 0;
                }
            }
        }

        out.println(pairs / k);
        out.close();
    }

    static int sFront(int arr[][], int n, int x, int row) { //x = what you're trying to find
        for (int i = 0; i < n; i++) {
            if (arr[row][i] == x) {
                return i; //returns column value within the row you inputted
            }
        }
        return -1;
    }

    static int sAfter(int arr[][], int n, int x, int row) { //x = what you're trying to find
        for (int i = 0; i < n; i++) {
            if (arr[row][i] == x) {
                return i; //returns column value within the row you inputted
            }
        }
        return -1;
    }
}