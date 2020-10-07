/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2v2.Servlets;

import com.mycompany.proyecto2v2.DBManage.ConnectionDB;
import com.mycompany.proyecto2v2.DBManage.ConsultasDB;
import com.mycompany.proyecto2v2.Objetos.Archivo;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

/**
 *
 * @author carlo
 */
@WebServlet("/descargarArchivo")
public class Descargar extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orden = req.getParameter("archivo");
        String idArchivo = req.getParameter("id");
        
        System.out.println("Orden: "+orden+" ,id: "+idArchivo);
        try {
            ConnectionDB con = new ConnectionDB();
            ConsultasDB consulta = new ConsultasDB();
            consulta.setConexion(con.getConexion());
            
            if(orden.equals("resultado")){
                Archivo tmp = consulta.retornarDocResultado(idArchivo);
                System.out.println("Arhivo recuperado: "+tmp.toString());
                InputStream arch = new ByteArrayInputStream(tmp.getDatos().readAllBytes());
                int tm = arch.available();
                byte[] datos = new byte[tm];
                arch.read(datos,0,tm);
                resp.getOutputStream().write(datos);
                arch.close();
            }
            if(orden.equals("orden")){
                Archivo tmp = consulta.retornarOrdenExamen(idArchivo);
                System.out.println("Arhivo recuperado: "+tmp.toString());
                InputStream arch = new ByteArrayInputStream(tmp.getDatos().readAllBytes());
                int tm = arch.available();
                byte[] datos = new byte[tm];
                arch.read(datos,0,tm);
                resp.getOutputStream().write(datos);
                arch.close();
            }
            if(orden.equals("orden2")){
                Archivo tmp = consulta.retornarOrdenResultado(idArchivo);
                System.out.println("Arhivo recuperado: "+tmp.toString());
                InputStream arch = new ByteArrayInputStream(tmp.getDatos().readAllBytes());
                int tm = arch.available();
                byte[] datos = new byte[tm];
                arch.read(datos,0,tm);
                resp.getOutputStream().write(datos);
                arch.close();
            }
            con.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Error en descarga de archivo: "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void envioInformacion(HttpServletRequest req, HttpServletResponse resap,Archivo archivo){
        
    }
    
    
    
}
