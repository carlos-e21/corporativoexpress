package com.cdp.corporativoexpress;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class servicios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);
    }
    public void regresar(View view)
    {
        Intent btregresar= new Intent(this, MainActivity.class);
        startActivity(btregresar);
    }
}