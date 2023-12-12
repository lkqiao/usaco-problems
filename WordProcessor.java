import java.util.*;
import java.io.*;

public class WordProcessor {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("word.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));

        StringTokenizer line1 = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(line1.nextToken());
        int k = Integer.parseInt(line1.nextToken());

        String[] essay = new String[n];

        int cc = 0;
        int ccf = 0;
        int sum = 0;

        boolean nl = false;

        StringTokenizer line2 = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            essay[i] = line2.nextToken();
        }

        cc += stringCount(essay[0]);

        for(int i = 0; i < n; i ++) {
            if(i < n - 1) {
                ccf = stringCount(essay[i + 1]);
                sum = cc + ccf;

                if(sum <= k) {
                    essay[i] += " ";
                    cc = sum;
                }

                if(sum > k) {
                    cc = ccf;
                }
            }
        }

        int totalLine = 0;
        boolean newLine = false;

        for(int i = 0; i < n; i++) {

            totalLine += stringCount(essay[i]);

            if(totalLine <= k) {
                out.print(essay[i]);
            } else {
                newLine = true;
            }

            if(newLine) {
                out.println();
                if(i == n - 1) {
                    out.print(essay[i]);
                } else {
                    out.print(essay[i]);
                }
                newLine = false;
                totalLine = stringCount(essay[i]);
            }
        }
        out.close();
    }

    public static int stringCount (String str) {
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != ' ')
                count++;
        }
        return count;
    }

}
