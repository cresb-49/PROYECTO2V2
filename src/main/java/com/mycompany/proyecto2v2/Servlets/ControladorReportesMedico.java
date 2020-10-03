/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2v2.Servlets;

import com.mycompany.proyecto2v2.Conversiones.ConvercionesVariables;
import com.mycompany.proyecto2v2.DBManage.ConnectionDB;
import com.mycompany.proyecto2v2.DBManage.ConsultasDB;
import com.mycompany.proyecto2v2.Objetos.Cita;
import com.mycompany.proyecto2v2.Objetos.Examen;
import com.mycompany.proyecto2v2.Objetos.Resultado;
import com.mycompany.proyecto2v2.Objetos.usuarioSistema;
import com.mycompany.proyecto2v2.QueryObjets.QueryCita;
import com.mycompany.proyecto2v2.QueryObjets.QueryPaciente;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReportesMedico")
public class ControladorReportesMedico extends HttpServlet {

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
                    String f1 = req.getParameter("fechaMenor");
                    String f2 = req.getParameter("fechaMayor");
                    if (!f1.isEmpty() || !f2.isEmpty()) {
                        Date fecha1 = conv.stringToDate(f1);
                        Date fecha2 = conv.stringToDate(f2);
                        String codigo = ((usuarioSistema) req.getSession().getAttribute("USER")).getCodigoEntidad();
                        System.out.println("Codigo: " + codigo);
                        List<QueryCita> citas = consultas.citasAgendadasIntevaloTiempo(codigo, fecha1, fecha2);
                        req.setAttribute("citasAge", citas);
                        req.getRequestDispatcher("/Medico/citasAgendadas.jsp").forward(req, resp);
                    } else {
                        resp.sendRedirect(req.getContextPath() + "/Medico/citasAgendadas.jsp?error=Debe de introducir un rango de fechas");
                    }
                } else if (reporte.equals("2")) {
                    String fechaDia = req.getParameter("fechaDia");
                    if (!fechaDia.isEmpty()) {
                        Date today = conv.stringToDate(fechaDia);
                        String codigo = ((usuarioSistema) req.getSession().getAttribute("USER")).getCodigoEntidad();
                        System.out.println("Codigo: " + codigo);
                        List<QueryCita> citasDia = consultas.citasAgendadasDia(codigo, today);
                        req.setAttribute("citasDia", citasDia);
                        req.getRequestDispatcher("/Medico/citasDiaCurso.jsp").forward(req, resp);
                    } else {
                        resp.sendRedirect(req.getContextPath() + "/Medico/citasDiaCurso.jsp?error=Debe de introducir una fecha");
                    }
                } else if (reporte.equals("3")) {
                    String f1 = req.getParameter("fechaMenor");
                    String f2 = req.getParameter("fechaMayor");
                    if (!f1.isEmpty() || !f2.isEmpty()) {
                        Date fecha1 = conv.stringToDate(f1);
                        Date fecha2 = conv.stringToDate(f2);
                        String codigo = ((usuarioSistema) req.getSession().getAttribute("USER")).getCodigoEntidad();
                        System.out.println("Codigo: " + codigo);
                        List<QueryPaciente> pacientes = consultas.pacientesConMasReportes(fecha1, fecha2);
                        System.out.println("Pacientes: " + pacientes.toString());
                        req.setAttribute("pacientesRe", pacientes);
                        req.getRequestDispatcher("/Medico/mayorCantidad.jsp").forward(req, resp);
                    } else {
                        resp.sendRedirect(req.getContextPath() + "/Medico/mayorCantidad.jsp?error=Debe de introducir un rango de fechas");
                    }
                } else if (reporte.equals("4")) {
                    String codigoPaciente = req.getParameter("codigoPaciente");
                    if (!codigoPaciente.isEmpty()) {
                        String codigo = ((usuarioSistema) req.getSession().getAttribute("USER")).getCodigoEntidad();
                        System.out.println("Codigo: " + codigo);
                        List<Cita> citas = consultas.citasPacientes(codigoPaciente);
                        List<Resultado> resultados = consultas.resultadosPaciente(codigoPaciente);
                        req.setAttribute("citasPaciente", citas);
                        req.setAttribute("resultadosPaciente", resultados);
                        req.getRequestDispatcher("/Medico/historialPaciente.jsp").forward(req, resp);
                    } else {
                        resp.sendRedirect(req.getContextPath() + "/Medico/historialPaciente.jsp?error=Debe introducir un codigo numerico");
                    }
                }else if(reporte.equals("5")){
                    List<Examen> examenes = consultas.retornarTodosExamen();
                    req.setAttribute("examenes", examenes);
                    req.getRequestDispatcher("/Medico/citaLabMedico.jsp").forward(req, resp);
                }

                /////////////////////FIN DE TRY CACHT///////////////////////////////////////////
            } catch (Exception e) {
                resp.sendRedirect(req.getContextPath() + "/usuarios/perfilDoctor.jsp");
                System.out.print("Error en controlador medico" + e.getMessage());
                e.printStackTrace();
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/usuarios/perfilDoctor.jsp");
        }
    }

}
