package com.example.alunos.orbit.Modelo;

public class Terminal {
    private  int id;
    private String telefone;
    private String nome;
    private String terminal;

    public Terminal(int id, String telefone, String nome, String terminal) {
        this.id = id;
        this.telefone = telefone;
        this.nome = nome;
        this.terminal = terminal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }
}



