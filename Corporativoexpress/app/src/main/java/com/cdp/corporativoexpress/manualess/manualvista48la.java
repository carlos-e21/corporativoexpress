package com.cdp.corporativoexpress.manualess;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.cdp.corporativoexpress.R;
import com.cdp.corporativoexpress.manualess.PDF.recibirPDF;
import com.github.barteksc.pdfviewer.PDFView;

public class manualvista48la extends AppCompatActivity {

    ProgressBar progressBar1;
    PDFView pdf_manual1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manualvista48la);

        pdf_manual1 = findViewById(R.id.pdf_manual1);
        progressBar1 = findViewById(R.id.progressBar1);

        String urlpdf="https://ftp3.syscom.mx/usuarios/yhermosillo/HONEYWELL/Serie%20inal%C3%A1mbrica%205800/5816%20Installation-setup-guide.pdf";
        new recibirPDF(progressBar1, pdf_manual1).execute(urlpdf);
    }
}