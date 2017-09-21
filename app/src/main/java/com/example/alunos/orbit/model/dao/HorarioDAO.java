package com.example.alunos.orbit.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.alunos.orbit.database.DataBase;
import com.example.alunos.orbit.model.Horario;
import com.example.alunos.orbit.model.Linha;
import com.example.alunos.orbit.model.Terminal;


/**
 * Created by Avell 1513 on 08/09/2017.
 */

public class HorarioDAO {

    private DataBase database;
    private Context context;

    public HorarioDAO(Context context) {
        database = new DataBase(context);
        this.context = context;
    }

    public static String getTabela() {
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE horario(");
        builder.append("id INTEGER NOT NULL PRIMARY KEY,");
        builder.append("fk_linha INTEGER NOT NULL,");
        builder.append("fk_saida INTEGER NOT NULL,");
        builder.append("fk_chegada INTEGER NOT NULL,");
        builder.append("FOREIGN KEY (fk_linha) REFERENCES linha(id),");
        builder.append("FOREIGN KEY (fk_saida) REFERENCES terminal(id),");
        builder.append("FOREIGN KEY (fk_chegada) REFERENCES terminal(id),");
        builder.append(");");

        return builder.toString();
    }

    public void inserir(Horario novoHorario) {
        SQLiteDatabase dataBase = database.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", novoHorario.getId());
        values.put("linha", novoHorario.getLinha().getCodigoLinha());
        values.put("terminalSaida", novoHorario.getTerminalSaida().getId());
        values.put("terminalChegada", novoHorario.getTerminalChegada().getId());

        dataBase.insert("horario", null, values);
    }

    public void remover(int id) {
        SQLiteDatabase dataBase = database.getWritableDatabase();

        String[] filtros = new String[1];
        filtros[0] = id + "";

        dataBase.delete("horario", "_id = ?", filtros);
    }

    public void editar(Horario horario) {
        SQLiteDatabase dataBase = database.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", horario.getId());
        values.put("linha", horario.getLinha().getCodigoLinha());
        values.put("terminalSaida", horario.getTerminalSaida().getId());
        values.put("terminalChegada", horario.getTerminalChegada().getId());


        String[] filtros = new String[1];
        filtros[0] = horario.getId() + "";

        dataBase.update("horario", values, "_id = ?", filtros);
    }

    public Horario buscar(int id) {
        Horario horario = null;
        SQLiteDatabase dataBase = database.getReadableDatabase();

        String sql = "SELECT id, linha, terminalSaida, terminalChegada FROM horario WHERE id = ?";
        String[] filtros = new String[1];
        filtros[0] = id + "";

        Cursor cursor = dataBase.rawQuery(sql, filtros);
        if (cursor.moveToFirst()) {
            id = cursor.getInt(0);
            int linha = cursor.getInt(1);
            int terminalSaida = cursor.getInt(2);
            int terminalChegada = cursor.getInt(3);

            Linha linhaClass = new LinhaDAO(context).buscar(linha);
            Terminal terminalSaidaClass = new TerminalDAO(context).buscar(terminalChegada);
            Terminal terminalChegadaClass = new TerminalDAO(context).buscar(terminalChegada);

            horario = new Horario(id,linhaClass,terminalSaidaClass,terminalChegadaClass,null);
        }

        return horario;
    }

}
