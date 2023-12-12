import java.awt.*;
import java.util.*;
import java.io.*;

public class BackAndForth {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("backforth.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));

        ArrayList<Integer> barn1 = new ArrayList<>(), barn2 = new ArrayList<>();
        int milk1 = 1000;
        ArrayList<Integer> finalMilk = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(f.readLine());
        for (int i = 0; i < 10; i++) {
            barn1.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < 10; i++) {
            barn2.add(Integer.parseInt(st.nextToken()));
        }

        for (int mt = 0; mt < barn1.size(); mt++) {
            int temp1 = barn1.get(0);
            barn1.remove(0);
            barn2.add(temp1);
            milk1 -= temp1;

            for (int tw = 0; tw < barn2.size(); tw++) {
                int temp2 = barn2.get(0);
                barn2.remove(0);
                barn1.add(temp2);
                milk1 += temp2;

                for (int wt = 0; wt < barn1.size(); wt++) {
                    int temp3 = barn1.get(0);
                    barn1.remove(0);
                    barn2.add(temp3);
                    milk1 -= temp3;

                    for (int tf = 0; tf < barn2.size(); tf++) {
                        int temp4 = barn2.get(tf);
                        milk1 += temp4;

                        if (!finalMilk.contains(milk1)) {
                            finalMilk.add(milk1);
                        }

                        milk1 -= temp4;
                    }

                    barn1.add(temp3);
                    barn2.remove(barn2.size() - 1);
                    milk1 += temp3;
                }

                barn2.add(temp2);
                barn1.remove(barn1.size() - 1);
                milk1 -= temp2;
            }

            barn1.add(temp1);
            barn2.remove(barn2.size() - 1);
            milk1 += temp1;
        }
        out.println(finalMilk.size());
        out.close();
    }
}
