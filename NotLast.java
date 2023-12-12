import java.util.*;
import java.io.*;

public class NotLast {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("notlast.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));
        StringTokenizer a = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(a.nextToken());

        int bessie = 0;
        int elsie = 0;
        int daisy = 0;
        int gertie = 0;
        int annabelle = 0;
        int maggie = 0;
        int henrietta = 0;

        String cowName;
        int milk;
        ArrayList<Integer> milkVal = new ArrayList<Integer>();
        int secondtoLast = 0;
        int min;

        for (int i = 0; i < n; i++) {
            StringTokenizer b = new StringTokenizer(f.readLine());
            cowName = b.nextToken();
            milk = Integer.parseInt(b.nextToken());

            if (cowName.equals("Bessie")) {
                bessie += milk;
            }
            if (cowName.equals("Elsie")) {
                elsie += milk;
            }
            if (cowName.equals("Daisy")) {
                daisy += milk;
            }
            if (cowName.equals("Gertie")) {
                gertie += milk;
            }
            if (cowName.equals("Annabelle")) {
                annabelle += milk;
            }
            if (cowName.equals("Maggie")) {
                maggie += milk;
            }
            if (cowName.equals("Henrietta")) {
                henrietta += milk;
            }
        }

        milkVal.add(bessie);
        milkVal.add(elsie);
        milkVal.add(daisy);
        milkVal.add(gertie);
        milkVal.add(annabelle);
        milkVal.add(maggie);
        milkVal.add(henrietta);

        boolean empty = false;

        Collections.sort(milkVal);
        min = Collections.min(milkVal);
        milkVal.removeAll(Collections.singletonList((min)));
        if (milkVal.size() > 0) {
            secondtoLast = Collections.min(milkVal);
        } else {
            out.println("Tie");
            empty = true;
        }

        String secondtoLastCow = " ";
        int numCows = 0;

        if (!empty) {
            for (int i = 0; i < n; i++) {
                if (secondtoLast == bessie) {
                    secondtoLastCow = "Bessie";
                    numCows++;
                }
                if (secondtoLast == elsie) {
                    secondtoLastCow = "Elsie";
                    numCows++;
                }
                if (secondtoLast == daisy) {
                    secondtoLastCow = "Daisy";
                    numCows++;
                }
                if (secondtoLast == gertie) {
                    secondtoLastCow = "Gertie";
                    numCows++;
                }
                if (secondtoLast == annabelle) {
                    secondtoLastCow = "Annabelle";
                    numCows++;
                }
                if (secondtoLast == maggie) {
                    secondtoLastCow = "Maggie";
                    numCows++;
                }
                if (secondtoLast == henrietta) {
                    secondtoLastCow = "Henrietta";
                    numCows++;
                }

                if (numCows == 1) {
                    out.println(secondtoLastCow);
                    break;
                } else {
                    out.println("Tie");
                    break;
                }
            }
        }
        out.close();

    }
}
