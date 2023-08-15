package com.cdp.corporativoexpress;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.cdp.corporativoexpress.clientess.Adapter;
import com.cdp.corporativoexpress.clientess.detalles;
import com.cdp.corporativoexpress.clientess.editar;
import com.cdp.corporativoexpress.clientess.usuarios;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class listaclientes extends AppCompatActivity {

    ListView listView;
    Adapter adapter;
    public static ArrayList<com.cdp.corporativoexpress.clientess.usuarios>usuariosArrayList = new ArrayList<>();

    usuarios usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listaclientes);

        listView = findViewById(R.id.list);
        adapter=new Adapter(this,usuariosArrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder builder=new AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog=new ProgressDialog(view.getContext());

                CharSequence[]dialogo={"VER DATOS","EDITAR DATOS","ELIMINAR DATOS"};
                builder.setTitle(usuariosArrayList.get(position).getNombre());
                builder.setItems(dialogo, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        switch (i)
                        {
                            case 0:
                            startActivity(new Intent(getApplicationContext(), detalles.class).putExtra("position",position));
                            break;
                            case 1:
                                startActivity(new Intent(getApplicationContext(), editar.class).putExtra("position",position));
                                break;
                            case 2:
                               eliminar(usuariosArrayList.get(position).getId());
                                break;
                        }

                    }
                });
                builder.show();
            }
        });

        listardatos();
    }

    public void listardatos()
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
        RequestQueue requestQueue = Volley.newRequestQueue(listaclientes.this);
        requestQueue.add(request);
    }

    public void eliminar(final String id)
    {
        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.100.64/programador/eliminar.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                            Toast.makeText(listaclientes.this, "se elimino correctamente", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(getApplicationContext(), listaclientes.class));
                            finish();
                        }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(listaclientes.this,error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<>();
                parametros.put("id", id);

                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(listaclientes.this);
        requestQueue.add(request);
    }





    public void regresarr(View view) {
        Intent btregresar = new Intent(this, MainActivity.class);
        startActivity(btregresar);
    }

    public void clientesss(View view) {
        Intent agregarclientes = new Intent(this, clientes.class);
        startActivity(agregarclientes);
    }
}