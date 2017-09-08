package com.example.alunos.orbit.model;

/**
 * Created by Avell 1513 on 08/09/2017.
 */

public class Linha {
    private int id;
    private String nome;
    private int numero;

    public Linha(int id, String nome, int numero) {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
