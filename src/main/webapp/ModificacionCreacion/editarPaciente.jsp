<%--    
    Document   : crearLaboratorista
    Created on : 28/09/2020, 14:13:46
    Author     : carlo
--%>

<%@page import="com.mycompany.proyecto2v2.DBManage.ModificacionDB"%>
<%@page import="com.mycompany.proyecto2v2.Conversiones.ConvercionesVariables"%>
<%@page import="com.mycompany.proyecto2v2.Objetos.Paciente"%>
<%@page import="com.mycompany.proyecto2v2.DBManage.ConsultasDB"%>
<%@page import="com.mycompany.proyecto2v2.DBManage.ConnectionDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REGISTRAR PACIENTE</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css"/>
        <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/comportamientoPerfiles.js" ></script>
    </head>
    <body>
        <header>
            <div class="container">
                <h1>HOSPITAL</h1>
                <h5>EDITAR PACIENTE</h5>
                <h5><a href="${pageContext.request.contextPath}/usuarios/ADMINISTRADOR.jsp" >Regresar el perfil</a></h5>
                <br/>
            </div>
        </header>
        <div class="container">
            <br>
            <div class="container">
                <br>
                <h3>BUSCAR PACIENTE</h3>
            </div>
            <br>
            <form class="form-inline" action="" method="POST">
                <label class="control-label col-md-2" for="codigoPaciente">Codigo Paciente: </label>
                <div class="form-group">
                    <input class="form-control" id="codigoPaciente" type="text" name="codigoPaciente" placeholder="Codigo Paciente">
                </div>
                <div class="form-group col-md-2">
                    <button class="btn btn-primary" type="submit" name="buscar" >Buscar</button>
                </div>
            </form>
            <br/>
            <%
                String codigoPaciente = request.getParameter("codigoPaciente");
                Paciente modPaciente = null;
                if (codigoPaciente != null || codigoPaciente != "") {
                    ConnectionDB cnx = new ConnectionDB();
                    ConsultasDB consulta = new ConsultasDB();
                    consulta.setConexion(cnx.getConexion());
                    modPaciente = consulta.retornarPaciente(codigoPaciente);
                    if (modPaciente.getCodigo() != null) {
                        System.out.println("Paciente rescatado: " + modPaciente.toString());
                        session.setAttribute("MODPACIENTE", modPaciente);
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
        <div class="container">
            <div class="container">
                <br>
                <h3>Informacion del paciente</h3>
            </div>
            <br>
            <form class="container form-group" action="" onsubmit="return validarModificarPaciente();" method="POST" >
                <div class="form-row form-group">
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label for="nombrePaciente" class="control-label">Nombre Paciente: </label>
                            <div class="">
                                <%
                                    if (modPaciente.getNombre() != null) {
                                %>
                                <input class="form-control" id="nombrePaciente" type="text" name="nombrePaciente" placeholder="Nombre" value="<%out.print(modPaciente.getNombre());%>">
                                <%
                                } else {
                                %>
                                <input class="form-control" id="nombrePaciente" type="text" name="nombrePaciente" placeholder="Nombre">
                                <%
                                    }
                                %>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="sexoPaciente">Sexo Paciente: </label>
                            <div class="">
                                <select class="form-control" name="sexoPaciente" id="sexoPaciente">
                                    <%
                                        if (modPaciente.getSexo() != null) {
                                            switch (modPaciente.getSexo()) {
                                                case "Hombre":
                                    %>
                                    <option value="Seleccionar">Seleccionar</option>
                                    <option value="Hombre" selected>Hombre</option>
                                    <option value="Mujer">Mujer</option>
                                    <%
                                            break;
                                        case "Mujer":
                                    %>
                                    <option value="Seleccionar">Seleccionar</option>
                                    <option value="Hombre" >Hombre</option>
                                    <option value="Mujer" selected >Mujer</option><%
                                            break;
                                        default:
                                    %>
                                    <option value="Seleccionar" selected>Seleccionar</option>
                                    <option value="Hombre">Hombre</option>
                                    <option value="Mujer">Mujer</option>
                                    <%
                                                break;
                                        }
                                    } else {
                                    %>
                                    <option value="Seleccionar" selected>Seleccionar</option>
                                    <option value="Hombre">Hombre</option>
                                    <option value="Mujer">Mujer</option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="telefonoPaciente">Telefono: </label>
                            <div class="">
                                <%
                                    if (modPaciente.getTelefono() != null) {
                                %>
                                <input class="form-control" id="telefonoPaciente" type="number" name="telefonoPaciente" placeholder="Telefono" value="<%out.print(modPaciente.getTelefono());%>">
                                <%
                                } else {
                                %>
                                <input class="form-control" id="telefonoPaciente" type="number" name="telefonoPaciente" placeholder="Telefono">
                                <%
                                    }
                                %>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="tipoSangre">Tipo de Sangre: </label>
                            <div class="">
                                <select class="form-control" name="tipoSangre" id="tipoSangre">
                                    <%
                                        if (modPaciente.getSangre() != null) {
                                            switch (modPaciente.getSangre()) {
                                                case "A":
                                    %>
                                    <option value="Seleccionar">Seleccionar</option>
                                    <option value="A" selected>A</option>
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
                                    <%
                                            break;
                                        case "A+":
                                    %>
                                    <option value="Seleccionar">Seleccionar</option>
                                    <option value="A">A</option>
                                    <option value="A+" selected>A+</option>
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
                                    <%
                                            break;
                                        case "A-":
                                    %>
                                    <option value="Seleccionar">Seleccionar</option>
                                    <option value="A">A</option>
                                    <option value="A+" >A+</option>
                                    <option value="A-" selected>A-</option>
                                    <option value="B">B</option>
                                    <option value="B+">B-</option>
                                    <option value="B-">B-</option>
                                    <option value="AB">AB</option>
                                    <option value="AB+">AB+</option>
                                    <option value="AB-">AB-</option>
                                    <option value="O">O</option>
                                    <option value="O+">O+</option>
                                    <option value="O-">O-</option>
                                    <%
                                            break;
                                        case "B":
                                    %>
                                    <option value="Seleccionar">Seleccionar</option>
                                    <option value="A">A</option>
                                    <option value="A+" >A+</option>
                                    <option value="A-" >A-</option>
                                    <option value="B" selected>B</option>
                                    <option value="B+">B-</option>
                                    <option value="B-">B-</option>
                                    <option value="AB">AB</option>
                                    <option value="AB+">AB+</option>
                                    <option value="AB-">AB-</option>
                                    <option value="O">O</option>
                                    <option value="O+">O+</option>
                                    <option value="O-">O-</option>
                                    <%
                                            break;
                                        case "B+":
                                    %>
                                    <option value="Seleccionar">Seleccionar</option>
                                    <option value="A">A</option>
                                    <option value="A+" >A+</option>
                                    <option value="A-" >A-</option>
                                    <option value="B" >B</option>
                                    <option value="B+" selected>B-</option>
                                    <option value="B-">B-</option>
                                    <option value="AB">AB</option>
                                    <option value="AB+">AB+</option>
                                    <option value="AB-">AB-</option>
                                    <option value="O">O</option>
                                    <option value="O+">O+</option>
                                    <option value="O-">O-</option>
                                    <%
                                            break;
                                        case "B-":
                                    %>
                                    <option value="Seleccionar">Seleccionar</option>
                                    <option value="A">A</option>
                                    <option value="A+" >A+</option>
                                    <option value="A-" >A-</option>
                                    <option value="B" >B</option>
                                    <option value="B+" >B-</option>
                                    <option value="B-" selected>B-</option>
                                    <option value="AB">AB</option>
                                    <option value="AB+">AB+</option>
                                    <option value="AB-">AB-</option>
                                    <option value="O">O</option>
                                    <option value="O+">O+</option>
                                    <option value="O-">O-</option>
                                    <%
                                            break;
                                        case "AB":
                                    %>
                                    <option value="Seleccionar">Seleccionar</option>
                                    <option value="A">A</option>
                                    <option value="A+" >A+</option>
                                    <option value="A-" >A-</option>
                                    <option value="B" >B</option>
                                    <option value="B+" >B-</option>
                                    <option value="B-">B-</option>
                                    <option value="AB" selected>AB</option>
                                    <option value="AB+">AB+</option>
                                    <option value="AB-">AB-</option>
                                    <option value="O">O</option>
                                    <option value="O+">O+</option>
                                    <option value="O-">O-</option>
                                    <%
                                            break;
                                        case "AB+":
                                    %>
                                    <option value="Seleccionar">Seleccionar</option>
                                    <option value="A">A</option>
                                    <option value="A+" >A+</option>
                                    <option value="A-" >A-</option>
                                    <option value="B" >B</option>
                                    <option value="B+" >B-</option>
                                    <option value="B-">B-</option>
                                    <option value="AB" >AB</option>
                                    <option value="AB+" selected>AB+</option>
                                    <option value="AB-">AB-</option>
                                    <option value="O">O</option>
                                    <option value="O+">O+</option>
                                    <option value="O-">O-</option>
                                    <%
                                            break;
                                        case "AB-":
                                    %>
                                    <option value="Seleccionar">Seleccionar</option>
                                    <option value="A">A</option>
                                    <option value="A+" >A+</option>
                                    <option value="A-" >A-</option>
                                    <option value="B" >B</option>
                                    <option value="B+" >B-</option>
                                    <option value="B-">B-</option>
                                    <option value="AB" >AB</option>
                                    <option value="AB+" >AB+</option>
                                    <option value="AB-" selected>AB-</option>
                                    <option value="O">O</option>
                                    <option value="O+">O+</option>
                                    <option value="O-">O-</option>
                                    <%
                                            break;
                                        case "O":
                                    %>
                                    <option value="Seleccionar">Seleccionar</option>
                                    <option value="A">A</option>
                                    <option value="A+" >A+</option>
                                    <option value="A-" >A-</option>
                                    <option value="B" >B</option>
                                    <option value="B+" >B-</option>
                                    <option value="B-">B-</option>
                                    <option value="AB" >AB</option>
                                    <option value="AB+" >AB+</option>
                                    <option value="AB-" >AB-</option>
                                    <option value="O" selected>O</option>
                                    <option value="O+">O+</option>
                                    <option value="O-">O-</option>
                                    <%
                                            break;
                                        case "O+":
                                    %>
                                    <option value="Seleccionar">Seleccionar</option>
                                    <option value="A">A</option>
                                    <option value="A+" >A+</option>
                                    <option value="A-" >A-</option>
                                    <option value="B" >B</option>
                                    <option value="B+" >B-</option>
                                    <option value="B-">B-</option>
                                    <option value="AB" >AB</option>
                                    <option value="AB+" >AB+</option>
                                    <option value="AB-" >AB-</option>
                                    <option value="O" >O</option>
                                    <option value="O+" selected>O+</option>
                                    <option value="O-">O-</option>
                                    <%
                                            break;
                                        case "O-":
                                    %>
                                    <option value="Seleccionar">Seleccionar</option>
                                    <option value="A">A</option>
                                    <option value="A+" >A+</option>
                                    <option value="A-" >A-</option>
                                    <option value="B" >B</option>
                                    <option value="B+" >B-</option>
                                    <option value="B-">B-</option>
                                    <option value="AB" >AB</option>
                                    <option value="AB+" >AB+</option>
                                    <option value="AB-" >AB-</option>
                                    <option value="O" >O</option>
                                    <option value="O+" >O+</option>
                                    <option value="O-" selected>O-</option>
                                    <%
                                            break;
                                        default:
                                    %>
                                    <option value="Seleccionar" selected>Seleccionar</option>
                                    <option value="A">A</option>
                                    <option value="A+" >A+</option>
                                    <option value="A-" >A-</option>
                                    <option value="B" >B</option>
                                    <option value="B+" >B-</option>
                                    <option value="B-">B-</option>
                                    <option value="AB" >AB</option>
                                    <option value="AB+" >AB+</option>
                                    <option value="AB-" >AB-</option>
                                    <option value="O" >O</option>
                                    <option value="O+" >O+</option>
                                    <option value="O-">O-</option>
                                    <%
                                                break;
                                        }
                                    } else {
                                    %>
                                    <option value="Seleccionar" selected>Seleccionar</option>
                                    <option value="A">A</option>
                                    <option value="A+" >A+</option>
                                    <option value="A-" >A-</option>
                                    <option value="B" >B</option>
                                    <option value="B+" >B-</option>
                                    <option value="B-">B-</option>
                                    <option value="AB" >AB</option>
                                    <option value="AB+" >AB+</option>
                                    <option value="AB-" >AB-</option>
                                    <option value="O" >O</option>
                                    <option value="O+" >O+</option>
                                    <option value="O-">O-</option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="DPIPaciente">DPI: </label>
                            <div class="">
                                <%
                                    if (modPaciente.getDPI() != null) {
                                %>
                                <input class="form-control" id="DPIPaciente" type="text" name="DPIPaciente" placeholder="DPI" value="<%out.print(modPaciente.getDPI());%>">
                                <%
                                } else {
                                %>
                                <input class="form-control" id="DPIPaciente" type="text" name="DPIPaciente" placeholder="DPI">
                                <%
                                    }
                                %>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="pesoPaciente">Peso Paciente: </label>
                            <div class="">
                                <%
                                    if (modPaciente.getPeso() != null) {
                                %>
                                <input class="form-control" id="pesoPaciente" type="number" name="pesoPaciente" placeholder="Peso (kg)" value="<%out.print(modPaciente.getPeso());%>">
                                <%
                                } else {
                                %>
                                <input class="form-control" id="pesoPaciente" type="number" name="pesoPaciente" placeholder="Peso (kg)">
                                <%
                                    }
                                %>

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="fechaNacimiento">Fecha de Nacimiento: </label>
                            <div class="">
                                <%
                                    if (modPaciente.getCumple() != null) {
                                %>
                                <input class="form-control" id="fechaNacimiento" type="date" name="fechaNacimiento" placeholder="Fecha" value="<%out.print(modPaciente.getCumple());%>">
                                <%
                                } else {
                                %>
                                <input class="form-control" id="fechaNacimiento" type="date" name="fechaNacimiento" placeholder="Fecha">
                                <%
                                    }
                                %>
                            </div>
                        </div>

                    </div>
                    <div class="container form-group col-md-12">
                        <div class="container" >
                            <div class="form-group">
                                <button class="btn btn-danger" type="submit" name="modificar" value="Ingresar">Modificar Paciente</button>
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
    </body>
</html>






<%
    String nombrePas = request.getParameter("nombrePaciente");
    String DPI = request.getParameter("DPIPaciente");
    String telefono = request.getParameter("telefonoPaciente");
    String sexo = request.getParameter("sexoPaciente");
    String peso = request.getParameter("pesoPaciente");
    String sangre = request.getParameter("tipoSangre");
    String fechaNacimiento = request.getParameter("fechaNacimiento");

    System.out.println("Nombre paciente: " + nombrePas);
    if (nombrePas != null) {
        ConvercionesVariables conv = new ConvercionesVariables();
        Paciente tempPaciente = (Paciente) session.getAttribute("MODPACIENTE");
        session.removeAttribute("MODPACIENTE");
        tempPaciente.setNombre(nombrePas);
        tempPaciente.setDPI(DPI);
        tempPaciente.setTelefono(telefono);
        tempPaciente.setSexo(sexo);
        tempPaciente.setPeso(conv.stringToDouble(peso));
        tempPaciente.setSangre(sangre);
        tempPaciente.setCumple(conv.stringToDate(fechaNacimiento));

        System.out.println("Paciente Modificado: " + tempPaciente.toString());
        try {
            //VARIBLES DE CONEXION A BASE DE DATOS
            ConnectionDB cnx = new ConnectionDB();
            ModificacionDB modificar = new ModificacionDB();
            modificar.setConexion(cnx.getConexion());
            String respuesta = modificar.modificarPaciente(tempPaciente);
            if (respuesta.equals("")) {
                request.getRequestDispatcher("../error.jsp?logroP=Se modifico con exito el paciente en el sistema").forward(request, response);
            } else {
                request.getRequestDispatcher("../error.jsp?errorP=" + respuesta).forward(request, response);
            }
            cnx.cerrarConexion();
        } catch (Exception e) {
            request.getRequestDispatcher("../error.jsp?errorP=" + e.getMessage()).forward(request, response);
        }

    }
%>