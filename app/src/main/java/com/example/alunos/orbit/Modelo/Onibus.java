package com.example.alunos.orbit.Modelo;


public class Onibus {
    private int id;
    private String ano;
    private String ultimaRevisao;
    private String numeroOnibus;
    private String placa;


    public Onibus(int id, String ano, String ultimaRevisao, String numeroOnibus, String placa) {

        this.id = id;
        this.ano = ano;
        this.ultimaRevisao = ultimaRevisao;
        this.numeroOnibus = numeroOnibus;
        this.placa = placa;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getUltimaRevisao() {
        return ultimaRevisao;
    }

    public void setUltimaRevisao(String ultimaRevisao) {
        this.ultimaRevisao = ultimaRevisao;
    }

    public String getNumeroOnibus() {
        return numeroOnibus;
    }

    public void setNumeroOnibus(String numeroOnibus) {
        this.numeroOnibus = numeroOnibus;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }


}
