package com.cdp.corporativoexpress;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class clientes extends AppCompatActivity {

    EditText edtnombre, edtapellido, edtdireccion, edtcorreo, edttelefono;
    Button btguardarclientes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        edtnombre =(EditText)findViewById(R.id.edtnombre);
        edtapellido = (EditText)findViewById(R.id.edtapellido);
        edtdireccion =(EditText)findViewById(R.id.edtdireccion);
        edtcorreo =(EditText)findViewById(R.id.edtcorreo);
        edttelefono = (EditText)findViewById(R.id.edttelefono);
        btguardarclientes = (Button)findViewById(R.id.btguardarclientes);

        btguardarclientes.setOnClickListener(v -> ejecutarclientes());


    }

    private void ejecutarclientes() {
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST, "http://192.168.100.64:80/programador/clientes.php",
                response -> Toast.makeText(getApplicationContext(), "SE GUARDO EL CLIENTE CORRECTAMENTE", Toast.LENGTH_SHORT).show(),
                error -> Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show()) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> parametros = new HashMap<>();
                parametros.put("nombre", edtnombre.getText().toString());
                parametros.put("apellido", edtapellido.getText().toString());
                parametros.put("direccion", edtdireccion.getText().toString());
                parametros.put("correo", edtcorreo.getText().toString());
                parametros.put("telefono", edttelefono.getText().toString());
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    //botones
    public void regresar(View view) {
        Intent btregresar = new Intent(this, MainActivity.class);
        startActivity(btregresar);
    }

}