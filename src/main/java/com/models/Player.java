package com.models;

import java.util.Objects;

public class Player {
    private final boolean isBlack;
    private final boolean isBot;
    private final String login;

    public boolean isBlack() {
        return isBlack;
    }

    private boolean myChoose;

    public Player(boolean isBlack, boolean isBot, String login) {
        this.isBlack = isBlack;
        this.isBot = isBot;
        this.login = login;
    }

    public boolean isMyChoose() {
        return myChoose;
    }

    public void setMyChoose(boolean myChoose) {
        this.myChoose = myChoose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return isBlack == player.isBlack && isBot == player.isBot && Objects.equals(login, player.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isBlack, isBot, login);
    }

    @Override
    public String toString() {
        return "Player{" +
                "isBlack=" + isBlack +
                ", isBot=" + isBot +
                ", login='" + login + '\'' +
                '}';
    }
}
