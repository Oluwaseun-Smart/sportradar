package com.oos.core.model;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreBoardTest {


    @Test
    void start() {
        ScoreBoard board = new ScoreBoard();
        final int gameId = board.start(1, "Poland", "Italy");
        assertEquals(gameId, 1);
        assertEquals(board.getGames().size(), 1);
    }

    @Test
    void update() {
        ScoreBoard board = new ScoreBoard();
        board.start(1, "Poland", "Italy");
        board.update(1, 6, 2);

        final Optional<Game> optional = board.getGames().stream().filter(g -> g.getId() == 1).findFirst();
        if (optional.isPresent()) {
            final Game game = optional.get();
            assertEquals(game.getHome().getScore(), 6);
            assertEquals(game.getAway().getScore(), 2);
        }
    }

    @Test
    void finish() {
        ScoreBoard board = new ScoreBoard();
        board.start(1, "Poland", "Italy");
        board.update(1, 2, 2);
        board.finish(1);

        final Optional<Game> optional = board.getGames().stream().filter(g -> g.getId() == 1).findFirst();
        assertFalse(optional.isPresent());
    }

    @Test
    void testGetGames() {

    }

    @Test
    void getSummary() {

    }
}
