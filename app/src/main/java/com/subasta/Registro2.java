package com.subasta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import OpenHelper.SQLite_OpenHelper;

public class Registro2 extends AppCompatActivity {

    EditText nombre, contraseña, recont, email;
    Button btnRegistrar;
    SQLite_OpenHelper helper= new SQLite_OpenHelper(this,"BD1",null,1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro2);

        btnRegistrar = (Button)findViewById(R.id.btnregistrar);
        nombre=(EditText)findViewById(R.id.TxtUsuario);
        contraseña=(EditText)findViewById(R.id.TxtContraseña);
        recont=(EditText)findViewById(R.id.recont);
        email=(EditText)findViewById(R.id.email);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.abrir();
                helper.insertar(String.valueOf(nombre.getText()),
                        String.valueOf(contraseña.getText()),
                        String.valueOf(recont.getText()),
                        String.valueOf(email.getText()));
                helper.cerrar();

                Toast.makeText(getApplicationContext(),"Usuario Registrado con éxito"
                        ,Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }
}
