package com.example.alunos.orbit.model.dao;

/**
 * Created by Avell 1513 on 08/09/2017.
 */

public class TerminalDAO {

    public static String getTabela(){
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE terminal(");
        builder.append("id INTEGER NOT NULL PRIMARY KEY,");
        builder.append("nome VARCHAR(45) NOT NULL,");
        builder.append("endereco VARCHAR(45) NOT NULL");
        builder.append(");");

        return builder.toString();
    }

}
