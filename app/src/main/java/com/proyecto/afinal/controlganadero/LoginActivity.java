package com.proyecto.afinal.controlganadero;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.facebook.FacebookSdk;

public class LoginActivity extends AppCompatActivity {
    Button registro,login;
    EditText usuario, contrasena;
    String auxusuario, auxcontrasena, auxcorreo;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        prefs=getSharedPreferences("mispreferencias",MODE_PRIVATE);
        editor=prefs.edit();

        registro=(Button)findViewById(R.id.bLregister);
        usuario=(EditText)findViewById(R.id.eLusername);
        contrasena=(EditText)findViewById(R.id.eLpassword);
        auxusuario=prefs.getString("usuario","nousuario");
        auxcontrasena=prefs.getString("contrasena","nocontrasena");
        auxcorreo=prefs.getString("correo","nocorreo");

        if(prefs.getInt("login",-1)==1){
            Intent intent=new Intent(LoginActivity.this,NotificacionesActivity.class);
            intent.putExtra("usuario",auxusuario);
            intent.putExtra("correo",auxusuario);
            startActivity(intent);
            finish();
        }


        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent =new Intent(LoginActivity.this,RegistroActivity.class);
                startActivityForResult(intent,1234);
            }
        });
        login=(Button)findViewById(R.id.bLlogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usuario.getText().toString().equals(auxusuario)&&contrasena.getText().toString().equals(auxcontrasena)){
                    editor.putInt("login",1);
                    editor.commit();
                    Intent intent=new Intent(LoginActivity.this,NotificacionesActivity.class);
                    intent.putExtra("usuario",auxusuario);
                    intent.putExtra("correo",auxusuario);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Datos Incorrectos", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1234&&resultCode==RESULT_OK){
            auxusuario=data.getExtras().getString("usuario");
            auxcorreo=data.getExtras().getString("correo");
            auxcontrasena=data.getExtras().getString("contrasena");
            editor.putString("usuario",auxusuario);
            editor.putString("correo",auxcorreo);
            editor.putString("contrasena",auxcontrasena);
            editor.commit();

        }
        else{
            if(requestCode==1234&&resultCode==RESULT_CANCELED){
                Toast.makeText(this, "Error al entrar", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
