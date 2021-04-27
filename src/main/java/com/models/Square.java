package com.models;

public class Square {
    private final String position;
    private final boolean isBlack;
    private Checker checker;
    public Square(String position, boolean isBlack, Checker checker) {
        this.position = position;
        this.isBlack = isBlack;
        this.checker = checker;
    }

    public String getPosition() {
        return position;
    }



    public boolean isBlack() {
        return isBlack;
    }

    public void setChecker(Checker checker) {
        this.checker = checker;
    }

    public boolean isEmpty(){
        return this.checker == null;
    }

    public Checker getChecker() {
        return checker;
    }

    @Override
    public String toString() {
        return "Square{" +
                "position='" + position + '\'' +
                ", isBlack=" + isBlack +
                ", checker=" + checker +
                '}';
    }
}
