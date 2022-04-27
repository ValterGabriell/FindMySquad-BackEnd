package com.FindMySquad.FindMySquad.Model.Users;

import com.FindMySquad.FindMySquad.Model.Games;
import com.FindMySquad.FindMySquad.Model.Plataforma;

import java.util.ArrayList;

public class ModelReponse {
    private String nickname;
    private String horario;
    private ArrayList<Games> games;
    private ArrayList<Plataforma> plataforma;
    private String email;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public ArrayList<Games> getGames() {
        return games;
    }

    public void setGames(ArrayList<Games> games) {
        this.games = games;
    }

    public ArrayList<Plataforma> getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(ArrayList<Plataforma> plataforma) {
        this.plataforma = plataforma;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
