package com.models;

import java.util.Arrays;

public class Board {
    private final int size = 64;
    private final Square[][] board = new Square[8][8];

    public void createCheckersOnBoard() {
        char positionLetter;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                positionLetter = getPositionChar(i);
                sb.append(positionLetter).append(j + 1);
                addWhiteCheckersOnBoard(sb.toString(), j, i);
                if (j > 2 && j < 5) {
                    addEmptySquareOnBoard(sb.toString(), j, i);
                }
                if (j > 4) {
                    addBlackCheckersOnBoard(sb.toString(), j, i);
                }
                sb.delete(0, sb.length());
            }
        }
        System.out.println(Arrays.deepToString(board));
    }

    private void addWhiteCheckersOnBoard(String charName, int positionChar, int numPosition) {
        if (positionChar > 2) {
            return;
        }
        if (positionChar % 2 == 0) {
            if (numPosition % 2 == 0) {
                board[positionChar][numPosition] = new Square(charName, false, true, false);
            }
        } else {
            if (numPosition % 2 != 0) {
                board[positionChar][numPosition] = new Square(charName, false, true, false);
            }
        }
    }

    private void addEmptySquareOnBoard(String charName, int positionChar, int numPosition) {
        if (positionChar % 2 == 0) {
            if (numPosition % 2 == 0) {
                board[positionChar][numPosition] = new Square(charName, true, true, false);
            }
        } else {
            if (numPosition % 2 != 0) {
                board[positionChar][numPosition] = new Square(charName, true, true, true);
            }
        }
    }

    private void addBlackCheckersOnBoard(String charName, int positionChar, int numPosition) {
        if (positionChar % 2 != 0) {
            if (numPosition % 2 != 0) {
                board[positionChar][numPosition] = new Square(charName, false, true, true);
            }
        } else {
            if (numPosition % 2 == 0) {
                board[positionChar][numPosition] = new Square(charName, false, true, true);
            }
        }
    }

    private char getPositionChar(int i) {
        switch (i) {
            case 0:
                return 'A';
            case 1:
                return 'B';
            case 2:
                return 'C';
            case 3:
                return 'D';
            case 4:
                return 'E';
            case 5:
                return 'F';
            case 6:
                return 'G';
            case 7:
                return 'H';
        }
        throw new IllegalArgumentException();
    }

}
