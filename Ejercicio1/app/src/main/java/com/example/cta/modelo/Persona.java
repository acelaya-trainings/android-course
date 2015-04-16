package com.example.cta.modelo;

import java.io.Serializable;

/**
 * Created by cta on 16/04/2015.
 */
public class Persona implements Serializable{

    private String nombre;
    private String apellidos;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {

        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
}
