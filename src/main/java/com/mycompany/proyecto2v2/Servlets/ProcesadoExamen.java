package com.mycompany.proyecto2v2.Servlets;

import com.mycompany.proyecto2v2.Conversiones.ConvercionesVariables;
import com.mycompany.proyecto2v2.DBManage.ConnectionDB;
import com.mycompany.proyecto2v2.DBManage.ConsultasDB;
import com.mycompany.proyecto2v2.DBManage.ModificacionDB;
import com.mycompany.proyecto2v2.DBManage.RegistroDB;
import com.mycompany.proyecto2v2.Objetos.Archivo;
import com.mycompany.proyecto2v2.Objetos.Examen;
import com.mycompany.proyecto2v2.Objetos.Resultado;
import com.mycompany.proyecto2v2.Objetos.SolicitudExamen;
import com.mycompany.proyecto2v2.Paths.obtenerNombreArchivo;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/ProcesarExamen")
@MultipartConfig(maxFileSize = 16177215)
public class ProcesadoExamen extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        obtenerNombreArchivo obtenerNom = new obtenerNombreArchivo();
        ConvercionesVariables conv = new ConvercionesVariables();
        String codigoSolicitud = req.getParameter("codigoSolicitud");
        String horaProcesado = req.getParameter("horaProcesado");
        String diaProcesado = req.getParameter("diaProceso");

        try {
            ConnectionDB con = new ConnectionDB();
            ConsultasDB consultas = new ConsultasDB();
            RegistroDB registro = new RegistroDB();
            ModificacionDB modificar = new ModificacionDB();
            registro.setConexion(con.getConexion());
            consultas.setConexion(con.getConexion());
            modificar.setConexion(con.getConexion());
            if (codigoSolicitud != null && horaProcesado != null && diaProcesado != null) {
                if (!codigoSolicitud.isEmpty() && !horaProcesado.isEmpty() && !diaProcesado.isEmpty()) {
                    SolicitudExamen solicitud = consultas.SolicitudExamen(conv.stringToLong(codigoSolicitud));

                    Resultado resultado = new Resultado();
                    resultado.setCodigoExamen(solicitud.getCodigoExamen());
                    resultado.setCodigoLaboratorista(solicitud.getCodigoLaboratorista());
                    resultado.setCodigoPaciente(solicitud.getCodigoPaciente());
                    resultado.setCodigoMedico(resultado.getCodigoMedico());
                    resultado.setHora(conv.stringToTime(horaProcesado));
                    resultado.setFecha(conv.stringToDate(diaProcesado));
                    resultado.setNombreOrden(solicitud.getOrden().getNombre());
                    resultado.setOrden(new Archivo(solicitud.getOrden().getNombre(),solicitud.getOrden().getDatos()));

                    Part filePart = req.getPart("informeExamen");
                    if (filePart.getSize() > 0) {
                        InputStream inputStream = filePart.getInputStream();
                        String nomA=filePart.getName()+"."+obtenerNom.obtenerNombre(filePart.getContentType());
                        inputStream = filePart.getInputStream();
                        resultado.setInforme(new Archivo(nomA, inputStream));
                        resultado.setNombreInforme(nomA);
                    }
                    System.out.println("Resultado: "+resultado.toString());
                    String resul = registro.registroResultado(resultado, "nuevo");
                    
                    if(resul.equals("")){
                        modificar.eliminarSolicitud(codigoSolicitud);
                        req.getRequestDispatcher("/Lab/errorProcesado.jsp?logroP="+"El resultado se registro con exito en la base de datos").forward(req, resp);
                    }else{
                        req.getRequestDispatcher("/Lab/errorProcesado.jsp?errorP="+resul).forward(req, resp);
                    }
                } else {
                    System.out.println("Un campo estaba vacio");
                    req.getRequestDispatcher("/Lab/examenesProcesar.jsp").forward(req, resp);
                }
            } else {
                System.out.println("Un campo estaba nulo");
                req.getRequestDispatcher("/Lab/examenesProcesar.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            req.getRequestDispatcher("/Lab/examenesProcesar.jsp").forward(req, resp);
            System.out.println("Error en post procesado de examen " + e.getMessage());
            e.printStackTrace();
            
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConvercionesVariables conv = new ConvercionesVariables();
        String codigoSolicitud = req.getParameter("codigoSolicitud");
        try {
            ConnectionDB con = new ConnectionDB();
            ConsultasDB consultas = new ConsultasDB();
            consultas.setConexion(con.getConexion());
            if (codigoSolicitud != null) {
                if (!codigoSolicitud.isEmpty()) {
                    SolicitudExamen solicitud = consultas.SolicitudExamen(conv.stringToLong(codigoSolicitud));
                    Examen examen = consultas.obtenerExamen(solicitud.getCodigoExamen().toString());

                    req.setAttribute("fechaSolicitud", solicitud.getFecha());
                    req.setAttribute("codeSolicitud", solicitud.getCodigoSolicitud());
                    req.setAttribute("nomExamen", examen.getNombre());
                    req.setAttribute("codeExamen", examen.getCodigo());
                    req.setAttribute("formato", examen.getInforme());

                    req.getRequestDispatcher("/Lab/proExamen.jsp").forward(req, resp);

                } else {
                    req.getRequestDispatcher("/Lab/examenesProcesar.jsp").forward(req, resp);
                }
            } else {
                req.getRequestDispatcher("/Lab/examenesProcesar.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            System.out.println("Error en servlet de procesado de examen " + e.getMessage());
            e.printStackTrace();
            req.getRequestDispatcher("/Lab/examenesProcesar.jsp").forward(req, resp);
        }

    }

}
