package com.mycompany.proyecto2v2.Servlets;

import com.mycompany.proyecto2v2.Conversiones.ConvercionesVariables;
import com.mycompany.proyecto2v2.DBManage.ConnectionDB;
import com.mycompany.proyecto2v2.DBManage.ConsultasDB;
import com.mycompany.proyecto2v2.Objetos.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReportesPaciente")
public class controladorPaciente extends HttpServlet {

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
                    System.out.println("Codigo: " + codigo);
                    List<Resultado> resultados = consultas.ultimos5ResultadosPaciente(codigo);
                    req.setAttribute("ul5R", resultados);
                    req.getRequestDispatcher("/AccionesPaciente/ultimos5Examenes.jsp").forward(req, resp);
                } else if (reporte.equals("2")) {

                    String f1 = req.getParameter("fechaMenor");
                    String f2 = req.getParameter("fechaMayor");
                    if (!f1.isEmpty() || !f2.isEmpty()) {
                        String codigo = ((usuarioSistema) req.getSession().getAttribute("USER")).getCodigoEntidad();
                        System.out.println("Codigo: " + codigo);
                        List<String[]> cantidad = consultas.CantidadExamenesRealizadosEnIntervalo(codigo, conv.stringToDate(f1), conv.stringToDate(f2));
                        req.setAttribute("cantidad", cantidad);
                        req.getRequestDispatcher("/AccionesPaciente/CantidadExamenesIntervalo.jsp").forward(req, resp);
                    } else {
                        req.getRequestDispatcher("/AccionesPaciente/CantidadExamenesIntervalo.jsp?error=Debe asignar un rengo de fechas para consultas").forward(req, resp);
                    }

                }else if(reporte.equals("3")){
                    String codigo = ((usuarioSistema) req.getSession().getAttribute("USER")).getCodigoEntidad();
                    System.out.println("Codigo: " + codigo);
                    List<Cita> citas = consultas.ultimas5CitasPacientes(codigo);
                    req.setAttribute("citas", citas);
                    req.getRequestDispatcher("/AccionesPaciente/ultimas5Consultas.jsp").forward(req, resp);
                }else if(reporte.equals("4")){
                    String f1 = req.getParameter("fechaMenor");
                    String f2 = req.getParameter("fechaMayor");
                    if (!f1.isEmpty() || !f2.isEmpty()) {
                        String codigo = ((usuarioSistema) req.getSession().getAttribute("USER")).getCodigoEntidad();
                        System.out.println("Codigo: " + codigo);
                        List<String[]> cantidadConsultas = consultas.consultasConMedico(codigo, conv.stringToDate(f1),conv.stringToDate(f2));
                        req.setAttribute("canConsutlas", cantidadConsultas);
                        req.getRequestDispatcher("/AccionesPaciente/CantidadConsultasHechas.jsp").forward(req, resp);
                    }else{
                        req.getRequestDispatcher("/AccionesPaciente/CantidadConsultasHechas.jsp?error=Debe asignar un rengo de fechas para consultas").forward(req, resp);
                    }
                }

            } catch (Exception e) {
                resp.sendRedirect(req.getContextPath() + "/usuarios/perfilPaciente.jsp");
                System.out.println("Error en controlador Pacietne" + e.getClass().toString() + e.getMessage());
                e.printStackTrace();
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/usuarios/perfilPaciente.jsp");
        }
    }

}