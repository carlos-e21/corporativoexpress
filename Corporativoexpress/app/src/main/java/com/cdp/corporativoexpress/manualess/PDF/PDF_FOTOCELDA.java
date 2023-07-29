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

public class PDF_FOTOCELDA extends AsyncTask<String,Void, InputStream> {

    ProgressBar progressBar_fotocelda;

    public PDF_FOTOCELDA(ProgressBar progressBar_fotocelda, PDFView manual_fotocelda) {
        this.progressBar_fotocelda = progressBar_fotocelda;
        this.manual_fotocelda = manual_fotocelda;
    }

    PDFView manual_fotocelda;


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

        manual_fotocelda.fromStream(inputStream).load();
        progressBar_fotocelda.setVisibility(View.GONE);
    }
}
