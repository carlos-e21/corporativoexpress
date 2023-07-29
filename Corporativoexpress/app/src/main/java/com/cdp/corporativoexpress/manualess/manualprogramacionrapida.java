package com.cdp.corporativoexpress.manualess;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.cdp.corporativoexpress.R;
import com.cdp.corporativoexpress.manualess.PDF.recibirpdf2;
import com.github.barteksc.pdfviewer.PDFView;

public class manualprogramacionrapida extends AppCompatActivity {

   ProgressBar progressBar2;
   PDFView pdfmanual2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manualprogramacionrapida);

        pdfmanual2 = findViewById(R.id.pdfmanual2);
        progressBar2 = findViewById(R.id.progressBar2);

        String urlpdf="https://ftp3.syscom.mx/usuarios/ftp/2016/12/05/5915d/Vista48LA%20Programacion%20Rapida.pdf";
        new recibirpdf2(progressBar2, pdfmanual2).execute(urlpdf);

    }
}