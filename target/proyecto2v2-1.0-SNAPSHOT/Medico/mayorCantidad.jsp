<%-- 
    Document   : mayorCantidad
    Created on : 30/09/2020, 23:02:55
    Author     : carlo
--%>

<%@page import="com.mycompany.proyecto2v2.Objetos.usuarioSistema"%>
<%@page import="com.mycompany.proyecto2v2.DBManage.ConsultasDB"%>
<%@page import="com.mycompany.proyecto2v2.DBManage.ConnectionDB"%>
<%@page import="com.mycompany.proyecto2v2.Objetos.Doctor"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <h5>MAYOR CANTIDAD DE REPORTES</h5>
                <h5><a href="${pageContext.request.contextPath}/usuarios/perfilDoctor.jsp">regresar al perfil</a></h5>
                <br/>
            </div>
        </header>
        <div class="container">
            <br/>
            <h5>Seleccione un intervalo de tiempo para la consulta</h5>
            <br/>
            <form method="GET" action="${pageContext.request.contextPath}/ReportesMedico">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="fechaMenor">Inicio de intervalo</label>
                        <input type="date" class="form-control" name="fechaMenor" id="fechaMenor" placeholder="Fecha">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="fechaMayor">Inicio de intervalo</label>
                        <input type="date" class="form-control" name="fechaMayor" id="fechaMayor" placeholder="Fecha">
                    </div>
                    <div class="form-group col-md-12">
                        <button class="btn btn-primary" type="submit" id="reporte" name="reporte" value="3" >Buscar</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="container">
            <%--ENCABEZADO DE LA TABLA DE LA NUESTRA DE RESULTADOS--%>
            <div class="container">
                <div class="container">
                    <h3>Pacientes:</h3>
                    <br>
                </div>
                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">Cantidad de reportes</th>
                            <th scope="col">Nombre del paciente</th>
                            <th scope="col">Codigo del paciente</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%-----ESTE DEBE SER EL BUCLE PARA LA IMPRECION DE LA INFROMACION----%> 
                    <c:forEach items="${pacientesRe}" var="paciente">
                        <tr>
                            <td>${paciente.cantidadReportes}</td>
                            <td>${paciente.nombre}</td>
                            <td>${paciente.codigo}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <footer>
            <div class="container">
                <h3>© HOSPITAL 2020</h3>

            </div>
        </footer>
    </body>
</html>
