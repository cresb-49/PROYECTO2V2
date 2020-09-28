
package com.mycompany.proyecto2v2.Objetos;

public class Admin extends Trabajador{
    
    public Admin(){
        this.setRol("admin");
    }
    @Override
    public String toString() {
        return "Admin{" + "codigo=" + this.getCodigo() + ", DPI=" + this.getDPI() + ", nombre=" + this.getNombre() + ", password=" + this.getPassword() + '}';
    }
    
}
