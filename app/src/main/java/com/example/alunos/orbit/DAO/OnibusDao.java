package com.example.alunos.orbit.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.alunos.orbit.Modelo.Onibus;

import java.util.ArrayList;

public class OnibusDao {
    private BancoDados bd;
    private Context context;

    public OnibusDao (Context context) {
        bd = new BancoDados(context);
        this.context = context;
    }
    public void inserir (Onibus novoOnibus) {
        SQLiteDatabase db = bd.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("OnibusDao",novoOnibus.getOnibus());
        values.put("id_Onibus",novoOnibus.getOnibus().getBytes());

        db.insert("Onibus", null, values);
    }
    public void remover(int id) {
        SQLiteDatabase db = bd.getWritableDatabase();

        String[] filtros = new String[1];
        filtros[0] = id + "";

        db.delete("Onibus", "_id = ?", filtros);
    }
    public void editar( Onibus onibus) {
        SQLiteDatabase db = bd.getWritableDatabase();

        ContentValues values;
        values = new ContentValues();
        values.put("Onibus", onibus.getOnibus());
        String[] filtros = new String[1];
        filtros[0] = onibus.getID() + "";

        db.update("Onibus", values, "_id = ?", filtros);
    }
    public Onibus buscar(int id) {
        Onibus onibus = null;
        SQLiteDatabase db = bd.getReadableDatabase();

        String sql = "SELECT _id, Onibus FROM onibus WHERE id = ?";
        String[] filtros = new String[1];
        filtros[0] = id + "";

        Cursor cursor = db.rawQuery(sql, filtros);
        if (cursor.moveToFirst()) {
            int idOnibus = cursor.getInt(0);
            String ONIBUSINFO = cursor.getString(1);

          onibus  = new Onibus(idOnibus,ONIBUSINFO );
        }

        return onibus;
    }
    public ArrayList<Onibus> buscarTodos() {
        ArrayList<Onibus> onibuses = new ArrayList<Onibus>();
        SQLiteDatabase db = bd.getReadableDatabase();

        String sql = "SELECT _id, Onibus FROM Onibus WHERE id = ?";
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                int idOnibus = cursor.getInt(0);
                String onibus = cursor.getString(1);

                Onibus onibus1 = new Onibus(idOnibus, onibus);
                onibuses.add(onibus1);
            } while (cursor.moveToNext());
        }

        return null;
    }
}


