import java.io.*;
import java.util.*;

public class WhereAmI {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("whereami.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        String mailboxes = st.nextToken();
        ArrayList<Boolean> ok = new ArrayList<>();
        ArrayList<Integer> posVal = new ArrayList<>();
        outer:
        for (int l = 1; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                String search = mailboxes.substring(i, i + l);
                if (search(mailboxes, search)) ok.add(true);
                else ok.add(false);
            }
            int counter = 0;
            for (int i = 0; i < ok.size(); i++)
                if (!ok.get(i)) counter++;
            if (counter == ok.size()) posVal.add(l);
            ok.clear();
        }
        out.println(Collections.min(posVal));
        out.close();
    }

    public static boolean search(String str, String search) {
        int counter = 0;
        for (int i = 0; i < str.length() - search.length() + 1; i++) {
            if (str.substring(i, i + search.length()).equals(search)) counter++;
            if (counter > 1) return true;
        }
        return false;
    }
}
