<%-- 
    Document   : proExamen
    Created on : 3/10/2020, 00:55:04
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Procesar Examen</title>
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
                <h5><a href="${pageContext.request.contextPath}/Lab/examenesProcesar.jsp">Regresar a Solicitudes</a></h5>
            </div>
        </header>


        <form class="container form-group" action="${pageContext.request.contextPath}/ProcesarExamen" method="POST" enctype="multipart/form-data">
            <div class="form-row form-group">
                <div class="container">
                    <br>
                    <h3>Descripcion de la solicitud:</h3>
                    <br>
                </div>
                <div class="container form-group col-md-6">
                    <div class="form-group">
                        <label for="codigoSolicitud">Codigo Solicitud: </label>
                        <div class="form-group">
                            <input class="form-control" id="codigoSolicitud" type="text" name="codigoSolicitud" value="${codeSolicitud}" placeholder="Codigo Solicitud" readonly="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="horaProcesado">Hora de procesado: </label>
                        <div class="form-group">
                            <input class="form-control" id="horaProcesado" type="time" name="horaProcesado" placeholder="Horario Procesado" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="diaProceso">Dia de procesado: </label>
                        <div class="form-group">
                            <input class="form-control" id="diaProceso" min="${fechaSolicitud}" type="date" name="diaProceso" placeholder="Dia Proceso">
                        </div>
                    </div>
                </div>
                <div class="container form-group col-md-6">
                    <div class="form-group">
                        <label for="codigoExamen">Codigo Examen: </label>
                        <div class="form-group">
                            <input class="form-control" id="codigoExamen" type="text" name="codigoExamen" placeholder="Codigo Examen" value="${codeExamen}" readonly="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="nombreExamen">Nombre Examen: </label>
                        <div class="form-group">
                            <input class="form-control" id="nombreExamen" type="text" name="nombreExamen" placeholder="Nombre Examen" value="${nomExamen}" readonly="">
                        </div>
                    </div>

                </div>
                <div class="container form-group col-12">
                    <label for="informeExamen">Archivo del Reporte: </label>
                    <div class="container" >
                        <div class="form-group">
                            <input class="form-control" type="file" name="informeExamen" id="informeExamen" required="" accept="${formato}" />
                        </div>
                    </div>
                </div>
                <div class="container form-group col-12">
                    <div class="container" >
                        <div class="form-group">
                            <button class="btn btn-success" type="submit" name="reporte" value="5">Registar</button>
                        </div>
                    </div>
                </div>
            </div>            
        </form>

        <footer>
            <div class="container">
                <h3>© HOSPITAL 2020</h3>
            </div>
        </footer>
    </body>
</html>
