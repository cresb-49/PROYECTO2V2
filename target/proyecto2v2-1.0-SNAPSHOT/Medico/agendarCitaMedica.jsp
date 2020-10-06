<%-- 
    Document   : agendarCitaMedica
    Created on : 3/10/2020, 03:30:14
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                <h5><a href="${pageContext.request.contextPath}/usuarios/perfilDoctor.jsp" >Regresar al perfil</a></h5>
                <br/>
            </div>
        </header>

        <div class="container">
            <br/>
            <h5>Ingrese los datos para agendar la cita</h5>
            <br/>
            <form method="POST" action="${pageContext.request.contextPath}/GenerarCitaMedico">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="fechaCita">Fecha de Cita</label>
                        <input type="date" class="form-control" name="fechaCita" id="fechaCita" min="${fecha}" value="${fecha}" placeholder="Fecha">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="horaCita">Hora de Cita</label>
                        <input type="time" class="form-control" min="${t1}" max="${t2}" name="horaCita" id="horaCita" placeholder="Fecha">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="codePaciente">Codigo Paciente</label>
                        <input type="text" class="form-control" name="codePaciente" id="codePaciente" placeholder="Codigo Paciente">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="especialidad">Especialidad</label>
                        <select class="custom-select" id="especialidad" name="especialidad">
                            <c:forEach items="${especilidades}" var="espe">
                                <option value="${espe}">${espe}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group col-md-12">
                        <button class="btn btn-success" type="submit" id="reporte" name="reporte" value="2" >Agendar Cita</button>
                    </div>
                </div>
            </form>
            <br/>
        </div>



        <footer>
            <div class="container">
                <h3>© HOSPITAL 2020</h3>
            </div>
        </footer>
    </body>
</html>