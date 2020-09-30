<%-- 
    Document   : crearExamen
    Created on : 28/09/2020, 14:09:56
    Author     : carlo
--%>
<%@page import="com.mycompany.proyecto2v2.DBManage.RegistroDB"%>
<%@page import="com.mycompany.proyecto2v2.DBManage.ConnectionDB"%>
<%@page import="com.mycompany.proyecto2v2.Conversiones.ConvercionesVariables"%>
<%@page import="com.mycompany.proyecto2v2.Objetos.Examen"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Examen</title>
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
            <div class="container">
                <br>
                <h3>REGISTRO DE EXAMEN</h3>
            </div>
            <br>
            <form class="container form-group" action="" onsubmit="return validarRegistroExamen();" method="POST" >
                <div class="form-row form-group">
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label for="codigoExamen" class="control-label">Codigo Examen: </label>
                            <div class="">
                                <input class="form-control" id="codigoExamen" type="text" name="codigoExamen" placeholder="Codigo Examen">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="nombreExamen">Nombre Examen: </label>
                            <div class="">
                                <input class="form-control" id="nombreExamen" type="text" name="nombreExamen" placeholder="Nombre Examen">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="ordenExamen">Orden: </label>
                            <div class="">
                                <select class="form-control" name="ordenExamen" id="ordenExamen">
                                    <option value="Seleccionar" selected>Seleccionar</option>
                                    <option value="TRUE">TRUE</option>
                                    <option value="FALSE">FALSE</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label for="costoExamen" class="control-label">Costo Examen: </label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">Q</span>
                                    <span class="input-group-text">0.00</span>
                                </div>
                                <input type="text" class="form-control" id="costoExamen" name="costoExamen">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="informeExamen">Informe: </label>
                            <div class="">
                                <select class="form-control" name="informeExamen" id="informeExamen">
                                    <option value="Seleccionar" selected>Seleccionar</option>
                                    <option value="PDF">PDF</option>
                                    <option value="IMG">IMG</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-12">
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">Descripcion</span>
                                </div>
                                <textarea class="form-control" id="descripcionExamen" name="descripcionExamen"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-12">
                        <div class="container" >
                            <div class="form-group">
                                <button class="btn btn-success" type="submit" name="modificar" value="Ingresar">Registrar Examen</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>

        <%
            String codigo = request.getParameter("codigoExamen");
            String nombre = request.getParameter("nombreExamen");
            String orden = request.getParameter("ordenExamen");
            String descripcion = request.getParameter("descripcionExamen");
            String costo = request.getParameter("costoExamen");
            String informe = request.getParameter("informeExamen");

            if (nombre != null) {
                ConvercionesVariables conv = new ConvercionesVariables();
                Examen nuevoExamen = new Examen();
                ////ASIGNACION DE ATRIBUTOS
                nuevoExamen.setCodigo(conv.stringToLong(codigo));
                nuevoExamen.setNombre(nombre);
                nuevoExamen.setOrden(conv.stringToBoolean(orden));
                nuevoExamen.setDescripcion(descripcion);
                nuevoExamen.setCosto(conv.stringToDouble(costo));
                nuevoExamen.setInforme(informe);
                ////FIN DE ASIGNACION DE ATRIBUTOS
                try {
                    //VARIBLES DE CONEXION A BASE DE DATOS
                    ConnectionDB cnx = new ConnectionDB();
                    RegistroDB registro = new RegistroDB();
                    registro.setConexion(cnx.getConexion());
                    //EVALUACION DE LA RESPUESTA OBTENIDA POR EL REGISTRO EN LA BASE DE DATOS
                    String respuesta = registro.registroExamen(nuevoExamen,"nuevo");
                    if(respuesta.equals("")){
                        request.getRequestDispatcher("../error.jsp?logroP=Se registro con exito el examen en el sistema").forward(request, response);
                    }else{
                        request.getRequestDispatcher("../error.jsp?errorP=" + respuesta).forward(request, response);
                    }
                    cnx.cerrarConexion();
                } catch (Exception e) {
                    request.getRequestDispatcher("../error.jsp?errorP=" + e.getMessage()).forward(request, response);
                }
            }
        %>
        <footer>
            <div class="container">
                <h3>© HOSPITAL 2020</h3>
            </div>
        </footer>
        <script src="../js/app.js"/>
        <script src="../js/jquery-3.5.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="../js/bootstrap.min.js"></script>
    </body>
</html>
