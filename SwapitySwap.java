import java.util.*;
import java.io.*;

public class SwapitySwap {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("swap.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int A1 = Integer.parseInt(st.nextToken()) - 1;
        int A2 = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(f.readLine());
        int B1 = Integer.parseInt(st.nextToken()) - 1;
        int B2 = Integer.parseInt(st.nextToken()) - 1;
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> subA = new ArrayList<>();
        ArrayList<Integer> subB = new ArrayList<>();
        for (int i = 0; i < n; i++)
            pos.add(i + 1);
        for (int i = 0; i < k; i++) {
            subA = getSub(pos, subA, A1, A2);
            pos = setVal(pos, subA, A1, A2);
            subA.clear();
            subB = getSub(pos, subB, B1, B2);
            pos = setVal(pos, subB, B1, B2);
            subB.clear();
        }
        for(int i = 0; i < pos.size(); i++)
            out.println(pos.get(i));
        out.close();
    }

    public static ArrayList<Integer> getSub(ArrayList<Integer> arr, ArrayList<Integer> a, int A1, int A2) {
        for (int i = A1; i <= A2; i++)
            a.add(arr.get(i));
        Collections.reverse(a);
        return a;
    }

    public static ArrayList<Integer> setVal(ArrayList<Integer> arr, ArrayList<Integer> a, int A1, int A2) {
        for (int i = A1; i <= A2; i++)
            arr.set(i, a.get(i - A1));
        return arr;
    }
}
