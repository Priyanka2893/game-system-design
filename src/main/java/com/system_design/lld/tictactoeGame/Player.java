package com.system_design.lld.tictactoeGame;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Player {
    private int id;

    private final String name;

    private SymbolEnum symbol;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
