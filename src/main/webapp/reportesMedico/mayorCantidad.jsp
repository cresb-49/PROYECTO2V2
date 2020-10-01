<%-- 
    Document   : mayorCantidad
    Created on : 30/09/2020, 23:02:55
    Author     : carlo
--%>

<%@page import="com.mycompany.proyecto2v2.DBManage.ConsultasDB"%>
<%@page import="com.mycompany.proyecto2v2.DBManage.ConnectionDB"%>
<%@page import="com.mycompany.proyecto2v2.Objetos.Doctor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    try {
        //Doctor doc = (Doctor)session.getAttribute("USER");
        
        ConnectionDB conx = new ConnectionDB();
        ConsultasDB consulta = new ConsultasDB();
        consulta.setConexion(conx.getConexion());
        
        

    } catch (Exception e) {
        System.out.println("Error en mayor cantidad de infromes "+e.getMessage());
    }

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="stylesheet" href="../css/bootstrap.min.css"/>
        <link rel="stylesheet" href="../css/estilos.css"/>
    </head>
    <body>
        <header>
            <div class="container">
                <h1>HOSPITAL</h1>
                <h5>MAYOR CANTIDAD DE REPORTES</h5>
                <br/>
            </div>
        </header>
        <div class="container">
            <%--ENCABEZADO DE LA TABLA DE LA NUESTRA DE RESULTADOS--%>
            <div class="container">
                <div class="container">
                    <br>
                    <h3>Pacientes:</h3>
                    <br>
                </div>
                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Codigo</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Dia</th>
                            <th scope="col">Codigo Medico</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        %>
                        <tr>
                            <th scope="row">1</th>
                            <td>MED-123</td>
                            <td>Otto Juarez</td>
                            <td>12:00:00</td>
                            <td>19:00:00</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <footer>
            <div class="container">
                <h3>© HOSPITAL 2020</h3>

            </div>
        </footer>
        <script src="../js/jquery-3.5.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/comportamientoPerfiles.js" ></script>
    </body>
</html>
