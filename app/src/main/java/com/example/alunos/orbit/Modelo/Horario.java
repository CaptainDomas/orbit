package com.example.alunos.orbit.Modelo;


public class Horario {
    private String horario;
    private int id;
    private Linha linha;
    private Terminal terminal;

    public Horario(int id, String horario) {
        this.id = id;
        this.linha = linha;
        this.terminal = terminal;
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }
}

