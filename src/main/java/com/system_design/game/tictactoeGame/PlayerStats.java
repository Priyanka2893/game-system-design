package com.system_design.game.tictactoeGame;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

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
