package com.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Board board = new Board();

    @Test
    void test() {
        board.createCheckersOnBoard();
    }
}