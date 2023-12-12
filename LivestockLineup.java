import java.util.*;
import java.io.*;

public class LivestockLineup {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("lineup.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        String a, must, be, milked, beside, b;
        ArrayList<String> list = new ArrayList<>();
        list.add("Beatrice");
        list.add("Belinda");
        list.add("Bella");
        list.add("Bessie");
        list.add("Betsy");
        list.add("Blue");
        list.add("Buttercup");
        list.add("Sue");
        ArrayList<String> order = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            a = st.nextToken();
            must = st.nextToken();
            be = st.nextToken();
            milked = st.nextToken();
            beside = st.nextToken();
            b = st.nextToken();
            order.add(a);
            order.add(b);
        }
        ArrayList<ArrayList<String>> perm = getPermutations(list);
        for (int i = 0; i < perm.size(); i++) {
            int counter = 0;
            for (int j = 0; j < n; j++)
                if (Math.abs(perm.get(i).indexOf(order.get(j * 2)) - perm.get(i).indexOf(order.get(j * 2 + 1))) == 1)
                    counter++;
            if (counter == n) {
                list = perm.get(i);
                break;
            }
        }
        for (int i = 0; i < list.size(); i++)
            out.println(list.get(i));
        out.close();
    }

    public static ArrayList<ArrayList<String>> getPermutations(ArrayList<String> list) {
        return permutations(null, list, null);
    }

    public static ArrayList<ArrayList<String>> permutations(ArrayList<String> prefix, ArrayList<String> suffix, ArrayList<ArrayList<String>> output) {
        if (prefix == null)
            prefix = new ArrayList<>();
        if (output == null)
            output = new ArrayList<>();
        if (suffix.size() == 1) {
            ArrayList<String> newElement = new ArrayList<>(prefix);
            newElement.addAll(suffix);
            output.add(newElement);
            return output;
        }
        for (int i = 0; i < suffix.size(); i++) {
            ArrayList<String> newPrefix = new ArrayList<>(prefix);
            newPrefix.add(suffix.get(i));
            ArrayList<String> newSuffix = new ArrayList<>(suffix);
            newSuffix.remove(i);
            permutations(newPrefix, newSuffix, output);
        }
        return output;
    }
}


