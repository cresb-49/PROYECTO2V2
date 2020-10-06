<%-- 
    Document   : historialPaciente
    Created on : 1/10/2020, 19:08:13
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HISTORIAL DE PACIENTE</title>
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
                <h5>MAYOR CANTIDAD DE REPORTES</h5>
                <h5><a href="${pageContext.request.contextPath}/usuarios/perfilDoctor.jsp">regresar al perfil</a></h5>
                <br/>
            </div>
        </header>
        <%----CONTENIDO DE FORMULARIO DE BUSQUEDA----%>
        <div class="container">
            <br/>
            <h5>Seleccione un intervalo de tiempo para la consulta</h5>
            <br/>
            <form method="GET" action="${pageContext.request.contextPath}/ReportesMedico">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="codigoPaciente">Inicio de intervalo</label>
                        <input type="number" class="form-control" name="codigoPaciente" id="codigoPaciente" placeholder="Codigo Paciente">
                    </div>
                    <div class="form-group col-md-12">
                        <button class="btn btn-primary" type="submit" id="reporte" name="reporte" value="4" >Buscar</button>
                    </div>
                </div>
            </form>
        </div>
        <%---- FIN CONTENIDO DE FORMULARIO DE BUSQUEDA----%>
        <%---- TABLAS DE CONTENIDO DEL RESULTADO DE BUSQUEDA----%>

        <div class="container">
            <div class="container">
                <h5>CITAS MEDICAS</h5>
            </div>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Codigo Cita</th>
                        <th scope="col">Codigo Medico</th>
                        <th scope="col">Fecha</th>
                        <th scope="col">Especialidad</th>
                    </tr>
                <tbody>
                    <%-----ESTE DEBE SER EL BUCLE PARA LA IMPRECION DE LA INFROMACION----%>
                    <c:forEach items="${citasPaciente}" var="cita">
                        <tr>
                            <td>${cita.codigo}</td>
                            <td>${cita.codigoMedico}</td>
                            <td>${cita.fecha}</td>
                            <td>${cita.especialidad}</td>
                        </tr>
                    </c:forEach>
                </tbody>

                </thead>
            </table>    
        </div>

        <div class="container">
            <br/>
            <div class="container">
                <h5>REPORTES LABORATORIO</h5>
            </div>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Codigo</th>
                        <th scope="col">Codigo Laboratorista</th>
                        <th scope="col">Codigo Medico</th>
                        <th scope="col">Codigo Examen</th>
                        <th scope="col">Fecha</th>
                    </tr>
                <tbody>
                    <%-----ESTE DEBE SER EL BUCLE PARA LA IMPRECION DE LA INFROMACION----%>
                    <c:forEach items="${resultadosPaciente}" var="lab">
                        <tr>
                            <td>${lab.codigo}</td>
                            <td>${lab.codigoLaboratorista}</td>
                            <td>${lab.codigoMedico}</td>
                            <td>${lab.codigoExamen}</td>
                            <td>${lab.fecha}</td>
                        </tr>
                    </c:forEach>
                </tbody>

                </thead>
            </table>    
        </div>
        <%---- FIN TABLAS DE CONTENIDO DEL RESULTADO DE BUSQUEDA----%>
        <footer>
            <div class="container">
                <h3>© HOSPITAL 2020</h3>
            </div>
        </footer>
    </body>
</html>
