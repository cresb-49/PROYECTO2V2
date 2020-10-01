<%-- 
    Document   : modificarConsulta
    Created on : 29/09/2020, 19:53:31
    Author     : carlo
--%>

<%@page import="com.mycompany.proyecto2v2.DBManage.ModificacionDB"%>
<%@page import="com.mycompany.proyecto2v2.Conversiones.ConvercionesVariables"%>
<%@page import="com.mycompany.proyecto2v2.DBManage.ConsultasDB"%>
<%@page import="com.mycompany.proyecto2v2.DBManage.ConnectionDB"%>
<%@page import="com.mycompany.proyecto2v2.Objetos.Consulta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MODIFICAR CONSULTA</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="stylesheet" href="../css/bootstrap.min.css"/>
        <link rel="stylesheet" href="../css/estilos.css"/>
    </head>
    <body>
        <header>
            <div class="container">
                <h1>HOSPITAL</h1>
                <h5>MODIFICAR TIPO DE CONSULTA</h5>
                <br/>
            </div>
        </header>
        <div class="container">
            <div class="container">
                <br>
                <h3>MODIFICACION CONSULTA</h3>
            </div>
            <div class="container">
                <div class="container">
                    <br>
                    <h3>BUSCAR CONSULTA</h3>
                </div>
                <br>
                <form class="form-inline" action="" method="POST">
                    <label class="control-label col-md-2" for="nombreConsultaBusqueda">Nombre Consulta: </label>
                    <div class="form-group">
                        <input class="form-control" id="nombreConsultaBusqueda" type="text" name="nombreConsultaBusqueda" placeholder="Nombre Consulta">
                    </div>
                    <div class="form-group col-md-2">
                        <button class="btn btn-primary" type="submit" name="buscar" >Buscar</button>
                    </div>
                </form>
                <br/>
                <%
                    String nombreConsulta = request.getParameter("nombreConsultaBusqueda");
                    Consulta modConsulta = null;
                    if (nombreConsulta != null || nombreConsulta != "") {
                        ConnectionDB cnx = new ConnectionDB();
                        ConsultasDB consulta = new ConsultasDB();
                        consulta.setConexion(cnx.getConexion());
                        modConsulta = consulta.obtenerConsulta(nombreConsulta);
                        if (modConsulta.getCodigo() != null) {
                            System.out.println("Consulta rescatada: " + modConsulta.toString());
                            session.setAttribute("MODCON", modConsulta);
                        } else {
                %>
                <div class="alert alert-danger" role="alert">
                    No hay ningun resultado de la busqueda
                </div>
                <%
                    }
                } else {
                %>
                <div class="alert alert-danger" role="alert">
                    Debe de introducir un codigo para la busqueda
                </div>
                <%
                    }
                %>
            </div>
            <form class="container form-group" action="" onsubmit="return validarRegistroconsulta();" method="POST" >
                <div class="container">
                    <br>
                    <h3>Datos de la consulta</h3>
                    <br/>
                </div>
                <div class="form-row form-group">
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label for="nombreConsulta" class="control-label">Nombre Consulta: </label>
                            <div class="">
                                <%
                                    if (modConsulta.getTipo() != null) {
                                %>
                                <input class="form-control" id="nombreConsulta" type="text" name="nombreConsulta" placeholder="Nombre Consulta" value="<%out.print(modConsulta.getTipo());%>">
                                <%
                                } else {
                                %>
                                <input class="form-control" id="nombreConsulta" type="text" name="nombreConsulta" placeholder="Nombre Consulta">
                                <%
                                    }
                                %>
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-6">
                        <label for="costoConsulta" class="control-label">Costo Consulta: </label>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Q</span>
                                <span class="input-group-text">0.00</span>
                            </div>
                            <%
                                if (modConsulta.getCosto() != null) {
                            %>
                            <input type="text" class="form-control" id="costoConsulta" name="costoConsulta" value="<%out.print(modConsulta.getCosto());%>">
                            <%
                            } else {
                            %>
                            <input type="text" class="form-control" id="costoConsulta" name="costoConsulta">
                            <%
                                }
                            %>
                        </div>
                    </div>
                    <div class="container form-group col-md-12">
                        <div class="container" >
                            <div class="form-group">
                                <button class="btn btn-danger" type="submit" name="modificar" value="Ingresar">Modificar Consulta</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
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
<%
    String nombreCon = request.getParameter("nombreConsulta");
    String costoCon = request.getParameter("costoConsulta");
    System.out.println("Nombre consulta: " + nombreCon);
    System.out.println("Nombre consulta: " + costoCon);
    if (nombreCon != null && costoCon != null) {
        ConvercionesVariables conv = new ConvercionesVariables();
        Consulta tempConsuta = (Consulta) session.getAttribute("MODCON");
        session.removeAttribute("MODCON");
        tempConsuta.setTipo(nombreCon);
        tempConsuta.setCosto(conv.stringToDouble(costoCon));
        System.out.println("Consulta: " + tempConsuta.toString());
        try {
            ConnectionDB conexion = new ConnectionDB();
            ModificacionDB modificacion = new ModificacionDB();
            modificacion.setConexion(conexion.getConexion());
            String respuesta = modificacion.modificarConsulta(tempConsuta);
            if (respuesta.equals("")) {
                request.getRequestDispatcher("../error.jsp?logroP=Se modifico con exito la consulta en el sistema").forward(request, response);
            } else {
                request.getRequestDispatcher("../error.jsp?errorP=" + respuesta).forward(request, response);
            }
        } catch (Exception e) {
            request.getRequestDispatcher("../error.jsp?errorP=" + e.getMessage()).forward(request, response);
        }
    }
%>