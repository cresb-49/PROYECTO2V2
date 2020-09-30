package com.mycompany.proyecto2v2.Objetos;

public class Persona extends usuarioSistema{
    private String nombre;
    private String DPI;
    public Persona(){

    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDPI() {
        return DPI;
    }
    public void setDPI(String dPI) {
        this.DPI = dPI;
    }
}
