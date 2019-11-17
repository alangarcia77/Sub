package com.subasta;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class principal2 extends AppCompatActivity {
    ImageButton imagesmart;
    ImageButton imagepc;
    ImageButton imageauto;
    ImageButton imageart;
    ImageButton imagebook;
    ImageButton imagereloj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal2);
        imagesmart = (ImageButton) findViewById(R.id.imgsmart);
        imagepc = (ImageButton) findViewById(R.id.imgpc);
        imageauto = (ImageButton) findViewById(R.id.imgauto);
        imageart = (ImageButton) findViewById(R.id.imgart);
        imagebook = (ImageButton) findViewById(R.id.imgbook);
        imagereloj = (ImageButton) findViewById(R.id.imgreloj);
        imagesmart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(principal2.this,smartphone.class));
            }
        });
        imagepc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(principal2.this, PC.class));
            }
        });
        imageauto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(principal2.this,automoviles.class));
            }
        });
        imageart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(principal2.this,arte.class));
            }
        });
        imagebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(principal2.this,libro.class));
            }
        });
        imagereloj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(principal2.this,Reloj.class));
            }
        });

    }


}
