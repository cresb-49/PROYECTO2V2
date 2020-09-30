
package com.mycompany.proyecto2v2.Objetos;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Doctor extends Trabajador{
    private String colegiado;
    private ArrayList<String> especialidad= new ArrayList<>();
    private Time inicio;
    private Time fin;
    private Date inicioTrabajo;
    
    public Doctor(){
        this.setRol("doctor");
    }
      
    /**
     * Retorna el numero de colegiado
     * @return 
     */
    public String getColegiado() {
        return colegiado;
    }
    /**
     * Asigna el numero de colegiado
     * @param colegiado 
     */
    public void setColegiado(String colegiado) {
        this.colegiado = colegiado;
    }
    /**
     * Retorna las especialidades del doctor
     * @return 
     */
    public ArrayList<String> getEspecialidad() {
        return especialidad;
    }
    /**
     * Asigna las especialidades del doctor
     * @param especialidad 
     */
    public void setEspecialidad(ArrayList<String> especialidad){
        this.especialidad=especialidad;
    }
    /**
     * Asigna un especialidad al doctor
     * @param especialidad 
     */
    public void agregarEspecialidad(String especialidad) {
        this.especialidad.add(especialidad);
    }
    /**
     * Retorna el inicio de horario del doctor
     * @return 
     */
    public Time getInicio() {
        return inicio;
    }
    /**
     * Asigna el inicio de horario del doctor
     * @param inicio 
     */
    public void setInicio(Time inicio) {
        this.inicio = inicio;
    }
    /**
     * Retorna el fin de horario del doctor
     * @return 
     */
    public Time getFin() {
        return fin;
    }
    /**
     * Asigna el fin de horario del doctor
     * @param fin 
     */
    public void setFin(Time fin) {
        this.fin = fin;
    }
    /**
     * Retorna el inicio de trabajo del doctor
     * @return 
     */
    public Date getInicioTrabajo() {
        return inicioTrabajo;
    }
    /**
     * asigna el inicio de trabajo del doctor
     * @param inicioTrabajo 
     */
    public void setInicioTrabajo(Date inicioTrabajo) {
        this.inicioTrabajo = inicioTrabajo;
    }

    @Override
    public String toString() {
        return "Doctor{" + "codigo=" + this.getCodigo() + ", DPI=" + this.getDPI() + ", nombre=" + this.getNombre() + ", password=" + this.getPassword() + ", colegiado=" + colegiado + ", telefono=" + this.getTelefono() + ", especialidad=" + especialidad + ", correo=" + this.getEmail() + ", inicio=" + inicio + ", fin=" + fin + ", inicioTrabajo=" + inicioTrabajo + '}';
    }
    
    
}
