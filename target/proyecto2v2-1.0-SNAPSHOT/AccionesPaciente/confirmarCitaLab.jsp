<%-- 
    Document   : confirmarCitaLab
    Created on : 2/10/2020, 17:40:18
    Author     : carlo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmar Examen</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css"/>
        <script src="${pageContext.request.contextPath}/js/app2.js"></script>
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
                <h5><a href="${pageContext.request.contextPath}/ReportesPaciente?reporte=6" >Retornar a examenes</a></h5>
                <br/>
            </div>
        </header>
        <div class="container">
            <form class="container form-group" action="${pageContext.request.contextPath}/ControladorCitaLab" method="POST" onsubmit="return validarCitaLab();" enctype="multipart/form-data">
                <div class="form-row form-group">
                    <div class="container">
                        <br>
                        <h3>Descripcion de la Cita:</h3>
                        <br>
                    </div>
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label for="codigoDoctor" class="control-label">Codigo de Examen: </label>
                            <div class="">
                                <input class="form-control" id="codigoExamen" type="text" name="codigoExamen" readonly="" value="${CodigoExamen}" placeholder="Codigo Examen">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="codigoLab">Codigo Laboratorista: </label>
                            <div class="">
                                <input class="form-control" id="codigoLab" type="text" name="codigoLab" readonly="" value="${codigoLab}" placeholder="LAB-XXX">
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="fechaCita">Fecha: </label>
                            <div class="">
                                <input class="form-control" id="fechaCita" type="date" name="fechaCita" min="${fecha}" value="${fecha}" placeholder="Fecha Cita">
                            </div>
                        </div>
                        <c:if test="${admitidoOrden == true}" >
                            <div class="form-group">
                                <label class="control-label" for="fileOrden">Suba la orden de su examen</label>
                                <div class="">
                                    <input class="form-control" id="fileOrden" type="file" name="fileOrden" required="" accept=".pdf">
                                </div>
                            </div>
                        </c:if>
                    </div>
                    <div class="container form-group col-md-12">
                        <div class="container" >
                            <div class="form-group">
                                <button class="btn btn-primary" type="submit" name="action" value="generarCitaLab">Generar Cita</button>
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
    </body>
</html>
