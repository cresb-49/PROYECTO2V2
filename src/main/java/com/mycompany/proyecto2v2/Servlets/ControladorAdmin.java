package com.mycompany.proyecto2v2.Servlets;

import com.mycompany.proyecto2v2.Conversiones.ConvercionesVariables;
import com.mycompany.proyecto2v2.DBManage.ConnectionDB;
import com.mycompany.proyecto2v2.DBManage.ConsultasDB;
import com.mycompany.proyecto2v2.Objetos.usuarioSistema;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReportesAdmin")
public class ControladorAdmin extends HttpServlet {

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
                    String codigo = ((usuarioSistema) req.getSession().getAttribute("USER")).getCodigoEntidad();
                    System.out.println("1 Codigo: " + codigo);
                    List<String[]> diezInformes = consultas.diezMedicosMasInforme();
                    req.setAttribute("diezInfo", diezInformes);
                    req.getRequestDispatcher("/accionesAdmin/diezMedicosMasInformes.jsp").forward(req, resp);
                } else if (reporte.equals("2")) {
                    String codigo = ((usuarioSistema) req.getSession().getAttribute("USER")).getCodigoEntidad();
                    System.out.println("2 Codigo: " + codigo);
                    List<String[]> cincoCitas = consultas.cincoMedicosMenorCitas();
                    req.setAttribute("cincoCitas", cincoCitas);
                    req.getRequestDispatcher("/accionesAdmin/cincoMedicosCitas.jsp").forward(req, resp);
                } else if (reporte.equals("3")) {
                    String f1 = req.getParameter("fechaMenor");
                    String f2 = req.getParameter("fechaMayor");

                    if (!f1.isEmpty() || !f2.isEmpty()) {
                        String codigo = ((usuarioSistema) req.getSession().getAttribute("USER")).getCodigoEntidad();
                        System.out.println("Codigo: " + codigo);
                        System.out.println("Fecha1: " + f1);
                        System.out.println("Fecha2: " + f2);

                        List<String[]> examenes = consultas.examenesMasDemandadosEnTiempo(conv.stringToDate(f1), conv.stringToDate(f2));
                        req.setAttribute("examDem", examenes);
                        req.getRequestDispatcher("/accionesAdmin/examenesDeLaboratorioMasDemandadosEnIntervalo.jsp").forward(req, resp);
                    } else {
                        req.getRequestDispatcher("/accionesAdmin/examenesDeLaboratorioMasDemandadosEnIntervalo.jsp?error=Debe asignar un rengo de fechas para consultas").forward(req, resp);
                    }
                } else if (reporte.equals("4")) {
                    String codigo = ((usuarioSistema) req.getSession().getAttribute("USER")).getCodigoEntidad();
                    System.out.println("4 Codigo: " + codigo);
                    List<String[]> medicos = consultas.medicosQueDemandanMasExamenes();
                    req.setAttribute("medRe", medicos);
                    req.getRequestDispatcher("/accionesAdmin/medicosConMayorRequeriminetosDeExamenes.jsp").forward(req, resp);
                } else if (reporte.equals("5")) {
                    String f1 = req.getParameter("fechaMenor");
                    String f2 = req.getParameter("fechaMayor");
                    if (!f1.isEmpty() || !f2.isEmpty()) {
                        String codigo = ((usuarioSistema) req.getSession().getAttribute("USER")).getCodigoEntidad();
                        System.out.println("Codigo: " + codigo);
                        System.out.println("Fecha1: " + f1);
                        System.out.println("Fecha2: " + f2);

                        List<String[]> examenes = consultas.TRESexamenesMasDemandadosEnTiempo(conv.stringToDate(f1), conv.stringToDate(f2));
                        req.setAttribute("treEx", examenes);
                        req.getRequestDispatcher("/accionesAdmin/tresExamenesMasSolicitadosIntervalo.jsp").forward(req, resp);
                    } else {
                        req.getRequestDispatcher("/accionesAdmin/tresExamenesMasSolicitadosIntervalo.jsp?error=Debe asignar un rengo de fechas para consultas").forward(req, resp);
                    }
                    con.cerrarConexion();
                }
                con.cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error en controlador admin" + e.getClass().toString() + e.getMessage());
                resp.sendRedirect(req.getContextPath() + "/usuarios/ADMINISTRADOR.jsp");
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/usuarios/ADMINISTRADOR.jsp");

        }
    }

}
