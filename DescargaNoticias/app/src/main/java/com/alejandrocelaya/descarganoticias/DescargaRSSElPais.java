package com.alejandrocelaya.descarganoticias;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * Created by cta on 05/05/2015.
 */
public class DescargaRSSElPais extends AsyncTask<String, Void, List<Noticia>> {

    private ProgressDialog dialogo;
    private ListView listaNoticias;

    public DescargaRSSElPais(ProgressDialog dialogo, ListView listaNoticias) {
        this.dialogo = dialogo;
        this.listaNoticias = listaNoticias;
    }

    @Override
    protected void onPreExecute() {
        dialogo.setMessage("Descargando noticias");
        dialogo.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialogo.setCancelable(false);
        dialogo.show();
    }

    @Override
    protected List<Noticia> doInBackground(String... params) {
        List<Noticia> noticias = null;
        try {
            URL url = new URL(params[0]);
            URLConnection conn = url.openConnection();
            InputStream input = conn.getInputStream();
            noticias = NoticiaPullParser.parse(input);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        return noticias;
    }

    @Override
    protected void onPostExecute(List<Noticia> noticias) {
        dialogo.hide();
        listaNoticias.setAdapter(new ArrayAdapter<Noticia>(
                listaNoticias.getContext(),
                android.R.layout.simple_list_item_1,
                noticias
        ));
    }
}
