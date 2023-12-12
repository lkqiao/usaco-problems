import java.util.*;
import java.io.*;

public class HPS {
    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("hps.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));

        StringTokenizer a = new StringTokenizer(f.readLine());

        int n = Integer.parseInt(a.nextToken());


        int[][] matches = new int[n][2];
        for(int i = 0; i < matches.length; i++) {
            StringTokenizer b = new StringTokenizer(f.readLine());
            for(int j = 0; j < matches[0].length; j++) {
                matches[i][j] = Integer.parseInt(b.nextToken());
            }
        }

        int wins = 0;
        int max = 0;

        //1 - hoof, 2 - paper, 3 - scissors
        for(int i = 0; i < n; i++) {
            if(matches[i][0] == 1 && matches[i][1] == 3) {
                wins++;
            }
            if(matches[i][0] == 3 && matches[i][1] == 2) {
                wins++;
            }
            if(matches[i][0] == 2 && matches[i][1] == 1) {
                wins++;
            }
        }
        if(wins > max) {
            max = wins;
        }
        wins = 0;
        //1 - hoof, 2 - scissors, 3 - paper
        for(int i = 0; i < n; i++) {
            if(matches[i][0] == 1 && matches[i][1] == 2) {
                wins++;
            }
            if(matches[i][0] == 2 && matches[i][1] == 3) {
                wins++;
            }
            if(matches[i][0] == 3 && matches[i][1] == 1) {
                wins++;
            }
        }
        if(wins > max) {
            max = wins;
        }
        wins = 0;
        //1 - paper, 2 - scissors, 3 - hoof
        for(int i = 0; i < n; i++) {
            if(matches[i][0] == 3 && matches[i][1] == 2) {
                wins++;
            }
            if(matches[i][0] == 2 && matches[i][1] == 1) {
                wins++;
            }
            if(matches[i][0] == 1 && matches[i][1] == 3) {
                wins++;
            }
        }
        if(wins > max) {
            max = wins;
        }
        wins = 0;
        //1 - paper, 2 - hoof, 3 - scissors
        for(int i = 0; i < n; i++) {
            if(matches[i][0] == 2 && matches[i][1] == 3) {
                wins++;
            }
            if(matches[i][0] == 3 && matches[i][1] == 1) {
                wins++;
            }
            if(matches[i][0] == 1 && matches[i][1] == 2) {
                wins++;
            }
        }
        if(wins > max) {
            max = wins;
        }
        wins = 0;
        //1 - scissors, 2 - hoof, 3 - paper
        for(int i = 0; i < n; i++) {
            if(matches[i][0] == 2 && matches[i][1] == 1) {
                wins++;
            }
            if(matches[i][0] == 1 && matches[i][1] == 3) {
                wins++;
            }
            if(matches[i][0] == 3 && matches[i][1] == 2) {
                wins++;
            }
        }
        if(wins > max) {
            max = wins;
        }
        wins = 0;
        //1 - scissors, 2 - paper, 3 - hoof
        for(int i = 0; i < n; i++) {
            if(matches[i][0] == 3 && matches[i][1] == 1) {
                wins++;
            }
            if(matches[i][0] == 1 && matches[i][1] == 2) {
                wins++;
            }
            if(matches[i][0] == 2 && matches[i][1] == 3) {
                wins++;
            }
        }
        if(wins > max) {
            max = wins;
        }
        wins = 0;

        out.println(max);
        out.close();
    }
}
