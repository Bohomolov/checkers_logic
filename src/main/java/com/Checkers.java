package com;

import com.models.Board;
import com.models.Checker;
import com.models.Player;
import com.models.Square;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Checkers {
    private final Scanner scanner = new Scanner(System.in);
    private final Board board;
    private final Player player;
    private final Square[][] boardField;
    private List<Checker> blackCheckers;
    private List<Checker> whiteCheckers;

    public Checkers(Board board, Player player) {
        this.board = board;
        this.player = player;
        boardField = board.getBoard();
        blackCheckers = board.getAllByColor(true);
        whiteCheckers = board.getAllByColor(false);
    }

    public void doMoveWight(Player player) {
        board.printBoard();
        System.out.println("Select move");
        System.out.println(player.getLogin() + " make chose");
        String command = scanner.nextLine();
        String[] moves = getImpossibleMove(command, player.isBlack());
        moves = chekIsMoveValid(moves, player.isBlack(), command);
        System.out.println("Your impossible move: " + Arrays.toString(moves));
        String myChoseMove = scanner.nextLine();
        if (moves != null) {

            if (myChoseMove.equals(moves[0]) || myChoseMove.equals(moves[1]) && !myChoseMove.equals("null")) {
                doingMove(command, myChoseMove);
            }

        }

    }


    public String[] getImpossibleMove(String move, boolean ourColorIsBlack) {

        Square currentSquare = board.getSquare(move);
        String[] impossibleMoves = new String[2];
        if (currentSquare == null || currentSquare.isEmpty()) {
            return null;
        }
        char currentLetter = move.charAt(0);
        int currentNumber = ourColorIsBlack ? Character.getNumericValue(move.charAt(1)) - 1 : Character.getNumericValue(move.charAt(1)) + 1;

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

    public String[] chekIsMoveValid(String[] move, boolean ourColorIsBlack, String nowPosition) {
        String[] res = new String[2];
        if (move == null) {
            return null;
        }
        if (move[0] == null && move[1] == null) {
            return null;
        }
        if (move[0] != null && move[1] == null) {
            Square square = board.getSquare(move[0]);
            if (square.isEmpty()) {
                return new String[]{move[0]};
            } else {
                if (square.getChecker().isCheckerBlack() == ourColorIsBlack) {
                    return null;
                } else {
                    Square fight = fightImpossible(nowPosition, move[0]);
                    if (fight != null && fight.isEmpty()) {
                        board.getSquare(move[0]).setChecker(null);
                        return new String[]{fightImpossible(nowPosition, move[0]).getPosition()};
                    } else {
                        return new String[]{null};
                    }
                }
            }
        }
        if (move[0] == null && move[1] != null) {
            Square square = board.getSquare(move[1]);
            if (square.isEmpty()) {
                return new String[]{move[1]};
            } else {
                if (square.getChecker().isCheckerBlack() == ourColorIsBlack) {
                    return null;
                } else {
                    Square fight = fightImpossible(nowPosition, move[1]);
                    if (fight != null && fight.isEmpty()) {
                        board.getSquare(move[1]).setChecker(null);
                        return new String[]{fightImpossible(nowPosition, move[1]).getPosition()};
                    } else {
                        return new String[]{null};
                    }
                }
            }
        }
        if (move[0] != null && move[1] != null) {
            Square square = board.getSquare(move[0]);
            Square square2 = board.getSquare(move[1]);
            if (square.isEmpty()) {
                res[0] = move[0];
            } else {
                if (square.getChecker().isCheckerBlack() == ourColorIsBlack) {
                    res[0] = null;
                } else {
                    Square fight = fightImpossible(nowPosition, move[0]);
                    if (fight != null && fight.isEmpty()) {
                        res[0] = fight.getPosition();
                    } else {
                        res[0] = null;
                    }
                }
            }
            if (square2.isEmpty()) {
                res[1] = move[1];
            } else {
                if (square2.getChecker().isCheckerBlack() == ourColorIsBlack) {
                    res[1] = null;
                } else {
                    Square fight = fightImpossible(nowPosition, move[0]);
                    if (fight != null && fight.isEmpty()) {
                        res[1] = fight.getPosition();
                    } else {
                        res[1] = null;
                    }
                }
            }
        }
        return res;
    }

    public boolean ifWeAreHaveFight(boolean isOurColorBlack) {
        if (isOurColorBlack) {
            for (int i = 0; i < blackCheckers.size(); i++) {
                blackCheckers.get(i)
            }
        }

    }

    public void doingMove(String myNowPosition, String movePosition) {
        Square myNowChecker = board.getSquare(myNowPosition);
        Square newPositionChecker = board.getSquare(movePosition);

        newPositionChecker.setChecker(myNowChecker.getChecker());
        myNowChecker.setChecker(null);
    }

    public Square fightImpossible(String nowPosition, String witchCheckerWantFight) {
        Square square;
        char latter = nowPosition.charAt(0);
        int numChecker = Character.getNumericValue(nowPosition.charAt(1));
        int nuwCheckerPos = numChecker + 2;
        if (latter == 'A') {
            return checkRiteSide(latter, nuwCheckerPos);
        }
        if (latter == 'H') {
            return checkLeftSide(latter, nuwCheckerPos);
        }
        if (board.getPositionInt(latter) > board.getPositionInt(witchCheckerWantFight.charAt(0))) {
            square = checkRiteSide(latter, nuwCheckerPos);

        } else {
            square = checkLeftSide(latter, nuwCheckerPos);
        }
        return square.isEmpty() ? square : null;
    }

    public Square checkRiteSide(char latter, int nuwCheckerPos) {
        char newLatterRight = board.getPositionChar(board.getPositionInt(latter) + 2);
        return board.getSquare("" + newLatterRight + nuwCheckerPos);
    }

    public Square checkLeftSide(char latter, int nuwCheckerPos) {
        char newLatterLeft = board.getPositionChar(board.getPositionInt(latter) - 2);
        return board.getSquare("" + newLatterLeft + nuwCheckerPos);
    }
}
