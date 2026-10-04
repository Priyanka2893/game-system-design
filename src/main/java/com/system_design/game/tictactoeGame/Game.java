package com.system_design.game.tictactoeGame;

public class Game {
    private Board board;
    private Player currentPlayer;
    private GameStatusEnum status;
    private Player[] players;

    public Game(Player[] player) {
        this.status = GameStatusEnum.IN_PROGRESS;
        this.players = player;
        board = new Board(3);
        currentPlayer = player[0];
    }

    public boolean makeMove(int row, int col){
        // 1. game already over ? reject
        if(status != GameStatusEnum.IN_PROGRESS){
            return false;
        }
        // 2. cell invalid ? reject, same player retries
        boolean valid = board.isValid(row, col);
        if (!valid){
            return false;
        }

        // 3. place current player symbol
        board.placeSymbol(row,col,currentPlayer.getSymbol());

        // 4. win? set status, announce winner
        boolean checkWin = board.checkWin(row, col, currentPlayer.getSymbol());
        if(checkWin){
            status = GameStatusEnum.WIN;
            System.out.println(currentPlayer.getName() + " wins!!");
            return true;
        }
        // 5. board full? set status draw
        boolean full = board.isFull();
        if(full){
            status = GameStatusEnum.DRAW;
            System.out.println("Game draws!!");

            return true;
        }
        // 6. switch current player
        if(currentPlayer == players[0]){
            currentPlayer = players[1];
        }else{
            currentPlayer = players[0];
        }
        return true;


    }

    public void restartGame(){
        board = new Board(3);
        status = GameStatusEnum.IN_PROGRESS;
        currentPlayer = players[0];
    }
}
