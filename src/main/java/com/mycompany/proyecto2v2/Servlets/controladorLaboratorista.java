package com.mycompany.proyecto2v2.Servlets;

import com.mycompany.proyecto2v2.Conversiones.ConvercionesVariables;
import com.mycompany.proyecto2v2.DBManage.ConnectionDB;
import com.mycompany.proyecto2v2.DBManage.ConsultasDB;
import com.mycompany.proyecto2v2.Objetos.usuarioSistema;
import java.io.IOException;
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
                    String codigo = ((usuarioSistema) req.getSession().getAttribute("USER")).getCodigoEntidad();
                    System.out.println("Codigo: " + codigo);
                    
                }
            } catch (Exception e) {
                resp.sendRedirect(req.getContextPath() + "/usuarios/perfilLaboratorista.jsp");
                System.out.print("Error en controlador laboratorista" + e.getMessage());
                e.printStackTrace();
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/usuarios/perfilLaboratorista.jsp");

        }
    }

}
