package com.example.alunos.orbit.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.alunos.orbit.Modelo.Linha;


import java.util.ArrayList;


public class LinhaDao {
    private BancoDados bd;
    private Context context;

    public LinhaDao(Context context) {
        bd = new BancoDados(context);
        this.context = context;
    }
    public void inserir (Linha novalinha ) {
        SQLiteDatabase db = bd.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("linha", novalinha.getLinha());
        values.put("id_Horario",novalinha.gethorario().getId());

        db.insert("LinhaDao", null, values);
    }
    public void remover(int id) {
        SQLiteDatabase db = bd.getWritableDatabase();

        String[] filtros = new String[1];
        filtros[0] = id + "";

        db.delete("linha", "_id = ?", filtros);
    }
    public void editar(Linha linha) {
        SQLiteDatabase db = bd.getWritableDatabase();

        ContentValues values;
        values = new ContentValues();
        values.put("linha", linha.getLinha());
        String[] filtros = new String[1];
        filtros[0] = linha.getId() + "";

        db.update("linha", values, "_id = ?", filtros);
    }
    public Linha buscar(int id) {
        Linha linha = null;
        SQLiteDatabase db = bd.getReadableDatabase();

        String sql = "SELECT _id, nomeLinha FROM Horario WHERE id = ?";
        String[] filtros = new String[1];
        filtros[0] = id + "";

        Cursor cursor = db.rawQuery(sql, filtros);
        if (cursor.moveToFirst()) {
            int idLinha= cursor.getInt(0);
            String nomeLinha = cursor.getString(1);

            linha = new Linha(idLinha,nomeLinha);
        }

        return linha;
    }
    public ArrayList<Linha> buscarTodos(Object horario) {
        ArrayList<Linha> Linha = new ArrayList<Linha>();
        SQLiteDatabase db = bd.getReadableDatabase();

        String sql = "SELECT _id, nomeLinha FROM Horario WHERE id = ?";
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                int idLinha = cursor.getInt(0);
                String nomeLinha = cursor.getString(1);

                Linha linha = new Linha(idLinha, nomeLinha);
                Linha.add(linha);
            } while (cursor.moveToNext());
        }

        return null;
    }
}
