<%-- 
    Document   : CitaMedica
    Created on : 28/09/2020, 12:33:53
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cita Medica</title>
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
                <h5><a href="${pageContext.request.contextPath}/usuarios/perfilPaciente.jsp" >Regresar al perfil</a></h5>
                <br/>
            </div>
        </header>
        <form class="container form-group" action="${pageContext.request.contextPath}/ReportesPaciente" method="GET" >
            <div class="form-row form-group">
                <div class="container">
                    <br>
                    <h3>Buscar Doctor:</h3>
                    <br>
                </div>
                <div class="container form-group col-md-6">
                    <div class="form-group">
                        <label for="nombreDoctor">Nombre Doctor: </label>
                        <div class="form-group">
                            <input class="form-control" id="nombreDoctor" type="text" name="nombreDoctor" placeholder="Nombre Doctor">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="Horario">Hora propuesta para consulta: </label>
                        <div class="form-group">
                            <input class="form-control" id="Horario" type="time" name="Horario" placeholder="inicio horario">
                        </div>
                    </div>
                </div>
                <div class="container form-group col-md-6">
                    <div class="form-group">
                        <label for="especialidadDoctor">Especialidad: </label>
                        <div class="form-group">
                            <input class="form-control" id="especialidadDoctor" type="text" name="especialidadDoctor" placeholder="Especialidad Doctor">
                        </div>
                    </div>
                </div>
                <div class="container form-group col-12">
                    <div class="container" >
                        <div class="form-group">
                            <button class="btn btn-success" type="submit" name="reporte" value="5">Buscar</button>
                        </div>
                    </div>
                </div>
            </div>            
        </form>
        <div class="container">
            <div class="container">
                <br>
                <h3>Doctores encontrados:</h3>
                <br>
            </div>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Codigo Medico</th>
                        <th scope="col">Nombre Medico</th>
                        <th scope="col">Colegiado</th>
                        <th scope="col">Especialidad</th>
                        <th scope="col">Inicio Horario</th>
                        <th scope="col">Fin Horario</th>
                        <th scope="col">Correo</th>
                        <th scope="col">Generar Cita</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${medicos}" var="med">
                        <tr>
                            <td>${med[0]}</td>
                            <td>${med[1]}</td>
                            <td>${med[2]}</td>
                            <td>${med[3]}</td>
                            <td>${med[4]}</td>
                            <td>${med[5]}</td>
                            <td>${med[6]}</td>
                            <td><a href="${pageContext.request.contextPath}/ControladorCita?medico=${med[0]}&especialidad=${med[3]}&hora1=${med[4]}&hora2=${med[5]}">Gererar Cita</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    <footer>
        <div class="container">
            <h3>© HOSPITAL 2020</h3>
        </div>
    </footer>
</body>
</html>
