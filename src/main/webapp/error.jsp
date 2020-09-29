<%-- 
    Document   : error
    Created on : 29/09/2020, 17:14:07
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AVISO DEL SISTEMA </title>
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
            String error = request.getParameter("errorP");
            String logro = request.getParameter("logroP");
            if (error != null) {
        %>
        <div class="container">
            <div class="alert alert-danger" role="alert">
                <%=error%>
            </div>
        </div>
        <%
        } else {
            if (logro != null) {
        %>
        <div class="container">
            <div class="alert alert-success" role="alert">
                <%=logro%>
            </div>
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
        <script src="../js/jquery-3.5.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="../js/bootstrap.min.js"></script>
    </body>
</html>
