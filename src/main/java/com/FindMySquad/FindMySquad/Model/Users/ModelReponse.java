package com.FindMySquad.FindMySquad.Model.Users;

import com.FindMySquad.FindMySquad.Model.Games;
import com.FindMySquad.FindMySquad.Model.Plataforma;

import java.util.ArrayList;

public class ModelReponse {
    private String nickname;
    private String horario;
    private ArrayList<Games> listaJogos;
    private ArrayList<Plataforma> listaPlataforma;
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

    public ArrayList<Games> getListaJogos() {
        return listaJogos;
    }

    public void setListaJogos(ArrayList<Games> listaJogos) {
        this.listaJogos = listaJogos;
    }

    public ArrayList<Plataforma> getListaPlataforma() {
        return listaPlataforma;
    }

    public void setListaPlataforma(ArrayList<Plataforma> listaPlataforma) {
        this.listaPlataforma = listaPlataforma;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
