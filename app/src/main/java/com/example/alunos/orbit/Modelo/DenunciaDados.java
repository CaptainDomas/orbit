package com.example.alunos.orbit.Modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Avell 1513 on 04/09/2017.
 */

public class DenunciaDados {

        private BancoDados bd;
        private Context context;

        public DenunciaDados(Context context) {
            bd = new BancoDados(context);
            this.context = context;
        }

        public void inserir(DenunciaDados novaDenuncia) {
          /*  SQLiteDatabase db = bd.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put("DenunciaDados", novaDenunciaDados);
            values.put("id_DenunciaDados", novaDenuncia.getDenuncia().getID());

            db.insert("Denuncia", null, values); */
        }

        public void remover(int id) {
            SQLiteDatabase db = bd.getWritableDatabase();

            String[] filtros = new String[1];
            filtros[0] = id + "";

            db.delete("Denuncia", "_id = ?", filtros);
        }

        public void editar(Denuncia denuncia) {
            SQLiteDatabase db = bd.getWritableDatabase();

            ContentValues values;
            values = new ContentValues();
            values.put("Denuncia", denuncia.getDenuncia());
            String[] filtros = new String[1];
            filtros[0] = denuncia.getID() + "";

            db.update("Usuarioo", values, "_id = ?", filtros);
        }

        public Denuncia buscar(int id) {
            Denuncia denuncia = null;
            SQLiteDatabase db = bd.getReadableDatabase();

            String sql = "SELECT _id, Denuncia FROM denuncia WHERE id = ?";
            String[] filtros = new String[1];
            filtros[0] = id + "";

            Cursor cursor = db.rawQuery(sql, filtros);
            if (cursor.moveToFirst()) {
                int idDenuncia = cursor.getInt(0);
                String nomeUsuario = cursor.getString(1);

                denuncia = new Denuncia(idDenuncia, nomeUsuario);
            }

            return denuncia;
        }

        public ArrayList<Denuncia> buscarTodos() {
            ArrayList<Denuncia> denuncias = new ArrayList<Denuncia>();
            SQLiteDatabase db = bd.getReadableDatabase();

            String sql = "SELECT _id, Denuncia FROM denuncia WHERE id = ?";
            Cursor cursor = db.rawQuery(sql, null);

            if (cursor.moveToFirst()) {
                do {
                    int idDenuncia = cursor.getInt(0);
                    String nomeUsuario = cursor.getString(1);

                    Denuncia denuncia = new Denuncia(idDenuncia, nomeUsuario);
                    denuncias.add(denuncia);
                } while (cursor.moveToNext());
            }

            return null;
        }


    }
}
