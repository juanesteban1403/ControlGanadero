package com.proyecto.afinal.controlganadero;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class PerfilVacaActivity extends AppCompatActivity {
    Lista_EventoVaca[] datos= new Lista_EventoVaca[]{
            new Lista_EventoVaca(R.drawable.secado,"Secado","22/03/2017"),
            new Lista_EventoVaca(R.drawable.parto,"Parto","20/05/2016"),
            new Lista_EventoVaca(R.drawable.secado,"secado","20/12/2016")
    };
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_vaca);
        FloatingActionButton fab =(FloatingActionButton)findViewById(R.id.bAgregarevento);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent (PerfilVacaActivity.this,AgregarEventoVacaActivity.class);
                startActivity(intent);
                finish();
            }
        });
        lista=(ListView)findViewById(R.id.listperfilvaca) ;
        Adapter adapter=new Adapter(this,datos);
        lista.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(PerfilVacaActivity.this,MisVacasActivity.class);
        startActivity(intent);
        finish();
    }
    class Adapter extends ArrayAdapter<Lista_EventoVaca> {
        public Adapter(Context context, Lista_EventoVaca[] datos) {
            super(context, R.layout.list_eventovaca, datos);
        }
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            LayoutInflater inflater =LayoutInflater.from(getContext());
            View item=inflater.inflate(R.layout.list_eventovaca,null);
            ImageView imageView = (ImageView)item.findViewById(R.id.imageneventovaca);
            TextView evento = (TextView)item.findViewById(R.id.tNombreeventovaca);
            TextView fecha = (TextView)item.findViewById(R.id.tFechaeventovaca);
            imageView.setImageResource(datos[position].getImagen());
            evento.setText(datos[position].getNombreevento());
            fecha.setText(datos[position].getFecha());
            return item;

        }
    }
}

