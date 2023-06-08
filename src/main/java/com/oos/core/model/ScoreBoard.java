package com.oos.core.model;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {

    private List<Game> games = new ArrayList<>();

    public int start(int id, String home, String away) {
        Game game = new Game(id, home, away);
        games.add(game);
        return id;
    }

    public void update(int id, int home, int away) {

    }

    public void finish(int id) {
    }

    public List<Game> getGames() {
        return new ArrayList<>();
    }

    public String getSummary() {
        return "";
    }
}
