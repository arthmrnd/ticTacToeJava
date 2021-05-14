package arthmrnd.ticTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final String[] board = new String[9];
    static String turn = "X";

    public static void main(String[] args) {

        String winner = null;
        fillBoard();

        System.out.println("\t-Tic Tac Toe-\n");
        board();
        System.out.println("X's play first. Enter a number to put X in:");
        Scanner read = new Scanner(System.in);

        while (winner == null) {
            int boardNumber = read.nextInt();
            if (!(boardNumber > 0 && boardNumber <= 9)) {
                System.out.println("Invalid input; re-enter a valid number:");
                continue;
            }
            if (board[boardNumber - 1].equals(String.valueOf(boardNumber))) {
                board[boardNumber - 1] = turn;
                if (turn.equals("X")) {
                    turn = "O";
                } else {
                    turn = "X";
                }
                board();
                winner = checkWinner();
            } else {
                System.out.println("Slot already taken; re-enter a valid number:");
            }
        }

        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("It's a draw!");
        } else {
            System.out.printf("Congratulations! %s have won!",winner);
        }
    }

    public static String checkWinner() {
        for (int i = 0; i < 8; i++) {
            String line = null;
            switch (i) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }

        for (int i = 0; i < 9; i++) {
            if (Arrays.asList(board).contains(String.valueOf(i + 1))) {
                break;
            } else if (i == 8)
                return "draw";
        }

        System.out.printf("%s's turn; Enter a number to put %s in:\n",turn,turn);
        return null;
    }

    public static void board() {
        String createBoard = "------------- \n" + "| " + board[0] + " | " + board[1] + " | " + board[2] + " | \n" +
                "|-----------| \n" + "| " + board[3] + " | " + board[4] + " | " + board[5] + " | \n" +
                "|-----------| \n" + "| " + board[6] + " | " + board[7] + " | " + board[8] + " | \n" +
                "------------- \n";
        System.out.println(createBoard);
    }

    public static void fillBoard() {
        for (int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i + 1);
        }
    }
}
