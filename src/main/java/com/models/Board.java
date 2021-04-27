package com.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                    addEmptyDarkSquareOnBoard(sb.toString(), j, i);
                }
                if (j > 4) {
                    addBlackCheckersOnBoard(sb.toString(), j, i);
                }
                sb.delete(0, sb.length());
            }
        }
//        System.out.println(Arrays.deepToString(board));
    }

    public Square getSquare(String move) {
        for (Square[] squares : board) {
            for (int j = 0; j < board.length; j++) {
                if (squares[j] != null) {
                    if (squares[j].getPosition().equals(move)) {
                        return squares[j];
                    }
                }
            }
        }
        return null;
    }

    // public Square(String position, boolean isEmpty, boolean isBlack, boolean isCheckerBlack) {
    public Square[][] getBoard() {
        return board;
    }

    private void addWhiteCheckersOnBoard(String charName, int positionChar, int numPosition) {
        if (positionChar > 2) {
            return;
        }
        if (positionChar % 2 == 0) {
            if (numPosition % 2 == 0) {
                board[positionChar][numPosition] = new Square(charName, true, new Checker(false, false));
            }
        } else {
            if (numPosition % 2 != 0) {
                board[positionChar][numPosition] = new Square(charName, true, new Checker(false, false));
            }
        }
    }

    private void addEmptyDarkSquareOnBoard(String charName, int positionChar, int numPosition) {
        if (positionChar % 2 == 0) {
            if (numPosition % 2 == 0) {
                board[positionChar][numPosition] = new Square(charName, true, null);
            }
        } else {
            if (numPosition % 2 != 0) {
                board[positionChar][numPosition] = new Square(charName, true, null);
            }
        }
    }

    private void addBlackCheckersOnBoard(String charName, int positionChar, int numPosition) {
        if (positionChar % 2 != 0) {
            if (numPosition % 2 != 0) {
                board[positionChar][numPosition] = new Square(charName, true, new Checker(true, false));
            }
        } else {
            if (numPosition % 2 == 0) {
                board[positionChar][numPosition] = new Square(charName, true, new Checker(true, false));
            }
        }
    }

    public List<Square> getAllByColor(boolean isColorBlack) {
        List<Square> result = new ArrayList<>();
        getAllBlackCheckers(result, isColorBlack);
        return result;
    }

    private void getAllBlackCheckers(List<Square> result, boolean color) {
        for (Square[] squares : board) {
            for (int j = 0; j < board.length; j++) {
                if (squares[j].getChecker().isCheckerBlack() == color) {
                    result.add(squares[j]);
                }
            }
        }
    }

    public char getPositionChar(int i) {
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

    public int getPositionInt(char i) {
        switch (i) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            case 'D':
                return 3;
            case 'E':
                return 4;
            case 'F':
                return 5;
            case 'G':
                return 6;
            case 'H':
                return 7;
        }
        throw new IllegalArgumentException();
    }

    public void printBoard() {
        int k = 0;
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board.length; j++) {
                if (j == 0 && k == 0) {
                    k++;
                    for (int z = 0; z < 8; z++) {
                        System.out.print(" " + getPositionChar(z) + " ");
                    }
                    System.out.println();
                }
                if (board[i][j] == null) {
                    System.out.print("___");
                    continue;
                }

                if (!board[i][j].isEmpty() && !board[i][j].getChecker().isCheckerBlack()) {
                    System.out.print(" * ");
                } else if (!board[i][j].isEmpty() && board[i][j].getChecker().isCheckerBlack()) {
                    System.out.print(" & ");
                } else if (board[i][j].isEmpty()) {
                    System.out.print(" □ ");
                }
            }
            System.out.println("   " + (i + 1));
        }
    }
}
