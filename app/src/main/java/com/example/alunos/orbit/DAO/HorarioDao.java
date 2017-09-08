package com.example.alunos.orbit.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.alunos.orbit.Modelo.Horario;

import java.util.ArrayList;


public class HorarioDao {
    private BancoDados bd;

    public HorarioDao(Context context) {
        bd = new BancoDados(context);
    }

    public void inserir(Horario novohorario) {
        SQLiteDatabase db = bd.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", novohorario.getId());
        values.put("linha",novohorario.getLinha().getId());
        db.insert("Horario", null, values);
    }

    public void remover(int id) {
        SQLiteDatabase db = bd.getWritableDatabase();
        String[] filtros = new String[1];
        filtros[0] = id + "";
        db.delete("horario", "_id = ?", filtros);
    }

    public void editar(Horario horario) {
        SQLiteDatabase db = bd.getWritableDatabase();

        ContentValues values;
        values = new ContentValues();
        values.put("horario", horario.getHorario());
        String[] filtros = new String[1];
        filtros[0] = horario.getId() + "";

        db.update("horario", values, "_id = ?", filtros);
    }

    public Horario buscar(int id) {
        Horario horario = null;
        SQLiteDatabase db = bd.getReadableDatabase();

        String sql = "SELECT _id, nomeLinha FROM Horario WHERE id = ?";
        String[] filtros = new String[1];
        filtros[0] = id + "";

        Cursor cursor = db.rawQuery(sql, filtros);
        if (cursor.moveToFirst()) {
            int idHorario= cursor.getInt(0);
            String nomeHorario= cursor.getString(1);

            horario = new Horario(idHorario,nomeHorario );
        }

        return horario;
    }

    public ArrayList<Horario> buscarTodos() {
        ArrayList<Horario> Horarios = new ArrayList<Horario>();
        SQLiteDatabase db = bd.getReadableDatabase();

        String sql = "SELECT _id, nomeLinha FROM Horario WHERE id = ?";
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                int idHorario = cursor.getInt(0);
                String nomeHorario = cursor.getString(1);

                Horario horario = new Horario(idHorario, nomeHorario);
                Horarios.add(horario);
            } while (cursor.moveToNext());
        }

        return null;
    }
}


