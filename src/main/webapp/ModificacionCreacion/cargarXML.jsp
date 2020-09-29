<%-- 
    Document   : cargarXML
    Created on : 28/09/2020, 14:19:04
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cargar XML</title>
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
            <p>
            <h5>Introduza una coleccion de archivos que alimentaran el sistema</h5>
        </p>
        <form action="cargarArchivos/cargarArchivos.jsp" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input class="form-control-file" type="file" multiple="multiple" name="selecFile"/>
            </div>
            <div class="form-group">
                <input class="btn btn-success" type="submit" value="Cargar Archivo"/>
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
