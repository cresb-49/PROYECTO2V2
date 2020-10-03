package com.mycompany.proyecto2v2.Servlets;

import com.mycompany.proyecto2v2.Conversiones.ConvercionesVariables;
import com.mycompany.proyecto2v2.DBManage.ConnectionDB;
import com.mycompany.proyecto2v2.DBManage.ConsultasDB;
import com.mycompany.proyecto2v2.DBManage.RegistroDB;
import com.mycompany.proyecto2v2.Objetos.Cita;
import com.mycompany.proyecto2v2.Objetos.usuarioSistema;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControladorCita")
public class ControladorCitas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String codeMedico = req.getParameter("medico");
        String especialidad = req.getParameter("especialidad");
        String h1 = req.getParameter("hora1");
        String h2 = req.getParameter("hora2");
        java.time.LocalDate today = java.time.LocalDate.now();
        System.out.println("Medico: " + codeMedico + " Espe: " + especialidad + " h1: " + h1 + " h2: " + h2 + " fecha: " + today);
        req.setAttribute("medico", codeMedico);
        req.setAttribute("especialidad", especialidad);
        req.setAttribute("hora1", h1);
        req.setAttribute("hora2", h2);
        req.setAttribute("fecha", today);
        req.getRequestDispatcher("/AccionesPaciente/confirmarCita.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConvercionesVariables conv = new ConvercionesVariables();
        String action = req.getParameter("action");
        if (action != null || !action.isEmpty()) {
            try {
                ConnectionDB con = new ConnectionDB();
                ConsultasDB consultas = new ConsultasDB();
                RegistroDB registro = new RegistroDB();
                registro.setConexion(con.getConexion());
                consultas.setConexion(con.getConexion());
                if (action.equals("generarCita")) {
                    String codigo = ((usuarioSistema) req.getSession().getAttribute("USER")).getCodigoEntidad();
                    System.out.println("Codigo Entidad: " + codigo);

                    String codeMedico = req.getParameter("codigoDoctor");
                    String codePaceinte = codigo;
                    String fecha = req.getParameter("fechaCita");
                    String hora = req.getParameter("horaCita");
                    String especialidad = req.getParameter("especilidadCita");
                    System.out.println("Cita: medico=" + codeMedico + " paciente=" + codePaceinte + " fecha=" + fecha + " hora=" + hora + " especialidad=" + especialidad);

                    if (codeMedico != null && codePaceinte != null && fecha != null && hora != null && especialidad != null) {
                        if (!codeMedico.isEmpty() || !codePaceinte.isEmpty() || !fecha.isEmpty() || !hora.isEmpty() || !hora.isEmpty()) {
                            Cita cita = new Cita(null, conv.stringToLong(codePaceinte), codeMedico, especialidad, conv.stringToDate(fecha), conv.stringToTime(hora));
                            String respuesta = registro.registroCita(cita, "nuevo");
                            if (respuesta.equals("")) {
                                req.getRequestDispatcher("/AccionesPaciente/errorCita.jsp?logroP=" + "Se registro con exito su cita medica puede regresar a su perfil").forward(req, resp);
                            } else {
                                req.getRequestDispatcher("/AccionesPaciente/errorCita.jsp?errorP=" + respuesta).forward(req, resp);
                            }
                        } else {
                            req.getRequestDispatcher("/AccionesPaciente/confirmarCita.jsp?error=Debe de introuducir todos los campos").forward(req, resp);
                        }
                    } else {
                        req.getRequestDispatcher("/AccionesPaciente/confirmarCita.jsp?error=Debe de introuducir todos los campos").forward(req, resp);
                    }
                } else {
                    resp.sendRedirect(req.getContextPath() + "/usuarios/perfilPaciente.jsp");
                }
            } catch (Exception e) {
                resp.sendRedirect(req.getContextPath() + "/usuarios/perfilPaciente.jsp");
                System.out.println("com.mycompany.proyecto2v2.Servlets.controladorPaciente.doPost() " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/usuarios/perfilPaciente.jsp");
        }
    }

}
