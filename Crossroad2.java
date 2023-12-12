import java.util.*;
import java.io.*;

public class Crossroad2 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("circlecross.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        String list = st.nextToken();
        int pairs = 0;
        for (int i = 0; i < list.length(); i++) {
            int endA = getEndPoint(list, i);
            for (int j = i + 1; j < endA; j++) {
                int endB = getEndPoint(list, j);
                if (endA < endB)
                    pairs++;
            }
        }
        out.println(pairs);
        out.close();
    }

    public static int getEndPoint(String str, int n) {
        char c = str.charAt(n);
        for (int i = n + 1; i < str.length(); i++)
            if (str.charAt(i) == c)
                return i;
        return -1;
    }
}
