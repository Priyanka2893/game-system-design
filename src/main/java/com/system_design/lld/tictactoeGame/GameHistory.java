package com.system_design.lld.tictactoeGame;

import java.util.ArrayList;
import java.util.List;

public class GameHistory implements GameObserver{

    private List<Game> games = new ArrayList<>();

    @Override
    public void update(Game game) {
        games.add(game);
    }

    public List<Game> getGame(){
        return games;
    }
}
