package com.mycompany.proyecto2v2.QueryObjets;

import java.sql.Time;

import com.mycompany.proyecto2v2.Objetos.Cita;

public class QueryCita extends Cita {
    private String nombrePaciente;
    public QueryCita(Long codigo,String nombrePaciente,Long codigoPaciente,Time hora,String especialidad)
    {
        super(codigo, codigoPaciente, null, especialidad, null, hora);
        this.nombrePaciente=nombrePaciente;
    }
    public String getNombrePaciente() {
        return nombrePaciente;
    }
    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }
    @Override
    public String toString() {
        return "QueryCita{" + "nombrePaciente=" + nombrePaciente + '}';
    }
    
}
