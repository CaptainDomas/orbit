package com.example.alunos.orbit.model;

/**
 * Created by Avell 1513 on 26/09/2017.
 */

public enum TipoDiaSemanaEnum {

    SEG_SEXTA("Segunda á sexta"),
    DOMINGOS_FERIADOS("Domingos e feriados"),
    SABADOS("Sábados");

    private String descricao;

    TipoDiaSemanaEnum(String descricao) {
        this.descricao = descricao;
    }
}
