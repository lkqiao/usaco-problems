import java.util.*;
import java.io.*;

public class Crossroad3 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cowqueue.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        Integer[][] list = new Integer[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            for (int j = 0; j < 2; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        sortArr(list);
        for (int i = 0; i < n; i++) {
            int arr = list[i][0];
            int t = list[i][1];
            if (i == 0)
                ans += arr + t;
            else {
                if (ans <= arr)
                    ans = arr + t;
                else if (ans > arr)
                    ans += t;
            }
        }
        out.println(ans);
        out.close();
    }

    public static void sortArr(Integer[][] arr) {
        Arrays.sort(arr, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] n, Integer[] m) {
                Integer a = n[0];
                Integer b = m[0];
                return a.compareTo(b);
            }
        });
    }
}
