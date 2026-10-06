package com.system_design.game.tictactoeGame;

public class Demo {

    public static void main(String[] args) {
        Admin admin = new Admin();
        int priyanka = admin.registerPlayer("Priyanka");
        int sanjay = admin.registerPlayer("Sanjay");

        TicTacToeSystem system = TicTacToeSystem.getInstance();

        // Game 1: Priyanka (X) wins with the top row
        Game g1 = system.createGame(priyanka, sanjay);
        g1.makeMove(0, 0); g1.makeMove(1, 0);
        g1.makeMove(0, 1); g1.makeMove(1, 1);
        g1.makeMove(0, 2);
        System.out.println("Move after game over accepted? " + g1.makeMove(2, 2));

        // Game 2: Sanjay plays X, ends in a draw
        Game g2 = system.createGame(sanjay, priyanka);
        g2.makeMove(0, 0); g2.makeMove(0, 1); g2.makeMove(0, 2);
        g2.makeMove(1, 1); g2.makeMove(2, 1); g2.makeMove(1, 2);
        g2.makeMove(1, 0); g2.makeMove(2, 0); g2.makeMove(2, 2);

        System.out.println("\n--- Game History ---");
        admin.viewGameHistory();
        System.out.println("\n--- Leaderboard ---");
        admin.viewLeaderboard();

    }
}
