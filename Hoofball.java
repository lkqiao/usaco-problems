import java.util.*;
import java.io.*;

public class Hoofball {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("hoofball.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer> pos = new ArrayList<>();
        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < n; i++)
            pos.add(Integer.parseInt(st.nextToken()));
        Collections.sort(pos);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (numPass(pos, i) == 0)
                ans++;
            if (numPass(pos, i) == 1)
                if (i == 0) {
                    if (numPass(pos, i + 1) == 1 && pos.get(i + 2) - pos.get(i + 1) > pos.get(i + 3) - pos.get(i + 2))
                        ans++;
                } else if (i == n - 2) {
                    if (numPass(pos, i + 1) == 1 && pos.get(i) - pos.get(i - 1) > pos.get(i - 1) - pos.get(i - 2))
                        ans++;
                } else if (i < n - 1 && i > 1) {
                    if (numPass(pos, i + 1) == 1 && pos.get(i) - pos.get(i - 1) > pos.get(i - 1) - pos.get(i - 2) && pos.get(i + 2) - pos.get(i + 1) > pos.get(i + 3) - pos.get(i + 2))
                        ans++;
                }
        }
        out.println(ans);
        out.close();
    }

    public static int numPass(ArrayList<Integer> arr, int i) {
        int ans = 0;
        if (i == 0) {
            if (arr.get(i + 1) - arr.get(i) <= arr.get(i + 2) - arr.get(i + 1))
                ans++;
        } else if (i == arr.size() - 1) {
            if (arr.get(i) - arr.get(i - 1) < arr.get(i - 1) - arr.get(i - 2))
                ans++;
        } else if (i == 1) {
            if (arr.get(i + 1) - arr.get(i) <= arr.get(i + 2) - arr.get(i + 1))
                ans++;
            ans++;
        } else if (i == arr.size() - 2) {
            if (arr.get(i) - arr.get(i - 1) < arr.get(i - 1) - arr.get(i - 2))
                ans++;
            ans++;
        } else {
            if (arr.get(i) - arr.get(i - 1) < arr.get(i - 1) - arr.get(i - 2))
                ans++;
            if (arr.get(i + 1) - arr.get(i) <= arr.get(i + 2) - arr.get(i + 1))
                ans++;
        }
        return ans;
    }
}
