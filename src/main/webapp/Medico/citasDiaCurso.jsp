<%-- 
    Document   : citasDiaCurso
    Created on : 1/10/2020, 16:01:46
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Citas del dia</title>
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
                <br/>
                <h5><a href="${pageContext.request.contextPath}/usuarios/perfilDoctor.jsp">regresar al perfil</a></h5>
                <br/>
            </div>
        </header>
        <div class="container">
            <br/>
            <h5>Seleccione el dia en curso</h5>
            <br/>
            <form method="GET" action="${pageContext.request.contextPath}/ReportesMedico">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="fechaDia">Inicio de intervalo</label>
                        <input type="date" class="form-control" name="fechaDia" id="fechaDia" placeholder="Fecha">
                    </div>
                    <div class="form-group col-md-12">
                        <button class="btn btn-primary" type="submit" id="reporte" name="reporte" value="2" >Buscar</button>
                    </div>
                </div>
            </form>
            <br/>
        </div>
        <div class="container">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Codigo Cita</th>
                        <th scope="col">Paciente</th>
                        <th scope="col">Codigo Paciente</th>
                        <th scope="col">Hora</th>
                        <th scope="col">Especialidad</th>
                        <th scope="col">Generacion de Reporte</th>
                    </tr>
                <tbody>
                    <%-----ESTE DEBE SER EL BUCLE PARA LA IMPRECION DE LA INFROMACION----%>
                    <c:forEach items="${citasDia}" var="cita">
                        <tr>
                            <td>${cita.codigo}</td>
                            <td>${cita.nombrePaciente}</td>
                            <td>${cita.codigoPaciente}</td>
                            <td>${cita.hora}</td>
                            <td>${cita.especialidad}</td>
                            <td><a href="${pageContext.request.contextPath}/RedactarReporte?citaCodigo=${cita.codigo}">Generar Reporte</a></td>
                        </tr>
                    </c:forEach>
                </tbody>

                </thead>
            </table>
        </div>
        <footer>
            <div class="container">
                <h3>© HOSPITAL 2020</h3>
            </div>
        </footer>
    </body>
</html>
