import java.util.*;
import java.io.*;

public class AngryCows {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("angry.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer> bales = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            bales.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(bales);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int right = numRight(bales, i);
            int left = numLeft(bales, i);
            max = Math.max(right + left, max);
        }
        out.println(max + 1);
        out.close();
    }

    public static int numRight(ArrayList<Integer> arr, int s) {
        int br = 1;
        boolean hit = true;
        int ans = 0;
        while (hit) {
            int fin = furthestRight(arr, s, br);
            if (fin == -1) {
                hit = false;
            } else {
                ans += fin - s;
                s = fin;
                br++;
            }
        }
        return ans;
    }

    public static int furthestRight(ArrayList<Integer> arr, int s, int br) {
        int upperBound = arr.get(s) + br;
        for (int i = arr.size() - 1; i >= s + 1; i--)
            if (arr.get(i) <= upperBound)
                return i;
        return -1;
    }

    public static int numLeft(ArrayList<Integer> arr, int s) {
        int br = 1;
        boolean hit = true;
        int ans = 0;
        while (hit) {
            int fin = furthestLeft(arr, s, br);
            if (fin == -1) {
                hit = false;
            } else {
                ans += s - fin;
                s = fin;
                br++;
            }
        }
        return ans;
    }

    public static int furthestLeft(ArrayList<Integer> arr, int s, int br) {
        int lowerBound = arr.get(s) - br;
        for (int i = 0; i <= s - 1; i++) {
            if (arr.get(i) >= lowerBound) {
                return i;
            }
        }
        return -1;
    }
}
