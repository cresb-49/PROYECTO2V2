<%--    
    Document   : crearLaboratorista
    Created on : 28/09/2020, 14:13:46
    Author     : carlo
--%>
<%@page import="com.mycompany.proyecto2v2.DBManage.*"%>
<%@page import="com.mycompany.proyecto2v2.Objetos.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REGISTRAR ADMIN</title>

        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="stylesheet" href="../css/bootstrap.min.css"/>
        <link rel="stylesheet" href="../css/estilos.css"/>
    </head>
    <body>
        <header>
            <div class="container">
                <h1>HOSPITAL</h1>
                <h5>REGISTRAR ADMIN</h5>
            </div>
        </header>
        <div class="container">
            <div class="container">
                <br>
                <h3>Informacion del admin</h3>
            </div>
            <br>
            <form class="container form-group" action="" onsubmit="return validarAdmin();" method="POST" >
                <div class="form-row form-group">
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label for="nombreAdmin" class="control-label">Nombre Administrador: </label>
                            <div class="">
                                <input class="form-control" id="nombreAdmin" type="text" name="nombreAdmin" placeholder="Nombre">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="codigoAdmin" class="control-label">Codigo Administrador: </label>
                            <div class="">
                                <input class="form-control" id="codigoAdmin" type="text" name="codigoAdmin" placeholder="ADMINXXX">
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="DPIAdmin">DPI: </label>
                            <div class="">
                                <input class="form-control" id="DPIAdmin" type="number" name="DPIAdmin" placeholder="DPI">
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="passAdmin">Password: </label>
                            <div class="">
                                <input class="form-control" id="passAdmin" type="password" name="passAdmin">
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="passAdmin2"> Confirmar Password: </label>
                            <div class="">
                                <input class="form-control" id="passAdmin2" type="password" name="passAdmin2">
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-12">
                        <div class="container" >
                            <div class="form-group">
                                <button class="btn btn-success" type="submit" name="modificar" value="Ingresar">Registrar Admin</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <%
            String nombreAdmin = request.getParameter("nombreAdmin");
            String codigoAdmin = request.getParameter("codigoAdmin");
            String DPIAdmin = request.getParameter("DPIAdmin");
            String passwordAdmin = request.getParameter("passAdmin");
            if (nombreAdmin != null && codigoAdmin != null && DPIAdmin != null && passwordAdmin != null) {
                Admin adminNuevo = new Admin(nombreAdmin, codigoAdmin, DPIAdmin, passwordAdmin);
                try {
                    //VARIBLES DE CONEXION A BASE DE DATOS
                    ConnectionDB cnx = new ConnectionDB();
                    RegistroDB registro = new RegistroDB(cnx.getConexion());
                    //EVALUACION DE LA RESPUESTA OBTENIDA POR EL REGISTRO EN LA BASE DE DATOS
                    String respuesta = registro.registroUsuario(adminNuevo, "nuevo");
                    if(respuesta.equals("")){
                        respuesta = registro.registroAdmin(adminNuevo);
                        if(respuesta.equals("")){
                            request.getRequestDispatcher("../error.jsp?logroP=Se registro con exito el administrador al sistema").forward(request, response);
                        }else{
                            request.getRequestDispatcher("../error.jsp?errorP="+respuesta).forward(request, response);
                        }
                    }else{
                        request.getRequestDispatcher("../error.jsp?errorP="+respuesta).forward(request, response);
                    }
                } catch (Exception e) {
                    request.getRequestDispatcher("../error.jsp?errorP="+e.getMessage()).forward(request, response);
                }
            }

        %>
        <footer>
            <div class="container">
                <h3>© HOSPITAL 2020</h3>
            </div>
        </footer>
        <script src="../js/app2.js"></script>
        <script src="../js/jquery-3.5.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="../js/bootstrap.min.js"></script>
    </body>
</html>
