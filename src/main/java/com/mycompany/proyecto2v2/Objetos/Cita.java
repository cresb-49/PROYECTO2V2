package com.mycompany.proyecto2v2.Objetos;

import java.sql.Date;
import java.sql.Time;

public class Cita {
    private Long codigo;
    private Long codigoPaciente;
    private String codigoMedico;
    private String especialidad;
    private Date fecha;
    private Time hora;
    
    public Cita(){
        
    }

    public Cita(Long codigo, Long codigoPaciente, String codigoMedico, String especialidad, Date fecha, Time hora) {
        this.codigo = codigo;
        this.codigoPaciente = codigoPaciente;
        this.codigoMedico = codigoMedico;
        this.especialidad = especialidad;
        this.fecha = fecha;
        this.hora = hora;
    }
    
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(Long codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public String getCodigoMedico() {
        return codigoMedico;
    }

    public void setCodigoMedico(String codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Cita{" + "codigo=" + codigo + ", codigoPaciente=" + codigoPaciente + ", codigoMedico=" + codigoMedico + ", especialidad=" + especialidad + ", fecha=" + fecha + ", hora=" + hora + '}';
    }
}
