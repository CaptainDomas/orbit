package com.example.alunos.orbit.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.alunos.orbit.database.DataBase;

import com.example.alunos.orbit.model.Terminal;

import java.util.ArrayList;

/**
 * Created by Avell 1513 on 08/09/2017.
 */

public class TerminalDAO {

    private DataBase database;
    private Context context;


    public TerminalDAO (Context context) {
        database = new DataBase(context);
        this.context = context;
    }

    public static String getTabela(){
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE terminal(");
        builder.append("id INTEGER NOT NULL PRIMARY KEY,");
        builder.append("nome VARCHAR(45) NOT NULL,");
        builder.append("endereco VARCHAR(45) NOT NULL");
        builder.append(");");

        return builder.toString();
}


    public void inserir(Terminal novoTerminal) {
        SQLiteDatabase dataBase = database.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", novoTerminal.getId());
        values.put("nome", novoTerminal.getNome());
        values.put("endereco", novoTerminal.getEndereco());


        dataBase.insert("terminal", null, values);
    }
    public void remover(int id) {
        SQLiteDatabase dataBase = database.getWritableDatabase();


        String[] filtros = new String[1];
        filtros[0] = id + "";

        dataBase.delete("terminal", "_id = ?", filtros);
    }
    public void editar(Terminal terminal) {
        SQLiteDatabase dataBase = database.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", terminal.getId());
        values.put("nome", terminal.getNome());
        values.put("endereco", terminal.getEndereco());


        String[] filtros = new String[1];
        filtros[0] = terminal.getId() + "";

        dataBase.update("terminal", values, "_id = ?", filtros);
    }
    public Terminal buscar(int id) {
        Terminal terminal = null;
        SQLiteDatabase dataBase = database.getReadableDatabase();

        String sql = "SELECT id, nome, endereco FROM terminal WHERE id = ?";
        String[] filtros = new String[1];
        filtros[0] = id + "";

        Cursor cursor = dataBase.rawQuery(sql, filtros);
        if (cursor.moveToFirst()) {
            id = cursor.getInt(0);
            String nome = cursor.getString(1);
            String endereco = cursor.getString(2);

            TerminalDAO tDao = new TerminalDAO(context);
            Terminal terminalHorario = tDao.buscar(id);

            terminal = new Terminal(id, nome, endereco);
        }

        return terminal;
    }
    public ArrayList<Terminal> buscarTodasosTerminais() {
        ArrayList<Terminal> linhas = new ArrayList<Terminal>();
        SQLiteDatabase dataBase = database.getReadableDatabase();

        String sql = "SELECT id, nome, endereco FROM linha";
        Cursor cursor = dataBase.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String nome = cursor.getString(1);
                String endereco = cursor.getString(2);

                Terminal linha = new Terminal(id, nome, endereco);
                linhas.add(linha);
            } while (cursor.moveToNext());
        }

        return null;
    }
}
