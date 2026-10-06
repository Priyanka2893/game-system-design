package com.system_design.game.tictactoeGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeaderBoard implements GameObserver{

    private Map<Player,PlayerStats> stats = new HashMap<>();

    @Override
    public void update(Game game) {
        Player player1 = game.getPlayers()[0];
        Player player2 = game.getPlayers()[1];
        PlayerStats s1 = stats.computeIfAbsent(player1, p -> new PlayerStats());
        PlayerStats s2 = stats.computeIfAbsent(player2, p -> new PlayerStats());
//        PlayerStats s1 = stats.get(p1); // long form of lambda
//        if (s1 == null) {
//            s1 = new PlayerStats();
//            stats.put(p1, s1);
//        }
        if (game.getStatus() == GameStatusEnum.DRAW) {
            s1.addDraw();
            s2.addDraw();
        } else if (game.getWinner() == player1) {
            s1.addWin();
            s2.addLoss();
        } else {
            s2.addWin();
            s1.addLoss();
        }
    }

    public List<Map.Entry<Player, PlayerStats>> getLeaderBoard() {
        List<Map.Entry<Player, PlayerStats>> list = new ArrayList<>(stats.entrySet());
        list.sort((a, b) -> Integer.compare(b.getValue().getWin(), a.getValue().getWin()));
        return list;
    }
}
