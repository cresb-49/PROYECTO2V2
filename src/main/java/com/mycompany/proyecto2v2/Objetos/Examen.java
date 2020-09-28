
package com.mycompany.proyecto2v2.Objetos;

public class Examen {
    private Long codigo;
    private String nombre;
    private Boolean orden;
    private String descripcion;
    private Double costo;
    private String informe;
    
    public Examen(){
        
    }
    /**
     * Retorna el codigo del examen
     * @return 
     */
    public Long getCodigo() {
        return codigo;
    }
    /**
     * Asigna el codigo del examen
     * @param codigo 
     */
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    /**
     * Retorna el nombre del examen
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Asigna el nombre del examen
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Retorna si el examen necesita orden
     * @return 
     */
    public Boolean isOrden() {
        return orden;
    }
    /**
     * Asigna si el examen necesita orden
     * @param orden 
     */
    public void setOrden(Boolean orden) {
        this.orden = orden;
    }
    /**
     * Retorna la descripcion del examen
     * @return 
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Asigna la descripcion del examen
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Retorna el costo del examen
     * @return 
     */
    public double getCosto() {
        return costo;
    }
    /**
     * Asigna el cosnto del examen
     * @param costo 
     */
    public void setCosto(Double costo) {
        this.costo = costo;
    }
    /**
     * Retorna el tipo de informe del examen
     * @return 
     */
    public String getInforme() {
        return informe;
    }
    /**
     * Asigna el tipo de informe al examen
     * @param informe 
     */
    public void setInforme(String informe) {
        this.informe = informe;
    }

    @Override
    public String toString() {
        return "Examen{" + "codigo=" + codigo + ", nombre=" + nombre + ", orden=" + orden + ", descripcion=" + descripcion + ", costo=" + costo + ", informe=" + informe + '}';
    }

    
}
