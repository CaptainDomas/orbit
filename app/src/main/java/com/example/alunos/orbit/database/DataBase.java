package com.example.alunos.orbit.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.alunos.orbit.model.dao.HoraDAO;
import com.example.alunos.orbit.model.dao.HorarioDAO;

/**
 * Created by Avell 1513 on 08/09/2017.
 */

public class DataBase extends SQLiteOpenHelper{

    private static final int VERSION_NAME=1;
    private static final String DATABASE_NAME ="orbit.sqlite";

    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NAME);
    }

    @Override
    public void onCreate(SQLiteDatabase dataBase) {
        dataBase.execSQL(HorarioDAO.getTabela());
        dataBase.execSQL(HoraDAO.getTabela());

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
