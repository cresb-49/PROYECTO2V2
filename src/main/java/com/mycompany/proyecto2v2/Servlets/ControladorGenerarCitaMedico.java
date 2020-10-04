package com.mycompany.proyecto2v2.Servlets;

import com.mycompany.proyecto2v2.Conversiones.ConvercionesVariables;
import com.mycompany.proyecto2v2.DBManage.ConnectionDB;
import com.mycompany.proyecto2v2.DBManage.ConsultasDB;
import com.mycompany.proyecto2v2.DBManage.RegistroDB;
import com.mycompany.proyecto2v2.Objetos.Cita;
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
        ConvercionesVariables conv = new ConvercionesVariables();
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
            if(codigoPaciente!=null&&fecha!=null&&hora!=null&&especialidad!=null){
                if(!codigoPaciente.isEmpty()&&!fecha.isEmpty()&&!hora.isEmpty() && !especialidad.isEmpty()){
                    Cita cita = new Cita(null, conv.stringToLong(codigoPaciente), codigoMedico, especialidad, conv.stringToDate(fecha), conv.stringToTime(hora));
                    System.out.println(cita.toString());
                    
                    String respuesta = registro.registroCita(cita, "nuevo");
                    
                    if(respuesta.equals("")){
                        System.out.println("Se registro con exito la cita en el sistema");
                        req.getRequestDispatcher("/Medico/errorCitaMedicaMedico.jsp?logroP=Se registro con exito la cita en el sistema").forward(req, resp);
                    }else{
                        System.out.println("Hubo error al momento de registrar la cita "+respuesta);
                        req.getRequestDispatcher("/Medico/errorCitaMedicaMedico.jsp?errorP="+respuesta).forward(req, resp);
                    }
                }else{
                    System.out.println("En parametro esta vacio");
                    req.getRequestDispatcher("/GenerarCitaMedico").forward(req, resp);
                }
            }else{
                System.out.println("Un parametro fue nulo");
                req.getRequestDispatcher("/GenerarCitaMedico").forward(req, resp);
            }
            con.cerrarConexion();
        } catch (Exception e) {
            req.getRequestDispatcher("/GenerarCitaMedico").forward(req, resp);
            System.out.println("Error en post controlador cita medico: "+e.getMessage());
            e.printStackTrace();
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
