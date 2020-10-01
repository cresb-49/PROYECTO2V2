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
        ConvercionesVariables conv = new ConvercionesVariables();
        //GENERACION DEL OBJETO PACIENTE PARA LUEGO HACER SU REGISTRO
        String nombre = req.getParameter("nombrePaciente");
        String DPI = req.getParameter("DPIPaciente");
        String password = req.getParameter("passPaciente");
        String telefono = req.getParameter("telefonoPaciente");
        String correo = req.getParameter("correoPaciente");
        String sexo = req.getParameter("sexoPaciente");
        String fechaNacimiento = req.getParameter("fechaNacimiento");
        String peso = req.getParameter("pesoPaciente");
        String sangre = req.getParameter("tipoSangre");
        if (nombre != null) {
            ////ASIGNACION DE ATRIBUTOS
            Paciente nuevoPaciente = new Paciente(nombre, DPI, password, telefono, correo, sexo, conv.stringToDate(fechaNacimiento), conv.stringToDouble(peso), sangre);
            ////FIN DE ASIGNACION DE ATRIBUTOS
            try {
                //VARIBLES DE CONEXION A BASE DE DATOS
                ConnectionDB cnx = new ConnectionDB();
                RegistroDB registro = new RegistroDB();
                registro.setConexion(cnx.getConexion());
                //EVALUACION DE LA RESPUESTA OBTENIDA POR EL REGISTRO EN LA BASE DE DATOS
                String respuesta = registro.registroUsuario(nuevoPaciente, "nuevo");
                if (respuesta.equals("")) {
                    respuesta = registro.registroPaciente(nuevoPaciente, "nuevo");
                    if (respuesta.equals("")) {
                        resp.sendRedirect("error.jsp?logroP=Se registro con exito el paciente en el sistema");
                    } else {
                        resp.sendRedirect("error.jsp?errorP=" + respuesta);
                    }
                } else {
                    resp.sendRedirect("error.jsp?errorP=" + respuesta);
                }
                cnx.cerrarConexion();
            } catch (Exception e) {
                resp.sendRedirect("error.jsp?errorP=" + e.getMessage());
            }
        }
    }
}
