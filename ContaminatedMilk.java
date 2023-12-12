import java.util.*;
import java.io.*;

public class ContaminatedMilk {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("badmilk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("badmilk.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[][] data = new int[d][3];
        for (int i = 0; i < d; i++) {
            st = new StringTokenizer(f.readLine());
            for (int j = 0; j < 3; j++)
                data[i][j] = Integer.parseInt(st.nextToken());
        }
        int[][] sick = new int[s][2];
        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(f.readLine());
            for (int j = 0; j < 2; j++)
                sick[i][j] = Integer.parseInt(st.nextToken());
        }
        if (m == 1)
            out.println(n);
        else
            out.println(ans(data, sick, m));
        out.close();
    }

    public static ArrayList<Integer> searchD(int[][] arr, int m) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            if (m == arr[i][1])
                ans.add(i);
        return ans;
    }

    public static int searchS(int[][] arr, int m) {
        for (int i = 0; i < arr.length; i++)
            if (m == arr[i][0])
                return i;
        return -1;
    }

    public static int ans(int[][] arr1, int[][] arr2, int m) {
        ArrayList<Integer> temp;
        int ind, sInd, t, max = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            int ok = 0;
            temp = searchD(arr1, i);
            for (int j = 0; j < temp.size(); j++) {
                ind = temp.get(j);
                sInd = searchS(arr2, arr1[ind][0]);
                if (sInd != -1 && arr1[ind][2] <= arr2[sInd][1]) {
                    ok++;
                }
            }
            if (ok >= arr2.length) {
                t = temp.size();
                max = Math.max(t, max);
            }
        }
        return max;
    }
}
