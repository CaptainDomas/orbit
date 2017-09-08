package com.example.alunos.orbit.DAO;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.alunos.orbit.Modelo.Terminal;

import java.util.ArrayList;

public class TerminalDao {

        private BancoDados bd;
        private Context context;

        public TerminalDao (Context context) {
            bd = new BancoDados(context);
            this.context = context;
        }
    public void inserir (Terminal novoterminal) {
        SQLiteDatabase db = bd.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("TerminalDao", novoterminal.getTerminal());
        values.put("id_Terminal",novoterminal.getTerminal().getBytes());

        db.insert("TerminalDao", null, values);
    }
    public void remover(int id) {
        SQLiteDatabase db = bd.getWritableDatabase();

        String[] filtros = new String[1];
        filtros[0] = id + "";

        db.delete("Terminal", "_id = ?", filtros);
    }
    public void editar(Terminal terminal) {
        SQLiteDatabase db = bd.getWritableDatabase();

        ContentValues values;
        values = new ContentValues();
        values.put("Terminal", terminal.getTerminal());
        String[] filtros = new String[1];
        filtros[0] = terminal.getID() + "";

        db.update("Terminal", values, "_id = ?", filtros);
    }
    public Terminal buscar(int id) {
        Terminal terminal = null;
        SQLiteDatabase db = bd.getReadableDatabase();

        String sql = "SELECT _id, nomeTerminal FROM Horario WHERE id = ?";
        String[] filtros = new String[1];
        filtros[0] = id + "";
        Cursor cursor = db.rawQuery(sql, filtros);
        if (cursor.moveToFirst()) {
            int idTerminal = cursor.getInt(0);
            String nomeTerminal = cursor.getString(1);

            terminal = new Terminal(idTerminal,nomeTerminal );
        }

        return terminal;
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
