package com.proyecto.afinal.controlganadero;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MisVacasActivity extends AppCompatActivity {

    Lista_vacas[] datos= new Lista_vacas[]{
        new Lista_vacas(R.drawable.vaca1,"Sasha","próximo evento: 27/03/2017","30litros"), new Lista_vacas(R.drawable.vaca2,"Andrea","próximo evento 28/06/2017","20 litros")
    };
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_vacas);
        lista=(ListView)findViewById(R.id.listavacas);
        Adapter adapter=new Adapter(this, datos);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String opcion =((Lista_vacas)parent.getItemAtPosition(position)).getNombres();
                if(opcion =="Sasha"){
                    Intent intent= new Intent(MisVacasActivity.this,PerfilVacaActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    class Adapter extends ArrayAdapter<Lista_vacas> {
        public Adapter(Context context, Lista_vacas[] datos) {
            super(context, R.layout.list_vacas, datos);
        }
        public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent){
            LayoutInflater inflater =LayoutInflater.from(getContext());
            View item=inflater.inflate(R.layout.list_vacas,null);
            ImageView imageView=(ImageView)item.findViewById(R.id.imagenvaca);
            TextView nombre=(TextView)item.findViewById(R.id.tNombrevaca);
            TextView litros=(TextView)item.findViewById(R.id.tLitros);
            TextView evento=(TextView)item.findViewById(R.id.tProxevento);
            imageView.setImageResource(datos[position].getImagen());
            nombre.setText(datos[position].getNombres());
            litros.setText(datos[position].getLirtros());
            evento.setText(datos[position].getEvento());
            return item;
        }
    }

}

