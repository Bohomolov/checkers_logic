package com;


import com.models.Board;
import com.models.Player;

public class Runner {
    public static void main(String[] args) {
        Board board = new Board();
        Player player1 = new Player(false, false, "White");
        Player player2 = new Player(true, false, "Black");

        Checkers checkers = new Checkers(board, player1);
        Checkers checkers2 = new Checkers(board, player2);

        board.createCheckersOnBoard();
        while (true){
            checkers.doMoveWight(player1);

            checkers2.doMoveWight(player2);
        }
    }
}
