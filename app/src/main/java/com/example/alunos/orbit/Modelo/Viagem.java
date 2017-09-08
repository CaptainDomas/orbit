package com.example.alunos.orbit.Modelo;

public class Viagem {

    private int id;
    private int motoristaFk;
    private int onibusFk;
    private int horarioFk;
    private Viagem viagem;

    public Viagem(int id, int motoristaFk, int onibusFk, int horarioFk, Viagem viagem) {
        this.id = id;
        this.motoristaFk = motoristaFk;
        this.onibusFk = onibusFk;
        this.horarioFk = horarioFk;
        this.viagem = viagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMotoristaFk() {
        return motoristaFk;
    }

    public void setMotoristaFk(int motoristaFk) {
        this.motoristaFk = motoristaFk;
    }

    public int getOnibusFk() {
        return onibusFk;
    }

    public void setOnibusFk(int onibusFk) {
        this.onibusFk = onibusFk;
    }

    public int getHorarioFk() {
        return horarioFk;
    }

    public void setHorarioFk(int horarioFk) {
        this.horarioFk = horarioFk;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }
}
