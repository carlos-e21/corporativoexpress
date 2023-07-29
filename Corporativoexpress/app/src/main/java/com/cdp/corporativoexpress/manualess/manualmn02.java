package com.cdp.corporativoexpress.manualess;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.cdp.corporativoexpress.R;
import com.cdp.corporativoexpress.manualess.PDF.PDFmn02;
import com.github.barteksc.pdfviewer.PDFView;

public class manualmn02 extends AppCompatActivity {


    ProgressBar progressBar_mn02;
    PDFView manual_mn02;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manualmn02);

        progressBar_mn02 = findViewById(R.id.progressBar_mn02);
        manual_mn02 = findViewById(R.id.manual_mn02);


        String urlpdf1="https://ftp3.syscom.mx/usuarios/vvega/M2M/mn02ltemv3/MN02LTEMV3%20-%20Manual%20Conexion%20Configuracion.pdf";
        new PDFmn02(progressBar_mn02, manual_mn02).execute(urlpdf1);

    }
}