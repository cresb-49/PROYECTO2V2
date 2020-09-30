<%--    
    Document   : crearLaboratorista
    Created on : 28/09/2020, 14:13:46
    Author     : carlo
--%>

<%@page import="com.mycompany.proyecto2v2.DBManage.RegistroDB"%>
<%@page import="com.mycompany.proyecto2v2.DBManage.ConnectionDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.mycompany.proyecto2v2.Objetos.*"%>
<%@page import="com.mycompany.proyecto2v2.Conversiones.ConvercionesVariables"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REGISTRAR LABORATORISTA</title>

        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="stylesheet" href="../css/bootstrap.min.css"/>
        <link rel="stylesheet" href="../css/estilos.css"/>
    </head>
    <body>
        <header>
            <div class="container">
                <h1>HOSPITAL</h1>
                <h5>REGISTRAR LABORATORISTA</h5>
            </div>
        </header>
        <div class="container">
            <div class="container">
                <br>
                <h3>Atributos del Laboratorista:</h3>
            </div>
            <br>
            <form class="container form-group" action="" onsubmit="return validarRegistroLaboratorista();" method="POST" >
                <div class="form-row form-group">
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label for="codeLaboratorista" class="control-label">Codigo Laboratorista: </label>
                            <div class="">
                                <input class="form-control" id="codeLaboratorista" type="text" name="codeLaboratorista" placeholder="LAB-XXXX">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="numeroRegistroSalud">No. Registro de Salud: </label>
                            <div class="">
                                <input class="form-control" id="numeroRegistroSalud" type="text" name="numeroRegistroSalud" placeholder="SALUD-XXXX">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="telefonoLaboratorista">Telefono: </label>
                            <div class="">
                                <input class="form-control" id="telefonoLaboratorista" type="number" name="telefonoLaboratorista" placeholder="Telefono">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="emailLaboratorista">Correo: </label>
                            <div class="">
                                <input class="form-control" id="emailLaboratorista" type="email" name="emailLaboratorista" placeholder="Correo Electronico">
                            </div>
                        </div>

                    </div>
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="nameLaboratorista">Nombre Laboratorista: </label>
                            <div class="">
                                <input class="form-control" id="nameLaboratorista" type="text" name="nameLaboratorista" placeholder="Nombre Laboratorista">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="DPILaboratorista">DPI: </label>
                            <div class="">
                                <input class="form-control" id="DPILaboratorista" type="text" name="DPILaboratorista" placeholder="DPI">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="incioTrabajoLaboratorista">Inicio de labores: </label>
                            <div class="">
                                <input class="form-control" id="incioTrabajoLaboratorista" type="date" name="incioTrabajoLaboratorista" placeholder="Fecha">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="tipoDeExamenLaboratorista">Tipo de Examen: </label>
                            <div class="">
                                <input class="form-control" id="tipoDeExamenLaboratorista" type="text" name="tipoDeExamenLaboratorista" placeholder="Nombre de Examen">
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-12">
                        <div class="form-group">
                            <label class="control-label" for="diasSemanaLab">Dias de trabajo: </label><br>
                            <select multiple="" class="form-control" name="diasSemanaLab" id="diasSemanaLab">                            

                            </select>
                        </div>
                    </div>
                    <div class="container form-group col-md-12">
                        <div class="container form-group row">
                            <div class="col-md-4">
                                <button class="form-group btn btn-danger" type="button" id="especialidadEliminar" onclick="eliminarDiaTrabajo();">Eliminar Seleccionado</button>
                            </div>
                            <div class="col-md-4">
                                <select class="form-control" name="diaTrabajoLaboratorista" id="diaTrabajoLaboratorista">                            
                                    <option value="Lunes"  >Lunes</option>
                                    <option value="Martes" >Martes</option>
                                    <option value="Miercoles" >Miercoles</option>
                                    <option value="Jueves" >Jueves</option>
                                    <option value="Martes" >Viernes</option>
                                    <option value="Viernes" >Sabado</option>
                                    <option value="Domingo" >Domingo</option>
                                </select>
                            </div>
                            <div class="col-md-4">
                                <button class="btn btn-success" type="button" id="especialidadAgregar" onclick="agregarDiaTrabajo();" >Agregar</button>
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="passwordLaboratorista">Password: </label>
                            <div class="">
                                <input class="form-control" id="passwordLaboratorista" type="password" name="passwordLaboratorista">
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="passwordLaboratorista2"> Confirmar Password: </label>
                            <div class="">
                                <input class="form-control" id="passwordLaboratorista2" type="password" name="passwordLaboratorista2">
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-12">
                        <div class="container" >
                            <div class="form-group">
                                <button class="btn btn-success" type="submit" name="modificar" value="Ingresar">Registrar al Laboratorista</button>
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
            String codigoLab = request.getParameter("codeLaboratorista");
            String registroSalud = request.getParameter("numeroRegistroSalud");
            String telefono = request.getParameter("telefonoLaboratorista");
            String correoLab = request.getParameter("emailLaboratorista");
            String nombreLab = request.getParameter("nameLaboratorista");
            String DPILab = request.getParameter("DPILaboratorista");
            String inicioLabores = request.getParameter("incioTrabajoLaboratorista");
            String tipoExamen = request.getParameter("tipoDeExamenLaboratorista");
            String diasTrabajo[] = request.getParameterValues("diasSemanaLab");
            String passLab = request.getParameter("passwordLaboratorista");

            if (codigoLab != null) {
                ConvercionesVariables conv = new ConvercionesVariables();
                Laboratorista nuevoLab = new Laboratorista();
                ////ASIGNACION DE ATRIBUTOS
                nuevoLab.setCodigo(codigoLab);
                nuevoLab.setRegistro(registroSalud);
                nuevoLab.setTelefono(telefono);
                nuevoLab.setCorreo(correoLab);
                nuevoLab.setNombre(nombreLab);
                nuevoLab.setDPI(DPILab);
                nuevoLab.setInicioTrabajo(conv.stringToDate(inicioLabores));
                nuevoLab.setExamen(tipoExamen);
                nuevoLab.setDias(new ArrayList<String>(Arrays.asList(diasTrabajo)));
                nuevoLab.setPassword(passLab);
                ////FIN DE ASIGNACION DE ATRIBUTOS
                try {
                    //VARIBLES DE CONEXION A BASE DE DATOS
                    ConnectionDB cnx = new ConnectionDB();
                    RegistroDB registro = new RegistroDB(cnx.getConexion());
                    //EVALUACION DE LA RESPUESTA OBTENIDA POR EL REGISTRO EN LA BASE DE DATOS
                    String respuesta = registro.registroUsuario(nuevoLab, "nuevo");
                    if (respuesta.equals("")) {
                        respuesta = registro.registroLaboratorista(nuevoLab);
                        if (respuesta.equals("")) {
                            request.getRequestDispatcher("../error.jsp?logroP=Se registro con exito el laboratorista en el sistema").forward(request, response);
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
