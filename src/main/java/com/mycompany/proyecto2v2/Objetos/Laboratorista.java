
package com.mycompany.proyecto2v2.Objetos;

import java.sql.Date;
import java.util.ArrayList;

public class Laboratorista extends Trabajador{
    private String registro;
    private String examen;
    private ArrayList<String> dias = new ArrayList<>();
    private Date inicioTrabajo;
    
    /**
     * COSNTRUCTOR VACIO DE LA CLASE LABORATORISTA
     */
    public Laboratorista(){
        this.setRol("laboratorista");
    }
    /**
     * Retorna el registro de salud del laboratorista
     * @return 
     */
    public String getRegistro() {
        return registro;
    }
    /**
     * Asigna el registro de salud del laboratorista
     * @param registro 
     */
    public void setRegistro(String registro) {
        this.registro = registro;
    }
    /**
     * Retrona el tipo de examen asociado al laboratorista
     * @return 
     */
    public String getExamen() {
        return examen;
    }
    /**
     * Asigna el tipo de examen asociado al laboratorista
     * @param examen 
     */
    public void setExamen(String examen) {
        this.examen = examen;
    }
    /**
     * Retorna los dias de trabajo del laboratorista
     * @return 
     */
    public ArrayList<String> getDias() {
        return dias;
    }
    /**
     * Agrega un dia de trabajo al laboratorista
     * @param dia 
     */
    public void agregarDia(String dia){
        this.dias.add(dia);
    }
    /**
     * Agrega los dias de trabajo al laboratorista
     * @param dias 
     */
    public void setDias(ArrayList<String> dias) {
        this.dias = dias;
    }
    /**
     * Retorna el inicio de labores del laboratorista
     * @return 
     */
    public Date getInicioTrabajo() {
        return inicioTrabajo;
    }
    /**
     * asigna el inicio de labores al laboratorista
     * @param inicioTrabajo 
     */
    public void setInicioTrabajo(Date inicioTrabajo) {
        this.inicioTrabajo = inicioTrabajo;
    }

    @Override
    public String toString() {
        return "Laboratorista{" + "codigo=" + this.getCodigo() + ", DPI=" + this.getDPI() + ", nombre=" + this.getNombre() + ", password=" + this.getPassword() + ", registro=" + registro + ", examen=" + examen + ", dias=" + dias + ", inicioTrabajo=" + inicioTrabajo + '}';
    }
    
}
