import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class BovineGenomics {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<String> spotty = new ArrayList<>();
        ArrayList<String> plain = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            spotty.add(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            plain.add(st.nextToken());
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            ArrayList<Character> geneSpotty = new ArrayList<>();
            ArrayList<Character> genePlain = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                String currSpotty = spotty.get(j);
                String currPlain = plain.get(j);
                geneSpotty.add(currSpotty.charAt(i));
                genePlain.add(currPlain.charAt(i));
            }
            if (!contains(genePlain, geneSpotty))
                ans++;
        }
        out.println(ans);
        out.close();
    }

    public static boolean contains(ArrayList<Character> arr1, ArrayList<Character> arr2) {
        for (char i : arr1)
            if (arr2.contains(i))
                return true;
        return false;
    }
}
