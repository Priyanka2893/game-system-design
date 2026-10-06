package com.system_design.game.tictactoeGame;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicTacToeSystem {

    private static volatile TicTacToeSystem instance;
    private Map<Integer,Player> players = new HashMap<>();
    private GameHistory gameHistory = new GameHistory();
    private LeaderBoard leaderBoard = new LeaderBoard();
    private int playerIdCount = 0;

    private TicTacToeSystem() {

    }

    public static TicTacToeSystem getInstance(){
        if(instance == null){
            synchronized (TicTacToeSystem.class){
                if(instance == null){
                    instance = new TicTacToeSystem();
                }
            }
        }
        return instance;
    }

    public Game createGame(int playerId1, int playerId2){
        Player player1 = players.get(playerId1);
        player1.setSymbol(SymbolEnum.X);

        Player player2 = players.get(playerId2);
        player2.setSymbol(SymbolEnum.O);

        Game game = new Game(new Player[]{player1, player2});
        game.addObserver(gameHistory);
        game.addObserver(leaderBoard);
        return game;
    }

    public int registerPlayer(String name){
        int id = playerIdCount++;
        players.put(id, new Player(id, name));
        return id;

    }

    public void removePlayer(int id){
        players.remove(id);
    }

    public List<Game> getGameHistory(){
        return gameHistory.getGame();
    }

    public List<Map.Entry<Player, PlayerStats>> getLeaderBoard(){
        return leaderBoard.getLeaderBoard();
    }

}

// simple factory
//    public static Game createGame(String name1, String name2){
//        Player player1 = new Player("Priyanka",SymbolEnum.X);
//        Player player2 = new Player("Sanjay",SymbolEnum.O);
//
////        Player[] players = new Player[2];
////        players[0] = player1;
////        players[1] = player2;
//
//        return new Game(new Player[]{player1,player2});


//    }
