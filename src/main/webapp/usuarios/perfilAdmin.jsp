<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADMIN</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="stylesheet" href="../css/bootstrap.min.css"/>
        <link rel="stylesheet" href="../css/estilos.css"/>
    </head>
    <body >
        <header>
            <div class="container">
                <h1>HOSPITAL</h1>
                <h2>BIENVENIDO A SU PERFIL DE USUARIO</h2>
            </div>
        </header>
        <div class="container">
            <ul class="nav nav-tabs nav-fill">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="true">Doctores</a>
                    <div class="dropdown-menu">
                        <button class="btn dropdown-item" onclick="mostrarEditDoc();">Editar</button>
                        <a class="dropdown-item" href="?opcion=D2">Crear</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="true">Laboratorista</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="?opcion=L1">Editar</a>
                        <a class="dropdown-item" href="?opcion=L2">Crear</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="true">Examenes</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="?opcion=E1">Editar</a>
                        <a class="dropdown-item" href="?opcion=E2">Crear</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="true">Consultas</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="?opcion=C1">Editar</a>
                        <a class="dropdown-item" href="?opcion=C2">Crear</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="true">Pacientes</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="?opcion=P1">Editar</a>
                        <a class="dropdown-item" href="?opcion=P2">Crear</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Cargar XML</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../Reportes/reportesAdmin.jsp">Reportes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../index.jsp">Cerrar sesion</a>
                </li>
            </ul>
        </div>


        <%
            String opcion = request.getParameter("opcion");
            System.out.println(opcion);
            if (opcion != null) {
                switch (opcion) {
                    case "D1":
        %>


        <%
                break;
            case "D2":
        %>

        <%
                break;
            case "L1":
        %>

        <%
                break;
            case "L2":
        %>

        <%
                break;
            case "E1":
        %>

        <%
                break;
            case "E2":
        %>

        <%
                break;
            case "C1":
        %>

        <%
                break;
            case "C2":
        %>

        <%
                break;
            case "P1":
        %>

        <%
                break;
            case "P2":
        %>

        <%
                break;
            default:
        %>

        <%
                        break;
                }
            }
        %>

        <footer>
            <div class="container">
                <h3>© HOSPITAL 2020</h3>
            </div>
        </footer>
        <script src="../js/app.js"></script>
        <script src="../js/jquery-3.5.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="../js/bootstrap.min.js"></script>
    </body>
</html>
