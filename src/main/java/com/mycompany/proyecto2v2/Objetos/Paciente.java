package com.mycompany.proyecto2v2.Objetos;

import java.sql.Date;

public class Paciente{
    
    private Long codigo;
    private String nombre;
    private String DPI;
    private String password;
    private String telefono;
    private String correo;
    
    private String sexo;
    private Date cumple;
    private Double peso;
    private String sangre;
    /**
     * CONSTRUCTOR DE LA CLASE PACIETNE
     */
    public Paciente(){
        
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
        this.codigo = codigo;
        this.nombre = nombre;
        this.DPI = DPI;
        this.password = password;
        this.telefono = telefono;
        this.correo = correo;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
        return "Paciente{" + "codigo=" + codigo + ", nombre=" + nombre + ", DPI=" + DPI + ", password=" + password + ", telefono=" + telefono + ", correo=" + correo + ", sexo=" + sexo + ", cumple=" + cumple + ", peso=" + peso + ", sangre=" + sangre + '}';
    }
}
