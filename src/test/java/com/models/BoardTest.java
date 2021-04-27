package com.models;

import com.Checkers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Board board = new Board();
    Player player1 = new Player(false, false, "dddd");
    Player player2 = new Player(true, false, "ddydd");
    Checkers checkers = new Checkers(board, player1, player2);

    @Test
    void test() {
        board.createCheckersOnBoard();
       checkers.doMove(player1);
    }
}