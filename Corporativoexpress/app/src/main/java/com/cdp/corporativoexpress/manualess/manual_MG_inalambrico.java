package com.cdp.corporativoexpress.manualess;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.cdp.corporativoexpress.R;
import com.cdp.corporativoexpress.manualess.PDF.PDF_MG_INALAMBRICO;
import com.github.barteksc.pdfviewer.PDFView;

public class manual_MG_inalambrico extends AppCompatActivity {

    ProgressBar progressBar_mg_inalambrico;
    PDFView manual_mg_inalambrico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_mg_inalambrico);

        progressBar_mg_inalambrico= findViewById(R.id.progressBar_mg_inalambrico);
        manual_mg_inalambrico = findViewById(R.id.manual_mg_inalambrico);

        String urlpdf1="https://ftp3.syscom.mx/usuarios/yhermosillo/HONEYWELL/Serie%20inal%C3%A1mbrica%205800/5816%20Installation-setup-guide.pdf";
        new PDF_MG_INALAMBRICO(progressBar_mg_inalambrico, manual_mg_inalambrico).execute(urlpdf1);
    }
}