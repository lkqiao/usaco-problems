import java.util.*;
import java.io.*;

public class MadScientist {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("breedflip.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        String a = st.nextToken();
        st = new StringTokenizer(f.readLine());
        String b = st.nextToken();
        int ans = 0;
        ArrayList<Integer> diff = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (a.charAt(i) != b.charAt(i)) diff.add(1);
            else diff.add(0);
        for (int i = 0; i < n; i++) {
            if (diff.get(i) == 1) {
                for (int j = i + 1; j < n; j++) {
                    if (diff.get(j) == 0) {
                        i = j;
                        ans++;
                        break;
                    }
                }
            }
        }
        out.println(ans);
        out.close();
    }
}
