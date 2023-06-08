package com.oos.core.service;

import com.oos.core.model.Game;
import com.oos.exceptions.GameNotFoundException;
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
    void updateGame_WithInvalid_Id_Should_ThrowException() {
        Exception exception = assertThrows(GameNotFoundException.class, () -> {
            ScoreBoard board = new ScoreBoard();
            board.start(1, "Poland", "Italy");
            board.update(2, 6, 2);
        });

        String expectedMessage = "Game with Id 2 does not exist";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
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
    void finishGame_WithInvalid_Id_Should_ThrowException() {
        Exception exception = assertThrows(GameNotFoundException.class, () -> {
            ScoreBoard board = new ScoreBoard();
            board.start(1, "Poland", "Italy");
            board.finish(2);
        });

        String expectedMessage = "Game with Id 2 does not exist";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testGetGames() {
        ScoreBoard board = new ScoreBoard();
        board.start(1, "Nigeria", "Germany");
        board.start(2, "France", "Egypt");
        board.start(3, "Poland", "Kenya");
        board.start(4, "Australia", "Spain");
        board.start(5, "Portugal", "China");

        board.update(1, 3, 1);
        board.update(2, 6, 2);
        board.update(5, 12, 2);

        assertAll(
                () -> assertEquals(5, board.getGames().get(0).getId()),
                () -> assertEquals(2, board.getGames().get(1).getId()),
                () -> assertEquals(1, board.getGames().get(2).getId())
        );
    }

    @Test
    void getSummary() {
        ScoreBoard board = new ScoreBoard();
        board.start(1, "Nigeria", "Germany");
        board.start(2, "France", "Egypt");

        assertNotNull(board.getSummary());
    }
}
