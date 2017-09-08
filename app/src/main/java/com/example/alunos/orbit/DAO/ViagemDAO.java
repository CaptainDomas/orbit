package com.example.alunos.orbit.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.alunos.orbit.Modelo.Motorista;
import com.example.alunos.orbit.Modelo.Viagem;

import java.util.ArrayList;

/**
 * Created by Avell 1513 on 06/09/2017.
 */

public class ViagemDAO {

    private BancoDados bd;
    private Context context;

    public ViagemDAO(Context context) {
        bd = new BancoDados(context);
        this.context = context;
    }

    public void inserir(Viagem novaViagem) {
        SQLiteDatabase db = bd.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id_Denuncia", novaViagem.getId());
        values.put("motorista_fk", novaViagem.getMotorista_fk());
        values.put("onibus_fk", novaViagem.getOnibus_fk());
        values.put("horario_fk", novaViagem.getHorario_fk());

        db.insert("Viagem", null, values);
    }

    public void remover(int id) {
        SQLiteDatabase db = bd.getWritableDatabase();

        String[] filtros = new String[1];
        filtros[0] = id + "";

        db.delete("Viagem", "_id = ?", filtros);
    }

    public void editar(Viagem viagem) {
        SQLiteDatabase db = bd.getWritableDatabase();

        ContentValues values;
        values = new ContentValues();
        values.put("Viagem", viagem.getId());
        String[] filtros = new String[1];
        filtros[0] = viagem.getId() + "";

        db.update("Viagem", values, "_id = ?", filtros);
    }

    public Viagem buscar(int id) {
        Viagem viagem = null;
        SQLiteDatabase db = bd.getReadableDatabase();

        String sql = "SELECT _id FROM viagem WHERE id = ?";
        String[] filtros = new String[1];
        filtros[0] = id + "";

        Cursor cursor = db.rawQuery(sql, filtros);
        if (cursor.moveToFirst()) {
            int idViagem = cursor.getInt(0);
            int motorista = cursor.getInt(1);
            int onibus = cursor.getInt(2);
            int horario = cursor.getInt(3);
            viagem = new Viagem(idViagem, motorista, onibus, horario, viagem);
        }

        return viagem;
    }

    public ArrayList<Viagem> buscarTodos() {
        ArrayList<Viagem> viagens = new ArrayList<Viagem>();
        SQLiteDatabase db = bd.getReadableDatabase();

        String sql = "SELECT _id FROM viagem WHERE id = ?";
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                int idViagem = cursor.getInt(0);
                int motorista = cursor.getInt(1);
                int onibus = cursor.getInt(2);
                int horario = cursor.getInt(3);
                Viagem viagem = new Viagem(idViagem, motorista, onibus, horario, buscar(idViagem));
                viagens.add(viagem);
            } while (cursor.moveToNext());
        }

        return viagens;
    }
}
