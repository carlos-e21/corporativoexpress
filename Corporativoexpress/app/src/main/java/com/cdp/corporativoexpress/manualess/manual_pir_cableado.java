package com.cdp.corporativoexpress.manualess;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.cdp.corporativoexpress.R;
import com.cdp.corporativoexpress.manualess.PDF.PDF_PIR_CABLEADO;
import com.github.barteksc.pdfviewer.PDFView;

public class manual_pir_cableado extends AppCompatActivity {

    ProgressBar progressBar_pir_cableado;
    PDFView manual_pir_cableado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_pir_cableado);

        progressBar_pir_cableado= findViewById(R.id.progressBar_pir_cableado);
        manual_pir_cableado = findViewById(R.id.manual_pir_cableado);

        String urlpdf1="https://ftp3.syscom.mx/usuarios/jsosa/HIKVISION/alarmas/manual/UD13284B-A%20Baseline%20DS-PDP18-EG2%2018m%20Digital%20Dual%20PIR%20Detector%20User%20Manual%20V1.0.0%2020190705%20multi-language.pdf";
        new PDF_PIR_CABLEADO(progressBar_pir_cableado, manual_pir_cableado).execute(urlpdf1);
    }
}