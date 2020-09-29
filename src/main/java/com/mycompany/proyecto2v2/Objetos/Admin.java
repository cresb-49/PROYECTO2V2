
package com.mycompany.proyecto2v2.Objetos;

public class Admin extends Trabajador{
    /**
     * CONSTRUCTOR VACIO PARA ADMINISTRADOR
     */
    public Admin(){
        this.setRol("admin");
    }
    /**
     * CONSTRUCTOR CON PARAMETROS PARA ADMINISTRADOR
     * @param nombre
     * @param codigo
     * @param DPI
     * @param password 
     */
     public Admin(String nombre, String codigo, String DPI, String password){
         this.setRol("admin");
         this.setCodigo(codigo);
         this.setNombre(nombre);
         this.setDPI(DPI);
         this.setPassword(password);
     }
    @Override
    public String toString() {
        return "Admin{" + "codigo=" + this.getCodigo() + ", DPI=" + this.getDPI() + ", nombre=" + this.getNombre() + ", password=" + this.getPassword() + '}';
    }
    
}
