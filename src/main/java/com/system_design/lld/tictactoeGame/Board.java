package com.system_design.lld.tictactoeGame;


public class Board {

    private Cell[][] cells;

    private int size;

    public Board(int size) {
        this.size = size;
        this.cells = new Cell[size][size];
        initCells();
    }

    private void initCells(){
        for (int row = 0; row < size; row++) { // 0 - col - 0,1,2, 1 - col - 0,1,2, 2 - col-0,1,2
            for (int col = 0; col < size; col++) {
                cells[row][col] = new Cell(row, col);
            }
        }
    }

    public void resetBoard(){
        initCells();
    }

    public Cell getCell(int x, int y){
        return cells[x][y];
    }

    public boolean isValid(int row, int col){
        boolean insideBoard = row >= 0 && row < size && col >= 0 && col < size;
        // && stops early: if outside, we never touch the array
        return insideBoard && cells[row][col].getSymbol() == SymbolEnum.EMPTY;

    }

    public void placeSymbol(int x, int y, SymbolEnum symbol){
        cells[x][y].setSymbol(symbol);
    }

    public boolean isFull(){
        // all cell have values
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(cells[row][col].getSymbol() == SymbolEnum.EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWin(int row, int col, SymbolEnum symbol) {
        // 1. row of the last move
        boolean rowWin = true;
        for (int i = 0; i < size; i++)
            if (cells[row][i].getSymbol() != symbol) rowWin = false;

        // 2. column of the last move
        boolean colWin = true;
        for (int i = 0; i < size; i++)
            if (cells[i][col].getSymbol() != symbol) colWin = false;

        // 3. main diagonal, only if the move is on it
        boolean diagWin = (row == col);
        for (int i = 0; i < size && diagWin; i++)
            if (cells[i][i].getSymbol() != symbol) diagWin = false;

        // 4. anti-diagonal, only if the move is on it
        boolean antiDiagWin = (row + col == size - 1);
        for (int i = 0; i < size && antiDiagWin; i++)
            if (cells[i][size - 1 - i].getSymbol() != symbol) antiDiagWin = false;

        return rowWin || colWin || diagWin || antiDiagWin;
    }
}
