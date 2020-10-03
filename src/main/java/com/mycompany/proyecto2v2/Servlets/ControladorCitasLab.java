/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2v2.Servlets;

import com.mycompany.proyecto2v2.DBManage.ConnectionDB;
import com.mycompany.proyecto2v2.DBManage.ConsultasDB;
import com.mycompany.proyecto2v2.Objetos.Archivo;
import com.mycompany.proyecto2v2.Objetos.Consulta;
import com.mycompany.proyecto2v2.Objetos.Examen;
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
        Archivo orden = new Archivo();
        String codigoLab = req.getParameter("codigoLab");
        String codigoExame = req.getParameter("codigoExamen");
        String fechaCita = req.getParameter("fechaCita");
        InputStream inputStream = null;
        try {
            Part filePart = req.getPart("fileOrden");
            if (filePart.getSize() > 0) {
                inputStream = filePart.getInputStream();
                orden.setNombre(filePart.getName());
                orden.setContentType(filePart.getContentType());
                inputStream = filePart.getInputStream();
                orden.setDatos(inputStream);
            }
        } catch (Exception ex) {
            System.out.println("fichero: "+ex.getMessage());
        }
        System.out.println("Cita lab: codigolab="+codigoLab+" codigoExamen="+codigoExame+" fechaCita="+fechaCita+" Orden="+orden.toString());
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
                    ///ERROR DE CITAS 
                }
            } catch (Exception e) {
                System.out.println("Error controlador citas lab " + e.getMessage());
                e.printStackTrace();
                req.getRequestDispatcher(req.getContextPath() + "/AccionesPaciente/ReportesPaciente?reporte=5").forward(req, resp);
            }

        } else {
            req.getRequestDispatcher(req.getContextPath() + "/AccionesPaciente/ReportesPaciente?reporte=5").forward(req, resp);
        }
    }

}
