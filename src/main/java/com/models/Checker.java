package com.models;

public class Checker {
    private final boolean isCheckerBlack;
    private boolean isQueen;

    public Checker(boolean isCheckerBlack, boolean isQueen) {
        this.isCheckerBlack = isCheckerBlack;
        this.isQueen = isQueen;
    }

    public boolean isCheckerBlack() {
        return isCheckerBlack;
    }

    public boolean isQueen() {
        return isQueen;
    }

    public void setQueen(boolean queen) {
        isQueen = queen;
    }

    @Override
    public String toString() {
        return "Checker{" +
                "isCheckerBlack=" + isCheckerBlack +
                ", isQueen=" + isQueen +
                '}';
    }
}
