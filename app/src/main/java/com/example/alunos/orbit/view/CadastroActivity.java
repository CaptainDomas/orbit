package com.example.alunos.orbit.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.alunos.orbit.R;
import com.example.alunos.orbit.model.Usuario;
import com.example.alunos.orbit.model.dao.UsuarioDAO;

public class CadastroActivity extends AppCompatActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.alunos.orbit.R.layout.activity_cadastro);

        btn = (Button) findViewById(R.id.insertButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Usuario usuario = new Usuario(1, "teste", "teste@teste.com", 1, 1);
                UsuarioDAO usuarioDAO = new UsuarioDAO(getApplicationContext());
                usuarioDAO.inserir(usuario);
            }
        });
    }
}