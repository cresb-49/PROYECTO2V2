<%-- 
    Document   : crearDoctor
    Created on : 28/09/2020, 14:15:35
    Author     : carlo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.proyecto2v2.Conversiones.ConvercionesVariables"%>
<%@page import="com.mycompany.proyecto2v2.DBManage.ConnectionDB"%>
<%@page import="com.mycompany.proyecto2v2.DBManage.RegistroDB"%>
<%@page import="com.mycompany.proyecto2v2.Objetos.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Medico</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="stylesheet" href="../css/bootstrap.min.css"/>
        <link rel="stylesheet" href="../css/estilos.css"/>
    </head>
    <body>
        <header>
            <div class="container">
                <h1>HOSPITAL</h1>
                <h5>REGISTRAR MEDICO</h5>
                <br>
            </div>
        </header>
        <div class="container">
            <br>
            <h3>Atributos del Medico:</h3>
        </div>

        <div class="container">
            <br>
            <form class="container form-group" action="" onsubmit="return validarRegistroMedico();" method="POST" >
                <div class="form-row form-group">
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label for="codeDoctor" class="control-label">Codigo Doctor: </label>
                            <div class="">
                                <input class="form-control" id="codeDoctor" type="text" name="codeDoctor" placeholder="MED-XXXX">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="coleDoctor">No. Colegiado: </label>
                            <div class="">
                                <input class="form-control" id="coleDoctor" type="text" name="coleDoctor" placeholder="No. Colegiado">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="telDoctor">Telefono: </label>
                            <div class="">
                                <input class="form-control" id="telDoctor" type="text" name="telDoctor" placeholder="Telefono">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="emailDoctor">Correo: </label>
                            <div class="">
                                <input class="form-control" id="emailDoctor" type="text" name="emailDoctor" placeholder="Correo Electronico">
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="nameDoctor">Nombre Doctor: </label>
                            <div class="">
                                <input class="form-control" id="nameDoctor" type="text" name="nameDoctor" placeholder="Nombre doctor">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="DPIDoctor">DPI: </label>
                            <div class="">
                                <input class="form-control" id="DPIDoctor" type="text" name="DPIDoctor" placeholder="DPI">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="incioTrabajo">Inicio de labores: </label>
                            <div class="">
                                <input class="form-control" id="incioTrabajo" type="date" name="incioTrabajo" placeholder="Fecha">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label">Horario:</label>
                            <div class="form-inline">
                                <label for="inicioDoctor">Inicio: </label>
                                <div class="">
                                    <input class="form-control" id="inicioDoctor" type="time" name="inicioDoctor" placeholder="HH:mm">
                                </div>
                                <label for="finDoctor">Fin: </label>
                                <div class="">
                                    <input class="form-control" id="finDoctor" type="time" name="finDoctor" placeholder="HH:mm">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-12">
                        <div class="form-group">
                            <label class="control-label" for="espeDoctor">Especialidad: </label><br>
                            <select multiple="" class="form-control" name="espeDoctor" id="espeDoctor">                            

                            </select>
                        </div>
                    </div>
                    <div class="container form-group col-md-12">
                        <div class="container form-group row">
                            <div class="col-md-4">
                                <button class="form-group btn btn-danger" type="button" id="especialidadEliminar" onclick="eliminarEspecialidad();">Eliminar Seleccionado</button>
                            </div>
                            <div class="col-md-4">
                                <input class="form-control" type="text" id="ingresoEspecialidad" placeholder="Especialidad a agregar"/>
                            </div>
                            <div class="col-md-4">
                                <button class="btn btn-success" type="button" id="especialidadAgregar" onclick="agregarEspecialidad();" >Agregar</button>
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="passwordDoctor">Password: </label>
                            <div class="">
                                <input class="form-control" id="passwordDoctor" type="password" name="passwordDoctor">
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="passwordDoctor2"> Confirmar Password: </label>
                            <div class="">
                                <input class="form-control" id="passwordDoctor2" type="password" name="passwordDoctor2">
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-12">
                        <div class="container" >
                            <div class="form-group">
                                <button class="btn btn-success" type="submit" name="modificar" value="Ingresar">Registrar al Medico</button>
                            </div>
                        </div>
                    </div>
                </div>            
            </form>
        </div>
        <br>
        <footer>
            <div class="container">
                <h3>© HOSPITAL 2020</h3>
            </div>
        </footer>
        <%
            String nombreMedico = request.getParameter("nameDoctor");
            String numeroColegiado = request.getParameter("coleDoctor");
            String codigoMedico = request.getParameter("codeDoctor");
            String telefonoMedico = request.getParameter("telDoctor");
            String emailMedico = request.getParameter("emailDoctor");
            String DPIMedico = request.getParameter("DPIDoctor");
            String inicioHorario = request.getParameter("inicioDoctor");
            String finHorario = request.getParameter("finDoctor");
            String especilidades[] = request.getParameterValues("espeDoctor");
            String inicioLabores = request.getParameter("incioTrabajo");
            String passMedico = request.getParameter("passwordDoctor");
            if (nombreMedico!=null) {
                ConvercionesVariables conv = new ConvercionesVariables();
                Doctor nuevoDoctor = new Doctor();
                ////ASIGNACION DE ATRIBUTOS
                    nuevoDoctor.setNombre(nombreMedico);
                    nuevoDoctor.setColegiado(numeroColegiado);
                    nuevoDoctor.setCodigo(codigoMedico);
                    nuevoDoctor.setTelefono(telefonoMedico);
                    nuevoDoctor.setEmail(emailMedico);
                    nuevoDoctor.setDPI(DPIMedico);
                    nuevoDoctor.setInicio(conv.stringToTime(inicioHorario));
                    nuevoDoctor.setFin(conv.stringToTime(finHorario));
                    nuevoDoctor.setEspecialidad(new ArrayList<String>(Arrays.asList(especilidades)));
                    nuevoDoctor.setInicioTrabajo(conv.stringToDate(inicioLabores));
                    nuevoDoctor.setPassword(passMedico);
                ////FIN DE ASIGNACION DE ATRIBUTOS
                try {
                    //VARIBLES DE CONEXION A BASE DE DATOS
                    ConnectionDB cnx = new ConnectionDB();
                    RegistroDB registro = new RegistroDB(cnx.getConexion());
                    //EVALUACION DE LA RESPUESTA OBTENIDA POR EL REGISTRO EN LA BASE DE DATOS
                    String respuesta = registro.registroUsuario(nuevoDoctor, "nuevo");
                    if (respuesta.equals("")) {
                        respuesta = registro.registroDoctor(nuevoDoctor);
                        if (respuesta.equals("")) {
                            request.getRequestDispatcher("../error.jsp?logroP=Se registro con exito el medico en el sistema").forward(request, response);
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
