package com.example.alunos.orbit.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.alunos.orbit.Modelo.Terminal;
import com.example.alunos.orbit.Modelo.Usuarioo;

import java.util.ArrayList;

public class UsuarioDao {
    private BancoDados bd;
    private Context context;

    public UsuarioDao (Context context) {
        bd = new BancoDados(context);
        this.context = context;
    }
    public void inserir (Usuarioo novousuario) {
        SQLiteDatabase db = bd.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("UsuarioDao", novousuario.getUsuario());
        values.put("id_Usuarioo",novousuario.getUsuario().getBytes());

        db.insert("UsuarioDao", null, values);
    }
    public void remover(int id) {
        SQLiteDatabase db = bd.getWritableDatabase();

        String[] filtros = new String[1];
        filtros[0] = id + "";

        db.delete("Usuarioo", "_id = ?", filtros);
    }
    public void editar(Usuarioo usuarioo) {
        SQLiteDatabase db = bd.getWritableDatabase();

        ContentValues values;
        values = new ContentValues();
        values.put("Usuarioo", usuarioo.getUsuario());
        String[] filtros = new String[1];
        filtros[0] = usuarioo.getID() + "";

        db.update("Usuarioo", values, "_id = ?", filtros);
    }
    public Usuarioo buscar(int id) {
        Usuarioo usuario = null;
        SQLiteDatabase db = bd.getReadableDatabase();

        String sql = "SELECT _id, nomeUsuario FROM Nome WHERE id = ?";
        String[] filtros = new String[1];
        filtros[0] = id + "";

        Cursor cursor = db.rawQuery(sql, filtros);
        if (cursor.moveToFirst()) {
            int idUsuario = cursor.getInt(0);
            String nomeUsuario = cursor.getString(1);

            usuario = new Usuarioo(idUsuario,nomeUsuario );
        }

        return usuario;
    }
    public ArrayList<Terminal> buscarTodos() {
        ArrayList<Terminal> terminals = new ArrayList<Terminal>();
        SQLiteDatabase db = bd.getReadableDatabase();

        String sql = "SELECT _id, nomeLinha FROM Horario WHERE id = ?";
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                int idTerminal = cursor.getInt(0);
                String nomeTerminal = cursor.getString(1);

                Terminal terminal = new Terminal(idTerminal, nomeTerminal);
                terminals.add(terminal);
            } while (cursor.moveToNext());
        }

        return null;
    }
}


