package com.mycompany.proyecto2v2.Servlets;

import com.mycompany.proyecto2v2.Conversiones.ConvercionesVariables;
import com.mycompany.proyecto2v2.DBManage.ConnectionDB;
import com.mycompany.proyecto2v2.DBManage.ConsultasDB;
import com.mycompany.proyecto2v2.DBManage.RegistroDB;
import com.mycompany.proyecto2v2.Objetos.Cita;
import com.mycompany.proyecto2v2.Objetos.Doctor;
import com.mycompany.proyecto2v2.Objetos.Reporte;
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
        ConvercionesVariables conv = new ConvercionesVariables();
        String codigoPaciente = req.getParameter("codePaciente");
        String fecha = req.getParameter("fechaCita");
        String hora = req.getParameter("horaCita");
        String informe = req.getParameter("informe");

        try {
            ConnectionDB con = new ConnectionDB();
            RegistroDB registro = new RegistroDB();
            registro.setConexion(con.getConexion());
            if (codigoPaciente != null && fecha != null && hora != null && informe != null) {
                if (!codigoPaciente.isEmpty() && !fecha.isEmpty() && !hora.isEmpty() && !informe.isEmpty()) {
                    String codigoMedico = ((usuarioSistema) req.getSession().getAttribute("USER")).getCodigoEntidad();
                    System.out.println("Codigo Entidad: " + codigoMedico);
                    
                    Reporte reporte = new Reporte();
                    reporte.setCodigoMedico(codigoMedico);
                    reporte.setCodigoPaciente(conv.stringToLong(codigoPaciente));
                    reporte.setFecha(conv.stringToDate(fecha));
                    reporte.setHora(conv.stringToTime(hora));
                    reporte.setInformeMedico(informe);
                    
                    String respuesta = registro.registroReporte(reporte, "nuevo");
                    
                    if(respuesta.equals("")){
                        req.getRequestDispatcher("/Medico/errorReporte.jsp?logroP=Se registro con exito su informe en el sistema").forward(req, resp);
                    }else{
                        req.getRequestDispatcher("/Medico/errorReporte.jsp?errorP="+respuesta).forward(req, resp);
                    }
                } else {
                    System.out.println("Un valor estaba vacio");
                    req.getRequestDispatcher("/Medico/errorReporte.jsp?errorP=La integridad de la informacion fue perdida").forward(req, resp);
                }
            } else {
                System.out.println("Un valor llego con valor nulo");
                req.getRequestDispatcher("/Medico/errorReporte.jsp?errorP=La integridad de la informacion fue perdida").forward(req, resp);
            }
        } catch (Exception e) {
            System.out.println("Un valor llego con valor nulo" +e.getMessage());
            req.getRequestDispatcher("/Medico/errorReporte.jsp?errorP=La integridad de la informacion fue perdida").forward(req, resp);
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String codigoCita = req.getParameter("citaCodigo");

        try {
            ConnectionDB con = new ConnectionDB();
            ConsultasDB consulta = new ConsultasDB();
            consulta.setConexion(con.getConexion());
            String codigo = ((usuarioSistema) req.getSession().getAttribute("USER")).getCodigoEntidad();
            System.out.println("Codigo: " + codigo);
            Doctor doc = consulta.retornarDoctor(codigo);
            Cita cita = consulta.retornarCita(codigoCita);
            System.out.println(cita.toString());

            req.setAttribute("t1", doc.getInicio());
            req.setAttribute("t2", doc.getFin());
            req.setAttribute("citaOrigen", cita);
            req.getRequestDispatcher("/Medico/crearInforme.jsp").forward(req, resp);

            con.cerrarConexion();
        } catch (Exception e) {
        }
    }

}
