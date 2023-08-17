package com.cdp.corporativoexpress;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.cdp.corporativoexpress.clientess.Adapter;
import com.cdp.corporativoexpress.clientess.usuarios;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class servicios extends AppCompatActivity {

    Spinner spinner1,spinner2,spinner3,spinner4,spinner5,spinner6,spinner7,spinner8;
    EditText edtzona1, edttipo1, edtzd1, edtubicacion1;
    EditText edtzona2, edttipo2, edtzd2, edtubicacion2;
    EditText edtzona3, edttipo3, edtzd3, edtubicacion3;
    EditText edtzona4, edttipo4, edtzd4, edtubicacion4;
    EditText edtzona5, edttipo5, edtzd5, edtubicacion5;
    EditText edtzona6, edttipo6, edtzd6, edtubicacion6;
    EditText edtzona7, edttipo7, edtzd7, edtubicacion7;
    EditText edtzona8, edttipo8, edtzd8, edtubicacion8;
    Spinner spinnerservicio;
    Adapter adapter;
    public static ArrayList<com.cdp.corporativoexpress.clientess.usuarios> usuariosArrayList = new ArrayList<>();
    usuarios usuarios;
    Button btnguardarservicio;






    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);

        spinnerservicio = findViewById(R.id.spinnerservicios);
        adapter=new Adapter(this,usuariosArrayList);
        spinnerservicio.setAdapter(adapter);



        //zona1
        spinner1= findViewById(R.id.spinner1);
        edttipo1 = findViewById(R.id.edttipo1);
        edtzd1 = findViewById(R.id.edtzd1);
        edtubicacion1 = findViewById(R.id.edtubicacion1);
        //zona2
        spinner2= findViewById(R.id.spinner2);
        edttipo2 = findViewById(R.id.edttipo2);
        edtzd2 = findViewById(R.id.edtzd2);
        edtubicacion2 = findViewById(R.id.edtubicacion2);
        //zona3
        spinner3= findViewById(R.id.spinner3);
        edttipo3 = findViewById(R.id.edttipo3);
        edtzd3 = findViewById(R.id.edtzd3);
        edtubicacion3 = findViewById(R.id.edtubicacion3);
        //zona4
        spinner4 = findViewById(R.id.spinner4);
        edttipo4 = findViewById(R.id.edttipo4);
        edtzd4 = findViewById(R.id.edtzd4);
        edtubicacion4 = findViewById(R.id.edtubicacion4);
        //zona5
        spinner5 = findViewById(R.id.spinner5);
        edttipo5 = findViewById(R.id.edttipo5);
        edtzd5 = findViewById(R.id.edtzd5);
        edtubicacion5 = findViewById(R.id.edtubicacion5);
        //zona6
        spinner6 = findViewById(R.id.spinner6);
        edttipo6 = findViewById(R.id.edttipo6);
        edtzd6 = findViewById(R.id.edtzd6);
        edtubicacion6 = findViewById(R.id.edtubicacion6);
        //zona7
        spinner7 = findViewById(R.id.spinner7);
        edttipo7 = findViewById(R.id.edttipo7);
        edtzd7 = findViewById(R.id.edtzd7);
        edtubicacion7 = findViewById(R.id.edtubicacion7);
        //zona8
        spinner8 = findViewById(R.id.spinner8);
        edttipo8 = findViewById(R.id.edttipo8);
        edtzd8 = findViewById(R.id.edtzd8);
        edtubicacion8 = findViewById(R.id.edtubicacion8);

        btnguardarservicio = findViewById(R.id.btnguardarservicio);


        listarservicios();
        spinnerservicio.setAdapter(adapter);
        spinnerservicio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long idl) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }






    public void listarservicios()
    {
        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.100.64/programador/mostrar.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        usuariosArrayList.clear();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String exito=jsonObject.getString("exito");
                            JSONArray jsonArray = jsonObject.getJSONArray("datos");
                            if (exito.equals("1")) {
                                for (int i=0;i<jsonArray.length();i++) {
                                    JSONObject object=jsonArray.getJSONObject(i);
                                    String id=object.getString("id");
                                    String nombre=object.getString("nombre");
                                    String apellido=object.getString("apellido");
                                    String direccion=object.getString("direccion");
                                    String correo=object.getString("correo");
                                    String telefono=object.getString("telefono");

                                    usuarios = new usuarios(id,nombre,apellido,direccion,correo,telefono);
                                    usuariosArrayList.add(usuarios);
                                    adapter.notifyDataSetChanged();

                                }
                            }

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        ){

        };
        RequestQueue requestQueue = Volley.newRequestQueue(servicios.this);
        requestQueue.add(request);
    }







    private void clientesservicios()
    {

        //zona1
        String zona1= spinner1.toString().toString().trim();
        String tipo1= edttipo1.getText().toString().trim();
        String zd1= edtzd1.getText().toString().trim();
        String ubicacion1= edtubicacion1.getText().toString().trim();
        //zona2
        String zona2= edtzona2.getText().toString().trim();
        String tipo2= edttipo2.getText().toString().trim();
        String zd2= edtzd2.getText().toString().trim();
        String ubicacion2= edtubicacion2.getText().toString().trim();
        //zona3
        String zona3= edtzona3.getText().toString().trim();
        String tipo3= edttipo3.getText().toString().trim();
        String zd3= edtzd3.getText().toString().trim();
        String ubicacion3= edtubicacion3.getText().toString().trim();
        //zona4
        String zona4= edtzona4.getText().toString().trim();
        String tipo4= edttipo4.getText().toString().trim();
        String zd4= edtzd4.getText().toString().trim();
        String ubicacion4= edtubicacion4.getText().toString().trim();
        //zona5
        String zona5= edtzona5.getText().toString().trim();
        String tipo5= edttipo5.getText().toString().trim();
        String zd5= edtzd5.getText().toString().trim();
        String ubicacion5= edtubicacion5.getText().toString().trim();
        //zona6
        String zona6= edtzona6.getText().toString().trim();
        String tipo6= edttipo6.getText().toString().trim();
        String zd6= edtzd6.getText().toString().trim();
        String ubicacion6= edtubicacion6.getText().toString().trim();
        //zona7
        String zona7= edtzona7.getText().toString().trim();
        String tipo7= edttipo7.getText().toString().trim();
        String zd7= edtzd7.getText().toString().trim();
        String ubicacion7= edtubicacion7.getText().toString().trim();
        //zona8
        String zona8= edtzona8.getText().toString().trim();
        String tipo8= edttipo8.getText().toString().trim();
        String zd8= edtzd8.getText().toString().trim();
        String ubicacion8= edtubicacion8.getText().toString().trim();

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("cargando");

        progressDialog.show();
        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.100.64/programador/servicios.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equalsIgnoreCase("datos insertados")) {
                            Toast.makeText(servicios.this, "registrado correctamente", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                        } else {
                            Toast.makeText(servicios.this, "ERROR, No se puede registrar", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(servicios.this,error.getMessage(),Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<>();
                //zona1
                parametros.put("zona1", zona1);
                parametros.put("tipo1", tipo1);
                parametros.put("zd1", zd1);
                parametros.put("ubicacion1", ubicacion1);
                //zona2
                parametros.put("zona2", zona2);
                parametros.put("tipo2", tipo2);
                parametros.put("zd2", zd2);
                parametros.put("ubicacion2", ubicacion2);
                //zona3
                parametros.put("zona3", zona3);
                parametros.put("tipo3", tipo3);
                parametros.put("zd3", zd3);
                parametros.put("ubicacion3", ubicacion3);
                //zona4
                parametros.put("zona4", zona4);
                parametros.put("tipo4", tipo4);
                parametros.put("zd4", zd4);
                parametros.put("ubicacion4", ubicacion4);
                //zona5
                parametros.put("zona5", zona5);
                parametros.put("tipo5", tipo5);
                parametros.put("zd5", zd5);
                parametros.put("ubicacion5", ubicacion5);
                //zona6
                parametros.put("zona6", zona6);
                parametros.put("tipo6", tipo6);
                parametros.put("zd6", zd6);
                parametros.put("ubicacion6", ubicacion6);
                //zona7
                parametros.put("zona7", zona7);
                parametros.put("tipo7", tipo7);
                parametros.put("zd7", zd7);
                parametros.put("ubicacion7", ubicacion7);
                //zona8
                parametros.put("zona8", zona8);
                parametros.put("tipo8", tipo8);
                parametros.put("zd8", zd8);
                parametros.put("ubicacion8", ubicacion8);

                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(servicios.this);
        requestQueue.add(request);
    }





    public void regresar(View view)
    {
        Intent btregresar= new Intent(this, MainActivity.class);
        startActivity(btregresar);
    }
}