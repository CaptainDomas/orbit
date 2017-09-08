package com.example.alunos.orbit.DAO;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDados extends SQLiteOpenHelper {

    private static final int VERSION_NAME = 1;
    private static final String DATABASE_NAME = "Orbit.sqlite";

    public BancoDados(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NAME);
    }

    public void onCreate(SQLiteDatabase db) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE usuario (_id INTEGER PRIMARY KEY,");
        sb.append("                        nome TEXT,");
        sb.append("                        email TEXT,");
        sb.append("                        senha TEXT);");
        db.execSQL(sb.toString());

        sb = new StringBuilder();
        sb.append("CREATE TABLE terminal (_id INTEGER PRIMARY KEY,");
        sb.append("                        telefone INTEGER,");
        sb.append("                        nome TEXT);");
        db.execSQL(sb.toString());

        sb = new StringBuilder();
        sb.append("CREATE TABLE linha (_id INTEGER PRIMARY KEY,");
        sb.append("                      nome INTEGER,");
        db.execSQL(sb.toString());

        sb = new StringBuilder();
        sb.append("CREATE TABLE onibus (_id INTEGER PRIMARY KEY,");
        sb.append("                      ano INTEGER,");
        sb.append("                      ultima_manuntencao TEXT,");
        sb.append("                      numero INTEGER,");
        sb.append("                      placa TEXT,");
        sb.append("                      dataCompra INTEGER);");
        db.execSQL(sb.toString());

        sb = new StringBuilder();
        sb.append("CREATE TABLE horario (_id INTEGER PRIMARY KEY,");
        sb.append("                       horario INTEGER,");
        sb.append("                        id_terminal INTEGER,");
        sb.append("                        id_linha INTEGER,");
        sb.append("FOREIGN KEY (id_terminal) REFERENCES terminal(_id),");
        sb.append("FOREIGN KEY (id_linha) REFERENCES linha(_id));");
        db.execSQL(sb.toString());

        sb = new StringBuilder();
        sb.append("CREATE TABLE motorista (_id INTEGER PRIMARY KEY,");
        sb.append("                         Nome TEXT);");
        sb.append("                         id_horario INTEGER);");
        sb.append("FOREIGN KEY (id_horario) REFERENCES horario(_id),");
        db.execSQL(sb.toString());

        sb = new StringBuilder();
        sb.append("CREATE TABLE denuncia (_id INTEGER PRIMARY KEY,");
        sb.append("                       avaliacao INTEGER,");
        sb.append("                       id_usuario INTEGER,");
        sb.append("                        texto INTEGER,");
        sb.append("                        id_viagem INTEGER,");
        sb.append("FOREIGN KEY (id_viagem) REFERENCES viagem(_id),");
        sb.append("FOREIGN KEY (id_usuario) REFERENCES usuario(_id));");

        db.execSQL(sb.toString());

        sb = new StringBuilder();
        sb.append("CREATE TABLE viagem( _id INTEGER PRIMARY KEY AUTOINCREMENT,");
        sb.append("motorista_fk INTEGER,");
        sb.append("onibus_fk INTEGER,");
        sb.append("horario_fk INTEGER,");
        sb.append("FOREIGN KEY (motorista_fk) REFERENCES motorista(_id)");
        sb.append("FOREIGN KEY (onibus_fk) REFERENCES onibus(_id),");
        sb.append("FOREIGN KEY (onibus_fk) REFERENCES onibus(_id));");
        db.execSQL(sb.toString());
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
