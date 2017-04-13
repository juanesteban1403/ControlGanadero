package com.proyecto.afinal.controlganadero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    Button registro,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        registro=(Button)findViewById(R.id.register);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent =new Intent(LoginActivity.this,RegistroActivity.class);
                startActivity(intent);
            }
        });
        login=(Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent=new Intent(LoginActivity.this,NotificacionesActivity.class);
                startActivity(intent);

            }
        });

    }
}
