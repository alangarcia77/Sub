package com.subasta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class recuperar extends AppCompatActivity {

    private Button recu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar2);
        recu =  (Button)findViewById(R.id.Btnenviar);
        recu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(recuperar.this,MainActivity.class));
                Toast.makeText(getApplicationContext(),"Se ha enviado un link a su correo para restablecer contraseña"
                        ,Toast.LENGTH_LONG).show();
            }
        });


    }
}