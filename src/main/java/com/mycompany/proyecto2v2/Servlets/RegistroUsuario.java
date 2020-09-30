/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2v2.Servlets;

import com.mycompany.proyecto2v2.Conversiones.ConvercionesVariables;
import com.mycompany.proyecto2v2.DBManage.*;
import com.mycompany.proyecto2v2.Objetos.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistroUsuario")
public class RegistroUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acction = req.getParameter("token");

        if (acction == null) {
            acction = "";
        }
        if (acction.equals("registarUsuario")) {
            try {
                ConvercionesVariables conv = new ConvercionesVariables();
                //GENERACION DEL OBJETO PACIENTE PARA LUEGO HACER SU REGISTRO
                Paciente nuevoPaciente = new Paciente(req.getParameter("nombrePaciente"),
                         req.getParameter("DPIPaciente"), req.getParameter("passPaciente"),
                         req.getParameter("telefonoPaciente"),
                         req.getParameter("correoPaciente"),
                         req.getParameter("sexoPaciente"),
                         conv.stringToDate(req.getParameter("fechaNacimiento")),
                         conv.stringToDouble(req.getParameter("pesoPaciente")),
                         req.getParameter("tipoSangre"));
                ConnectionDB cnx = new ConnectionDB();
                RegistroDB registro = new RegistroDB();
                registro.setConexion(cnx.getConexion());
                DuplicidadDB duplicidad = new DuplicidadDB();
                duplicidad.setConexion(cnx.getConexion());
                String resultado = "";
                if (!duplicidad.existenciaDeRegistroUsuario(nuevoPaciente.getEmail())) {
                    resultado = duplicidad.existenciaDePaciente(nuevoPaciente);
                    if (resultado.equals("")) {
                        registro.registroPaciente(nuevoPaciente, "nuevo");
                        registro.registroUsuario(nuevoPaciente, "nuevo");
                        resp.sendRedirect("/proyecto2v2/index.jsp");
                    } else {
                        req.setAttribute("nuevoPaciente", nuevoPaciente);
                        req.getRequestDispatcher("registrarUsuario.jsp?error=").forward(req, resp);
                    }
                } else {
                    resultado = "El correo ya esta registrado";
                    System.out.println(resultado);
                    req.setAttribute("nuevoPaciente", nuevoPaciente);
                    req.getRequestDispatcher("registrarUsuario.jsp?error=" + resultado).forward(req, resp);
                }
                cnx.cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error Servlet Registro: " + e.getMessage());
            }
        }
    }
}
