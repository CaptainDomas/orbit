package com.example.alunos.orbit.Modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Avell 1513 on 04/09/2017.
 */

public class BancoDados extends SQLiteOpenHelper {

    private static final int VERSION_NAME = 1;
    private static final String DATABASE_NAME = "Orbit.sqlite";

    public BancoDados(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NAME);
    }

    public void onCreate(SQLiteDatabase db) {
        StringBuilder sb = new StringBuilder();

        sb.append("CREATE TABLE usuario (_id INTEGER PRIMARY KEY,");
        sb.append("                        nome TEXT");
        sb.append("                        email TEXT");
        sb.append("                        senha TEXT);");
        db.execSQL(sb.toString());

        sb = new StringBuilder();
        sb.append("CREATE TABLE terminal (_id INTEGER PRIMARY KEY,");
        sb.append("                        telefone Integer");
        sb.append("                        nome TEXT);");
        db.execSQL(sb.toString());

        sb = new StringBuilder();
        sb.append("CREATE TABLE linha (_id INTEGER PRIMARY KEY,");
        sb.append("                      nome INTEGER,");
        db.execSQL(sb.toString());

        sb = new StringBuilder();
        sb.append("CREATE TABLE Onibus (_id INTEGER PRIMARY KEY,");
        sb.append("                      Ano INTEGER,");
        sb.append("                      Ultima_Manuntenção TEXT,");
        sb.append("                      Numero Integer,");
        sb.append("                      Placa text,");
        sb.append("                      dataCompra integer);");
        db.execSQL(sb.toString());

        sb = new StringBuilder();
        sb.append("CREATE TABLE Horario (_id INTEGER PRIMARY KEY,");
        sb.append("                       Horario Integer,");
        sb.append("                        id_terminal Integer,");
        sb.append("                        id_linha Integer,");
        sb.append("FOREIGN KEY (id_terminal) REFERENCES terminal(_id));");
        sb.append("FOREIGN KEY (id_linha) REFERENCES linha(_id));");
        db.execSQL(sb.toString());

        sb = new StringBuilder();
        sb.append("CREATE TABLE Motorista (_id INTEGER PRIMARY KEY,");
        sb.append("                         Nome TEXT);");
        db.execSQL(sb.toString());

        sb = new StringBuilder();
        sb.append("CREATE TABLE Denuncia (_id INTEGER PRIMARY KEY,");
        sb.append("                       avaliacao Integer,");
        sb.append("                       id_usuario Integer,");
        sb.append("                        Texto Integer,");
        sb.append("                        id_viagem Integer,");
        sb.append("FOREIGN KEY (id_viagem) REFERENCES viagem(_id));");
        sb.append("FOREIGN KEY (id_usuario) REFERENCES usuario(_id));");

        db.execSQL(sb.toString());

        sb = new StringBuilder();
        sb.append("CREATE TABLE viagem(_id INTEGER PRIMARY KEY,");
        sb.append("                        id_Motorista integer,");
        sb.append("                        id_Onibus integer,");
        sb.append("                        id_Horario integer,");
        sb.append("FOREIGN KEY (id_Onibus) REFERENCES Onibus(_id));");
        sb.append("FOREIGN KEY (id_Horario) REFERENCES Horario(_id));");
        sb.append("FOREIGN KEY (id_Motorista) REFERENCES Motorista(_id));");

        db.execSQL(sb.toString());
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
