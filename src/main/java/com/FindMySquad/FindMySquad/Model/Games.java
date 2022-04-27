package com.FindMySquad.FindMySquad.Model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;


public class  Games implements Serializable {
    private String nameGame;

    public String getNameGame() {
        return nameGame;
    }

    public void setNameGame(String nameGame) {
        this.nameGame = nameGame;
    }
}
