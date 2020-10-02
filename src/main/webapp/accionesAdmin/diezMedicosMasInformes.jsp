<%-- 
    Document   : diezMedicosMasInformes
    Created on : 2/10/2020, 02:08:07
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Los 10 medicos con mas informes</title>
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
                <h5>Los 10 medicos con mas informes</h5>
                <h5><a href="${pageContext.request.contextPath}/usuarios/ADMINISTRADOR.jsp" >Regresar el perfil</a></h5>
                <br/>
            </div>
        </header>
        <div class="container">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Cantidad</th>
                        <th scope="col">Nombre del Medico</th>
                        <th scope="col">Codigo del Medico</th>
                    </tr>
                <tbody>
                    <%-----ESTE DEBE SER EL BUCLE PARA LA IMPRECION DE LA INFROMACION----%>
                    <c:forEach items="${diezInfo}" var="info">
                        <tr>
                            <td>${info[0]}</td>
                            <td>${info[1]}</td>
                            <td>${info[2]}</td>
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
