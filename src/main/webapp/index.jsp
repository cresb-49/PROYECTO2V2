<%@page import="java.sql.Connection"%>
<%@page import="com.mycompany.proyecto2v2.DBManage.ConsultasDB"%>
<%@page import="com.mycompany.proyecto2v2.DBManage.ConnectionDB"%>
<%@page import="com.mycompany.proyecto2v2.LecturaXML.lecturaXML"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hospital</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/estilos.css"/>
    </head>

    <body>
        <%
            try {
                session.removeAttribute("USER");
            } catch (Exception e) {
                System.out.println("Eliminar seccion: "+e.getMessage());
            }
            ConsultasDB consultas = new ConsultasDB();
            boolean resultado = false;
            try {
                ConnectionDB cnx = new ConnectionDB();
                consultas = new ConsultasDB();
                consultas.setConexion(cnx.getConexion());
                resultado = consultas.comprobarInformacion();
                cnx.cerrarConexion();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        %>
        <header>
            <div class="container">
                <h1>HOSPITAL</h1>
            </div>
        </header>

        <div class="container">
            <section class="main row">
                <article class="col-md-4">
                    <br>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                    </p>
                </article>

                <div class="container col-md-4">
                    <br>
                    <%
                        String error = request.getParameter("errorInicio");
                        if (error != null) {
                    %>
                    <div class="container alert alert-danger">
                        <%
                            out.write(error);
                        %>
                    </div>
                    <%
                        }
                        if (resultado) {
                    %>
                    <form action="Login" method="POST">
                        <h2>Inicio sesion</h2>
                        <div class="form-group">
                            <label for="usuario">Usuario:</label>
                            <input class="form-control" id="usuario" type="text" name="usuario">
                        </div>
                        <div class="form-group">
                            <label for="password">Password:</label>
                            <input class="form-control" id="password" type="password" name="password">
                        </div>
                        <div class="form-group">
                            <button class="btn btn-success" type="submit" name="enviar" value="Ingresar">Ingresar</button>
                            <a class="btn btn-primary" name="resgistrar" href="ManejoDeCuentas/registrarPaciente.jsp">Registrare</a>
                        </div>
                    </form>
                    <%
                    } else {
                    %>
                    <h2>NO HAY DATOS EN EL SISTEMA DEBE CARGARLOS</h2>
                    <form action="cargarArchivos/cargarArchivos.jsp" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <input class="form-control-file" type="file" multiple="multiple" name="selecFile"/>
                        </div>
                        <div class="form-group">
                            <input class="btn btn-success" type="submit" value="Cargar Archivo"/>
                        </div>
                    </form>

                    <%
                        }
                    %>
                </div>

            </section>
        </div>

        <footer>
            <div class="container">
                <h3>© HOSPITAL 2020</h3>
            </div>
        </footer>
        <script src="js/jquery-3.5.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
