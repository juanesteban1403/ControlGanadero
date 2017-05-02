package com.proyecto.afinal.controlganadero;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MiFincaActivity extends AppCompatActivity {
    Lista_Fincainterior[] datos =new Lista_Fincainterior[]{
            new Lista_Fincainterior(R.drawable.finca2,"Mis Vacas"),
            new Lista_Fincainterior(R.drawable.ordenado,"Ordeño")
    };
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_finca);
        Adapter adapter = new Adapter(this,datos);
        lista=(ListView)findViewById(R.id.listafinca);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(((Lista_Fincainterior)parent.getItemAtPosition(position)).getId_imagen()==R.drawable.finca2){
                    Intent intent = new Intent(MiFincaActivity.this,MisVacasActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if (((Lista_Fincainterior)parent.getItemAtPosition(position)).getId_imagen()==R.drawable.ordenado){
                    Intent intent = new Intent(MiFincaActivity.this,OrdenoActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MiFincaActivity.this, FincasActivity.class);
        startActivity(intent);
        finish();
    }
    class Adapter extends ArrayAdapter<Lista_Fincainterior> {
        public Adapter(Context context, Lista_Fincainterior[] datos) {
            super(context, R.layout.list_fincas, datos);
        }

        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            LayoutInflater inflater =LayoutInflater.from(getContext());
            View item=inflater.inflate(R.layout.list_fincas,null);
            ImageView imageView=(ImageView)item.findViewById(R.id.imagen1);
            TextView nombre =(TextView)item.findViewById(R.id.tNombre1);

            imageView.setImageResource(datos[position].getId_imagen());
            nombre.setText(datos[position].getNombre());

            return item;

        }

    }

}

