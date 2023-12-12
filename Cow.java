import java.util.*;
import java.io.*;

public class Cow {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cow.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cow.out")));

        long c = 0;
        long co = 0;
        long cow = 0;

        StringTokenizer st = new StringTokenizer(f.readLine());
        long n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(f.readLine());
        String s = st.nextToken();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'C') {
                c++;
            } else if (s.charAt(i) == 'O') {
                co += c;
            } else if (s.charAt(i) == 'W') {
                cow += co;
            }
        }
        out.println(cow);
        out.close();
    }
}
