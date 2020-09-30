<%-- 
    Document   : modificarConsulta
    Created on : 29/09/2020, 19:53:31
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                <h5>REGISTRAR TIPO DE CONSULTA</h5>
                <br/>
            </div>
        </header>
        <div class="container">
            <div class="container">
                <br>
                <h3>MODIFICACION CONSULTA</h3>
            </div>
            <div class="container">
                <div class="container">
                    <br>
                    <h3>BUSCAR CONSULTA</h3>
                </div>
                <br>
                <form class="form-inline" action="#">
                    <label class="control-label col-md-2" for="nombreConsultaBusqueda">Nombre Consulta: </label>
                    <div class="form-group">
                        <input class="form-control" id="nombreConsultaBusqueda" type="text" name="nombreConsultaBusqueda" placeholder="Nombre Consulta">
                    </div>
                    <div class="form-group col-md-2">
                        <button class="btn btn-primary" type="submit" name="buscar" >Buscar</button>
                    </div>
                </form>
                <br/>
            </div>
            <form class="container form-group" action="" onsubmit="return validarRegistroconsulta();" method="POST" >
                <div class="container">
                    <br>
                    <h3>Datos de la consulta</h3>
                    <br/>
                </div>
                <div class="form-row form-group">
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label for="nombreConsulta" class="control-label">Nombre Paciente: </label>
                            <div class="">
                                <input class="form-control" id="nombreConsulta" type="text" name="nombreConsulta" placeholder="Nombre Consulta">
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-6">
                        <label for="costoConsulta" class="control-label">Costo Consulta: </label>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Q</span>
                                <span class="input-group-text">0.00</span>
                            </div>
                            <input type="text" class="form-control" id="costoConsulta" name="costoConsulta">
                        </div>
                    </div>
                    <div class="container form-group col-md-12">
                        <div class="container" >
                            <div class="form-group">
                                <button class="btn btn-danger" type="submit" name="modificar" value="Ingresar">Modificar Consulta</button>
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
        <script src="../js/app.js"></script>
        <script src="../js/jquery-3.5.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="../js/bootstrap.min.js"></script>
    </body>
</html>
