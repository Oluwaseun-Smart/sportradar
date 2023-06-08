package com.oos.core.model;

import com.oos.exceptions.GameNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
    }

    public List<Game> getGames() {
        Collections.sort(games);
        return games;
    }

    public String getSummary() {
        return "";
    }

    private Game find(int id) {
        Optional<Game> optional = games.stream().filter(e -> e.getId() == id).findFirst();
        return optional.orElseThrow(() -> new GameNotFoundException("Game with id " + id + " not found"));
    }
}
