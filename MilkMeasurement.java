import java.util.*;
import java.io.*;

public class MilkMeasurement {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        StringTokenizer a = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(a.nextToken());

        int bessie = 7;
        int elsie = 7;
        int mildred = 7;

        ArrayList<Integer> days = new ArrayList<Integer>();
        ArrayList<Integer> milk = new ArrayList<Integer>();
        ArrayList<String> names = new ArrayList<String>();

        for (int i = 0; i < n; i++) {
            StringTokenizer b = new StringTokenizer(f.readLine());
            days.add(Integer.parseInt(b.nextToken()));
            names.add(b.nextToken());
            milk.add(Integer.parseInt(b.nextToken()));
        }

        int currday;
        int change = 0;
        boolean bessieOn = true, elsieOn = true, mildredOn = true;

        for (int i = 0; i < n; i++) {
            currday = days.indexOf(Collections.min(days));
            days.remove(currday);
            if (names.get(currday).equals("Bessie")) {
                bessie += milk.get(currday);
            }
            if (names.get(currday).equals("Elsie")) {
                elsie += milk.get(currday);
            }
            if (names.get(currday).equals("Mildred")) {
                mildred += milk.get(currday);
            }

            int highestMilk = Math.max(bessie, Math.max(elsie, mildred));

            boolean bessieOnNext = bessie == highestMilk;
            boolean elsieOnNext = elsie == highestMilk;
            boolean mildredOnNext = mildred == highestMilk;
            if (bessieOn != bessieOnNext || elsieOn != elsieOnNext || mildredOn != mildredOnNext) {
                change++;
            }
            bessieOn = bessieOnNext;
            elsieOn = elsieOnNext;
            mildredOn = mildredOnNext;

            names.remove(currday);
            milk.remove(currday);
        }

        out.println(change);
        out.close();
    }


}

