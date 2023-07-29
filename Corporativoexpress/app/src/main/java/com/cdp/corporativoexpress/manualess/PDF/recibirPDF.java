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

public class recibirPDF extends AsyncTask<String,Void, InputStream> {

    public recibirPDF(ProgressBar progressBar1, PDFView pdf_manual1) {
        this.progressBar1 = progressBar1;
        this.pdf_manual1 = pdf_manual1;
    }

    ProgressBar progressBar1;
    PDFView pdf_manual1;





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

        pdf_manual1.fromStream(inputStream).load();
        progressBar1.setVisibility(View.GONE);



    }


}
