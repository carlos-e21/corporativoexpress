package com.cdp.corporativoexpress.manualess;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.cdp.corporativoexpress.R;
import com.cdp.corporativoexpress.manualess.PDF.PDFPIR_INA;
import com.github.barteksc.pdfviewer.PDFView;

public class manualpir_inalambrico extends AppCompatActivity {

    ProgressBar progressBar_pir_ina;
    PDFView manual_pir_inalambrico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manualpir_inalambrico);

        progressBar_pir_ina= findViewById(R.id.progressBar_pir_ina);
        manual_pir_inalambrico = findViewById(R.id.manual_pir_inalambrico);

        String urlpdf1="https://ftp3.syscom.mx/usuarios/yhermosillo/HONEYWELL/Serie%20inal%c3%a1mbrica%205800/Detectores%20inal%c3%a1mbricos%20de%20Movimiento%20-%20Humo/5800PIR%20Instrucciones%20de%20instalaci%c3%b3n.pdf";
        new PDFPIR_INA(progressBar_pir_ina, manual_pir_inalambrico).execute(urlpdf1);
    }
}