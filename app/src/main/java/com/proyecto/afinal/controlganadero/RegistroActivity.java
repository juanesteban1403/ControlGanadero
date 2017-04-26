package com.proyecto.afinal.controlganadero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {
    EditText correo,usuario,contrasena,recontrasena;
    Button cancelar, registrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        correo=(EditText)findViewById(R.id.eRcorreo);
        usuario=(EditText)findViewById(R.id.eRusername);
        contrasena=(EditText)findViewById(R.id.eRpassword);
        recontrasena=(EditText)findViewById(R.id.eRrpassword);
        cancelar=(Button)findViewById(R.id.bRcancelar);
        registrar=(Button)findViewById(R.id.bRregistro);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(contrasena.getText().toString().equals(recontrasena.getText().toString())) {
                    Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                    intent.putExtra("usuario", usuario.getText().toString());
                    intent.putExtra("contrasena", contrasena.getText().toString());
                    intent.putExtra("correo", correo.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }
                else{
                    Toast.makeText(RegistroActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegistroActivity.this,LoginActivity.class);
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });

    }
}
