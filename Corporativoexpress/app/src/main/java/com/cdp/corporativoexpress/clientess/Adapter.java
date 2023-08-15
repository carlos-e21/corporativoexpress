package com.cdp.corporativoexpress.clientess;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.cdp.corporativoexpress.R;

import java.util.List;

public class Adapter extends ArrayAdapter<usuarios> {

    Context context;
    List<usuarios>usuariosList;

    public Adapter(@NonNull Context context, List<usuarios>usuariosList) {
        super(context, R.layout.list_usuarios,usuariosList);
        this.context=context;
        this.usuariosList=usuariosList;
    }

    public View getView(int position, @NonNull View context, ViewGroup resource) {
        View view = LayoutInflater.from(resource.getContext()).inflate(R.layout.list_usuarios,null,true);
        //TextView tvid=view.findViewById(R.id.txt_id);
        TextView tvnombre=view.findViewById(R.id.txt_id);
        TextView tvapellido=view.findViewById(R.id.txt_name);


        tvapellido.setText(usuariosList.get(position).getApellido());
        tvnombre.setText(usuariosList.get(position).getNombre());


        return view;
    }



}
