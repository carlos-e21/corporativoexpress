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

public class PDFPIR_INA extends AsyncTask<String,Void, InputStream> {

    ProgressBar progressBar_pir_ina;
    PDFView manual_pir_inalambrico;

    public PDFPIR_INA(ProgressBar progressBar_pir_ina, PDFView manual_pir_inalambrico) {
        this.progressBar_pir_ina = progressBar_pir_ina;
        this.manual_pir_inalambrico = manual_pir_inalambrico;
    }

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

        manual_pir_inalambrico.fromStream(inputStream).load();
        progressBar_pir_ina.setVisibility(View.GONE);


    }
}