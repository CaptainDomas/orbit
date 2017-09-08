package com.example.alunos.orbit.model;

/**
 * Created by Avell 1513 on 08/09/2017.
 */

public class Hora {
    private int id;
    private String valor;

    public Hora(int id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
