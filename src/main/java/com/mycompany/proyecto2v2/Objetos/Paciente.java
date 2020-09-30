package com.mycompany.proyecto2v2.Objetos;

import java.sql.Date;

public class Paciente extends Persona{
    
    private Long codigo;
    private String telefono;
    private String sexo;
    private Date cumple;
    private Double peso;
    private String sangre;
    /**
     * CONSTRUCTOR DE LA CLASE PACIETNE
     */
    public Paciente(){
        this.setRol("paciente");
    }
    /**
     * CONSTRUCTOR DE PACIENTE CON ATRIBUTOS
     * @param codigo
     * @param nombre
     * @param DPI
     * @param password
     * @param telefono
     * @param correo
     * @param sexo
     * @param cumple
     * @param peso
     * @param sangre 
     */
    public Paciente(String nombre, String DPI, String password, String telefono, String correo, String sexo, Date cumple, Double peso, String sangre) {
        this.setRol("paciente");
        this.setNombre(nombre);
        this.setDPI(DPI);
        this.setPassword(password);
        this.telefono = telefono;
        this.setEmail(correo);
        this.sexo = sexo;
        this.cumple = cumple;
        this.peso = peso;
        this.sangre = sangre;
    }
    

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    /**
     * Retorna el sexo del paciente
     * @return 
     */
    public String getSexo() {
        return sexo;
    }
    /**
     * Asigna el sexo del paciente
     * @param sexo 
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    /**
     * Retorna la fecha de cumpleaños del paciente
     * @return 
     */
    public Date getCumple() {
        return cumple;
    }
    /**
     * Asigna la fecha de cumpleaños del paciente
     * @param cumple 
     */
    public void setCumple(Date cumple) {
        this.cumple = cumple;
    }
    /**
     * Retorna el peso del paciente
     * @return 
     */
    public Double getPeso() {
        return peso;
    }
    /**
     * Asigna el peso del paciente
     * @param peso 
     */
    public void setPeso(Double peso) {
        this.peso = peso;
    }
    /**
     * Retorna el tipo de sangre del paciente
     * @return 
     */
    public String getSangre() {
        return sangre;
    }
    /**
     * Asigna el tipo de sangre del paciente
     * @param sangre 
     */
    public void setSangre(String sangre) {
        this.sangre = sangre;
    }

    @Override
    public String toString() {
        return "Paciente{" + "codigo=" + codigo + ", nombre=" + this.getNombre() + ", DPI=" + this.getDPI() + ", password=" + this.getPassword() + ", telefono=" + telefono + ", correo=" + this.getEmail()+", sexo=" + sexo + ", cumple=" + cumple + ", peso=" + peso + ", sangre=" + sangre + '}';
    }
}
