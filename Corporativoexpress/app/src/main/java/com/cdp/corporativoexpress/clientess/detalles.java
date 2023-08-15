package com.cdp.corporativoexpress.clientess;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.cdp.corporativoexpress.R;
import com.cdp.corporativoexpress.listaclientes;

public class detalles extends AppCompatActivity {


    EditText edtnombre, edtapellido, edtdireccion, edtcorreo, edttelefono, edtid;

    private int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        edtid = findViewById(R.id.edtid);
        edtnombre = findViewById(R.id.edtnombre);
        edtapellido = findViewById(R.id.edtapellido);
        edtdireccion = findViewById(R.id.edtdireccion);
        edtcorreo = findViewById(R.id.edtcorreo);
        edttelefono = findViewById(R.id.edttelefono);


        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        edtid.setText(listaclientes.usuariosArrayList.get(position).getId());
        edtnombre.setText(listaclientes.usuariosArrayList.get(position).getNombre());
        edtapellido.setText(listaclientes.usuariosArrayList.get(position).getApellido());
        edtdireccion.setText(listaclientes.usuariosArrayList.get(position).getDireccion());
        edtcorreo.setText(listaclientes.usuariosArrayList.get(position).getCorreo());
        edttelefono.setText(listaclientes.usuariosArrayList.get(position).getTelefono());

    }
}