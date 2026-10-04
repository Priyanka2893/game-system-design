package com.system_design.game.tictactoeGame;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cell {

    private final int row;

    private final int col;

    private SymbolEnum symbol;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.symbol = SymbolEnum.EMPTY;
    }
}
