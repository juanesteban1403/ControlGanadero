package com.proyecto.afinal.controlganadero;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class AgregarEventoVacaActivity extends AppCompatActivity {
    Button registrar,cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_evento_vaca);

        registrar=(Button)findViewById(R.id.bRregistrarRegistro);
        cancelar=(Button)findViewById(R.id.bRcancelarRegistro);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AgregarEventoVacaActivity.this,PerfilVacaActivity.class);
        startActivity(intent);
        finish();
    }


}
