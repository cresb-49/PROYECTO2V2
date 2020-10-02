
package com.mycompany.proyecto2v2.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Medico")
public class ControladorMedico extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reporte = req.getParameter("reporte");
        System.out.println("Tipo de reporte: "+reporte);
        if(reporte!= null || !reporte.isEmpty()){
            if(reporte.equals("2")){
                resp.sendRedirect(req.getContextPath()+"/reportesMedico/mayorCantidad.jsp");
            }
        }else{
            resp.sendRedirect(req.getContextPath()+"/usuarios/perfilDoctor.jsp");
        }
    }
    
}
