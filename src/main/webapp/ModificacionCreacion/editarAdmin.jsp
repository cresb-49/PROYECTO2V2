<%--    
    Document   : crearLaboratorista
    Created on : 28/09/2020, 14:13:46
    Author     : carlo
--%>

<%@page import="com.mycompany.proyecto2v2.Objetos.Admin"%>
<%@page import="com.mycompany.proyecto2v2.DBManage.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REGISTRAR ADMIN</title>
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
                <h5>MODIFICAR ADMIN</h5>
                <h5><a href="${pageContext.request.contextPath}/usuarios/ADMINISTRADOR.jsp" >Regresar el perfil</a></h5>
                <br/>
            </div>
        </header>
        <div class="container">
            <div class="container">
                <br>
                <h3>Buscar Administrador</h3>
            </div>
            <br>
            <form class="form-inline" action="" method="POST">
                <label class="control-label col-md-2" for="codigoAdmin">Codigo Admin: </label>
                <div class="form-group">
                    <input class="form-control" id="codigoAdmin" type="text" name="codigoAdmin" placeholder="ADMINXXXX">
                </div>
                <div class="form-group col-md-2">
                    <button class="btn btn-primary" type="submit" name="buscar" >Buscar</button>
                </div>
            </form>
            <br/>
            <%
                String codigoAdmin = request.getParameter("codigoAdmin");
                Admin modAdmin = null;
                if (codigoAdmin != null || codigoAdmin != "") {
                    ConnectionDB cnx = new ConnectionDB();
                    ConsultasDB consulta = new ConsultasDB();
                    consulta.setConexion(cnx.getConexion());
                    modAdmin = consulta.retornarAdmin(codigoAdmin);
                    if (modAdmin.getCodigo() != null) {
                        System.out.println("Admin rescatado: " + modAdmin.toString());
                        session.setAttribute("MODADMIN", modAdmin);
                    } else {
            %>
            <div class="alert alert-danger" role="alert">
                No hay ningun resultado de la busqueda
            </div>
            <%
                }
            } else {
            %>
            <div class="alert alert-danger" role="alert">
                Debe de introducir un codigo para la busqueda
            </div>
            <%
                }
            %>
        </div>
        <div class="container">
            <div class="container">
                <br>
                <h3>Informacion del admin</h3>
            </div>
            <br>
            <form class="container form-group" action="" onsubmit="return validarModificacionAdmin();" method="POST" >
                <div class="form-row form-group">
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label for="nombreAdmin" class="control-label">Nombre Administrador: </label>
                            <div class="">
                                <%
                                    if (modAdmin.getNombre() != null) {
                                %>
                                <input class="form-control" id="nombreAdmin" type="text" name="nombreAdmin" placeholder="Nombre" value="<% out.print(modAdmin.getNombre()); %>">
                                <%
                                } else {
                                %>
                                <input class="form-control" id="nombreAdmin" type="text" name="nombreAdmin" placeholder="Nombre">
                                <%
                                    }
                                %>

                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="DPIAdmin">DPI: </label>
                            <div class="">
                                <%
                                    if (modAdmin.getDPI() != null) {
                                %>
                                <input class="form-control" id="DPIAdmin" type="number" name="DPIAdmin" placeholder="DPI" value="<%out.print(modAdmin.getDPI());%>">
                                <%
                                } else {
                                %>
                                <input class="form-control" id="DPIAdmin" type="number" name="DPIAdmin" placeholder="DPI">
                                <%
                                    }
                                %>
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-12">
                        <div class="container" >
                            <div class="form-group">
                                <button class="btn btn-danger" type="submit" name="modificar" value="Ingresar">Modificar Admin</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <footer>
            <div class="container">
                <h3>© HOSPITAL 2020</h3>
            </div>
        </footer>
        <script src="../js/app2.js"></script>
    </body>
</html>




<%
    String nombreAdmin = request.getParameter("nombreAdmin");
    String DPIAdmin = request.getParameter("DPIAdmin");

    if (nombreAdmin != null && DPIAdmin != null) {
        Admin tempAdmin = (Admin) session.getAttribute("MODADMIN");
        session.removeAttribute("MODADMIN");
        tempAdmin.setNombre(nombreAdmin);
        tempAdmin.setDPI(DPIAdmin);
        System.out.println("Admin Modificado: " + tempAdmin.toString());
        try {
            //VARIBLES DE CONEXION A BASE DE DATOS
            ConnectionDB cnx = new ConnectionDB();
            ModificacionDB modificar = new ModificacionDB();
            modificar.setConexion(cnx.getConexion());
            String respuesta = modificar.modificarAdmin(tempAdmin);
            if (respuesta.equals("")) {
                request.getRequestDispatcher("../error.jsp?logroP=Se modifico con exito el administrador al sistema").forward(request, response);
            } else {
                request.getRequestDispatcher("../error.jsp?errorP=" + respuesta).forward(request, response);
            }
            cnx.cerrarConexion();
        } catch (Exception e) {
            request.getRequestDispatcher("../error.jsp?errorP=" + e.getMessage()).forward(request, response);
        }
    }
%>