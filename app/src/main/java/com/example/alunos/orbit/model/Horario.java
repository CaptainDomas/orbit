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
    private List<String> partidas;
    private TipoDiaSemanaEnum tipoDiaSemana;

    public Horario(int id, Linha linha, Terminal terminalChegada, Terminal terminalSaida, List<String> partidas, TipoDiaSemanaEnum tipoDiaSemana) {
        this.id = id;
        this.linha = linha;
        this.terminalChegada = terminalChegada;
        this.terminalSaida = terminalSaida;
        this.partidas = partidas;
        this.tipoDiaSemana = tipoDiaSemana;
    }

    public Horario( Linha linha, Terminal terminalChegada, Terminal terminalSaida, List<String> partidas, TipoDiaSemanaEnum tipoDiaSemana) {

        this.linha = linha;
        this.terminalChegada = terminalChegada;
        this.terminalSaida = terminalSaida;
        this.partidas = partidas;
        this.tipoDiaSemana = tipoDiaSemana;
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

    public List<String> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<String> partidas) {
        this.partidas = partidas;
    }

    public TipoDiaSemanaEnum getTipoDiaSemana() {
        return tipoDiaSemana;
    }

    public void setTipoDiaSemana(TipoDiaSemanaEnum tipoDiaSemana) {
        this.tipoDiaSemana = tipoDiaSemana;
    }
}
