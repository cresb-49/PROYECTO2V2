
package com.mycompany.proyecto2v2.Objetos;

import java.sql.Date;
import java.sql.Time;

public class Reporte {
    private Long codigo;
    private Long codigoPaciente;
    private String codigoMedico;
    private String informeMedico;
    private Date fecha;
    private Time hora;
    
    public Reporte(){
        
    }
    /**
     * Retorna el codigo de reporte
     * @return 
     */
    public Long getCodigo() {
        return codigo;
    }
    /**
     * Asigna el codigo de reporte
     * @param codigo 
     */
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    /**
     * Retorne ale codigo del paciente
     * @return 
     */
    public Long getCodigoPaciente() {
        return codigoPaciente;
    }
    /**
     * Asigna el codigo del paciente
     * @param codigoPaciente 
     */
    public void setCodigoPaciente(Long codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }
    /**
     * Retorna el codigo del medico
     * @return 
     */
    public String getCodigoMedico() {
        return codigoMedico;
    }
    /**
     * Asigna el codigo del medico
     * @param codigoMedico 
     */
    public void setCodigoMedico(String codigoMedico) {
        this.codigoMedico = codigoMedico;
    }
    /**
     * Retrona el informe medico
     * @return 
     */
    public String getInformeMedico() {
        return informeMedico;
    }   
    /**
     * Asigna el informe medico
     * @param informeMedico 
     */
    public void setInformeMedico(String informeMedico) {
        this.informeMedico = informeMedico;
    }
    /**
     * Retorna la fecha de reporte 
     * @return 
     */
    public Date getFecha() {
        return fecha;
    }
    /**
     * Asigna la fecha de reporte
     * @param fecha 
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    /**
     * Retorna la hora del reporte
     * @return 
     */
    public Time getHora() {
        return hora;
    }
    /**
     * Asigna la hora del reporte
     * @param hora 
     */
    public void setHora(Time hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Reporte{" + "codigo=" + codigo + ", codigoPaciente=" + codigoPaciente + ", codigoMedico=" + codigoMedico + ", fecha=" + fecha + ", hora=" + hora + ", informeMedico=" + informeMedico +  '}';
    }
    
}
