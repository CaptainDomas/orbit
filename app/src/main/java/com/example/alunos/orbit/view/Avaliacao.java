package com.example.alunos.orbit.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alunos.orbit.R;

public class Avaliacao extends Activity {

    private RatingBar ratingBar;
    private TextView txtValorAvaliacao;
    private Button btnSubmit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        addListenerOnRatingBar();
        addListenerOnButton();
    }

    public void addListenerOnRatingBar() {
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        txtValorAvaliacao = (TextView) findViewById(R.id.txtValorAvaliacao);

        //se o valor de avaliação mudar,
        //exiba o valor de avaliação atual no resultado (textview) automaticamente
        ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float avaliacao, boolean fromUser) {
                txtValorAvaliacao.setText(String.valueOf(avaliacao));
            }
        });
    }

    public void addListenerOnButton() {
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        //se o botão for clicado, exiba o valor de avaliação corrente.
        btnSubmit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        
                        String.valueOf(ratingBar.getRating()),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}


