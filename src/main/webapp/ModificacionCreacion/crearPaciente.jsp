<%--    
    Document   : crearLaboratorista
    Created on : 28/09/2020, 14:13:46
    Author     : carlo
--%>

<%@page import="com.mycompany.proyecto2v2.Conversiones.ConvercionesVariables"%>
<%@page import="com.mycompany.proyecto2v2.DBManage.ConnectionDB"%>
<%@page import="com.mycompany.proyecto2v2.DBManage.RegistroDB"%>
<%@page import="com.mycompany.proyecto2v2.Objetos.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REGISTRAR PACIENTE</title>

        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="stylesheet" href="../css/bootstrap.min.css"/>
        <link rel="stylesheet" href="../css/estilos.css"/>
    </head>
    <body>
        <header>
            <div class="container">
                <h1>HOSPITAL</h1>
                <h5>REGISTRAR PACIENTE</h5>
            </div>
        </header>
        <div class="container">
            <div class="container">
                <br>
                <h3>Informacion del paciente</h3>
            </div>
            <br>
            <form class="container form-group" action="" onsubmit="return validarRegistroPaciente();" method="POST" >
                <div class="form-row form-group">
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label for="nombrePaciente" class="control-label">Nombre Paciente: </label>
                            <div class="">
                                <input class="form-control" id="nombrePaciente" type="text" name="nombrePaciente" placeholder="Nombre">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="sexoPaciente">Sexo Paciente: </label>
                            <div class="">
                                <select class="form-control" name="sexoPaciente" id="sexoPaciente">
                                    <option value="Seleccionar" selected>Seleccionar</option>
                                    <option value="Hombre">Hombre</option>
                                    <option value="Mujer">Mujer</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="telefonoPaciente">Telefono: </label>
                            <div class="">
                                <input class="form-control" id="telefonoPaciente" type="number" name="telefonoPaciente" placeholder="Telefono">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="correoPaciente">Correo: </label>
                            <div class="">
                                <input class="form-control" id="correoPaciente" type="email" name="correoPaciente" placeholder="Correo Electronico">
                            </div>
                        </div>

                    </div>
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="DPIPaciente">DPI: </label>
                            <div class="">
                                <input class="form-control" id="DPIPaciente" type="text" name="DPIPaciente" placeholder="DPI">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="pesoPaciente">Peso Paciente: </label>
                            <div class="">
                                <input class="form-control" id="pesoPaciente" type="number" name="pesoPaciente" placeholder="Peso (kg)">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="fechaNacimiento">Fecha de Nacimiento: </label>
                            <div class="">
                                <input class="form-control" id="fechaNacimiento" type="date" name="fechaNacimiento" placeholder="Fecha">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="tipoSangre">Tipo de Sangre: </label>
                            <div class="">
                                <select class="form-control" name="tipoSangre" id="tipoSangre">
                                    <option value="Seleccionar" selected>Seleccionar</option>
                                    <option value="A">A</option>
                                    <option value="A+">A+</option>
                                    <option value="A-">A-</option>
                                    <option value="B">B</option>
                                    <option value="B+">B-</option>
                                    <option value="B-">B-</option>
                                    <option value="AB">AB</option>
                                    <option value="AB+">AB+</option>
                                    <option value="AB-">AB-</option>
                                    <option value="O">O</option>
                                    <option value="O+">O+</option>
                                    <option value="O-">O-</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="passPaciente">Password: </label>
                            <div class="">
                                <input class="form-control" id="passPaciente" type="password" name="passPaciente">
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="passPacienteVer"> Confirmar Password: </label>
                            <div class="">
                                <input class="form-control" id="passPacienteVer" type="password" name="passPacienteVer">
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-12">
                        <div class="container" >
                            <div class="form-group">
                                <button class="btn btn-success" type="submit" name="modificar" value="Ingresar">Registrar Paciente</button>
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
        <%
            String nombre = request.getParameter("nombrePaciente");
            String DPI = request.getParameter("DPIPaciente");
            String password = request.getParameter("passPaciente");
            String telefono = request.getParameter("telefonoPaciente");
            String sexo = request.getParameter("sexoPaciente");
            String peso = request.getParameter("pesoPaciente");
            String sangre = request.getParameter("tipoSangre");
            String correo = request.getParameter("correoPaciente");
            String fechaNacimiento = request.getParameter("fechaNacimiento");

            if (nombre != null) {
                ConvercionesVariables conv = new ConvercionesVariables();
                ////ASIGNACION DE ATRIBUTOS
                Paciente nuevoPaciente = new Paciente(nombre, DPI, password, telefono, correo, sexo, conv.stringToDate(fechaNacimiento), conv.stringToDouble(peso), sangre);
                ////FIN DE ASIGNACION DE ATRIBUTOS
                try {
                    //VARIBLES DE CONEXION A BASE DE DATOS
                    ConnectionDB cnx = new ConnectionDB();
                    RegistroDB registro = new RegistroDB(cnx.getConexion());
                    //EVALUACION DE LA RESPUESTA OBTENIDA POR EL REGISTRO EN LA BASE DE DATOS
                    String respuesta = registro.registroUsuario(nuevoPaciente, "nuevo");
                    if (respuesta.equals("")) {
                        respuesta = registro.registroPaciente(nuevoPaciente,"nuevo");
                        if (respuesta.equals("")) {
                            request.getRequestDispatcher("../error.jsp?logroP=Se registro con exito el paciente en el sistema").forward(request, response);
                        } else {
                            request.getRequestDispatcher("../error.jsp?errorP=" + respuesta).forward(request, response);
                        }
                    } else {
                        request.getRequestDispatcher("../error.jsp?errorP=" + respuesta).forward(request, response);
                    }
                    cnx.cerrarConexion();
                } catch (Exception e) {
                    request.getRequestDispatcher("../error.jsp?errorP=" + e.getMessage()).forward(request, response);
                }
            }
        %>
        <script src="../js/app.js"></script>
        <script src="../js/jquery-3.5.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="../js/bootstrap.min.js"></script>
    </body>
</html>
