package com.oos.core.model;

import java.time.LocalDateTime;

public class Game {

    private int id;
    private Team home;
    private Team away;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime endAt;
}
