import java.util.*;
import java.io.*;

public class CowSignal {
    public static void main(String[] args) throws IOException {
        // initialize file I/O
        BufferedReader br = new BufferedReader(new FileReader("cowsignal.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < r; i++) {
            String currRow = br.readLine();

            for(int internalRow = 0; internalRow < k; internalRow++) {
                for(int j = 0; j < c; j++) {
                    for(int a = 0; a < k; a++) {
                        pw.print(currRow.charAt(j));
                    }
                }
                pw.println();
            }
        }

        pw.close();
    }
}