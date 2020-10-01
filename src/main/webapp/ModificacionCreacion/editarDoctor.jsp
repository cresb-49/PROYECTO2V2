<%@page import="com.mycompany.proyecto2v2.Conversiones.ConvercionesVariables"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.proyecto2v2.DBManage.ModificacionDB"%>
<%@page import="com.mycompany.proyecto2v2.DBManage.ConsultasDB"%>
<%@page import="com.mycompany.proyecto2v2.DBManage.ConnectionDB"%>
<%@page import="com.mycompany.proyecto2v2.Objetos.Doctor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EDITAR DOCTOR</title>
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
            <br>
            <h3>Buscar Doctor:</h3>
        </div>
        <div class="container">
            <br>
            <form class="form-inline" action="" method="POST">
                <label class="control-label col-md-2" for="codeDoctor">Codigo Doctor: </label>
                <div class="form-group">
                    <input class="form-control" id="codeDoctor" type="text" name="codeDoctor" placeholder="MED-XXXX">
                </div>
                <div class="form-group col-md-2">
                    <button class="btn btn-primary" type="submit" name="buscar" >Buscar</button>
                </div>
            </form>
            <br/>
            <%
                String codigoDoctor = request.getParameter("codeDoctor");
                Doctor modDoctor = null;
                if (codigoDoctor != null || codigoDoctor != "") {
                    ConnectionDB cnx = new ConnectionDB();
                    ConsultasDB consulta = new ConsultasDB();
                    consulta.setConexion(cnx.getConexion());
                    modDoctor = consulta.retornarDoctor(codigoDoctor);
                    if (modDoctor.getCodigo() != null) {
                        System.out.println("Doctor rescatado: " + modDoctor.toString());
                        session.setAttribute("MODMEDICO", modDoctor);
                    }else{
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
            <br>
            <h3>Atributos:</h3>
        </div>

        <div class="container">
            <br>
            <form class="container form-group" action="" onsubmit="return validarModificaionMedico()" method="POST" >
                <div class="form-row form-group">
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="coleDoctor">No. Colegiado: </label>
                            <div class="">
                                <%
                                    if (modDoctor.getColegiado() != null) {
                                %>
                                <input class="form-control" id="coleDoctor" type="text" name="coleDoctor" placeholder="No. Colegiado" value="<%out.print(modDoctor.getColegiado());%>">
                                <%
                                } else {
                                %>
                                <input class="form-control" id="coleDoctor" type="text" name="coleDoctor" placeholder="No. Colegiado">
                                <%
                                    }
                                %>

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="telDoctor">Telefono: </label>
                            <div class="">
                                <%
                                    if (modDoctor.getTelefono() != null) {
                                %>
                                <input class="form-control" id="telDoctor" type="text" name="telDoctor" placeholder="Telefono" value="<%out.print(modDoctor.getTelefono());%>">
                                <%
                                } else {
                                %>
                                <input class="form-control" id="telDoctor" type="text" name="telDoctor" placeholder="Telefono">
                                <%
                                    }
                                %>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label">Horario:</label>
                            <div class="form-inline">
                                <label for="inicioDoctor">Inicio: </label>
                                <div class="">
                                    <%
                                        if (modDoctor.getInicio() != null) {
                                    %>
                                    <input class="form-control" id="inicioDoctor" type="time" name="inicioDoctor" placeholder="HH:mm" value="<%out.print(modDoctor.getInicio());%>">
                                    <%
                                    } else {
                                    %>
                                    <input class="form-control" id="inicioDoctor" type="time" name="inicioDoctor" placeholder="HH:mm">
                                    <%
                                        }
                                    %>
                                </div>
                                <label for="finDoctor">Fin: </label>
                                <div class="">
                                    <%
                                        if (modDoctor.getFin() != null) {
                                    %>
                                    <input class="form-control" id="finDoctor" type="time" name="finDoctor" placeholder="HH:mm" value="<%out.print(modDoctor.getFin());%>">
                                    <%
                                    } else {
                                    %>
                                    <input class="form-control" id="finDoctor" type="time" name="finDoctor" placeholder="HH:mm">
                                    <%
                                        }
                                    %>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="nameDoctor">Nombre Doctor: </label>
                            <div class="">
                                <%
                                    if (modDoctor.getNombre() != null) {
                                %>
                                <input class="form-control" id="nameDoctor" type="text" name="nameDoctor" placeholder="Nombre doctor" value="<%out.print(modDoctor.getNombre());%>">
                                <%
                                } else {
                                %>
                                <input class="form-control" id="nameDoctor" type="text" name="nameDoctor" placeholder="Nombre doctor">
                                <%
                                    }
                                %>

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="DPIDoctor">DPI: </label>
                            <div class="">
                                <%
                                    if (modDoctor.getDPI() != null) {
                                %>
                                <input class="form-control" id="DPIDoctor" type="text" name="DPIDoctor" placeholder="DPI" value="<%out.print(modDoctor.getDPI());%>">
                                <%
                                } else {
                                %>
                                <input class="form-control" id="DPIDoctor" type="text" name="DPIDoctor" placeholder="DPI">
                                <%
                                    }
                                %>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="incioTrabajo">Inicio de labores: </label>
                            <div class="">
                                <%
                                    if (modDoctor.getInicioTrabajo() != null) {
                                %>
                                <input class="form-control" id="incioTrabajo" type="date" name="incioTrabajo" placeholder="Fecha" value="<%out.print(modDoctor.getInicioTrabajo());%>">
                                <%
                                } else {
                                %>
                                <input class="form-control" id="incioTrabajo" type="date" name="incioTrabajo" placeholder="Fecha">
                                <%
                                    }
                                %>
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-12">
                        <div class="form-group">
                            <label class="control-label" for="espeDoctor">Especialidad: </label><br>
                            <select multiple="multiple" class="form-control" name="espeDoctor" id="espeDoctor">                            
                                <%
                                    if (!modDoctor.getEspecialidad().isEmpty()) {
                                        for (String espe : modDoctor.getEspecialidad()) {
                                %>
                                <option value="<%=espe%>"><%=espe%></option>
                                <%
                                        }
                                    }
                                %>
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
                    <div class="container form-group col-md-12">
                        <div class="container" >
                            <div class="form-group">
                                <button class="btn btn-danger" type="submit" name="modificar" value="Ingresar">Modificar el Doctor</button>
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
        <script src="../js/app.js"></script>
        <script src="../js/jquery-3.5.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="../js/bootstrap.min.js"></script>
    </body>
</html>
<%
    String nombreMedico = request.getParameter("nameDoctor");
    String numeroColegiado = request.getParameter("coleDoctor");
    String telefonoMedico = request.getParameter("telDoctor");
    String DPIMedico = request.getParameter("DPIDoctor");
    String inicioHorario = request.getParameter("inicioDoctor");
    String finHorario = request.getParameter("finDoctor");
    String especilidades[] = request.getParameterValues("espeDoctor");
    String inicioLabores = request.getParameter("incioTrabajo");

    System.out.println("Nombre Medico: " + nombreMedico);
    if (nombreMedico != null) {
        System.out.println("SimplifiedJSPServlet.mergedScriptlets()");
        ConvercionesVariables conv = new ConvercionesVariables();
        Doctor tempDoc = (Doctor) session.getAttribute("MODMEDICO");
        session.removeAttribute("MODMEDICO");
        tempDoc.setNombre(nombreMedico);
        tempDoc.setColegiado(numeroColegiado);
        tempDoc.setTelefono(telefonoMedico);
        tempDoc.setDPI(DPIMedico);
        tempDoc.setInicio(conv.stringToTime(inicioHorario));
        tempDoc.setFin(conv.stringToTime(finHorario));
        tempDoc.setEspecialidad(new ArrayList<String>(Arrays.asList(especilidades)));
        tempDoc.setInicioTrabajo(conv.stringToDate(inicioLabores));
        System.out.println("Doctor Modificado: " + tempDoc.toString());
        try {
            //VARIBLES DE CONEXION A BASE DE DATOS
            ConnectionDB cnx = new ConnectionDB();
            ModificacionDB modificar = new ModificacionDB();
            modificar.setConexion(cnx.getConexion());
            String respuesta = modificar.modificarDoctor(tempDoc);
            if (respuesta.equals("")) {
                request.getRequestDispatcher("../error.jsp?logroP=Se modifico con exito el medico en el sistema").forward(request, response);
            } else {
                request.getRequestDispatcher("../error.jsp?errorP=" + respuesta).forward(request, response);
            }
            cnx.cerrarConexion();
        } catch (Exception e) {
            request.getRequestDispatcher("../error.jsp?errorP=" + e.getMessage()).forward(request, response);
        }

    }
%>