import java.util.*;
import java.io.*;

public class CowEvolution {

    static int n;
    static int[] k;
    static ArrayList<String>[] traits;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("evolution.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("evolution.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        k = new int[n];
        traits = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            k[i] = Integer.parseInt(st.nextToken());

            ArrayList<String> t = new ArrayList<>();
            for (int j = 0; j < k[i]; j++) {
                t.add(st.nextToken());
            }

            traits[i] = t;
        }

        boolean no = false;
        sort();

        for (int i = n - 1; i >= 0; i--) {
            int num_ancestors = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (k[i] > k[j] && contains(j, i)) {
                    num_ancestors++;
                }
                if (num_ancestors > 1 || num_ancestors == 0) {
                    no = true;
                } else {
                    no = false;
                }
            }
        }

        if (no) {
            out.println("no");
        } else {
            out.println("yes");
        }
        out.close();
    }

    public static void sort() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (k[j + 1] < k[j]) {
                    int t1 = k[j];
                    k[j] = k[j + 1];
                    k[j + 1] = t1;
                    ArrayList<String> t2 = traits[j];
                    traits[j] = traits[j + 1];
                    traits[j + 1] = t2;
                }
            }
        }
    }

    public static boolean contains(int a, int b) {
        int ans = 0;
        for (int i = 0; i < traits[a].size(); i++) {
            for (int j = 0; j < traits[b].size(); j++) {
                if (traits[a].get(i).equals(traits[b].get(j))) {
                    ans++;
                }
            }
        }
        return ans == traits[a].size();
    }
}