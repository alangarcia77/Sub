package com.subasta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.Toast;

import java.time.chrono.HijrahEra;

import OpenHelper.SQLite_OpenHelper;

public class MainActivity extends AppCompatActivity {
    CheckedTextView text;
    Button btnIngresar;
    SQLite_OpenHelper Helper = new SQLite_OpenHelper(this,"BD1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (CheckedTextView) findViewById(R.id.Checkolv);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,recuperar.class));
            }
        });

        btnIngresar = (Button)findViewById(R.id.BtnLogin);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText  usu =(EditText)findViewById(R.id.TxtUsuario);
                EditText  pas =(EditText)findViewById(R.id.TxtContraseña);

                try {
                    Cursor cursor = Helper.consultarusuario(usu.getText().toString(),pas.getText().toString());
                    if (cursor.getCount()>0){
                        Intent i = new Intent(getApplicationContext(),principal2.class);
                        startActivity(i);

                    }else{
                        Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrectos"
                                ,Toast.LENGTH_LONG).show();
                    }
                    usu.setText("");
                    pas.setText("");
                    usu.findFocus();

                }catch (SQLException e){
                    e.printStackTrace();

                }
                }
        });

    }


    //Método boton login
    public void Login( View view){
        Intent login = new Intent(this,principal2.class);
        startActivity(login);
    }
    //Metodo boton registro
    public void Registro(View view){
        Intent registro = new Intent(this,Registro2.class);
        startActivity(registro);
    }



}
