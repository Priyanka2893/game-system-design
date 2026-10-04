package com.system_design.game.tictactoeGame;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Player {
    private final String name;

    private SymbolEnum symbol;

}
