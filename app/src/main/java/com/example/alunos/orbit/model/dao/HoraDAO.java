package com.example.alunos.orbit.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.alunos.orbit.database.DataBase;
import com.example.alunos.orbit.model.Hora;

import java.util.ArrayList;


/**
 * Created by Avell 1513 on 08/09/2017.
 */

public class HoraDAO {

    private DataBase database;
    private Context context;


    public HoraDAO(Context context) {
        database = new DataBase(context);
        this.context = context;
    }

    public static String getTabela() {
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE hora(");
        builder.append("id INTEGER NOT NULL PRIMARY KEY,");
        builder.append("valor VARCHAR(10) NOT NULL");
        builder.append(");");

        return builder.toString();

    }

    public void inserir(Hora novaHora) {
        SQLiteDatabase dataBase = database.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", novaHora.getId());
        values.put("valor", novaHora.getValor());

        dataBase.insert("hora", null, values);
    }

    public void remover(int id) {
        SQLiteDatabase dataBase = database.getWritableDatabase();


        String[] filtros = new String[1];
        filtros[0] = id + "";

        dataBase.delete("hora", "_id = ?", filtros);
    }

    public void editar(Hora hora) {
        SQLiteDatabase dataBase = database.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", hora.getId());
        values.put("valor", hora.getValor());


        String[] filtros = new String[1];
        filtros[0] = hora.getId() + "";

        dataBase.update("hora", values, "_id = ?", filtros);
    }

    public Hora buscar(int id) {
        Hora hora = null;
        SQLiteDatabase dataBase = database.getReadableDatabase();

        String sql = "SELECT _id, valor FROM hora WHERE id = ?";
        String[] filtros = new String[1];
        filtros[0] = id + "";

        Cursor cursor = dataBase.rawQuery(sql, filtros);
        if (cursor.moveToFirst()) {
            id = cursor.getInt(0);
            String valor = cursor.getString(1);


            HoraDAO hDao = new HoraDAO(context);
            Hora horaHorario = hDao.buscar(id);

            hora = new Hora(id, valor);
        }

        return hora;
    }

    public ArrayList<Hora> buscarHoras() {
        ArrayList<Hora> turmas = new ArrayList<Hora>();
        SQLiteDatabase dataBase = database.getReadableDatabase();

        String sql = "SELECT _id FROM turma";
        Cursor cursor = dataBase.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String valor = cursor.getString(1);

                Hora hora = new Hora(id, valor);
                turmas.add(hora);
            } while (cursor.moveToNext());
        }

        return null;
    }
}
