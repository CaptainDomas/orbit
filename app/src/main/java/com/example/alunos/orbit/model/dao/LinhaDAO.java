package com.example.alunos.orbit.model.dao;

/**
 * Created by Avell 1513 on 08/09/2017.
 */

public class LinhaDAO {

    public static String getTabela() {
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE linha(");
        builder.append("id INTEGER NOT NULL,");
        builder.append("nome VARCHAR(45) NOT NULL,");
        builder.append("codigo INTEGER NOT NULL");
        builder.append(");");

        return builder.toString();
    }
}
