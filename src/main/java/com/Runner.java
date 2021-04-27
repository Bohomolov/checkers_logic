package com;


import com.models.Board;
import com.models.Player;

public class Runner {
    public static void main(String[] args) {
        Board board = new Board();
        Player player1 = new Player(false, false, "dddd");
        Player player2 = new Player(true, false, "ddydd");
        Checkers checkers = new Checkers(board, player1, player2);


        board.createCheckersOnBoard();
        checkers.doMoveWight(player1);

    }
}
