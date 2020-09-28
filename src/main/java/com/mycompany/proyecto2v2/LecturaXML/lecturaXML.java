package com.mycompany.proyecto2v2.LecturaXML;

import com.mycompany.proyecto2v2.Objetos.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class lecturaXML {
    /**
     * CONSTRUCTOR VACIO DE LA CLASE LEER XML
     */
    public lecturaXML(){
        
    }
    /**
     * La lectura del docuemento XML da como resultado un hopital de forma abstracta
     * @param archivo
     * @return
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException 
     */
    public Hospital leer(InputStream archivo) throws ParserConfigurationException, SAXException, IOException{
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            //File archivo = new File("/home/benjamin/Escritorio/data.xml");
            HospitalHandler handler = new HospitalHandler();
            
            saxParser.parse(archivo, handler);

            ArrayList<Admin> admins = handler.getAdmins();
            ArrayList<Doctor> doctores = handler.getDoctores();
            ArrayList<Laboratorista> lab = handler.getLaboratoristas();
            ArrayList<Paciente> pacientes = handler.getPacientes();
            ArrayList<Examen> examenes = handler.getExamenes();
            ArrayList<Reporte> reportes = handler.getReportes();
            ArrayList<Resultado> resultados = handler.getResultados();
            ArrayList<Cita> citas = handler.getCitas();
            ArrayList<Consulta> consultas = handler.getConsultas();
            
            Hospital hospital=new Hospital(admins, doctores, lab, pacientes, examenes, reportes, resultados, citas, consultas);

            for(Admin ad:admins){
                System.out.println(ad.toString());
            }
            for(Doctor dc:doctores){
                System.out.println(dc.toString());
            }
            for(Laboratorista l:lab){
                System.out.println(l.toString());
            }
            for(Paciente p:pacientes){
                System.out.println(p.toString());
            }
            for(Examen examen:examenes){
                System.out.println(examen.toString());
            }
            for(Reporte reporte:reportes){
                System.out.println(reporte.toString());
            }
            for(Resultado resultado:resultados){
                System.out.println(resultado.toString());
            }
            for(Cita cita:citas){
                System.out.println(cita.toString());
            }
            for(Consulta consulta:consultas){
                System.out.println(consulta.toString());
            }
            return hospital;
    }
}