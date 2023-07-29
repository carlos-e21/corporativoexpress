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

public class PDFLLAVERO extends AsyncTask<String,Void, InputStream> {

    public PDFLLAVERO(ProgressBar progressBar_llavero, PDFView manual_llavero) {
        this.progressBar_llavero = progressBar_llavero;
        this.manual_llavero = manual_llavero;
    }

    ProgressBar progressBar_llavero;
    PDFView manual_llavero;

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
    protected void onPostExecute (InputStream inputStream){

        manual_llavero.fromStream(inputStream).load();
        progressBar_llavero .setVisibility(View.GONE);



    }
}
