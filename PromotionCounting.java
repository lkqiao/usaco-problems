import java.util.*;
import java.io.*;

public class PromotionCounting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("promote.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int bronzeBefore = Integer.parseInt(st.nextToken());
        int bronzeAfter = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int silverBefore = Integer.parseInt(st.nextToken());
        int silverAfter = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int goldBefore = Integer.parseInt(st.nextToken());
        int goldAfter = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int platinumBefore = Integer.parseInt(st.nextToken());
        int platinumAfter = Integer.parseInt(st.nextToken());

        int goldToPlatinum = platinumAfter - platinumBefore;
        int silverToGold = goldAfter - goldBefore + platinumAfter - platinumBefore;
        int bronzeToSilver = silverAfter - silverBefore + goldAfter - goldBefore + platinumAfter - platinumBefore;

        pw.println(bronzeToSilver);
        pw.println(silverToGold);
        pw.println(goldToPlatinum);
        pw.close();
    }
}
