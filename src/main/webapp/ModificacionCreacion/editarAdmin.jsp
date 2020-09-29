<%--    
    Document   : crearLaboratorista
    Created on : 28/09/2020, 14:13:46
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REGISTRAR ADMIN</title>

        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="stylesheet" href="../css/bootstrap.min.css"/>
        <link rel="stylesheet" href="../css/estilos.css"/>
    </head>
    <body>
        <header>
            <div class="container">
                <h1>HOSPITAL</h1>
                <h5>MODIFICAR ADMIN</h5>
            </div>
        </header>
        <div class="container">
            <div class="container">
                <br>
                <h3>Buscar Administrador</h3>
            </div>
            <br>
            <form class="form-inline" action="#">
                <label class="control-label col-md-2" for="codigoAdmin">Codigo Admin: </label>
                <div class="form-group">
                    <input class="form-control" id="codigoAdmin" type="text" name="codigoAdmin" placeholder="ADMINXXXX">
                </div>
                <div class="form-group col-md-2">
                    <button class="btn btn-primary" type="submit" name="buscar" >Buscar</button>
                </div>
            </form>
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
                                <input class="form-control" id="nombreAdmin" type="text" name="nombreAdmin" placeholder="Nombre">
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="DPIAdmin">DPI: </label>
                            <div class="">
                                <input class="form-control" id="DPIAdmin" type="number" name="DPIAdmin" placeholder="DPI">
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
        <script src="../js/jquery-3.5.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="../js/bootstrap.min.js"></script>
    </body>
</html>
