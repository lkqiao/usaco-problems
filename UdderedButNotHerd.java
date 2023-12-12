import java.util.*;
import java.io.*;

public class UdderedButNotHerd {

    static String alphabet, s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        alphabet = st.nextToken();
        st = new StringTokenizer(br.readLine());
        s = st.nextToken();
        int ans = 1;

        for (int i = 0; i < s.length() - 1; i++) {
            if (!inOrder(s.charAt(i + 1), s.charAt(i))) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    public static boolean inOrder(char c1, char c2) {
        return alphabet.indexOf(c1) > alphabet.indexOf(c2);
    }
}
