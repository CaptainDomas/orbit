package com.example.alunos.orbit.model;

import java.util.List;

/**
 * Created by Avell 1513 on 08/09/2017.
 */

public class Horario {
    private int id;
    private Linha linha;
    private Terminal terminalChegada;
    private Terminal terminalSaida;
    private List<Hora> partidas;



    public Horario(int id,Linha linha, Terminal  terminalSaida, Terminal  terminalChegada,  List<Hora> partidas) {
        this.id = id;
        this.linha = linha;
        this.terminalChegada = terminalChegada;
        this.terminalSaida = terminalSaida;
        this.partidas = partidas;
    }


    public Terminal getTerminalChegada() {
        return terminalChegada;
    }

    public void setTerminalChegada(Terminal terminalChegada) {
        this.terminalChegada = terminalChegada;
    }

    public Terminal getTerminalSaida() {
        return terminalSaida;
    }

    public void setTerminalSaida(Terminal terminalSaida) {
        this.terminalSaida = terminalSaida;
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

    public List<Hora> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Hora> partidas) {
        this.partidas = partidas;
    }
}
