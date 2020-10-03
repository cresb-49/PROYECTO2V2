package com.mycompany.proyecto2v2.Servlets;

import com.mycompany.proyecto2v2.DBManage.ConnectionDB;
import com.mycompany.proyecto2v2.DBManage.ConsultasDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProcesarExamen")
@MultipartConfig(maxFileSize = 16177215)
public class ProcesadoExamen extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String codigoSolicitud = req.getParameter("codigoSolicitud");

        try {
            ConnectionDB con = new ConnectionDB();
            ConsultasDB consultas = new ConsultasDB();
            consultas.setConexion(con.getConexion());
            if (codigoSolicitud != null) {
                if (!codigoSolicitud.isEmpty()) {

                } else {
                    resp.sendRedirect(req.getContextPath() + "/Lab/examenesProcesar.jsp");
                }
            } else {
                resp.sendRedirect(req.getContextPath() + "/Lab/examenesProcesar.jsp");
            }

        } catch (Exception e) {
        }

    }

}
