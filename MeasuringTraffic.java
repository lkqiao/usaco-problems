import java.util.*;
import java.io.*;

public class MeasuringTraffic {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("traffic.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("traffic.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<String> type = new ArrayList<>();
        ArrayList<Integer> lowerBound = new ArrayList<>();
        ArrayList<Integer> upperBound = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            type.add(st.nextToken());
            lowerBound.add(Integer.parseInt(st.nextToken()));
            upperBound.add(Integer.parseInt(st.nextToken()));
        }
        int ansLow1, ansHigh1, ansLow2, ansHigh2;
        int low1 = Integer.MIN_VALUE, high1 = Integer.MAX_VALUE;
        for (int i = type.lastIndexOf("none"); i >= 0; i--) {
            if (type.get(i).equals("none")) {
                low1 = Math.max(low1, lowerBound.get(i));
                high1 = Math.min(high1, upperBound.get(i));
                if (low1 > high1) {
                    int temp = low1;
                    low1 = high1;
                    high1 = temp;
                }
                if (low1 < 0) low1 = 0;
                if (high1 < 0) high1 = 0;
            } else if (type.get(i).equals("on")) {
                low1 = Math.min(low1 - lowerBound.get(i), low1 - upperBound.get(i));
                high1 = Math.max(high1 - lowerBound.get(i), high1 - upperBound.get(i));
                if (low1 > high1) {
                    int temp = low1;
                    low1 = high1;
                    high1 = temp;
                }
                if (low1 < 0) low1 = 0;
                if (high1 < 0) high1 = 0;
            } else if (type.get(i).equals("off")) {
                low1 = Math.min(low1 + lowerBound.get(i), low1 + upperBound.get(i));
                high1 = Math.max(high1 + lowerBound.get(i), high1 + upperBound.get(i));
                if (low1 > high1) {
                    int temp = low1;
                    low1 = high1;
                    high1 = temp;
                }
                if (low1 < 0) low1 = 0;
                if (high1 < 0) high1 = 0;
            }
        }
        ansLow1 = low1;
        ansHigh1 = high1;
        out.println(ansLow1 + " " + ansHigh1);

        int low2 = Integer.MIN_VALUE, high2 = Integer.MAX_VALUE;
        for (int i = type.indexOf("none"); i < n; i++) {
            if (type.get(i).equals("none")) {
                low2 = Math.max(low2, lowerBound.get(i));
                high2 = Math.min(high2, upperBound.get(i));
                if (low2 > high1) {
                    int temp = low2;
                    low2 = high2;
                    high2 = temp;
                }
                if (low2 < 0) low2 = 0;
                if (high2 < 0) high2 = 0;
            } else if (type.get(i).equals("on")) {
                low2 = Math.min(low2 + lowerBound.get(i), low2 + upperBound.get(i));
                high2 = Math.max(high2 + lowerBound.get(i), high2 + upperBound.get(i));
                if (low2 > high2) {
                    int temp = low2;
                    low2 = high2;
                    high2 = temp;
                }
                if (low2 < 0) low2 = 0;
                if (high2 < 0) high2 = 0;
            } else if (type.get(i).equals("off")) {
                low2 = Math.min(low2 - lowerBound.get(i), low2 - upperBound.get(i));
                high2 = Math.max(high2 - lowerBound.get(i), high2 - upperBound.get(i));
                if (low2 > high2) {
                    int temp = low2;
                    low2 = high2;
                    high2 = temp;
                }
                if (low2 < 0) low2 = 0;
                if (high2 < 0) high2 = 0;
            }
        }
        ansLow2 = low2;
        ansHigh2 = high2;
        out.println(ansLow2 + " " + ansHigh2);
        out.close();
    }
}
