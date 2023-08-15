package com.cdp.corporativoexpress;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //botones
    public void btclientes(View view)
    {
        Intent btclientes = new Intent(this, listaclientes.class);
        startActivity(btclientes);

    }

    public void btservicios (View t)
    {
        Intent btservicios = new Intent(this, servicios.class);
        startActivity(btservicios);



    }

    public void manual (View m)
    {
        Intent manual= new Intent(this, manuales.class);
        startActivity(manual);
    }

    public void acercadee (View d)
    {
        Intent acercadee= new Intent(this, acercade.class);
        startActivity(acercadee);
    }
}