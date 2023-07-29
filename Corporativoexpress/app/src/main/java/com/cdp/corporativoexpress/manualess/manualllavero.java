package com.cdp.corporativoexpress.manualess;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.cdp.corporativoexpress.R;
import com.cdp.corporativoexpress.manualess.PDF.PDFLLAVERO;
import com.github.barteksc.pdfviewer.PDFView;

public class manualllavero extends AppCompatActivity {

    ProgressBar progressBar_llavero;
    PDFView manual_llavero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manualllavero);

        progressBar_llavero = findViewById(R.id.progressBar_llavero);
        manual_llavero = findViewById(R.id.manual_llavero);

        String urlpdf1="https://ftp3.syscom.mx/usuarios/ftp/2015/02/23/958da/Llavero%20en%20un%20Vista%2048.pdf";
        new PDFLLAVERO(progressBar_llavero, manual_llavero).execute(urlpdf1);

    }
}