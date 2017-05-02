package com.proyecto.afinal.controlganadero;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FincasActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Lista_Fincas[] datos =new Lista_Fincas[]{
        new Lista_Fincas(R.drawable.finca1,"El encanto","San Pedro de los Milagros")
    };
    ListView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fincas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(FincasActivity.this,RegistroFincasActivity.class);

                startActivity(intent);
            }
        });
        lista= (ListView)findViewById(R.id.listfincas);
        Adapter adapter=new Adapter(this,datos);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String opcion=((Lista_Fincas)parent.getItemAtPosition(position)).getNombre();
                if(((Lista_Fincas)parent.getItemAtPosition(position)).getNombre()=="El encanto"){
                    Intent intent;
                    intent= new Intent(FincasActivity.this,MiFincaActivity.class);
                    startActivity(intent);
                    finish();

                }
            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.mPerfil) {
            Intent intent;
            intent = new Intent(FincasActivity.this, PerfilActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.mFincas) {


        } else if (id == R.id.mNotificaciones) {
            Intent intent;
            intent = new Intent(FincasActivity.this, NotificacionesActivity.class);
            startActivity(intent);
            finish();

        } else if (id == R.id.mCerrar) {


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    class Adapter extends ArrayAdapter<Lista_Fincas> {
        public Adapter(Context context, Lista_Fincas[] datos) {
            super(context, R.layout.list_notificaciones, datos);
        }

        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            LayoutInflater inflater =LayoutInflater.from(getContext());
            View item=inflater.inflate(R.layout.list_notificaciones,null);
            ImageView imageView=(ImageView)item.findViewById(R.id.imagen);
            TextView nombre =(TextView)item.findViewById(R.id.tNombre);
            TextView ubicacion= (TextView)item.findViewById(R.id.tUbicacion);
            imageView.setImageResource(datos[position].getId_imagen());
            nombre.setText(datos[position].getNombre());
            ubicacion.setText(datos[position].getUbicacion());
            return item;

        }

    }


}


