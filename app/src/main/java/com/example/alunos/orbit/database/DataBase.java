package com.example.alunos.orbit.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.alunos.orbit.model.dao.HoraDAO;
import com.example.alunos.orbit.model.dao.HorarioDAO;
import com.example.alunos.orbit.model.dao.LinhaDAO;
import com.example.alunos.orbit.model.dao.TerminalDAO;
import com.example.alunos.orbit.model.dao.UsuarioDAO;


public class DataBase extends SQLiteOpenHelper {

    private static final int VERSION_NAME = 1;
    private static final String DATABASE_NAME = "orbit.sqlite";

    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NAME);
    }

    @Override
    public void onCreate(SQLiteDatabase dataBase) {

        dataBase.execSQL(HoraDAO.getTabela());
        dataBase.execSQL(HorarioDAO.getTabela());
        dataBase.execSQL(TerminalDAO.getTabela());
        dataBase.execSQL(LinhaDAO.getTabela());
        dataBase.execSQL(UsuarioDAO.getTabela());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
