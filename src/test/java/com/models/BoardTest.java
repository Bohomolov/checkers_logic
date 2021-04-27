package com.models;

import com.Checkers;
import org.junit.jupiter.api.Test;

class BoardTest {
    Board board = new Board();
    Player player1 = new Player(false, false, "dddd");
    Player player2 = new Player(true, false, "ddydd");
    Checkers checkers = new Checkers(board, player1);

    @Test
    void test() {
        board.createCheckersOnBoard();
        checkers.doMoveWight(player1);
    }
}