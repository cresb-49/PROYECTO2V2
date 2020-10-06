<%-- 
    Document   : informesCitas
    Created on : 3/10/2020, 22:15:25
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informes Citas</title>
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

        <div class="container">
            <div class="container">
                <br>
                <h3>Doctores encontrados:</h3>
                <br>
            </div>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Codigo Resultado</th>
                        <th scope="col">Fecha</th>
                        <th scope="col">Medico</th>
                        <th scope="col">Informe</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${reportesCitas}" var="resul">
                    <tr>
                        <td>${resul.codigo}</td>
                        <td>${resul.fecha}</td>
                        <td>${resul.codigoMedico}</td>
                        <td>${resul.informeMedico}</td>
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
