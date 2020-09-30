
package com.mycompany.proyecto2v2.Objetos;

public class Trabajador extends Persona {
    
    private String codigo;
    private String telefono;
    
    
    public Trabajador() {
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
