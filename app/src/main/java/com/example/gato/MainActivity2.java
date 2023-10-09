package com.example.gato;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;
    private ImageView imageView7;
    private ImageView imageView8;
    private ImageView imageView9;
    private ImageView imgTurnoX;
    private ImageView imgTurnoO;
    private String turno = "x";
    private final int[][] matrizGanadora = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9},
            {1, 5, 9},
            {3, 5, 7}
    };
    private final int[] posicionesX = new int[5];
    private final int[] posicionesO = new int[5];
    private int contadorX = 0;
    private int contadorO = 0;
    private String ganador = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imgTurnoX = findViewById(R.id.imgTurnoX);
        imgTurnoO = findViewById(R.id.imgTurnoO);
        imgTurnoX.setBackgroundColor(Color.RED);
    }

    public void clickImagen(View view) {
        String rutaNombre = getResources().getResourceName(view.getId());
        String nombreClick = rutaNombre.substring(rutaNombre.lastIndexOf("/") + 1);

        for (int i = 1; i <= 9; i++) {
            String nombreConcatenado = "imageView" + i;
            if (nombreClick.equals(nombreConcatenado)) {
                if ("x".equals(turno)) {
                    posicionesX[contadorX] = i;
                    contadorX++;
                } else {
                    posicionesO[contadorO] = i;
                    contadorO++;
                }
            }
        }

        if ("x".equals(turno)) {
            view.setBackgroundResource(R.drawable.gato_x);
            imgTurnoX.setBackgroundColor(Color.WHITE);
            imgTurnoO.setBackgroundColor(Color.RED);
            turno = "o";
        } else {
            view.setBackgroundResource(R.drawable.gato_o);
            imgTurnoX.setBackgroundColor(Color.RED);
            imgTurnoO.setBackgroundColor(Color.WHITE);
            turno = "x";
        }

        int altoMatriz = matrizGanadora.length;
        for (int i = 0; i < contadorX; i++) {
            boolean gano = true;
            for (int j = 0; j < altoMatriz; j++) {
                gano = coincideGanador(matrizGanadora[j], posicionesX);
                if (gano) {
                    ganador = "x";
                    Toast.makeText(this, "Gano X", Toast.LENGTH_LONG).show();
                    dibujaLinea();
                    deshabilitar();
                    break;
                }
            }
            if (gano) {
                break;
            }
        }

        for (int i = 0; i < contadorO; i++) {
            boolean gano = true;
            for (int j = 0; j < altoMatriz; j++) {
                gano = coincideGanador(matrizGanadora[j], posicionesO);
                if (gano) {
                    ganador = "o";
                    Toast.makeText(this, "Gano O", Toast.LENGTH_LONG).show();
                    dibujaLinea();
                    deshabilitar();
                    break;
                }
            }
            if (gano) {
                break;
            }
        }

        view.setEnabled(false);
    }

    public boolean coincideGanador(int[] registroGanador, int[] posiciones) {
        for (int i = 0; i < 3; i++) {
            if (registroGanador[i] != posiciones[i]) {
                return false;
            }
        }
        return true;
    }

    public void dibujaLinea() {
        if ("x".equals(ganador)) {
            for (int i = 0; i < contadorX; i++) {
                switch (posicionesX[i]) {
                    case 1:
                        imageView1.setBackgroundColor(Color.BLUE);
                        break;
                    case 2:
                        imageView2.setBackgroundColor(Color.BLUE);
                        break;
                    case 3:
                        imageView3.setBackgroundColor(Color.BLUE);
                        break;
                    case 4:
                        imageView4.setBackgroundColor(Color.BLUE);
                        break;
                    case 5:
                        imageView5.setBackgroundColor(Color.BLUE);
                        break;
                    case 6:
                        imageView6.setBackgroundColor(Color.BLUE);
                        break;
                    case 7:
                        imageView7.setBackgroundColor(Color.BLUE);
                        break;
                    case 8:
                        imageView8.setBackgroundColor(Color.BLUE);
                        break;
                    case 9:
                        imageView9.setBackgroundColor(Color.BLUE);
                        break;
                }
            }
        } else {
            for (int i = 0; i < contadorO; i++) {
                switch (posicionesO[i]) {
                    case 1:
                        imageView1.setBackgroundColor(Color.BLUE);
                        break;
                    case 2:
                        imageView2.setBackgroundColor(Color.BLUE);
                        break;
                    case 3:
                        imageView3.setBackgroundColor(Color.BLUE);
                        break;
                    case 4:
                        imageView4.setBackgroundColor(Color.BLUE);
                        break;
                    case 5:
                        imageView5.setBackgroundColor(Color.BLUE);
                        break;
                    case 6:
                        imageView6.setBackgroundColor(Color.BLUE);
                        break;
                    case 7:
                        imageView7.setBackgroundColor(Color.BLUE);
                        break;
                    case 8:
                        imageView8.setBackgroundColor(Color.BLUE);
                        break;
                    case 9:
                        imageView9.setBackgroundColor(Color.BLUE);
                        break;
                }
            }
        }
    }

    public void deshabilitar() {
        imageView1.setEnabled(false);
        imageView2.setEnabled(false);
        imageView3.setEnabled(false);
        imageView4.setEnabled(false);
        imageView5.setEnabled(false);
        imageView6.setEnabled(false);
        imageView7.setEnabled(false);
        imageView8.setEnabled(false);
        imageView9.setEnabled(false);
    }

    public void reiniciar(View view) {
        recreate();
    }
}
