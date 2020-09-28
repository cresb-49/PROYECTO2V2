
package com.mycompany.proyecto2v2.Objetos;

import com.mycompany.proyecto2v2.Conversiones.ConvercionesVariables;
import java.util.ArrayList;

public class Hospital {
    private ConvercionesVariables conv = new ConvercionesVariables();
    private ArrayList<Admin> admins;
    private ArrayList<Doctor> doctores;
    private ArrayList<Laboratorista> laboratoristas;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Examen> examenes;
    private ArrayList<Reporte> reportes;
    private ArrayList<Resultado> resultados;
    private ArrayList<Cita> citas;
    private ArrayList<Consulta> consultas;

    public Hospital(ArrayList<Admin> admins, ArrayList<Doctor> doctores, ArrayList<Laboratorista> laboratoristas, ArrayList<Paciente> pacientes, ArrayList<Examen> examenes, ArrayList<Reporte> reportes, ArrayList<Resultado> resultados, ArrayList<Cita> citas, ArrayList<Consulta> consultas) {
        this.admins = admins;
        this.doctores = doctores;
        this.laboratoristas = laboratoristas;
        this.pacientes = pacientes;
        this.examenes = examenes;
        this.reportes = reportes;
        this.resultados = resultados;
        this.citas = citas;
        this.consultas = consultas;
    }

    public ConvercionesVariables getConv() {
        return conv;
    }

    public void setConv(ConvercionesVariables conv) {
        this.conv = conv;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<Admin> admins) {
        this.admins = admins;
    }

    public ArrayList<Doctor> getDoctores() {
        return doctores;
    }

    public void setDoctores(ArrayList<Doctor> doctores) {
        this.doctores = doctores;
    }

    public ArrayList<Laboratorista> getLaboratoristas() {
        return laboratoristas;
    }

    public void setLaboratoristas(ArrayList<Laboratorista> laboratoristas) {
        this.laboratoristas = laboratoristas;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public ArrayList<Examen> getExamenes() {
        return examenes;
    }

    public void setExamenes(ArrayList<Examen> examenes) {
        this.examenes = examenes;
    }

    public ArrayList<Reporte> getReportes() {
        return reportes;
    }

    public void setReportes(ArrayList<Reporte> reportes) {
        this.reportes = reportes;
    }

    public ArrayList<Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(ArrayList<Resultado> resultados) {
        this.resultados = resultados;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(ArrayList<Consulta> consultas) {
        this.consultas = consultas;
    }

    @Override
    public String toString() {
        return "Hospital{" + "conv=" + conv + ", admins=" + admins + ", doctores=" + doctores + ", laboratoristas=" + laboratoristas + ", pacientes=" + pacientes + ", examenes=" + examenes + ", reportes=" + reportes + ", resultados=" + resultados + ", citas=" + citas + ", consultas=" + consultas + '}';
    }
}
