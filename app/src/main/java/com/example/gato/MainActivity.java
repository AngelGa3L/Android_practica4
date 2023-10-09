package com.example.gato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button iniciar;
    Button salir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar = findViewById(R.id.iniciar);
        salir = findViewById(R.id.salir);
        iniciar.setOnClickListener(this);
        salir.setOnClickListener(this);
    }
    public void onClick(View view) {
        if (view == iniciar) {
            inicarjuego();
        }
    }
    public void inicarjuego(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

}