package com.example.alunos.orbit.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.alunos.orbit.database.DataBase;
import com.example.alunos.orbit.model.Usuario;

import java.util.ArrayList;


public class UsuarioDAO {

    private DataBase database;
    private Context context;


    public UsuarioDAO(Context context) {
        database = new DataBase(context);
        this.context = context;
    }

    public static String getTabela() {
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE usuario(");
        builder.append("id INTEGER NOT NULL PRIMARY KEY,");
        builder.append("nome VARCHAR(45) NOT NULL,");
        builder.append("email VARCHAR(45) NOT NULL,");
        builder.append("numero_cartao INTEGER NOT NULL");
        builder.append("saldo INTEGER NOT NULL");
        builder.append(");");

        return builder.toString();
    }

    public void inserir(Usuario novoUsuario) {
        SQLiteDatabase dataBase = database.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", novoUsuario.getId());
        values.put("nome", novoUsuario.getNome());
        values.put("email", novoUsuario.getEmail());
        values.put("numero_cartao", novoUsuario.getNumCartao());
        values.put("saldo", novoUsuario.getSaldo());

        dataBase.insert("usuario", null, values);
    }

    public void remover(int id) {
        SQLiteDatabase dataBase = database.getWritableDatabase();


        String[] filtros = new String[1];
        filtros[0] = id + "";

        dataBase.delete("usuario", "_id = ?", filtros);
    }

    public void editar(Usuario usuario) {
        SQLiteDatabase dataBase = database.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", usuario.getId());
        values.put("nome", usuario.getNome());
        values.put("email", usuario.getEmail());
        values.put("numero_cartao", usuario.getNumCartao());
        values.put("saldo", usuario.getSaldo());

        String[] filtros = new String[1];
        filtros[0] = usuario.getId() + "";

        dataBase.update("usuario", values, "_id = ?", filtros);
    }

    public Usuario buscar(int id) {
        Usuario usuario = null;
        SQLiteDatabase dataBase = database.getReadableDatabase();

        String sql = "SELECT id, nome, email,numero_cartao,saldo FROM terminal WHERE id = ?";
        String[] filtros = new String[1];
        filtros[0] = id + "";

        Cursor cursor = dataBase.rawQuery(sql, filtros);
        if (cursor.moveToFirst()) {
            id = cursor.getInt(0);
            String nome = cursor.getString(1);
            String email = cursor.getString(2);
            int numero_cartao = cursor.getInt(3);
            int saldo = cursor.getInt(4);

            UsuarioDAO uDAO = new UsuarioDAO(context);
            Usuario usuarioHorario = uDAO.buscar(id);

            usuario = new Usuario(id, nome, email, numero_cartao, saldo);

        }
        return usuario;
    }
    public ArrayList<Usuario> buscarTodasosUsuarios() {
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    SQLiteDatabase dataBase = database.getReadableDatabase();

    String sql = "SELECT id FROM usuario";
    Cursor cursor = dataBase.rawQuery(sql, null);

        if(cursor.moveToFirst())

    {
        do {
            int id = cursor.getInt(0);
            String nome = cursor.getString(1);
            String email = cursor.getString(2);
            int numero_cartao = cursor.getInt(3);
            int saldo = cursor.getInt(4);


            Usuario usuario = new Usuario(id, nome, email, numero_cartao, saldo);
            usuarios.add(usuario);
        } while (cursor.moveToNext());
    }

        return null;
}

}
