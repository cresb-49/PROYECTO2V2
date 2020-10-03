package com.mycompany.proyecto2v2.Servlets;

import com.mycompany.proyecto2v2.DBManage.ConnectionDB;
import com.mycompany.proyecto2v2.DBManage.ConsultasDB;
import com.mycompany.proyecto2v2.DBManage.RegistroDB;
import com.mycompany.proyecto2v2.Objetos.Doctor;
import com.mycompany.proyecto2v2.Objetos.usuarioSistema;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GenerarCitaMedico")
public class ControladorGenerarCitaMedico extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String codigoMedico = ((usuarioSistema) req.getSession().getAttribute("USER")).getCodigoEntidad();
        System.out.println("Codigo Medico: " + codigoMedico);
        String codigoPaciente = req.getParameter("codePaciente");
        String fecha = req.getParameter("fechaCita");
        String hora = req.getParameter("horaCita");
        String especialidad = req.getParameter("especialidad");
        
        try {
            ConnectionDB con = new ConnectionDB();
            ConsultasDB consultas = new ConsultasDB();
            RegistroDB registro = new RegistroDB();
            registro.setConexion(con.getConexion());
            consultas.setConexion(con.getConexion());
            
            
            
            con.cerrarConexion();
        } catch (Exception e) {
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String codigoMedico = ((usuarioSistema) req.getSession().getAttribute("USER")).getCodigoEntidad();
        System.out.println("Codigo Medico: " + codigoMedico);
        try {
            ConnectionDB con = new ConnectionDB();
            ConsultasDB consultas = new ConsultasDB();
            consultas.setConexion(con.getConexion());
            
            List<String> especialidades = consultas.obtenerEspecialidades(codigoMedico);
            Doctor doc = consultas.retornarDoctor(codigoMedico);
            java.time.LocalDate today = java.time.LocalDate.now();
            
            req.setAttribute("especilidades",especialidades);
            req.setAttribute("t1",doc.getInicio());
            req.setAttribute("t2",doc.getFin());
            req.setAttribute("fecha", today);
            
            
            
            
            req.getRequestDispatcher("/Medico/agendarCitaMedica.jsp").forward(req, resp);
            
            
            
            
            
            con.cerrarConexion();
        } catch (Exception e) {
            req.getRequestDispatcher("/usuarios/perfilDoctor.jsp").forward(req, resp);
            System.out.println("error en controlador de citas por medico "+e.getMessage());
            e.printStackTrace();
        }
        
        
        
        
    }

}
