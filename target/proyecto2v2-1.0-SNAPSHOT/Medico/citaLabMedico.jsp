<%-- 
    Document   : citaLabMedico
    Created on : 3/10/2020, 02:30:00
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitar Examen Lab</title>
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
            <div class="container">
                <br>
                <h3>Examenes Dispopnibles:</h3>
                <br>
            </div>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Codigo</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Descripcion</th>
                        <th scope="col">Costo</th>
                        <th scope="col">Tipo Informe</th>
                        <th scope="col">Generar Cita</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${examenes}" var="exam">
                    <tr>
                        <td>${exam.codigo}</td>
                        <td>${exam.nombre}</td>
                        <td>${exam.descripcion}</td>
                        <td>${exam.costo}</td>
                        <td>${exam.informe}</td>
                        <td><a href="${pageContext.request.contextPath}/ControladorCitaLabMed?codigo=${exam.codigo}&">Gererar Cita</a></td>
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
