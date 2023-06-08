package com.oos.core.model;

import com.oos.exceptions.InvalidStateException;

import java.time.LocalDateTime;
import java.util.List;

public class Game implements Comparable<Game> {

    private int id;
    private Team home;
    private Team away;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime endAt;

    public Game(int id, String home, String away) {
        this.id = id;
        this.home = new Team(home, Type.HOME, 0);
        this.away = new Team(away, Type.AWAY, 0);
        this.status = Status.START;
        this.createdAt = LocalDateTime.now();
    }

    public void update(int home, int away) {
        if (List.of(Status.START, Status.PAUSE).contains(status)) {
            status = Status.IN_PROGRESS;
        }
        if (status == Status.FINISH) {
            throw new InvalidStateException("Game score cannot be updated");
        }

        this.home.setScore(home);
        this.away.setScore(away);
    }

    public void finish() {
        this.endAt = LocalDateTime.now();
    }

    private int totalScore() {
        return this.home.getScore() + this.away.getScore();
    }

    public int getId() {
        return id;
    }

    public Team getHome() {
        return home;
    }

    public Team getAway() {
        return away;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("%s %d - %s %d", home.getName(), home.getScore(), away.getName(), away.getScore());
    }

    @Override
    public int compareTo(Game other) {
        if (this.totalScore() > other.totalScore()) {
            return -1;
        } else if (this.totalScore() < other.totalScore()) {
            return 1;
        } else {
            return other.createdAt.compareTo(this.createdAt);
        }
    }
}
