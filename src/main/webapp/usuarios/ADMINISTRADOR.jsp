<%-- 
    Document   : ADMINISTRADOR
    Created on : 29/09/2020, 20:35:26
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADMISTRADOR</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="stylesheet" href="../css/bootstrap.min.css"/>
        <link rel="stylesheet" href="../css/estilos.css"/>
    </head>
    <body>
        <header>
            <div class="container">
                <h1>HOSPITAL</h1>
            </div>
        </header>
        <div class="container">
            <ul class="nav nav-tabs nav-fill">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="true">Administrador</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="../ModificacionCreacion/editarAdmin.jsp">Editar</a>
                        <a class="dropdown-item" href="../ModificacionCreacion/crearAdmin.jsp">Crear</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="true">Doctores</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="../ModificacionCreacion/editarDoctor.jsp">Editar</a>
                        <a class="dropdown-item" href="../ModificacionCreacion/crearDoctor.jsp">Crear</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="true">Laboratorista</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="../ModificacionCreacion/editarLaboratorista.jsp">Editar</a>
                        <a class="dropdown-item" href="../ModificacionCreacion/crearLaboratorista.jsp">Crear</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="true">Examenes</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="../ModificacionCreacion/editarExamen.jsp">Editar</a>
                        <a class="dropdown-item" href="../ModificacionCreacion/crearExamen.jsp">Crear</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="true">Consultas</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="../ModificacionCreacion/modificarConsulta.jsp">Editar</a>
                        <a class="dropdown-item" href="../ModificacionCreacion/crearModificarConsulta.jsp">Crear</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="true">Pacientes</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="../ModificacionCreacion/editarPaciente.jsp">Editar</a>
                        <a class="dropdown-item" href="../ModificacionCreacion/crearPaciente.jsp">Crear</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../ModificacionCreacion/cargarXML.jsp">Cargar XML</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../Reportes/reportesAdmin.jsp">Reportes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../index.jsp">Cerrar sesion</a>
                </li>
            </ul>
        </div>
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
