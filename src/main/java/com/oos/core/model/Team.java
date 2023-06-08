package com.oos.core.model;

public class Team {

    private String name;
    private int score;
    private Type type;

    public Team(String name, Type type, int score) {
        this.name = name;
        this.type = type;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
