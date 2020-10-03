package com.mycompany.proyecto2v2.Servlets;

import com.mycompany.proyecto2v2.Conversiones.ConvercionesVariables;
import com.mycompany.proyecto2v2.DBManage.ConnectionDB;
import com.mycompany.proyecto2v2.DBManage.ConsultasDB;
import com.mycompany.proyecto2v2.Objetos.Resultado;
import com.mycompany.proyecto2v2.Objetos.SolicitudExamen;
import com.mycompany.proyecto2v2.Objetos.usuarioSistema;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author carlo
 */
@WebServlet("/ReportesLab")
public class controladorLaboratorista extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConvercionesVariables conv = new ConvercionesVariables();
        String reporte = req.getParameter("reporte");
        System.out.println("controlador Reportes; tipo de reporte: " + reporte);
        if (reporte != null || !reporte.isEmpty()) {
            try {

                ConnectionDB con = new ConnectionDB();
                ConsultasDB consultas = new ConsultasDB();
                consultas.setConexion(con.getConexion());

                if (reporte.equals("1")) {
                    String fecha = req.getParameter("fechaDia");
                    if (!fecha.isEmpty()) {
                        String codigo = ((usuarioSistema) req.getSession().getAttribute("USER")).getCodigoEntidad();
                        System.out.println("Codigo: " + codigo);
                        List<SolicitudExamen> solicitudes = consultas.solicitudesExamen(codigo, conv.stringToDate(fecha));
                        req.setAttribute("soliExamen", solicitudes);
                        req.getRequestDispatcher("/Lab/examenesProcesar.jsp").forward(req, resp);
                    } else {
                        req.getRequestDispatcher("/Lab/examenesProcesar.jsp?error=Debe de introducir un fecha para procesar").forward(req, resp);
                    }

                } else if (reporte.equals("2")) {
                    String fecha = req.getParameter("fechaR");
                    if (!fecha.isEmpty()) {
                        String codigo = ((usuarioSistema) req.getSession().getAttribute("USER")).getCodigoEntidad();
                        System.out.println("Codigo: " + codigo);
                        System.out.println("Fecha: " + fecha);
                        List<Resultado> examenesRe = consultas.resultadosHechos(codigo, conv.stringToDate(fecha));
                        for (Resultado res : examenesRe) {
                            System.out.println("---" + res.toString());
                        }
                        req.setAttribute("examHechos", examenesRe);
                        req.getRequestDispatcher("/Lab/examenesRealizados.jsp").forward(req, resp);
                    } else {
                        req.getRequestDispatcher("/Lab/examenesRealizados.jsp?error=Debe de introducir un fecha para procesar").forward(req, resp);
                    }
                } else if (reporte.equals("3")) {
                    String codigo = ((usuarioSistema) req.getSession().getAttribute("USER")).getCodigoEntidad();
                    System.out.println("Codigo: " + codigo);
                    List<String[]> diasTrabajo = consultas.cantidadResultadosHechos(codigo);
                    req.setAttribute("mayorT",diasTrabajo);
                    req.getRequestDispatcher("/Lab/cantidadTrabajo.jsp").forward(req, resp);
                }
                con.cerrarConexion();
            } catch (Exception e) {
                resp.sendRedirect(req.getContextPath() + "/usuarios/perfilLaboratorista.jsp");
                System.out.println("Error en controlador laboratorista" + e.getClass().toString() + e.getMessage());
                e.printStackTrace();
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/usuarios/perfilLaboratorista.jsp");

        }
    }

}
