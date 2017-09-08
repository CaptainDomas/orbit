package com.example.alunos.orbit.model;

/**
 * Created by Avell 1513 on 08/09/2017.
 */

public class Usuario {
    private int id;
    private String nome;
    private int numCartao;
    private int saldo;

    public Usuario(int id, String nome, int numCartao, int saldo) {
        this.id = id;
        this.nome = nome;
        this.numCartao = numCartao;
        this.saldo = saldo;
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

    public int getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(int numCartao) {
        this.numCartao = numCartao;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
