package com.oos.core.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreBoardTest {


    @Test
    void start() {
        ScoreBoard board = new ScoreBoard();
        final int gameId = board.start(1, "Poland", "Italy");
        assertEquals(gameId, 1);
    }

    @Test
    void update() {
        ScoreBoard board = new ScoreBoard();
        board.update(1, 6, 2);
    }

    @Test
    void finish() {
        ScoreBoard board = new ScoreBoard();
        board.finish(1);
    }

    @Test
    void testGetGames() {

    }

    @Test
    void getSummary() {

    }
}
