/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2v2.Objetos;

import com.mycompany.proyecto2v2.Conversiones.ConvercionesVariables;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author benjamin
 */
public class HospitalHandler extends DefaultHandler {

    private ConvercionesVariables conv = new ConvercionesVariables();
    private ArrayList<Admin> admins = new ArrayList();
    private ArrayList<Doctor> doctores = new ArrayList();
    private ArrayList<Laboratorista> laboratoristas = new ArrayList<>();
    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private ArrayList<Examen> examenes = new ArrayList<>();
    private ArrayList<Reporte> reportes = new ArrayList<>();
    private ArrayList<Resultado> resultados = new ArrayList<>();
    private ArrayList<Cita> citas = new ArrayList<>();
    private ArrayList<Consulta> consultas = new ArrayList<>();
    private Object objeto;

    private StringBuilder buffer = new StringBuilder();

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "CODIGO":
                asignarCodigo();
                break;
            case "DPI":
                asignarDPI();
                break;
            case "NOMBRE":
                asignarNombre();
                break;
            case "PASSWORD":
                asignarPassword();
                break;
            case "COLEGIADO":
                if (objeto instanceof Doctor) {
                    Doctor doctor = (Doctor) objeto;
                    doctor.setColegiado(buffer.toString());
                }
                break;
            case "TELEFONO":
                asignarTelefono();
                break;
            case "ESPECIALIDAD":
                if (objeto instanceof Cita) {
                    Cita cita = (Cita) objeto;
                    cita.setEspecialidad(buffer.toString());
                }
                break;
            case "TITULO":
                if (objeto instanceof Doctor) {
                    Doctor doctor = (Doctor) objeto;
                    doctor.agregarEspecialidad(buffer.toString());
                }
                break;
            case "CORREO":
                asignarCorreo();
                break;
            case "HORARIO":
                break;
            case "INICIO":
                convercionHora(qName);
                break;
            case "FIN":
                convercionHora(qName);
                break;
            case "TRABAJO":
                if (objeto instanceof Doctor) {
                    Doctor doctor = (Doctor) objeto;
                    doctor.setInicioTrabajo(this.conv.stringToDate(buffer.toString()));
                }
                break;
            case "TRABAJOF":
                if (objeto instanceof Laboratorista) {
                    Laboratorista lab = (Laboratorista) objeto;
                    lab.setInicioTrabajo(this.conv.stringToDate(buffer.toString()));
                }
                break;
            case "REGISTRO":
                if (objeto instanceof Laboratorista) {
                    Laboratorista lab = (Laboratorista) objeto;
                    lab.setRegistro(buffer.toString());
                }
                break;
            case "EXAMEN":
                asignarExamen();
                break;
            case "DIA":
                if (objeto instanceof Laboratorista) {
                    Laboratorista lab = (Laboratorista) objeto;
                    lab.agregarDia(this.conv.arregloDiaSemana(buffer.toString()));
                }
                break;
            case "SEXO":
                if (objeto instanceof Paciente) {
                    Paciente paciente = (Paciente) objeto;
                    paciente.setSexo(buffer.toString());
                }
                break;
            case "BIRTH":
                if (objeto instanceof Paciente) {
                    Paciente paciente = (Paciente) objeto;
                    paciente.setCumple(this.conv.stringToDate(buffer.toString()));
                }
                break;
            case "PESO":
                if (objeto instanceof Paciente) {
                    Paciente paciente = (Paciente) objeto;
                    paciente.setPeso(this.conv.stringToDouble(buffer.toString()));
                }
                break;
            case "SANGRE":
                if (objeto instanceof Paciente) {
                    Paciente paciente = (Paciente) objeto;
                    paciente.setSangre(buffer.toString());
                }
                break;
            case "ORDEN":
                asignarOrden();
                break;
            case "DESCRIPCION":
                if (objeto instanceof Examen) {
                    Examen examen = (Examen) objeto;
                    examen.setDescripcion(buffer.toString());
                }
                break;
            case "COSTO":
                asignarCosto();
                break;
            case "INFORME":
                asignarInforme();
                break;
            case "PACIENTE":
                asignarPaciente();
                break;
            case "MEDICO":
                asignarMedico();

                break;
            case "FECHA":
                asignarFecha();
                break;
            case "HORA":
                asignarHora();
                break;
            case "LABORATORISTA":
                if (objeto instanceof Resultado) {
                    Resultado resultado = (Resultado) objeto;
                    resultado.setCodigoLaboratorista(buffer.toString());
                }
                break;
            case "TIPO":
                if (objeto instanceof Consulta) {
                    Consulta consulta = (Consulta) objeto;
                    consulta.setTipo(buffer.toString());
                }
                break;
            default:
                objeto = null;
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "admin":
                objeto = new Admin();
                admins.add((Admin) objeto);
                break;
            case "doctor":
                objeto = new Doctor();
                doctores.add((Doctor) objeto);
                break;
            case "laboratorista":
                objeto = new Laboratorista();
                laboratoristas.add((Laboratorista) objeto);
                break;
            case "paciente":
                objeto = new Paciente();
                pacientes.add((Paciente) objeto);
                break;
            case "examen":
                objeto = new Examen();
                examenes.add((Examen) objeto);
                break;
            case "reporte":
                objeto = new Reporte();
                reportes.add((Reporte) objeto);
                break;
            case "resultado":
                objeto = new Resultado();
                resultados.add((Resultado) objeto);
                break;
            case "cita":
                objeto = new Cita();
                citas.add((Cita) objeto);
                break;
            case "consulta":
                objeto = new Consulta();
                consultas.add((Consulta) objeto);
                break;
            default:
                buffer.delete(0, buffer.length());
                break;
        }
    }

    private void asignarCodigo() {
        if (objeto instanceof Trabajador) {
            Trabajador trabajador = (Trabajador) objeto;
            trabajador.setCodigo(buffer.toString());
        }
        if (objeto instanceof Paciente) {
            Paciente paciente = (Paciente) objeto;
            paciente.setCodigo(this.conv.stringToLong(buffer.toString()));
        }
        if (objeto instanceof Examen) {
            Examen examen = (Examen) objeto;
            examen.setCodigo(this.conv.stringToLong(buffer.toString()));
        }
        if (objeto instanceof Reporte) {
            Reporte reporte = (Reporte) objeto;
            reporte.setCodigo(this.conv.stringToLong(buffer.toString()));
        }
        if (objeto instanceof Resultado) {
            Resultado resultado = (Resultado) objeto;
            resultado.setCodigo(this.conv.stringToLong(buffer.toString()));
        }
        if (objeto instanceof Cita) {
            Cita cita = (Cita) objeto;
            cita.setCodigo(this.conv.stringToLong(buffer.toString()));
        }

    }

    private void asignarDPI() {
        if (objeto instanceof Trabajador) {
            Trabajador trabajador = (Trabajador) objeto;
            trabajador.setDPI(buffer.toString());
        }
        if (objeto instanceof Paciente) {
            Paciente paciente = (Paciente) objeto;
            paciente.setDPI(buffer.toString());
        }
    }

    private void asignarNombre() {
        if (objeto instanceof Trabajador) {
            Trabajador trabajador = (Trabajador) objeto;
            trabajador.setNombre(buffer.toString());
        }
        if (objeto instanceof Examen) {
            Examen examen = (Examen) objeto;
            examen.setNombre(buffer.toString());
        }
        if (objeto instanceof Paciente) {
            Paciente paciente = (Paciente) objeto;
            paciente.setNombre(buffer.toString());
        }
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    private void asignarPassword() {
        if (objeto instanceof Trabajador) {
            Trabajador trabajador = (Trabajador) objeto;
            trabajador.setPassword(buffer.toString());
        }
        if (objeto instanceof Paciente) {
            Paciente paciente = (Paciente) objeto;
            paciente.setPassword(buffer.toString());
        }
    }

    private void asignarTelefono() {
        if (objeto instanceof Trabajador) {
            Trabajador trabajador = (Trabajador) objeto;
            trabajador.setTelefono(buffer.toString());
        }
        if (objeto instanceof Paciente) {
            Paciente paciente = (Paciente) objeto;
            paciente.setTelefono(buffer.toString());
        }
    }

    private void asignarCorreo() {
        if (objeto instanceof Trabajador) {
            if (!(objeto instanceof Admin)) {
                Trabajador trabajador = (Trabajador) objeto;
                trabajador.setCorreo(buffer.toString());
            }
        }
        if (objeto instanceof Paciente) {
            Paciente paciente = (Paciente) objeto;
            paciente.setCorreo(buffer.toString());
        }
    }

    private void convercionHora(String tipo) {

        if (tipo.equals("INICIO")) {
            if (objeto instanceof Doctor) {
                Doctor doctor = (Doctor) objeto;
                doctor.setInicio(this.conv.stringToTime(buffer.toString()));
            }
        }
        if (tipo.equals("FIN")) {
            if (objeto instanceof Doctor) {
                Doctor doctor = (Doctor) objeto;
                doctor.setFin(this.conv.stringToTime(buffer.toString()));
            }
        }
    }

    public ArrayList<Doctor> getDoctores() {
        return doctores;
    }

    public ArrayList<Laboratorista> getLaboratoristas() {
        return laboratoristas;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public ArrayList<Examen> getExamenes() {
        return examenes;
    }

    private void asignarInforme() {
        if (objeto instanceof Examen) {
            Examen examen = (Examen) objeto;
            examen.setInforme(this.conv.ajusteFormatos(buffer.toString()));
        }
        if (objeto instanceof Reporte) {
            Reporte reporte = (Reporte) objeto;
            reporte.setInformeMedico(buffer.toString());
        }
        if (objeto instanceof Resultado) {
            Resultado resultado = (Resultado) objeto;
            resultado.setNombreInforme(buffer.toString());
        }
    }

    public ArrayList<Reporte> getReportes() {
        return reportes;
    }

    private void asignarPaciente() {
        if (objeto instanceof Reporte) {
            Reporte reporte = (Reporte) objeto;
            reporte.setCodigoPaciente(this.conv.stringToLong(buffer.toString()));
        }
        if (objeto instanceof Resultado) {
            Resultado resultado = (Resultado) objeto;
            resultado.setCodigoPaciente(this.conv.stringToLong(buffer.toString()));
        }
        if (objeto instanceof Cita) {
            Cita cita = (Cita) objeto;
            cita.setCodigoPaciente(this.conv.stringToLong(buffer.toString()));
        }
    }

    private void asignarExamen() {
        if (objeto instanceof Laboratorista) {
            Laboratorista lab = (Laboratorista) objeto;
            lab.setExamen(buffer.toString());
        }
        if (objeto instanceof Resultado) {
            Resultado resultado = (Resultado) objeto;
            resultado.setCodigoExamen(this.conv.stringToLong(buffer.toString()));
        }
    }

    private void asignarOrden() {
        if (objeto instanceof Examen) {
            Examen examen = (Examen) objeto;
            examen.setOrden(this.conv.stringToBoolean(buffer.toString()));
        }
        if (objeto instanceof Resultado) {
            Resultado resultado = (Resultado) objeto;
            resultado.setNombreOrden(buffer.toString());
        }
    }

    private void asignarFecha() {
        if (objeto instanceof Reporte) {
            Reporte reporte = (Reporte) objeto;
            reporte.setFecha(this.conv.stringToDate(buffer.toString()));
        }
        if (objeto instanceof Resultado) {
            Resultado resultado = (Resultado) objeto;
            resultado.setFecha(this.conv.stringToDate(buffer.toString()));
        }
        if (objeto instanceof Cita) {
            Cita cita = (Cita) objeto;
            cita.setFecha(this.conv.stringToDate(buffer.toString()));
        }
    }

    private void asignarHora() {
        if (objeto instanceof Reporte) {
            Reporte reporte = (Reporte) objeto;
            reporte.setHora(this.conv.stringToTime(buffer.toString()));
        }
        if (objeto instanceof Resultado) {
            Resultado resultado = (Resultado) objeto;
            resultado.setHora(this.conv.stringToTime(buffer.toString()));
        }
        if (objeto instanceof Cita) {
            Cita cita = (Cita) objeto;
            cita.setHora(this.conv.stringToTime(buffer.toString()));
        }
    }

    public ArrayList<Resultado> getResultados() {
        return resultados;
    }

    private void asignarMedico() {
        if (objeto instanceof Reporte) {
            Reporte reporte = (Reporte) objeto;
            reporte.setCodigoMedico(buffer.toString());
        }
        if (objeto instanceof Cita) {
            Cita cita = (Cita) objeto;
            cita.setCodigoMedico(buffer.toString());
        }
        if (objeto instanceof Resultado) {
            Resultado resultado = (Resultado) objeto;
            resultado.setCodigoMedico(buffer.toString());
        }
    }

    private void asignarCosto() {
        if (objeto instanceof Examen) {
            Examen examen = (Examen) objeto;
            examen.setCosto(this.conv.stringToDouble(buffer.toString()));
        }
        if (objeto instanceof Consulta) {
            Consulta consulta = (Consulta) objeto;
            consulta.setCosto(this.conv.stringToDouble(buffer.toString()));
        }
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }
}
