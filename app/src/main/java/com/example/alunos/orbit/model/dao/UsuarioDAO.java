package com.example.alunos.orbit.model.dao;

/**
 * Created by Avell 1513 on 08/09/2017.
 */

public class UsuarioDAO {

    public static String getTabela() {
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE usuario(");
        builder.append("id INTEGER NOT NULL PRIMARY KEY,");
        builder.append("nome VARCHAR(45) NOT NULL,");
        builder.append("email VARCHAR(45) NOT NULL,");
        builder.append("numero_cartao INTEGER NOT NULL");
        builder.append(");");

        return builder.toString();
    }
}
