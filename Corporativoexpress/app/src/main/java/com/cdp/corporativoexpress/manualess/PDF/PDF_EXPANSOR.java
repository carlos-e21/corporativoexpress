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

public class PDF_EXPANSOR extends AsyncTask<String,Void, InputStream> {

    public PDF_EXPANSOR(ProgressBar progressBar_expansor, PDFView manual_expansor) {
        this.progressBar_expansor = progressBar_expansor;
        this.manual_expansor = manual_expansor;
    }

    ProgressBar progressBar_expansor;
    PDFView manual_expansor;

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

        manual_expansor.fromStream(inputStream).load();
        progressBar_expansor.setVisibility(View.GONE);
    }
}
