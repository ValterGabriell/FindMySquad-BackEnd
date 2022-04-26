package com.FindMySquad.FindMySquad.Model.Requisition;

import com.FindMySquad.FindMySquad.Model.Games;
import com.FindMySquad.FindMySquad.Model.Plataforma;

import java.util.ArrayList;

public class ModelRequisitonRequest {


    private Integer id;
    private String userId;
    private String nickname;
    private String horario;
    private ArrayList<Games> listaGames;
    private ArrayList<Plataforma> listaPlataforma;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public ArrayList<Games> getListaGames() {
        return listaGames;
    }

    public void setListaGames(ArrayList<Games> listaGames) {
        this.listaGames = listaGames;
    }

    public ArrayList<Plataforma> getListaPlataforma() {
        return listaPlataforma;
    }

    public void setListaPlataforma(ArrayList<Plataforma> listaPlataforma) {
        this.listaPlataforma = listaPlataforma;
    }
}
