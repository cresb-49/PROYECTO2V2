package com.mycompany.proyecto2v2.Servlets;

import com.mycompany.proyecto2v2.DBManage.ConnectionDB;
import com.mycompany.proyecto2v2.DBManage.ConsultasDB;
import com.mycompany.proyecto2v2.Objetos.usuarioSistema;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class logIn extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usuario = req.getParameter("usuario");
        String password = req.getParameter("password");

        if (usuario != null && password != null) {
            ConnectionDB cnx = null;
            ConsultasDB consulta = null;
            try {
                cnx = new ConnectionDB();
                consulta = new ConsultasDB();
                consulta.setConexion(cnx.getConexion());
            } catch (Exception e) {
                resp.sendRedirect("/proyecto2v2/index.jsp?errorInicio=" + e.getMessage());
            }
            if (cnx != null && consulta != null) {
                usuarioSistema user = consulta.accesoUsuario(usuario, password);
                try {
                    String rol = user.getRol();
                    System.out.println("Usuario: " + user.toString());
                    if (rol.equals("admin")) {
                        usuarioSistema temp;
                        temp = user;
                        temp = consulta.retornoCodigoDependiente(user);
                        HttpSession session = req.getSession();
                        session.setAttribute("USER", temp);
                        resp.sendRedirect("/proyecto2v2/usuarios/ADMINISTRADOR.jsp");
                    }
                    if (rol.equals("doctor")) {
                        usuarioSistema temp;
                        temp = user;
                        temp = consulta.retornoCodigoDependiente(user);
                        HttpSession session = req.getSession();
                        session.setAttribute("USER", temp);
                        resp.sendRedirect("/proyecto2v2/usuarios/perfilDoctor.jsp");
                    }
                    if (rol.equals("laboratorista")) {
                        usuarioSistema temp;
                        temp = user;
                        temp = consulta.retornoCodigoDependiente(user);
                        HttpSession session = req.getSession();
                        session.setAttribute("USER", temp);
                        resp.sendRedirect("/proyecto2v2/usuarios/perfilLaboratorista.jsp");
                    }
                    if (rol.equals("paciente")) {
                        usuarioSistema temp;
                        temp = user;
                        temp = consulta.retornoCodigoDependiente(user);
                        HttpSession session = req.getSession();
                        session.setAttribute("USER", temp);
                        resp.sendRedirect("/proyecto2v2/usuarios/perfilPaciente.jsp");
                    }
                } catch (Exception e) {
                    System.out.println("com.mycompany.proyecto2v2.Servlets.logIn.doPost() "+ e.getMessage());
                    e.printStackTrace();
                    resp.sendRedirect("/proyecto2v2/index.jsp?errorInicio=El usuario y la password no coinciden");
                }
                cnx.cerrarConexion();
            }
            cnx.cerrarConexion();
        } else {
            resp.sendRedirect("/proyecto2v2/index.jsp?errorInicio=Debe de introducir las credenciales");
        }
    }

}
