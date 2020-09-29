<%-- 
    Document   : editarExamen
    Created on : 28/09/2020, 14:12:03
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Examen</title>
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
        
        <div class="container">
            <br>
            <h3>Buscar Examen:</h3>
        </div>
        <div class="container">
            <br>
            <form class="form-inline" action="#">
                <label class="control-label col-md-2" for="codigoExamenBusqueda">Codigo Examen: </label>
                <div class="form-group">
                    <input class="form-control" id="codigoExamenBusqueda" type="text" name="codigoExamenBusqueda" placeholder="Codigo">
                </div>
                <div class="form-group col-md-2">
                    <button class="btn btn-primary" type="submit" name="buscar" >Buscar</button>
                </div>
            </form>
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
                                <input class="form-control" id="nombreExamen" type="text" name="nombreExamen" placeholder="Nombre Examen">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="ordenExamen">Orden: </label>
                            <div class="">
                                <select class="form-control" name="ordenExamen" id="ordenExamen">
                                    <option value="Seleccionar" selected>Seleccionar</option>
                                    <option value="TRUE">TRUE</option>
                                    <option value="FALSE">FALSE</option>
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
                                <input type="text" class="form-control" id="costoExamen" name="costoExamen">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="informeExamen">Informe: </label>
                            <div class="">
                                <select class="form-control" name="informeExamen" id="informeExamen">
                                    <option value="Seleccionar" selected>Seleccionar</option>
                                    <option value="PDF">PDF</option>
                                    <option value="IMG">IMG</option>
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
                                <textarea class="form-control" id="descripcionExamen" name="descripcionExamen"></textarea>
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
        <script src="../js/jquery-3.5.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="../js/bootstrap.min.js"></script>
    </body>
</html>
