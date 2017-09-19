package com.example.alunos.orbit.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.alunos.orbit.database.DataBase;
import com.example.alunos.orbit.model.Linha;

import java.util.ArrayList;

/**
 * Created by Avell 1513 on 08/09/2017.
 */

public class LinhaDAO {
    private DataBase database;
    private Context context;


    public LinhaDAO(Context context) {
        database = new DataBase(context);
        this.context = context;
    }

    public static String getTabela() {
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE linha(");
        builder.append("id INTEGER NOT NULL,");
        builder.append("nome VARCHAR(45) NOT NULL,");
        builder.append("codigolinha INTEGER NOT NULL");
        builder.append(");");

        return builder.toString();
    }

    public void inserir(Linha novalinha) {
        SQLiteDatabase dataBase = database.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", novalinha.getId());
        values.put("nome", novalinha.getNome());
        values.put("codigolinha", novalinha.getCodigoLinha());

        dataBase.insert("linha", null, values);
    }

    public void remover(int id) {
        SQLiteDatabase dataBase = database.getWritableDatabase();


        String[] filtros = new String[1];
        filtros[0] = id + "";

        dataBase.delete("linha", "_id = ?", filtros);
    }

    public void editar(Linha linha) {
        SQLiteDatabase dataBase = database.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", linha.getId());
        values.put("nome", linha.getNome());
        values.put("codigolinha", linha.getCodigoLinha());


        String[] filtros = new String[1];
        filtros[0] = linha.getId() + "";

        dataBase.update("linha", values, "_id = ?", filtros);
    }

    public Linha buscar(int id) {
        Linha linha = null;
        SQLiteDatabase dataBase = database.getReadableDatabase();

        String sql = "SELECT _id, nome, codigolinha FROM linha WHERE id = ?";
        String[] filtros = new String[1];
        filtros[0] = id + "";

        Cursor cursor = dataBase.rawQuery(sql, filtros);
        if (cursor.moveToFirst()) {
            id = cursor.getInt(0);
            String nome = cursor.getString(1);
            int codigolinha = cursor.getInt(2);

            LinhaDAO lDao = new LinhaDAO(context);
            Linha linhaHorario = lDao.buscar(id);

            linha = new Linha(id, nome, codigolinha);
        }

        return linha;
    }

    public ArrayList<Linha> buscarTodasaslinhas() {
        ArrayList<Linha> linhas = new ArrayList<Linha>();
        SQLiteDatabase dataBase = database.getReadableDatabase();

        String sql = "SELECT id FROM linha";
        Cursor cursor = dataBase.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String nome = cursor.getString(1);
                int codigolinha = cursor.getInt(2);

                Linha linha = new Linha(id, nome, codigolinha);
                linhas.add(linha);
            } while (cursor.moveToNext());
        }

        return null;
    }
}






