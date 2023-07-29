package com.cdp.corporativoexpress.manualess;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.cdp.corporativoexpress.R;
import com.cdp.corporativoexpress.manualess.PDF.PDF_FOTOCELDA;
import com.github.barteksc.pdfviewer.PDFView;

public class manual_fotoelectrico extends AppCompatActivity {

    ProgressBar progressBar_fotocelda;
    PDFView manual_fotocelda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_fotoelectrico);

        progressBar_fotocelda= findViewById(R.id.progressBar_fotocelda);
        manual_fotocelda = findViewById(R.id.manual_fotocelda);

        String urlpdf1="https://ftp3.syscom.mx/usuarios/ftp/2016/09/13/0c4a9/SF60P-SF100P.pdf";
        new PDF_FOTOCELDA(progressBar_fotocelda, manual_fotocelda).execute(urlpdf1);
    }
}