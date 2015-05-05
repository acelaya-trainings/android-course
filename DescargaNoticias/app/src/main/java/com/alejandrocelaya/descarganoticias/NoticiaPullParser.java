package com.alejandrocelaya.descarganoticias;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cta on 05/05/2015.
 */
public class NoticiaPullParser {

    public static List<Noticia> parse(InputStream input) throws XmlPullParserException, IOException {
        List<Noticia> noticias = new LinkedList<>();
        XmlPullParser xmlParser = Xml.newPullParser();
        xmlParser.setInput(input, "UTF-8");
        int tagType = xmlParser.getEventType();
        Noticia noticia = null;

        while (tagType != XmlPullParser.END_DOCUMENT) {
            String tag = null;

            switch (tagType) {
                case XmlPullParser.END_TAG:
                    tag = xmlParser.getName();
                    if ("item".equals(tag)) {
                        noticias.add(noticia);
                        noticia = null;
                    }
                    break;
                case XmlPullParser.START_TAG:
                    tag = xmlParser.getName();
                    if ("item".equals(tag)) {
                        noticia = new Noticia();
                    } else if (noticia != null) {
                        if ("title".equals(tag)) {
                            noticia.setTitulo(xmlParser.nextText());
                        } else if ("link".equals(tag)) {
                            noticia.setEnlace(xmlParser.nextText());
                        } else if ("creator".equals(tag)) {
                            noticia.setAuthor(xmlParser.nextText());
                        }
                    }
                    break;
            }

            tagType = xmlParser.next();
        }

        return noticias;
    }
}
