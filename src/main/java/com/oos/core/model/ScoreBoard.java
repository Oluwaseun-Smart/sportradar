package com.oos.core.model;

import com.oos.exceptions.GameNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ScoreBoard {

    private List<Game> games = new ArrayList<>();

    public int start(int id, String home, String away) {
        Game game = new Game(id, home, away);
        games.add(game);
        return id;
    }

    public void update(int id, int home, int away) {
        find(id).update(home, away);
    }

    public void finish(int id) {
        Game game = find(id);
        game.finish();
        games.remove(game);
    }

    public List<Game> getGames() {
        Collections.sort(games);
        return games;
    }

    public String getSummary() {
        return games.stream().sorted().map(Game::toString).collect(Collectors.joining("\n"));
    }

    private Game find(int id) {
        Optional<Game> optional = games.stream().filter(e -> e.getId() == id).findFirst();
        return optional.orElseThrow(() -> new GameNotFoundException("Game with id " + id + " not found"));
    }
}
