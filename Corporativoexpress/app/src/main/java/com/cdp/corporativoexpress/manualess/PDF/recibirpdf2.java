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

public class recibirpdf2 extends AsyncTask<String,Void, InputStream> {


    public recibirpdf2(ProgressBar progressBar2, PDFView pdfmanual2) {
        this.progressBar2 = progressBar2;
        this.pdfmanual2 = pdfmanual2;
    }

    ProgressBar progressBar2;
    PDFView pdfmanual2;


    @Override
    protected InputStream doInBackground(String... strings) {
        InputStream inputStream = null;
        try{

            URL url =new URL(strings[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            if (urlConnection.getResponseCode()==200);
            inputStream = new BufferedInputStream(urlConnection.getInputStream());

        }catch (IOException e){
            return null;
        }
        return inputStream;
    }

    @Override
    protected void onPostExecute(InputStream inputStream) {

        pdfmanual2.fromStream(inputStream).load();
        progressBar2.setVisibility(View.GONE);



    }


    }


