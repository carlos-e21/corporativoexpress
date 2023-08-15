package com.cdp.corporativoexpress.clientess;

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
import com.cdp.corporativoexpress.R;
import com.cdp.corporativoexpress.listaclientes;

import java.util.HashMap;
import java.util.Map;

public class editar extends AppCompatActivity {


    EditText edtnombre, edtapellido, edtdireccion, edtcorreo, edttelefono,edtid;
    Button btneditarr;
    private int position;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        edtid =findViewById(R.id.edtid);
        edtnombre =findViewById(R.id.edtnombre);
        edtapellido = findViewById(R.id.edtapellido);
        edtdireccion =findViewById(R.id.edtdireccion);
        edtcorreo =findViewById(R.id.edtcorreo);
        edttelefono =findViewById(R.id.edttelefono);
        btneditarr =findViewById(R.id.btneditarr);

        Intent intent=getIntent();
        position=intent.getExtras().getInt("position");

        edtid.setText(listaclientes.usuariosArrayList.get(position).getId());
        edtnombre.setText(listaclientes.usuariosArrayList.get(position).getNombre());
        edtapellido.setText(listaclientes.usuariosArrayList.get(position).getApellido());
        edtdireccion.setText(listaclientes.usuariosArrayList.get(position).getDireccion());
        edtcorreo.setText(listaclientes.usuariosArrayList.get(position).getCorreo());
        edttelefono.setText(listaclientes.usuariosArrayList.get(position).getTelefono());

        btneditarr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizar();
            }
        });


    }

    private void actualizar() {

        String id= edtid.getText().toString().trim();
        String nombre= edtnombre.getText().toString().trim();
        String apellidos= edtapellido.getText().toString().trim();
        String direccion = edtdireccion.getText().toString().trim();
        String email=edtcorreo.getText().toString().trim();
        String telefono= edttelefono.getText().toString().trim();

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("actualizando");

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
            StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.100.64/programador/actualizar.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                                Toast.makeText(editar.this, "actualizado correctamente", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                startActivity(new Intent(getApplicationContext(), listaclientes.class));

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(editar.this,error.getMessage(),Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> parametros = new HashMap<>();
                    parametros.put("id", id);
                    parametros.put("nombre", nombre);
                    parametros.put("apellido", apellidos);
                    parametros.put("direccion", direccion);
                    parametros.put("correo", email);
                    parametros.put("telefono", telefono);
                    return parametros;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(editar.this);
            requestQueue.add(request);
        }


    }
}