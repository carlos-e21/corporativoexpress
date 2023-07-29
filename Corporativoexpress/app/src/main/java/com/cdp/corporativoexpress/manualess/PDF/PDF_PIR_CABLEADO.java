package com.cdp.corporativoexpress.manualess.PDF;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PDF_PIR_CABLEADO extends AsyncTask<String,Void, InputStream> {

    public PDF_PIR_CABLEADO(ProgressBar progressBar_pir_cableado, PDFView manual_pir_cableado) {
        this.progressBar_pir_cableado = progressBar_pir_cableado;
        this.manual_pir_cableado = manual_pir_cableado;
    }

    ProgressBar progressBar_pir_cableado;
    PDFView manual_pir_cableado;

    @Override
    protected InputStream doInBackground(String... strings) {
        InputStream inputStream = null;
        try {

            URL url = new URL(strings[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            if (urlConnection.getResponseCode() == 200) ;
            inputStream = new BufferedInputStream(urlConnection.getInputStream());

        } catch (IOException e) {
            return null;
        }
        return inputStream;
    }


    @Override
    protected void onPostExecute(InputStream inputStream) {

        manual_pir_cableado.fromStream(inputStream).load();
        progressBar_pir_cableado.setVisibility(View.GONE);
    }
}
