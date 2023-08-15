package com.cdp.corporativoexpress;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class acercade extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acercade);

    Button btnoficina = findViewById(R.id.btnoficina);
        Button btnsyscom = findViewById(R.id.btnsyscom);

        btnoficina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phoneoficina="tel:9611321079";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(phoneoficina));
                startActivity(intent);

            }
        });

        btnsyscom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phonesyscom="tel:6144152525";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(phonesyscom));
                startActivity(intent);

            }
        });

    }




    public void regresar(View view)
    {
        Intent btregresar= new Intent(this, MainActivity.class);
        startActivity(btregresar);
    }
}