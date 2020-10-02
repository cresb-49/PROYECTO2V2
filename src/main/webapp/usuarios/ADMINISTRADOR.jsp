<%-- 
    Document   : ADMINISTRADOR
    Created on : 29/09/2020, 20:35:26
    Author     : carlo
--%>

<%@page import="com.mycompany.proyecto2v2.Objetos.usuarioSistema"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADMISTRADOR</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css"/>
        <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/comportamientoPerfiles.js" ></script>
    </head>
    <%
        usuarioSistema user = (usuarioSistema)session.getAttribute("USER");
        if(user != null){
            System.out.println("Seccion del sistema: "+user.toString());
        }
    %>
    <body>
        <header>
            <div class="container">
                <h1>HOSPITAL</h1>
                <h2>BIENVENIDO: ${USER.codigoEntidad}</h2>
            </div>
        </header>
        <div class="container">
            <ul class="nav nav-tabs nav-fill">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="true">Administrador</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ModificacionCreacion/editarAdmin.jsp">Editar</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ModificacionCreacion/crearAdmin.jsp">Crear</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="true">Doctores</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ModificacionCreacion/editarDoctor.jsp">Editar</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ModificacionCreacion/crearDoctor.jsp">Crear</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="true">Laboratorista</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ModificacionCreacion/editarLaboratorista.jsp">Editar</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ModificacionCreacion/crearLaboratorista.jsp">Crear</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="true">Examenes</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ModificacionCreacion/editarExamen.jsp">Editar</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ModificacionCreacion/crearExamen.jsp">Crear</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="true">Consultas</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ModificacionCreacion/modificarConsulta.jsp">Editar</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ModificacionCreacion/crearModificarConsulta.jsp">Crear</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="true">Pacientes</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ModificacionCreacion/editarPaciente.jsp">Editar</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ModificacionCreacion/crearPaciente.jsp">Crear</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ModificacionCreacion/cargarXML.jsp">Cargar XML</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="true">Reportes</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ReportesAdmin?reporte=1">Los 10 medicos con mas informes</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ReportesAdmin?reporte=2">Los 5 medicos con menor cantidad de citas</a>
                        <a class="dropdown-item" href="">Los examenes de laboratorio mas demandados en un intervalo de tiempo</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ReportesAdmin?reporte=4">Los medicos con mayor cantidad de examnes requeridos</a>
                        <a class="dropdown-item" href="">Los 3 examenes mas requeridos en un intervalo de tiempo</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">Cerrar sesion</a>
                </li>
            </ul>
        </div>
        <footer>
            <div class="container">
                <h3>© HOSPITAL 2020</h3>
            </div>
        </footer>
    </body>
</html>
