package com.oos.core.model;

import java.time.LocalDateTime;

public class Game {

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
}
