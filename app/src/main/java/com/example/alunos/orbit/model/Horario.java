package com.example.alunos.orbit.model;

import java.util.Date;
import java.util.List;

/**
 * Created by Avell 1513 on 08/09/2017.
 */

public class Horario {
    private int id;
    private Linha linha;
    private Terminal chegada;
    private Terminal saida;
    private List<Hora> partidas;
}
