package com.example.alunos.orbit.model;

/**
 * Created by Avell 1513 on 08/09/2017.
 */

public class Linha {
    private int id;
    private String nome;
    private int codigoLinha;

    public Linha(int id, String nome, int numero) {
        this.id = id;
        this.nome = nome;
        this.codigoLinha = numero;
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

    public int getCodigoLinha() {
        return codigoLinha;
    }

    public void setCodigoLinha(int codigoLinha) {
        this.codigoLinha = codigoLinha;
    }
}
