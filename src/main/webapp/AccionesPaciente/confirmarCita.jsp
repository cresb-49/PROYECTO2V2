<%-- 
    Document   : confirmarCita
    Created on : 2/10/2020, 14:42:36
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmar Cita</title>
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
                <h5><a href="${pageContext.request.contextPath}/AccionesPaciente/CitaMedica.jsp" >Retornar a busqueda</a></h5>
                <br/>
            </div>
        </header>
        <div class="container">
            <form class="container form-group" action="${pageContext.request.contextPath}/ControladorCita" method="POST" onsubmit="return validarCita()" >
                <div class="form-row form-group">
                    <div class="container">
                        <br>
                        <h3>Descripcion de la Cita:</h3>
                        <br>
                    </div>
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label for="codigoDoctor" class="control-label">Codigo Doctor: </label>
                            <div class="">
                                <input class="form-control" id="codigoDoctor" type="text" name="codigoDoctor" readonly="" value="${medico}" placeholder="Codigo doctor">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="horaCita">Hora: </label>
                            <div class="">
                                <input class="form-control" id="horaCita" type="time" min="${hora1}" max="${hora2}" name="horaCita" placeholder="Hora Cita">
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="fechaCita">Fecha: </label>
                            <div class="">
                                <input class="form-control" id="fechaCita" type="date" name="fechaCita" value="${fecha}" placeholder="Fecha Cita">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="especilidadCita">Especialidad: </label>
                            <div class="">
                                <input class="form-control" id="especilidadCita" type="text" name="especilidadCita" readonly="" value="${especialidad}" placeholder="Especialidad">
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-12">
                        <div class="container" >
                            <div class="form-group">
                                <button class="btn btn-primary" type="submit" name="action" value="generarCita">Generar Cita</button>
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
