<%-- 
    Document   : editarExamen
    Created on : 28/09/2020, 14:12:03
    Author     : carlo
--%>

<%@page import="com.mycompany.proyecto2v2.DBManage.ModificacionDB"%>
<%@page import="com.mycompany.proyecto2v2.Conversiones.ConvercionesVariables"%>
<%@page import="com.mycompany.proyecto2v2.Objetos.Examen"%>
<%@page import="com.mycompany.proyecto2v2.DBManage.ConsultasDB"%>
<%@page import="com.mycompany.proyecto2v2.DBManage.ConnectionDB"%>
<%@page import="com.mycompany.proyecto2v2.DBManage.ConnectionDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Examen</title>
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
                <h5><a href="${pageContext.request.contextPath}/usuarios/ADMINISTRADOR.jsp" >Regresar el perfil</a></h5>
                <br/>
            </div>
        </header>

        <div class="container">
            <br>
            <h3>Buscar Examen:</h3>
        </div>
        <div class="container">
            <br>
            <form class="form-inline" action="" method="POST">
                <label class="control-label col-md-2" for="codigoExamenBusqueda">Codigo Examen: </label>
                <div class="form-group">
                    <input class="form-control" id="codigoExamenBusqueda" type="text" name="codigoExamenBusqueda" placeholder="Codigo">
                </div>
                <div class="form-group col-md-2">
                    <button class="btn btn-primary" type="submit" name="buscar" >Buscar</button>
                </div>
            </form>
            <br/>
            <%
                String codigoBusqueda = request.getParameter("codigoExamenBusqueda");
                Examen modExamen = new Examen();
                if (codigoBusqueda != null && codigoBusqueda != "") {
                    ConnectionDB cnx = new ConnectionDB();
                    ConsultasDB consulta = new ConsultasDB();
                    consulta.setConexion(cnx.getConexion());
                    modExamen = consulta.retornarExamen(codigoBusqueda);

                    if (modExamen.getCodigo() != null) {
                        System.out.println("Examen rescatado: " + modExamen.toString());
                        session.setAttribute("MODEXAMEN", modExamen);
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
                <h3>Datos examen:</h3>
            </div>
            <br>
            <form class="container form-group" action="" onsubmit="return validarModificacionExamen();" method="POST" >
                <div class="form-row form-group">
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="nombreExamen">Nombre Examen: </label>
                            <div class="">
                                <%
                                    if (modExamen.getNombre() != null) {
                                %>
                                <input class="form-control" id="nombreExamen" type="text" name="nombreExamen" placeholder="Nombre Examen" value="<%out.print(modExamen.getNombre());%>">
                                <%
                                } else {
                                %>
                                <input class="form-control" id="nombreExamen" type="text" name="nombreExamen" placeholder="Nombre Examen">
                                <%
                                    }
                                %>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="ordenExamen">Orden: </label>
                            <div class="">
                                <select class="form-control" name="ordenExamen" id="ordenExamen">
                                    <%
                                        if (modExamen.isOrden() != null) {
                                            if (modExamen.isOrden() == true) {
                                    %>
                                    <option value="Seleccionar" >Seleccionar</option>
                                    <option value="TRUE" selected>TRUE</option>
                                    <option value="FALSE">FALSE</option>
                                    <%
                                        }
                                        if (modExamen.isOrden() == false) {
                                    %>
                                    <option value="Seleccionar" >Seleccionar</option>
                                    <option value="TRUE">TRUE</option>
                                    <option value="FALSE" selected>FALSE</option>
                                    <%
                                    } else {
                                    %>
                                    <option value="Seleccionar" selected>Seleccionar</option>
                                    <option value="TRUE">TRUE</option>
                                    <option value="FALSE">FALSE</option>
                                    <%
                                        }
                                    } else {
                                    %>
                                    <option value="Seleccionar" selected>Seleccionar</option>
                                    <option value="TRUE">TRUE</option>
                                    <option value="FALSE">FALSE</option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label for="costoExamen" class="control-label">Costo Examen: </label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">Q</span>
                                    <span class="input-group-text">0.00</span>
                                </div>
                                <%
                                    if (modExamen.getCosto() != null) {
                                %>
                                <input type="text" class="form-control" id="costoExamen" name="costoExamen" value="<%out.print(modExamen.getCosto());%>">
                                <%
                                } else {
                                %>
                                <input type="text" class="form-control" id="costoExamen" name="costoExamen">
                                <%
                                    }
                                %>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="informeExamen">Informe: </label>
                            <div class="">
                                <select class="form-control" name="informeExamen" id="informeExamen">
                                    <%
                                        if (modExamen.getInforme() != null) {
                                            switch (modExamen.getInforme()) {
                                                case "PDF":
                                    %>
                                    <option value="Seleccionar" >Seleccionar</option>
                                    <option value="PDF" selected>PDF</option>
                                    <option value="IMG">IMG</option>
                                    <%
                                            break;
                                        case "IMG":
                                    %>
                                    <option value="Seleccionar" >Seleccionar</option>
                                    <option value="PDF">PDF</option>
                                    <option value="IMG" selected>IMG</option>
                                    <%
                                            break;
                                        default:
                                    %>
                                    <option value="Seleccionar" selected>Seleccionar</option>
                                    <option value="PDF">PDF</option>
                                    <option value="IMG">IMG</option>
                                    <%
                                                break;
                                        }
                                    } else {
                                    %>
                                    <option value="Seleccionar" selected>Seleccionar</option>
                                    <option value="PDF">PDF</option>
                                    <option value="IMG">IMG</option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-12">
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">Descripcion</span>
                                </div>
                                <%
                                    if (modExamen.getDescripcion() != null) {
                                %>
                                <textarea class="form-control" id="descripcionExamen" name="descripcionExamen"><%out.print(modExamen.getDescripcion());%></textarea>
                                <%
                                } else {
                                %>
                                <textarea class="form-control" id="descripcionExamen" name="descripcionExamen"></textarea>
                                <%
                                    }
                                %>
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-12">
                        <div class="container" >
                            <div class="form-group">
                                <button class="btn btn-danger" type="submit" name="modificar" value="Ingresar">Modificar Examen</button>
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
        <script src="../js/jquery-3.5.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="../js/bootstrap.min.js"></script>
    </body>
</html>





<%
    String nombre = request.getParameter("nombreExamen");
    String orden = request.getParameter("ordenExamen");
    String descripcion = request.getParameter("descripcionExamen");
    String costo = request.getParameter("costoExamen");
    String informe = request.getParameter("informeExamen");

    if (nombre != null) {
        ConvercionesVariables conv = new ConvercionesVariables();
        Examen tempExamen = (Examen) session.getAttribute("MODEXAMEN");
        tempExamen.setNombre(nombre);
        tempExamen.setOrden(conv.stringToBoolean(orden));
        tempExamen.setDescripcion(descripcion);
        tempExamen.setCosto(conv.stringToDouble(costo));
        tempExamen.setInforme(conv.ajusteFormatos(informe));

        System.out.println("Examen Modificado: " + tempExamen.toString());
        try {
            //VARIBLES DE CONEXION A BASE DE DATOS
            ConnectionDB cnx = new ConnectionDB();
            ModificacionDB modificar = new ModificacionDB();
            modificar.setConexion(cnx.getConexion());
            String respuesta = modificar.modificarExamen(tempExamen);
            if (respuesta.equals("")) {
                request.getRequestDispatcher("../error.jsp?logroP=Se modifico con exito el examen en el sistema").forward(request, response);
            } else {
                request.getRequestDispatcher("../error.jsp?errorP=" + respuesta).forward(request, response);
            }
            cnx.cerrarConexion();
        } catch (Exception e) {
            request.getRequestDispatcher("../error.jsp?errorP=" + e.getMessage()).forward(request, response);
        }

    }
%>