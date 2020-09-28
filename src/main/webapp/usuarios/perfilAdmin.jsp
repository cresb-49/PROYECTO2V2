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
                    <a class="nav-link" href="/PROYECTO2/Reportes/reportesAdmin.jsp">Reportes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/PROYECTO2/index.jsp">Cerrar sesion</a>
                </li>
            </ul>
        </div>
        
        <section style="display: block" id="areaEditarDoc">
            <div class="container">
                <br>
                <h3>Buscar Doctor:</h3>
            </div>
            <div class="container">
                <br>
                <form class="form-inline" action="#">
                    <label class="control-label col-md-2" for="codeDoctor">Codigo Doctor: </label>
                    <div class="form-group">
                        <input class="form-control" id="codeDoctor" type="text" name="codeDoctorText" placeholder="codigo doctor">
                    </div>
                    <div class="form-group col-md-2">
                        <button class="btn btn-primary" type="submit" name="buscar" >Buscar</button>
                    </div>
                </form>
            </div>
            <div class="container">
                <br>
                <h3>Atributos:</h3>
            </div>

            <div class="container">
                <br>
                <section class="row">
                    <!--Primera columna del formulario-->
                    <div class="container col-md-6">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label for="codeDoctor" class="control-label">Codigo Doctor: </label>
                                <div class="">
                                    <input class="form-control" id="codeDoctor" type="text" name="codeDoctorText" placeholder="codigo doctor">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="coleDoctor">No. Colegiado: </label>
                                <div class="">
                                    <input class="form-control" id="coleDoctor" type="text" name="coleDoctorText" placeholder="No. Colegiado">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="telDoctor">Telefono: </label>
                                <div class="">
                                    <input class="form-control" id="telDoctor" type="text" name="telDoctorText" placeholder="Telefono">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="emailDoctor">Correo: </label>
                                <div class="">
                                    <input class="form-control" id="emailDoctor" type="text" name="emailDoctorText" placeholder="Correo Electronico">
                                </div>
                            </div>
                            <div class="container" >
                                <div class="form-group">
                                    <button class="btn btn-danger" type="submit" name="modificar" value="Ingresar">Modificar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <!--Segunda Columna del formulario-->
                    <div class="container col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="nameDoctor">Nombre Doctor: </label>
                            <div class="">
                                <input class="form-control" id="nameDoctor" type="text" name="nameDoctorText" placeholder="Nombre doctor">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="DPIDoctor">DPI: </label>
                            <div class="">
                                <input class="form-control" id="DPIDoctor" type="text" name="DPIDoctorText" placeholder="DPI">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="espeDoctor">Especialidad: </label><br>
                            <select class="form-control" name="Especialidad" id="espeDoctor">                            

                            </select>
                        </div>
                        <div class="form-group">
                            <label class="control-label">Horario:</label>
                            <div class="form-inline">
                                <label for="inicioDoctor">Inicio: </label>
                                <div class="">
                                    <input class="form-control" id="inicioDoctor" type="text" name="inicioDoctorText" placeholder="HH:mm">
                                </div>
                                <label for="finDoctor">Fin: </label>
                                <div class="">
                                    <input class="form-control" id="finDoctor" type="text" name="finDoctorText" placeholder="HH:mm">
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </section>
        
        <%
           String opcion =request.getParameter("opcion");
           System.out.println(opcion);
           if(opcion!=null){
               switch(opcion){
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
                   default :
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
