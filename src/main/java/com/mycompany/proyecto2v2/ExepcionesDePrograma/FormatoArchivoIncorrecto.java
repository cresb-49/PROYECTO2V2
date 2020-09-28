package com.mycompany.proyecto2v2.ExepcionesDePrograma;

public class FormatoArchivoIncorrecto extends Exception{
    public FormatoArchivoIncorrecto(){
        
    }
    public FormatoArchivoIncorrecto(String msj){
        super(msj);
    }
}
