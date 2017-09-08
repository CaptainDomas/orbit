package com.example.alunos.orbit.model.dao;

/**
 * Created by Avell 1513 on 08/09/2017.
 */

public class HorarioDAO {

    public static String getTabela(){
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE horario(");
        builder.append("id INTEGER NOT NULL PRIMARY KEY,");
        builder.append("fk_linha INTEGER NOT NULL,");
        builder.append("fk_saida INTEGER NOT NULL,");
        builder.append("fk_chegada INTEGER NOT NULL,");
        builder.append("FOREIGN KEY (fk_linha) REFERENCES linha(id),");
        builder.append("FOREIGN KEY (fk_saida) REFERENCES terminal(id),");
        builder.append("FOREIGN KEY (fk_chegada) REFERENCES terminal(id),");
        builder.append(");");

        return builder.toString();
    }
}
