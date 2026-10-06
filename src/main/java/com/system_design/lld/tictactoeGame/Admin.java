package com.system_design.lld.tictactoeGame;

import java.util.Map;

public class Admin {

    private final TicTacToeSystem system = TicTacToeSystem.getInstance();

    public int registerPlayer(String name) { return system.registerPlayer(name); }

    public void removePlayer(int id) { system.removePlayer(id); }

    public void viewGameHistory() {
        for (Game g : system.getGameHistory()) {
            String result = g.getStatus() == GameStatusEnum.DRAW
                    ? "Draw" : g.getWinner().getName() + " won";
            System.out.println(g.getPlayers()[0].getName() + " vs "
                    + g.getPlayers()[1].getName() + " -> " + result);
        }
    }

    public void viewLeaderboard() {
        for (Map.Entry<Player, PlayerStats> e : system.getLeaderBoard()) {
            PlayerStats s = e.getValue();
            System.out.println(e.getKey().getName() + "  W:" + s.getWin()
                    + " L:" + s.getLoss() + " D:" + s.getDraw());
        }
    }

//    Game game = createGame("Priyanka", "Sanjay");
//        game.makeMove(0,0);
//        game.makeMove(1,0);
//        game.makeMove(0,1);
//        game.makeMove(1,2);
//        game.makeMove(0,2);
//        System.out.println(game.makeMove(2,2));
}
