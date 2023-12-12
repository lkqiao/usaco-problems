import java.util.*;

public class TicTacToe {

    private static char[][] board = new char[3][3];
    private static int[][] occupied = new int[3][3];

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        int row, col;
        char piece;
        boolean win = false;
        boolean allOccupied = false;

        while (!win && !allOccupied) {
            printBoard();

            System.out.println("Enter a row, column, and piece");
            row = s.nextInt();
            col = s.nextInt();
            piece = s.next().charAt(0);

            if (occupied[row - 1][col - 1] == 0) {
                board[row - 1][col - 1] = piece;
            } else {
                System.out.println("Position is occupied");
            }
            occupied[row - 1][col - 1] = 1;

            win = winDetection();

            allOccupied = allOccupied();
        }

        printBoard();

        if (win) {
            System.out.println("Win!");
        } else if (allOccupied) {
            System.out.println("Tie!");
        }
    }

    private static void printBoard() {
        System.out.println("   1   2   3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                if (j < 2) {
                    System.out.print(" " + board[i][j] + " " + "|");
                } else {
                    System.out.print(" " + board[i][j] + " ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  ---|---|---");
            } else {
                System.out.println();
            }
        }
    }

    private static boolean winDetection() {
        //horizontals
        for (int i = 0; i < 3; i++) {
            int counter = 0;
            for (int j = 1; j < 3; j++) {
                if (board[i][0] == board[i][j] && occupied[i][0] == 1) {
                    counter++;
                }
            }
            if (counter == 2) {
                return true;
            }
        }

        //verticals
        for (int i = 0; i < 3; i++) {
            int counter = 0;
            for (int j = 1; j < 3; j++) {
                if (board[0][i] == board[j][i] && occupied[0][i] == 1) {
                    counter++;
                }
            }
            if (counter == 2) {
                return true;
            }
        }

        //diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && occupied[0][0] == 1) {
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && occupied[0][2] == 1) {
            return true;
        }

        return false;
    }

    private static boolean allOccupied() {
        //check if all occupied
        int rowCounter = 0;
        for (int i = 0; i < 3; i++) {
            int counter = 0;
            for (int j = 1; j < 3; j++) {
                if (occupied[i][0] == 1 && occupied[i][0] == occupied[i][j]) {
                    counter++;
                }
            }
            if (counter == 2) {
                rowCounter++;
            }
        }
        if (rowCounter == 3) {
            return true;
        }

        return false;
    }
}