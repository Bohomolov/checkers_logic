package com;

import com.models.Board;
import com.models.Player;

import java.util.Scanner;

public class Checkers {
    private final Scanner scanner = new Scanner(System.in);
    private final Board board;
    private final Player player1;
    private final Player player2;

    public Checkers(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    private void doMove(Player player) {
        scanner.nextLine();
//        validateMove();
    }

    private boolean validateMove(String move) {
//        if (move.equals())
    }
}
