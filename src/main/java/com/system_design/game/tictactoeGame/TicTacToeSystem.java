package com.system_design.game.tictactoeGame;

public class TicTacToeSystem {
    public static void main(String[] args) {
        Game game = createGame("Priyanka", "Sanjay");
        game.makeMove(0,0);
        game.makeMove(1,0);
        game.makeMove(0,1);
        game.makeMove(1,2);
        game.makeMove(0,2);
        System.out.println(game.makeMove(2,2));
    }

    // simple factory
    public static Game createGame(String name1, String name2){
        Player player1 = new Player("Priyanka",SymbolEnum.X);
        Player player2 = new Player("Sanjay",SymbolEnum.O);

//        Player[] players = new Player[2];
//        players[0] = player1;
//        players[1] = player2;

        return new Game(new Player[]{player1,player2});


    }
}
