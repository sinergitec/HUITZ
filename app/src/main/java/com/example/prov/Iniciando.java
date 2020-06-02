package com.example.prov;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class Iniciando extends AppCompatActivity {

    private final int DURACION_SPLASH = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciando);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Iniciando.this , MainActivity.class);

                startActivity(intent);
                fileList();
                // finish();
            }
        }, DURACION_SPLASH);
    }
}
