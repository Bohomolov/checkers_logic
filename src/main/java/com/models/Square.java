package com.models;

public class Square {
    private final String position;
    private final boolean isBlack;
    private boolean isEmpty;
    private final boolean isCheckerBlack;

    public Square(String position, boolean isEmpty, boolean isBlack, boolean isCheckerBlack) {
        this.position = position;
        this.isEmpty = isEmpty;
        this.isBlack = isBlack;
        this.isCheckerBlack = isCheckerBlack;
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
