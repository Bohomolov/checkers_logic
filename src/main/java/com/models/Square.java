package com.models;

public class Square {
    private final String position;
    private final boolean isBlack;
    private boolean isEmpty;
    private boolean isCheckerBlack;
    public Square(String position, boolean isEmpty, boolean isBlack, boolean isCheckerBlack) {
        this.position = position;
        this.isEmpty = isEmpty;
        this.isBlack = isBlack;
        this.isCheckerBlack = isCheckerBlack;
    }

    public String getPosition() {
        return position;
    }

    public void setCheckerBlack(boolean checkerBlack) {
        isCheckerBlack = checkerBlack;
    }

    public boolean isBlack() {
        return isBlack;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public boolean isCheckerBlack() {
        return isCheckerBlack;
    }

    @Override
    public String toString() {
        return "Square{" +
                "position='" + position + '\'' +
                ", isBlack=" + isBlack +
                ", isEmpty=" + isEmpty +
                ", isCheckerBlack=" + isCheckerBlack +
                '}';
    }
}
