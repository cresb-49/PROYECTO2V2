
package com.mycompany.proyecto2v2.Objetos;

import java.io.InputStream;

public class Archivo {
    
    private String nombre;
    private InputStream datos;
    private String ContentType;

    public Archivo(String nombre, InputStream datos) {
        this.nombre = nombre;
        this.datos = datos;
    }
    public Archivo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public InputStream getDatos() {
        return datos;
    }

    public void setDatos(InputStream datos) {
        this.datos = datos;
    }
    
    public void setContentType(String ContentType) {
        this.ContentType = ContentType;
    }
    public String getContentType() {
        return ContentType;
    }

    @Override
    public String toString() {
        return "Archivo{" + "nombre=" + nombre + ", datos=" + datos + ", ContentType=" + ContentType + '}';
    }
    
    
}
