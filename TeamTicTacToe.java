import java.util.*;
import java.io.*;

public class TeamTicTacToe {

    private static String[] grid = new String[3];

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("tttt.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            grid[i] = st.nextToken();
        }
        ArrayList<Character> letters = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++)
            letters.add(c);
        int singleWins = 0, teamWins = 0;
        for (char c : letters)
            singleWins += singleWins(c);
        for (int i = 0; i < letters.size(); i++)
            for (int j = i + 1; j < letters.size(); j++)
                teamWins += teamWins(letters.get(i), letters.get(j));
        out.println(singleWins);
        out.println(teamWins);
        out.close();
    }

    public static int singleWins(char ch) {
        if (grid[0].charAt(0) == ch && grid[1].charAt(1) == ch && grid[2].charAt(2) == ch)
            return 1;
        if (grid[0].charAt(2) == ch && grid[1].charAt(1) == ch && grid[2].charAt(0) == ch)
            return 1;
        for (int i = 0; i < 3; i++) {
            if (grid[0].charAt(i) == ch && grid[1].charAt(i) == ch && grid[2].charAt(i) == ch)
                return 1;
            if (grid[i].charAt(0) == ch && grid[i].charAt(1) == ch && grid[i].charAt(2) == ch)
                return 1;
        }

        return 0;
    }

    public static boolean checkDiagonals(char ch1, char ch2, char a, char b, char c) {
        if (a != ch1 && a != ch2)
            return false;
        if (b != ch1 && b != ch2)
            return false;
        if (c != ch1 && c != ch2)
            return false;
        if (a != ch1 && b != ch1 && c != ch1)
            return false;
        if (a != ch2 && b != ch2 && c != ch2)
            return false;
        return true;
    }

    public static int teamWins(char ch1, char ch2) {
        if (checkDiagonals(ch1, ch2, grid[0].charAt(0), grid[1].charAt(1), grid[2].charAt(2)))
            return 1;
        if (checkDiagonals(ch1, ch2, grid[0].charAt(2), grid[1].charAt(1), grid[2].charAt(0)))
            return 1;
        for (int i = 0; i < 3; i++) {
            if (checkDiagonals(ch1, ch2, grid[0].charAt(i), grid[1].charAt(i), grid[2].charAt(i)))
                return 1;
            if (checkDiagonals(ch1, ch2, grid[i].charAt(0), grid[i].charAt(1), grid[i].charAt(2)))
                return 1;
        }

        return 0;
    }
}