package com.example.alunos.orbit.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.alunos.orbit.R;
import com.example.alunos.orbit.model.Horario;
import com.example.alunos.orbit.model.dao.HorarioDAO;

import java.util.ArrayList;

public class ListaHorarioActivity extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_horario);

        lv = (ListView) findViewById(R.id.lvLinhas);
        HorarioDAO horarioDAO = new HorarioDAO((getApplicationContext()));
        ArrayList<Horario> horarios = horarioDAO.buscarTodos();
        String[] nomes = new String[horarios.size()];
        for (int i = 0; i < nomes.length; i++) {
            nomes[i] = horarios.get(i).getLinha().getCodigoLinha() + " - " + horarios.get(i).getLinha().getNome();
        }
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_lista_horario, nomes);
        lv.setAdapter(adapter);
    }
}
