package com.cdp.corporativoexpress;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
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

        edtnombre =findViewById(R.id.edtnombre);
        edtapellido = findViewById(R.id.edtapellido);
        edtdireccion =findViewById(R.id.edtdireccion);
        edtcorreo =findViewById(R.id.edtcorreo);
        edttelefono =findViewById(R.id.edttelefono);
        btguardarclientes =findViewById(R.id.btguardarclientes);

        btguardarclientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarclientes();
            }
        });


    }

    private void ejecutarclientes() {

    String nombre= edtnombre.getText().toString().trim();
    String apellidos= edtapellido.getText().toString().trim();
    String direccion = edtdireccion.getText().toString().trim();
    String email=edtcorreo.getText().toString().trim();
    String telefono= edttelefono.getText().toString().trim();

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("cargando");

        if (nombre.isEmpty()){
            Toast.makeText(this,"ingrese nombre",Toast.LENGTH_SHORT).show();
        } else if (apellidos.isEmpty()) {
            Toast.makeText(this,"ingrese apellidos",Toast.LENGTH_SHORT).show();
        } else if (direccion.isEmpty()) {
            Toast.makeText(this,"ingrese direccion",Toast.LENGTH_SHORT).show();
        } else if (email.isEmpty()) {
            Toast.makeText(this,"ingrese email",Toast.LENGTH_SHORT).show();
        }
        else if (telefono.isEmpty()) {
           Toast.makeText(this,"ingrese numero",Toast.LENGTH_SHORT).show();
        }
        else {
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.100.64/programador/clientes.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equalsIgnoreCase("datos insertados")) {
                                Toast.makeText(clientes.this, "registrado correctamente", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                startActivity(new Intent(getApplicationContext(), clientes.class));
                                finish();
                            } else {
                                Toast.makeText(clientes.this, "ERROR, No se puede registrar", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(clientes.this,error.getMessage(),Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> parametros = new HashMap<>();
                    parametros.put("nombre", nombre);
                    parametros.put("apellido", apellidos);
                    parametros.put("direccion", direccion);
                    parametros.put("correo", email);
                    parametros.put("telefono", telefono);
                    return parametros;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(clientes.this);
            requestQueue.add(request);
        }


    }

    //botones
    public void regresar(View view) {
        Intent btregresar = new Intent(this, MainActivity.class);
        startActivity(btregresar);
    }

}