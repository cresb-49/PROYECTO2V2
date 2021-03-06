/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2v2.Servlets;

import com.mycompany.proyecto2v2.Conversiones.ConvercionesVariables;
import com.mycompany.proyecto2v2.DBManage.ConnectionDB;
import com.mycompany.proyecto2v2.DBManage.ConsultasDB;
import com.mycompany.proyecto2v2.DBManage.RegistroDB;
import com.mycompany.proyecto2v2.Objetos.Archivo;
import com.mycompany.proyecto2v2.Objetos.Consulta;
import com.mycompany.proyecto2v2.Objetos.Examen;
import com.mycompany.proyecto2v2.Objetos.SolicitudExamen;
import com.mycompany.proyecto2v2.Objetos.usuarioSistema;
import com.mycompany.proyecto2v2.Paths.obtenerNombreArchivo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author carlo
 */
@WebServlet("/ControladorCitaLab")
@MultipartConfig(maxFileSize = 16177215)
public class ControladorCitasLab extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        obtenerNombreArchivo obtenerNom = new obtenerNombreArchivo();
        ConvercionesVariables conv = new ConvercionesVariables();
        try {
            ConnectionDB conexion = new ConnectionDB();
            ConsultasDB consultas = new ConsultasDB();
            RegistroDB registro = new RegistroDB();
            consultas.setConexion(conexion.getConexion());
            registro.setConexion(conexion.getConexion());
            Archivo orden = new Archivo();
            String codigoLab = req.getParameter("codigoLab");
            String codigoExame = req.getParameter("codigoExamen");
            String fechaCita = req.getParameter("fechaCita");
            try {
                Part filePart = req.getPart("fileOrden");
                if (filePart.getSize() > 0) {
                    InputStream inputStream = filePart.getInputStream();
                    String nomA = filePart.getName() + "." + obtenerNom.obtenerNombre(filePart.getContentType());
                    inputStream = filePart.getInputStream();
                    orden.setNombre(nomA);
                    orden.setDatos(inputStream);
                    orden.setContentType(filePart.getContentType());
                }
            } catch (Exception ex) {
                System.out.println("fichero: " + ex.getMessage());
            }
            Examen examen = consultas.retornarExamen(codigoExame);
            System.out.println("Cita lab: codigolab=" + codigoLab + " codigoExamen=" + codigoExame + " fechaCita=" + fechaCita + " Orden=" + orden.toString());
            SolicitudExamen solicitud = new SolicitudExamen();
            String codigoPaciente = ((usuarioSistema) req.getSession().getAttribute("USER")).getCodigoEntidad();
            System.out.println("Codigo Entidad: " + codigoPaciente);
            
            solicitud.setCodigoExamen(examen.getCodigo());
            solicitud.setCodigoLaboratorista(codigoLab);
            solicitud.setCodigoPaciente(conv.stringToLong(codigoPaciente));
            solicitud.setOrden(orden);
            solicitud.setFecha(conv.stringToDate(fechaCita));

            String resultado = registro.registroSolicitudExamen(solicitud);
            
            if(resultado.equals("")){
                req.getRequestDispatcher("/AccionesPaciente/errorCitaLab.jsp?logroP=Se registro con exito su cita de laboratorio").forward(req, resp);
            }else{
                req.getRequestDispatcher("/AccionesPaciente/errorCitaLab.jsp?errorP="+resultado).forward(req, resp);
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            req.getRequestDispatcher("/AccionesPaciente/errorCitaLab.jsp?errorP="+e.getMessage()).forward(req, resp);
            System.out.println("Error en controlador cita lab " + e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String codigoExamen = req.getParameter("codigo");
        System.out.println("Codigo Examen: " + codigoExamen);
        if (codigoExamen != null) {
            java.time.LocalDate today = java.time.LocalDate.now();
            try {
                ConnectionDB conexion = new ConnectionDB();
                ConsultasDB consulta = new ConsultasDB();
                consulta.setConexion(conexion.getConexion());

                Examen examen = consulta.obtenerExamen(codigoExamen);
                System.out.println("Examen: " + examen.toString());
                ArrayList<String> codigos = consulta.retornarCodigosSegunExamenLab(examen.getNombre());
                String codigoLab = "";

                int cantidad = codigos.size();
                if (cantidad != 0) {
                    if (cantidad == 1) {
                        codigoLab = codigos.get(0);
                    } else {
                        int numero = (int) (Math.random() * cantidad);
                        codigoLab = codigos.get(numero);
                    }
                    System.out.println("Codigo lab: " + codigoLab + " Codigo Examen: " + examen.getCodigo() + " Orden: " + examen.isOrden());

                    req.setAttribute("fecha", today);
                    req.setAttribute("CodigoExamen", examen.getCodigo());
                    req.setAttribute("admitidoOrden", examen.isOrden());
                    req.setAttribute("codigoLab", codigoLab);

                    req.getRequestDispatcher("/AccionesPaciente/confirmarCitaLab.jsp").forward(req, resp);

                } else {
                    System.out.println("Error controlador citas lab cantidad ");
                    req.getRequestDispatcher("/ReportesPaciente?reporte=6").forward(req, resp);
                }
                conexion.cerrarConexion();
            } catch (Exception e) {
                req.getRequestDispatcher("/ReportesPaciente?reporte=6").forward(req, resp);
                System.out.println("Error controlador citas lab " + e.getMessage());
                e.printStackTrace();
            }

        } else {
            req.getRequestDispatcher("/ReportesPaciente?reporte=6").forward(req, resp);
        }
    }

}
