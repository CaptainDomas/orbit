package com.example.alunos.orbit.model;

import java.util.Date;
import java.util.List;

/**
 * Created by Avell 1513 on 08/09/2017.
 */

public class Horario {
    private int id;
    private Linha linha;
    private Terminal chegada;
    private Terminal saida;
    private List<Hora> partidas;

    public Horario(int id, Linha linha, Terminal chegada, Terminal saida, List<Hora> partidas) {
        this.id = id;
        this.linha = linha;
        this.chegada = chegada;
        this.saida = saida;
        this.partidas = partidas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Linha getLinha() {
        return linha;
    }

    public void setLinha(Linha linha) {
        this.linha = linha;
    }

    public Terminal getChegada() {
        return chegada;
    }

    public void setChegada(Terminal chegada) {
        this.chegada = chegada;
    }

    public Terminal getSaida() {
        return saida;
    }

    public void setSaida(Terminal saida) {
        this.saida = saida;
    }

    public List<Hora> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Hora> partidas) {
        this.partidas = partidas;
    }
}
