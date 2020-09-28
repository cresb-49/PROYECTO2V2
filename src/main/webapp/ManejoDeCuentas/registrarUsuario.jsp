<%-- 
    Document   : registrarUsuario
    Created on : 19/09/2020, 17:36:17
    Author     : benjamin
--%>

<%@page import="com.mycompany.proyecto2v2.Objetos.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
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
        <%
            //Atributos del paciente
            String nombre = null;
            String fecha = null;
            String peso = null;
            String telefono = null;
            String sexo = null;
            String dpi = null;
            String sangre = null;
            String correo = null;
            //Objeto paciente
            Paciente paci = null;
            //Resultados de error
            String resultado = null;
            try {
                paci = (Paciente) request.getAttribute("nuevoPaciente");
            } catch (Exception e) {

            }
            if (paci != null) {
                nombre = paci.getNombre();
                fecha = paci.getCumple().toString();
                peso = paci.getPeso().toString();
                telefono = paci.getTelefono();
                sexo = paci.getSexo();
                dpi = paci.getDPI();
                sangre = paci.getSangre();
                correo = paci.getCorreo();
            }
            resultado = request.getParameter("error");
            if (resultado != null) {

        %>
        <br>
        <div class="container alert alert-danger" role="alert">
            <%System.out.println(resultado);
                            out.write(resultado);%>
        </div>
        <%
            }
        %>
        <div class="container">
            <br>
            <h4>Ingresa tus datos:</h4>
        </div>
        <div class="container">
            <br>
            <form action="acountProcess.jsp?token=registarUsuario" id="registroUsuario" name="registroUsuario" onsubmit="return validarRegistroPaciente()" method="post">
                <section class="row">
                    <!--Primera columna del formulario-->
                    <div class="container col-md-6">
                        <div class="form-group">
                            <label for="nombrePaciente" class="">Nombre: </label>
                            <div class="">
                                <%
                                    if (nombre == null) {
                                %>
                                <input class="form-control" id="nombrePaciente" type="text" name="nombrePaciente" placeholder="Nombre" >
                                <%
                                } else {
                                %>
                                <input class="form-control" id="nombrePaciente" type="text" name="nombrePaciente" placeholder="Nombre" value="<% out.write(nombre);%>">
                                <%
                                    }
                                %>

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="" for="fechaNacimiento">Fecha Nacimiento: </label>
                            <div class="">
                                <%
                                    if (fecha == null) {
                                %>
                                <input class="form-control" id="fechaNacimiento" type="date" name="fechaNacimiento" value="2000-01-01" min="1950-01-01" >
                                <%
                                } else {
                                %>
                                <input class="form-control" id="fechaNacimiento" type="date" name="fechaNacimiento" value="<% out.write(fecha); %>" min="1950-01-01">
                                <%
                                    }
                                %>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="" for="telefonoPaciente">Telefono: </label>
                            <div class="">
                                <%
                                    if (telefono == null) {
                                %>
                                <input class="form-control" id="telefonoPaciente" type="text" name="telefonoPaciente" placeholder="Telefono" >
                                <%
                                } else {
                                %>
                                <input class="form-control" id="telefonoPaciente" type="text" name="telefonoPaciente" placeholder="Telefono" value="<%out.write(telefono);%>">
                                <%
                                    }
                                %>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="" for="pesoPaciente">Peso (Kg): </label>
                            <div class="">
                                <%
                                    if (peso == null) {
                                %>
                                <input class="form-control" id="pesoPaciente" type="text" name="pesoPaciente" placeholder="Peso (Kg)">
                                <%
                                } else {
                                %>
                                <input class="form-control" id="pesoPaciente" type="text" name="pesoPaciente" placeholder="Peso (Kg)" value="<%out.write(peso);%>">
                                <%
                                    }
                                %>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="" for="passPaciente">Password: </label>
                            <div class="">
                                <input class="form-control" id="passPaciente" type="password" name="passPaciente" placeholder="Password">
                            </div>
                        </div>
                        <div class="container" >
                            <div class="form-group">
                                <button class="btn btn-success" type="submit" name="Registarse" value="Registrarse">Registrarse</button>
                            </div>
                        </div>
                    </div>
                    <div class="container col-md-6">
                        <div class="form-group">
                            <label class="" for="sexoPaciente">Sexo: </label><br>
                            <select class="form-control" name="sexoPaciente" id="sexoPaciente">
                                <%
                                    if (sexo != null) {
                                        switch (sexo) {
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
                                <option value="Hombre">Hombre</option>
                                <option value="Mujer" selected>Mujer</option>
                                <%
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
                        <div class="form-group">
                            <label class="" for="DPIPaciente">DPI: </label>
                            <div class="">
                                <%
                                    if (dpi == null) {
                                %>
                                <input class="form-control" id="DPIPaciente" type="text" name="DPIPaciente" placeholder="DPI">
                                <%
                                } else {
                                %>
                                <input class="form-control" id="DPIPaciente" type="text" name="DPIPaciente" placeholder="DPI" value="<%out.write(dpi);%>">
                                <%
                                    }
                                %>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="" for="correoPaciente">Correo: </label>
                            <div class="">
                                <%
                                    if (correo == null) {
                                %>
                                <input class="form-control" id="correoPaciente" type="email" name="correoPaciente" placeholder="Correo">
                                <%
                                } else {
                                %>
                                <input class="form-control" id="correoPaciente" type="email" name="correoPaciente" placeholder="Correo" value="<%out.write(correo);%>">
                                <%
                                    }
                                %>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="" for="tipoSangre">Tipo Sangre: </label><br>
                            <select class="form-control" name="tipoSangre" id="tipoSangre">
                                <%
                                    if (sangre != null) {
                                        switch (sangre) {
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
                        <div class="form-group">
                            <label class="" for="passPacienteVer">Repetir Password: </label>
                            <div class="">
                                <input class="form-control" id="passPacienteVer" type="password" name="passPacienteVer" placeholder="Password">
                            </div>
                        </div>
                        <div class="container" >
                            <div class="form-group">
                                <a class="btn btn-info" href="../index.jsp">Regresar al inicio</a>
                            </div>
                        </div>
                    </div>
                </section>
            </form>
        </div>


        <footer>
            <div class="container">
                <h3>© HOSPITAL 2020</h3>
            </div>
        </footer>
        <script src="../js/precargadoRegistroUsuario.js"></script>
        <script src="../js/app.js"></script>
        <script src="../js/jquery-3.5.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="../js/bootstrap.min.js"></script>
    </body>
</html>
