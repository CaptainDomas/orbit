package com.example.alunos.orbit.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.alunos.orbit.database.DataBase;
import com.example.alunos.orbit.model.Horario;



/**
 * Created by Avell 1513 on 08/09/2017.
 */

public class HorarioDAO {

    private DataBase database;
    private Context context;

    public HorarioDAO(Context context) {
        database = new DataBase(context);
        this.context = context;
    }

    public static String getTabela() {
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
    public void inserir(Horario novoHorario) {
        SQLiteDatabase dataBase = database.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id",novoHorario.getId());

        dataBase.insert("hora", null, values);
    }


}
