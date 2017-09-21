package com.example.alunos.orbit.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class activity_splash_screen extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.alunos.orbit.R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(this, 5000);
    }

    public void run() {
        startActivity(new Intent(this, com.example.alunos.orbit.view.Cadastro.class));
        finish();
    }
}
