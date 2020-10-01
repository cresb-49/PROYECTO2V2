<%-- 
    Document   : crearConsulta
    Created on : 28/09/2020, 14:17:06
    Author     : carlo
--%>

<%@page import="com.mycompany.proyecto2v2.DBManage.RegistroDB"%>
<%@page import="com.mycompany.proyecto2v2.DBManage.ConnectionDB"%>
<%@page import="com.mycompany.proyecto2v2.DBManage.ConnectionDB"%>
<%@page import="com.mycompany.proyecto2v2.Conversiones.ConvercionesVariables"%>
<%@page import="com.mycompany.proyecto2v2.Objetos.Consulta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CREAR/MODIFICAR CONSULTA</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="stylesheet" href="../css/bootstrap.min.css"/>
        <link rel="stylesheet" href="../css/estilos.css"/>
    </head>
    <body>
        <header>
            <div class="container">
                <h1>HOSPITAL</h1>
                <h5>REGISTRAR TIPO DE CONSULTA</h5>
                <br/>
            </div>
        </header>
        <div class="container">
            <div class="container">
                <br>
                <h3>REGISTRO CONSULTA</h3>
            </div>
            <br>
            <form class="container form-group" action="" onsubmit="return validarRegistroconsulta();" method="POST" >
                <div class="form-row form-group">
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label for="nombreConsulta" class="control-label">Nombre Consulta: </label>
                            <div class="">
                                <input class="form-control" id="nombreConsulta" type="text" name="nombreConsulta" placeholder="Nombre Consulta">
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
                            <input type="text" class="form-control" id="costoConsulta" name="costoConsulta">
                        </div>
                    </div>
                    <div class="container form-group col-md-12">
                        <div class="container" >
                            <div class="form-group">
                                <button class="btn btn-success" type="submit" name="modificar" value="Ingresar">Registrar Consulta</button>
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
    String nombre = request.getParameter("nombreConsulta");
    String costo = request.getParameter("costoConsulta");
    if (nombre != null) {
        ConvercionesVariables conv = new ConvercionesVariables();
        Consulta nuevaConsulta = new Consulta();
        ////ASIGNACION DE ATRIBUTOS
        nuevaConsulta.setTipo(nombre);
        nuevaConsulta.setCosto(conv.stringToDouble(costo));
        ////FIN DE ASIGNACION DE ATRIBUTOS
        try {
            //VARIBLES DE CONEXION A BASE DE DATOS
            ConnectionDB cnx = new ConnectionDB();
            RegistroDB registro = new RegistroDB();
            registro.setConexion(cnx.getConexion());
            //EVALUACION DE LA RESPUESTA OBTENIDA POR EL REGISTRO EN LA BASE DE DATOS
            String respuesta = registro.registroConsulta(nuevaConsulta);
            if (respuesta.equals("")) {
                request.getRequestDispatcher("../error.jsp?logroP=Se registro con exito la consulta en el sistema").forward(request, response);
            } else {
                request.getRequestDispatcher("../error.jsp?errorP=" + respuesta).forward(request, response);
            }
            cnx.cerrarConexion();
        } catch (Exception e) {
            request.getRequestDispatcher("../error.jsp?errorP=" + e.getMessage()).forward(request, response);
        }
    }
%>
