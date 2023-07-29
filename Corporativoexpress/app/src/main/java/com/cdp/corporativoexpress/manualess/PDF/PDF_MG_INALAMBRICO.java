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

public class PDF_MG_INALAMBRICO extends AsyncTask<String,Void, InputStream> {

    public PDF_MG_INALAMBRICO(ProgressBar progressBar_mg_inalambrico, PDFView manual_mg_inalambrico) {
        this.progressBar_mg_inalambrico = progressBar_mg_inalambrico;
        this.manual_mg_inalambrico = manual_mg_inalambrico;
    }

    ProgressBar progressBar_mg_inalambrico;
    PDFView manual_mg_inalambrico;

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

        manual_mg_inalambrico.fromStream(inputStream).load();
        progressBar_mg_inalambrico.setVisibility(View.GONE);
    }
}
