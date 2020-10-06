<%-- 
    Document   : errorCitaLabMed
    Created on : 3/10/2020, 02:39:00
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Info Cita</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css"/>
        <script src="${pageContext.request.contextPath}/js/app2.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/comportamientoPerfiles.js" ></script>
    </head>
    <body>
        <header>
            <div class="container">
                <h1>HOSPITAL</h1>
            </div>
        </header>
        <br/>
        <%
            String error = request.getParameter("errorP");
            String logro = request.getParameter("logroP");
            if (error != null) {
        %>
        <div class="container">
            <div class="alert alert-danger" role="alert">
                <%=error%>
            </div>
            <br/>
            <h5><a href="${pageContext.request.contextPath}/ReportesMedico?reporte=5" >Generar Cita</a></h5>
            <br/>
        </div>
        <%
        } else {
            if (logro != null) {
        %>
        <div class="container">
            <div class="alert alert-success" role="alert">
                <%=logro%>
            </div>
            <br/>
            <h5><a href="${pageContext.request.contextPath}/usuarios/perfilDoctor.jsp" >Regresar al perfil</a></h5>
            <br/>
        </div>
        <%
                }
            }
        %>
        <footer>
            <div class="container">
                <h3>© HOSPITAL 2020</h3>
            </div>
        </footer>
    </body>
</html>
