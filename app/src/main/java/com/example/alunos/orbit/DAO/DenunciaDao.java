package com.example.alunos.orbit.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.alunos.orbit.Modelo.Denuncia;


import com.example.alunos.orbit.Modelo.Denuncia;

import java.util.ArrayList;

public class DenunciaDao {
    private BancoDados bd;
    private Context context;


    public DenunciaDao(Context context) {
        bd = new BancoDados(context);
        this.context = context;
    }

    public void inserir(Denuncia novaDenuncia) {
        SQLiteDatabase db = bd.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("ID", novaDenuncia.getID());
        values.put("Avaliacao", novaDenuncia.getAvaliacao());
        values.put("ID_usuario", novaDenuncia.getID_usuario());
        values.put("id_Denuncia", novaDenuncia.getDenuncia().getID());
        values.put("Texto", novaDenuncia.getTexto());
        db.insert("Denuncia", null, values);
    }

    public void remover(int id) {
        SQLiteDatabase db = bd.getWritableDatabase();

        String[] filtros = new String[1];
        filtros[0] = id + "";

        db.delete("Denuncia", "_id = ?", filtros);
    }

    public void editar(Denuncia denuncia) {
        SQLiteDatabase db = bd.getWritableDatabase();

        ContentValues values;
        values = new ContentValues();
        values.put("Denuncia", denuncia.getID());
        String[] filtros = new String[1];
        filtros[0] = denuncia.getID() + "";

        db.update("Usuarioo", values, "_id = ?", filtros);
    }

    public Denuncia buscar(int id) {
        Denuncia denuncia = null;
        SQLiteDatabase db = bd.getReadableDatabase();

        String sql = "SELECT _id FROM denuncia WHERE id = ?";
        String[] filtros = new String[1];
        filtros[0] = id + "";

        Cursor cursor = db.rawQuery(sql, filtros);
        if (cursor.moveToFirst()) {
            int idDenuncia = cursor.getInt(0);
            String avaliacao = cursor.getString(1);
            int idusuario = cursor.getInt(2);
            String texto = cursor.getString(3);
            denuncia = new Denuncia(idDenuncia, avaliacao, idusuario, texto, denuncia);
        }

        return denuncia;
    }

    public ArrayList<Denuncia> buscarTodos() {
        ArrayList<Denuncia> denuncias = new ArrayList<Denuncia>();
        SQLiteDatabase db = bd.getReadableDatabase();

        String sql = "SELECT _id, Denuncia FROM denuncia WHERE id = ?";
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                int idDenuncia = cursor.getInt(0);
                String avaliacao = cursor.getString(1);
                int idusuario = cursor.getInt(2);
                String texto = cursor.getString(3);
                Denuncia denuncia = new Denuncia(idDenuncia, avaliacao, idusuario, texto, buscar(idDenuncia));
                denuncias.add(denuncia);
            } while (cursor.moveToNext());
        }

        return null;
    }
}




