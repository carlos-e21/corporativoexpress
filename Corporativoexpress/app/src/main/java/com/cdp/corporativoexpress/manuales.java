package com.cdp.corporativoexpress;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.cdp.corporativoexpress.manualess.manual_MG_inalambrico;
import com.cdp.corporativoexpress.manualess.manual_expansor;
import com.cdp.corporativoexpress.manualess.manual_fotoelectrico;
import com.cdp.corporativoexpress.manualess.manual_pir_cableado;
import com.cdp.corporativoexpress.manualess.manualllavero;
import com.cdp.corporativoexpress.manualess.manualmn02;
import com.cdp.corporativoexpress.manualess.manualpir_inalambrico;
import com.cdp.corporativoexpress.manualess.manualprogramacionrapida;
import com.cdp.corporativoexpress.manualess.manualvista48la;

public class manuales extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manuales);


    }

    public void regresar(View view) {
        Intent btregresar = new Intent(this, MainActivity.class);
        startActivity(btregresar);
    }

    public void boton1(View view) {
        Intent btnmanualvista48 = new Intent(this, manualvista48la.class);
        startActivity(btnmanualvista48);
    }

    public void boton2(View view) {
        Intent btnmanualvista48 = new Intent(this, manualprogramacionrapida.class);
        startActivity(btnmanualvista48);
    }

    public void boton3(View view) {
        Intent btnmanualmn02 = new Intent(this, manualmn02.class);
        startActivity(btnmanualmn02);
    }

    public void boton4(View view) {
        Intent btnmanualllavero = new Intent(this, manualllavero.class);
        startActivity(btnmanualllavero);
    }
    public void boton5(View view) {
        Intent btnmanual_pir_ina = new Intent(this, manualpir_inalambrico.class);
        startActivity(btnmanual_pir_ina);
    }

    public void boton6(View view) {
        Intent btnmanual_pir_cableado = new Intent(this, manual_pir_cableado.class);
        startActivity(btnmanual_pir_cableado);
    }

    public void boton7(View view) {
        Intent btnmanual_mg = new Intent(this, manual_MG_inalambrico.class);
        startActivity(btnmanual_mg);
    }
    public void boton8(View view) {
        Intent btnmanual_foto = new Intent(this, manual_fotoelectrico.class);
        startActivity(btnmanual_foto);
    }
    public void boton9(View view) {
        Intent btnmanual_expansor = new Intent(this, manual_expansor.class);
        startActivity(btnmanual_expansor);
    }

}