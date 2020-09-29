package com.mycompany.proyecto2v2.Servlets;

import com.mycompany.proyecto2v2.Objetos.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistroEntidades")
public class registroEntidades extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object entidad = null;
        String paginaOrigen=null;
        try {
            entidad = req.getAttribute("entidadRegistrar");
        } catch (Exception e) {
            //System.out.println("Error en el Servlet RegistroEntidades: "+e.getMessage());
        }
        if (entidad != null && paginaOrigen != null) {
            if(entidad instanceof Paciente){
                System.out.println(((Paciente)entidad).toString());
            }else if(entidad instanceof Doctor){
                System.out.println(((Doctor)entidad).toString());
            }else if(entidad instanceof Laboratorista){
                System.out.println(((Laboratorista)entidad).toString());
            }else if(entidad instanceof Admin){
                System.out.println(((Admin)entidad).toString());
            }else if(entidad instanceof Examen){
                System.out.println(((Examen)entidad).toString());
            }else{
                System.out.println(((Doctor)entidad).toString());
            }
        }else{
            System.out.println("Entidad: "+entidad.toString());
            System.out.println("Pagina: "+paginaOrigen);
        }

    }

}
