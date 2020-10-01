<%@page import="com.mycompany.proyecto2v2.Objetos.usuarioSistema"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DOCTOR</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="stylesheet" href="../css/bootstrap.min.css"/>
        <link rel="stylesheet" href="../css/estilos.css"/>
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
            </div>
        </header>
        <div class="container">
            <ul class="nav nav-tabs nav-fill">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="true">Consultar Historial Paciente</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#">Paciente en Especifico</a>
                        <a class="dropdown-item" href="../reportesMedico/mayorCantidad.jsp">Pacientes en General</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="true">Citas Agendadas</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#">Consultar</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="true">Generar Reporte de Cita</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#">Redactar</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../index.jsp">Cerrar sesion</a>
                </li>
            </ul>
        </div>
        <%
            
        %>
        
        <footer>
            <div class="container">
                <h3>© HOSPITAL 2020</h3>
            </div>
        </footer>
        <script src="../js/jquery-3.5.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/comportamientoPerfiles.js" ></script>
    </body>
</html>
