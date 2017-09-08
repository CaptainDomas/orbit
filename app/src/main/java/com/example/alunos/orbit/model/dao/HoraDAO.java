package com.example.alunos.orbit.model.dao;

/**
 * Created by Avell 1513 on 08/09/2017.
 */

public class HoraDAO {

    public static String getTabela() {
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE hora(");
        builder.append("id INTEGER NOT NULL PRIMARY KEY,");
        builder.append("valor VARCHAR(10) NOT NULL");
        builder.append(");");

        return builder.toString();
    }
}
