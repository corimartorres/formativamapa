package com.example.mapa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    EditText etlatitud, etlongitud, etzoom, etetiqueta;
    Button btnvermapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etlatitud = (EditText) findViewById(R.id.et_latitud);
        etlongitud = (EditText) findViewById(R.id.et_longitud);
        etzoom = (EditText) findViewById(R.id.zoom);
        etetiqueta = (EditText) findViewById(R.id.et_etiqueta);
        btnvermapa = (Button) findViewById(R.id.btn_vermapa);

        btnvermapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Mapa.class);
                startActivity(intent);
            }
        });
    }

    public void mostrarubicacion(View v){
        String latitud = etlatitud.getText().toString();
        String longitud = etlongitud.getText().toString();
        int zoom = Integer.parseInt(etzoom.getText().toString());
        String etiqueta = etetiqueta.getText().toString();

        if (latitud.length() == 0){
            Toast.makeText(this, "El campo Latitud es requerido", Toast.LENGTH_LONG).show();
        }
        if (longitud.length() == 0) {
            Toast.makeText(this, "El campo Longitud es requerido", Toast.LENGTH_LONG).show();
        }
        if (zoom < 1 || zoom > 23){
            Toast.makeText(this, "No se acepta este valor de Zoom", Toast.LENGTH_LONG).show();
        }
        if (etiqueta.length() == 0) {
            Toast.makeText(this, "El campo Etiqueta es requerido", Toast.LENGTH_LONG).show();
        }
        if (etlongitud.length()!=0 && etlatitud.length()!=0 && zoom >= 1 && zoom <= 23 && etetiqueta.length()!=0) {
            Intent i = new Intent(this, Mapa.class);
            i.putExtra("latitud", etlatitud.getText().toString());
            i.putExtra("longitud", etlongitud.getText().toString());
            i.putExtra("zoom", etzoom.getText().toString());
            i.putExtra("etiqueta", etetiqueta.getText().toString());
            startActivity(i);
        }
    }

}
