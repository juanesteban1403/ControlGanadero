package com.proyecto.afinal.controlganadero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistroFincasActivity extends AppCompatActivity {
    Button registro,cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_fincas);
        registro = (Button)findViewById(R.id.bRregistro);
        cancelar = (Button)findViewById(R.id.bRcancelar);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(RegistroFincasActivity.this, FincasActivity.class);
                startActivity(intent);
                finish();
            }
        });
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(RegistroFincasActivity.this, FincasActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent= new Intent(RegistroFincasActivity.this, FincasActivity.class);
        startActivity(intent);
        finish();

    }
}
