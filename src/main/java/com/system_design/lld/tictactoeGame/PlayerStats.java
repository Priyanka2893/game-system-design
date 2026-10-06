package com.system_design.lld.tictactoeGame;

import lombok.Getter;

@Getter
public class PlayerStats {
    int win;
    int loss;
    int draw;

    public void addWin(){
        win++;
    }

    public void addLoss(){
        loss++;
    }

    public void addDraw(){
        draw++;
    }
}
