package com.example.alunos.orbit.Modelo;

public class Denuncia {
    private int id;
    private String avaliacao;
    private String idUsuario;
    private String texto;

    public Denuncia(int id, String avaliacao, String idUsuario, String texto) {
        this.id = id;
        this.avaliacao = avaliacao;
        this.idUsuario = idUsuario;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
