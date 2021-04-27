package com;

import com.models.Board;
import com.models.Player;
import com.models.Square;

import java.util.Arrays;
import java.util.Scanner;

public class Checkers {
    private final Scanner scanner = new Scanner(System.in);
    private final Board board;
    private final Player player1;
    private final Player player2;
    private final Square[][] boardField;

    public Checkers(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        boardField = board.getBoard();
    }

    public void doMove(Player player) {
        while (true) {
            System.out.println(Arrays.deepToString(board.getBoard()));
            System.out.println("Select move");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("exit")) {
                break;
            }
            Square current = board.getSquare(command);
            System.out.println("Player 1 make chose");
            String[] moves = getImpossibleMove(command);
            System.out.println("Your impossible move: " + Arrays.toString(moves));
            String command2 = scanner.nextLine();
            if (moves != null) {
                Square square1 = board.getSquare(moves[0]);
                if (square1 != null && command2.equals(moves[0])) {
                    if (square1.isEmpty()) {
                        square1.setCheckerBlack(false);
                        square1.setEmpty(false);
                        current.setEmpty(true);
                    }
                    continue;
                }
                Square square2 = board.getSquare(moves[1]);
                if (square2 != null && command2.equals(moves[1])) {
                    if (square2.isEmpty()) {
                        square2.setCheckerBlack(false);
                        square2.setEmpty(false);
                        current.setEmpty(true);
                    }
                    continue;
                }
            }
        }
    }

    public String[] getImpossibleMove(String move) {
        Square currentSquare = board.getSquare(move);
        String[] impossibleMoves = new String[2];
        if (currentSquare == null || currentSquare.isEmpty()) {
            return null;
        }
        char currentLetter = move.charAt(0);
        int currentNumber = Character.getNumericValue(move.charAt(1)) + 1;

        if (currentLetter == 'H') {
            impossibleMoves[0] = (board.getPositionChar(board.getPositionInt(currentLetter) - 1)) + "" + currentNumber;
            return impossibleMoves;
        }
        if (currentLetter == 'A') {
            impossibleMoves[0] = (board.getPositionChar(board.getPositionInt(currentLetter) + 1)) + "" + currentNumber;
            return impossibleMoves;
        }

        impossibleMoves[0] = (board.getPositionChar(board.getPositionInt(currentLetter) - 1)) + "" + currentNumber;
        impossibleMoves[1] = (board.getPositionChar(board.getPositionInt(currentLetter) + 1)) + "" + currentNumber;

        return impossibleMoves;
    }
}
