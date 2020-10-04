package com.mycompany.proyecto2v2.Servlets;

import com.mycompany.proyecto2v2.DBManage.ConnectionDB;
import com.mycompany.proyecto2v2.DBManage.ConsultasDB;
import com.mycompany.proyecto2v2.Objetos.Cita;
import com.mycompany.proyecto2v2.Objetos.Doctor;
import com.mycompany.proyecto2v2.Objetos.usuarioSistema;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RedactarReporte")
public class redactarReporte extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String codigoCita = req.getParameter("");

        try {
            ConnectionDB con = new ConnectionDB();
            ConsultasDB consulta = new ConsultasDB();
            consulta.setConexion(con.getConexion());
            String codigo = ((usuarioSistema) req.getSession().getAttribute("USER")).getCodigoEntidad();
            System.out.println("Codigo: " + codigo);
            Cita cita = consulta.retornarCita(codigoCita);
            Doctor doc = consulta.retornarDoctor(codigo);
            req.setAttribute("t1", doc.getInicio());
            req.setAttribute("t2", doc.getFin());
            req.setAttribute("citaOrigen", cita);
            req.getRequestDispatcher("/Medico/crearInforme.jsp").forward(req, resp);

            con.cerrarConexion();
        } catch (Exception e) {
        }
    }

}
