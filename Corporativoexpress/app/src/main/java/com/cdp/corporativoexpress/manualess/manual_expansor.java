package com.cdp.corporativoexpress.manualess;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.cdp.corporativoexpress.R;
import com.cdp.corporativoexpress.manualess.PDF.PDF_EXPANSOR;
import com.github.barteksc.pdfviewer.PDFView;

public class manual_expansor extends AppCompatActivity {

    ProgressBar progressBar_expansor;
    PDFView manual_expansor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_expansor);

        progressBar_expansor= findViewById(R.id.progressBar_expansor);
        manual_expansor = findViewById(R.id.manual_expansor);

        String urlpdf1="https://ftp3.syscom.mx/usuarios/ftp/2016/08/05/905fc/4219-without-EOLR-option--Installation-Instructions.PDF";
        new PDF_EXPANSOR(progressBar_expansor, manual_expansor).execute(urlpdf1);
    }
}