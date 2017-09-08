package com.example.alunos.orbit.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.alunos.orbit.Modelo.Denuncia;
import com.example.alunos.orbit.Modelo.Linha;
import com.example.alunos.orbit.Modelo.Motorista;

import java.util.ArrayList;


public class MotoristaDAO {

    private BancoDados bd;
    private Context context;


    public MotoristaDAO(Context context) {
        bd = new BancoDados(context);
        this.context = context;
    }

    public void inserir(Motorista novoMotorista) {
        SQLiteDatabase db = bd.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("motoristaDAO", novoMotorista.getId());
        values.put("id_motorista", novoMotorista.getMotorista().getId());
        db.insert("MotoristaDAO", null, values);
    }

    public void remover(int id) {
        SQLiteDatabase db = bd.getWritableDatabase();

        String[] filtros = new String[1];
        filtros[0] = id + "";

        db.delete("MotoristaDAO", "_id = ?", filtros);
    }

    public void editar(Motorista motorista) {
        SQLiteDatabase db = bd.getWritableDatabase();

        ContentValues values;
        values = new ContentValues();
        values.put("motorista", motorista.getId());
        String[] filtros = new String[1];
        filtros[0] = motorista.getId() + "";

        db.update("Motorista", values, "_id = ?", filtros);
    }

    public Motorista buscar(int id) {
        Motorista motorista = null;
        SQLiteDatabase db = bd.getReadableDatabase();

        String sql = "SELECT _id, Motorista FROM motorista WHERE id = ?";
        String[] filtros = new String[1];
        filtros[0] = id + "";

        Cursor cursor = db.rawQuery(sql, filtros);
        if (cursor.moveToFirst()) {
            int id_motorista = cursor.getInt(0);
            String nome = cursor.getString(1);
            motorista = new Motorista(id_motorista, nome);
        }

        return motorista;
    }

    public ArrayList<Motorista> buscarTodos() {
        ArrayList<Motorista> motoristas = new ArrayList<Motorista>();
        SQLiteDatabase db = bd.getReadableDatabase();

        String sql = "SELECT _id, Denuncia FROM denuncia WHERE id = ?";
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                int id_motorista = cursor.getInt(0);
                String nome = cursor.getString(1);
                Motorista motorista = new Motorista(id_motorista, nome);
                motoristas.add(motorista);
            } while (cursor.moveToNext());
        }

        return null;
    }


}
