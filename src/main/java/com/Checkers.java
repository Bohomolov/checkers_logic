package com;

import com.models.Board;
import com.models.Player;
import com.models.Square;

import java.util.*;

public class Checkers {
    private final Scanner scanner = new Scanner(System.in);
    private final Board board;
    private final Player player;
    private HashMap<HashMap<String, String>, List<String>> chooses;
    String withCheckWeFight;
    List<String> moves;

    public Checkers(Board board, Player player) {
        this.board = board;
        this.player = player;

    }

    public void doMoveWight(Player player) {
        board.printBoard();
        chooses = ifWeAreHaveFight(player.isBlack());
        System.out.println(chooses);
        System.out.println("Select move");
        System.out.println(player.getLogin() + " make chose");
        String command = scanner.nextLine();
        if(board.getSquare(command) == null || board.getSquare(command).isEmpty()){
            System.out.println("Пустая клетка " + player.getLogin());
            doMoveWight(player);
            return;
        }
        if (board.getSquare(command).getChecker().isCheckerBlack() != player.isBlack()) {
            System.out.println("Выбери свой цвет мудак " + player.getLogin());
            doMoveWight(player);
            return;
        }
        moves = getImpossibleMove(command, player.isBlack());
//
        if (chooses.size()  >0) {
            chooses.forEach((k, v) -> {
                withCheckWeFight = k.get(command);
                moves = v;
            });
        }

        if(chooses.size()>0 && withCheckWeFight == null){
            System.out.println("Нужно бить !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
            doMoveWight(player);
            return;
        }


        System.out.println("Your impossible move: " + moves + " " + chooses);
        String myChoseMove = scanner.nextLine();
        if (moves != null) {

            if (myChoseMove.equals(moves.get(0)) || myChoseMove.equals(moves.get(1)) && !myChoseMove.equals("null")) {
                if (withCheckWeFight != null) {
                    doingMove(command, myChoseMove);
                    board.getSquare(withCheckWeFight).setChecker(null);
                } else doingMove(command, myChoseMove);
            }
        }
    }


    public List<String> getImpossibleMove(String move, boolean ourColorIsBlack) {

        Square currentSquare = board.getSquare(move);
        List<String> impossibleMoves = new ArrayList<>();
        if (currentSquare == null || currentSquare.isEmpty()) {
            return null;
        }
        char currentLetter = move.charAt(0);
        int currentNumber = ourColorIsBlack ? Character.getNumericValue(move.charAt(1)) - 1 : Character.getNumericValue(move.charAt(1)) + 1;

        if (currentLetter == 'H') {
            impossibleMoves.add(board.getPositionChar(board.getPositionInt(currentLetter) - 1) + "" + currentNumber);
            return impossibleMoves;
        }

        if (currentLetter == 'A') {
            impossibleMoves.add(board.getPositionChar(board.getPositionInt(currentLetter) + 1) + "" + currentNumber);
            return impossibleMoves;
        }

        impossibleMoves.add(board.getPositionChar(board.getPositionInt(currentLetter) - 1) + "" + currentNumber);
        impossibleMoves.add(board.getPositionChar(board.getPositionInt(currentLetter) + 1) + "" + currentNumber);

        return impossibleMoves;
    }

//    public List<String> chekIsMoveValid(List<String> move, boolean ourColorIsBlack, String nowPosition) {
//        List<String> res = new ArrayList<>();
//        if (move == null) {
//            return null;
//        }
//        if (move.get(0) == null && move.get(1) == null) {
//            return null;
//        }
//        if (move.get(0) != null && move[1] == null) {
//            Square square = board.getSquare(move[0]);
//            if (square.isEmpty()) {
//                return new ArrayList<>({move.get(0)};
//            } else {
//                if (square.getChecker().isCheckerBlack() == ourColorIsBlack) {
//                    return null;
//                } else {
//                    Square fight = fightImpossible(nowPosition, move[0]);
//                    if (fight != null && fight.isEmpty()) {
//                        board.getSquare(move[0]).setChecker(null);
//                        return new String[]{fightImpossible(nowPosition, move[0]).getPosition()};
//                    } else {
//                        return new String[]{null};
//                    }
//                }
//            }
//        }
//        if (move[0] == null && move[1] != null) {
//            Square square = board.getSquare(move[1]);
//            if (square.isEmpty()) {
//                return new String[]{move[1]};
//            } else {
//                if (square.getChecker().isCheckerBlack() == ourColorIsBlack) {
//                    return null;
//                } else {
//                    Square fight = fightImpossible(nowPosition, move[1]);
//                    if (fight != null && fight.isEmpty()) {
//                        board.getSquare(move[1]).setChecker(null);
//                        return new String[]{fightImpossible(nowPosition, move[1]).getPosition()};
//                    } else {
//                        return new String[]{null};
//                    }
//                }
//            }
//        }
//        if (move[0] != null && move[1] != null) {
//            Square square = board.getSquare(move[0]);
//            Square square2 = board.getSquare(move[1]);
//            if (square.isEmpty()) {
//                res[0] = move[0];
//            } else {
//                if (square.getChecker().isCheckerBlack() == ourColorIsBlack) {
//                    res[0] = null;
//                } else {
//                    Square fight = fightImpossible(nowPosition, move[0]);
//                    if (fight != null && fight.isEmpty()) {
//                        res[0] = fight.getPosition();
//                    } else {
//                        res[0] = null;
//                    }
//                }
//            }
//            if (square2.isEmpty()) {
//                res[1] = move[1];
//            } else {
//                if (square2.getChecker().isCheckerBlack() == ourColorIsBlack) {
//                    res[1] = null;
//                } else {
//                    Square fight = fightImpossible(nowPosition, move[0]);
//                    if (fight != null && fight.isEmpty()) {
//                        res[1] = fight.getPosition();
//                    } else {
//                        res[1] = null;
//                    }
//                }
//            }
//        }
//        return res;
//    }

    public HashMap<HashMap<String, String>, List<String>> ifWeAreHaveFight(boolean isOurColorBlack) {
        HashMap<HashMap<String, String>, List<String>> res = new HashMap<>();

        if (!isOurColorBlack) {
            ifWeAreHaveFightForDifferentCollar(res, board.getAllByColor(false), isOurColorBlack);
        } else {
            ifWeAreHaveFightForDifferentCollar(res, board.getAllByColor(true), isOurColorBlack);
        }
        return res;
    }

    private void ifWeAreHaveFightForDifferentCollar(HashMap<HashMap<String, String>, List<String>> res, List<Square> squares, boolean ourColor) {
        for (Square square : squares) {
            List<String> currentList = new ArrayList<>();
            char latter = square.getPosition().charAt(0);
            int numCheck = Character.getNumericValue(square.getPosition().charAt(1));
            char latterUpd;
            int numUpd;

            if (board.getPositionInt(latter) < 6 && numCheck < 6) {
                latterUpd = board.getPositionChar(board.getPositionInt(latter) + 1);
                numUpd = numCheck + 1;
                checkDestination(res, currentList, square.getPosition(), latter, numCheck, latterUpd, numUpd, ourColor, 2, 2);
            }
            if (board.getPositionInt(latter) >= 2 && numCheck < 6) {
                latterUpd = board.getPositionChar(board.getPositionInt(latter) - 1);
                numUpd = numCheck + 1;
                checkDestination(res, currentList, square.getPosition(), latter, numCheck, latterUpd, numUpd, ourColor, -2, 2);
            }
            if (board.getPositionInt(latter) < 6 && numCheck >= 2) {
                latterUpd = board.getPositionChar(board.getPositionInt(latter) + 1);
                numUpd = numCheck - 1;
                checkDestination(res, currentList, square.getPosition(), latter, numCheck, latterUpd, numUpd, ourColor, 2, -2);
            }
            if (board.getPositionInt(latter) >= 2 && numCheck >= 2) {
                latterUpd = board.getPositionChar(board.getPositionInt(latter) - 1);
                numUpd = numCheck - 1;
                checkDestination(res, currentList, square.getPosition(), latter, numCheck, latterUpd, numUpd, ourColor, -2, -2);
            }

        }
    }

    private void checkDestination(HashMap<HashMap<String, String>, List<String>> res, List<String> currentList, String squarePosition, char latter, int numCheck, char letterUpdate, int numUpdate, boolean color, int newPositionChar, int newPositionNum) {
        HashMap<String, String> currentAndFightingCheckers = new HashMap<>();
        Square checkedSq = board.getSquare("" + letterUpdate + numUpdate);
        if (checkedSq != null && !checkedSq.isEmpty() && checkedSq.getChecker().isCheckerBlack() != color) {
            char latterUpd2 = board.getPositionChar(board.getPositionInt(latter) + newPositionChar);
            int numUpd2 = numCheck + newPositionNum;
            Square nexAfterChecked = board.getSquare("" + latterUpd2 + numUpd2);
            if (nexAfterChecked != null && nexAfterChecked.isEmpty()) {
                currentList.add(nexAfterChecked.getPosition());
                currentAndFightingCheckers.put(squarePosition, checkedSq.getPosition());
                res.put(currentAndFightingCheckers, currentList);
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
