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

public class PDFmn02 extends AsyncTask<String,Void, InputStream> {

    ProgressBar progressBar_mn02;
    PDFView manual_mn02;

    public PDFmn02(ProgressBar progressBar_mn02, PDFView manual_mn02) {
        this.progressBar_mn02 = progressBar_mn02;
        this.manual_mn02 = manual_mn02;
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
        protected void onPostExecute (InputStream inputStream){

            manual_mn02.fromStream(inputStream).load();
            progressBar_mn02.setVisibility(View.GONE);

            String urlpdf1="https://ftp3.syscom.mx/usuarios/vvega/M2M/mn02ltemv3/MN02LTEMV3%20-%20Manual%20Conexion%20Configuracion.pdf";
            new PDFmn02(progressBar_mn02, manual_mn02).execute(urlpdf1);


    }

}
