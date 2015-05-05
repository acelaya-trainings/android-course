package com.alejandrocelaya.descarganoticias;

import java.io.Serializable;

/**
 * Created by cta on 05/05/2015.
 */
public class Noticia implements Serializable {

    private String titulo;
    private String enlace;
    private String author;

    public Noticia() {}

    public Noticia(String titulo, String enlace, String author) {
        this.titulo = titulo;
        this.enlace = enlace;
        this.author = author;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format(
                "Noticia: {titulo: %s, enlace: %s, author: %s}",
                titulo,
                enlace,
                author
        );
    }
}
