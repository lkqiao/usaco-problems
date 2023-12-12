import java.util.*;
import java.io.*;

public class Censoring {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("censor.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("censor.out")));

        StringBuilder s, ans;
        StringTokenizer st = new StringTokenizer(f.readLine());
        s = new StringBuilder(st.nextToken());
        ans = new StringBuilder();

        st = new StringTokenizer(f.readLine());
        String r = st.nextToken();

        for (int i = 0; i < s.length(); i++) {
            ans.append(s.charAt(i));

            if (ans.length() >= r.length() && ans.substring(ans.length() - r.length()).equals(r)) {
                ans = ans.replace(ans.length() - r.length(), ans.length(), "");
            }
        }

        out.println(ans);
        out.close();
    }
}
