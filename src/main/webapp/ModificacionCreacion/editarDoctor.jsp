<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EDITAR DOCTOR</title>
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
            <h3>Buscar Doctor:</h3>
        </div>
        <div class="container">
            <br>
            <form class="form-inline" action="#">
                <label class="control-label col-md-2" for="codeDoctor">Codigo Doctor: </label>
                <div class="form-group">
                    <input class="form-control" id="codeDoctor" type="text" name="codeDoctorText" placeholder="MED-XXXX">
                </div>
                <div class="form-group col-md-2">
                    <button class="btn btn-primary" type="submit" name="buscar" >Buscar</button>
                </div>
            </form>
        </div>
        <div class="container">
            <br>
            <h3>Atributos:</h3>
        </div>

        <div class="container">
            <br>
            <form class="container form-group" action="" onsubmit="return validarModificaionMedico()" method="POST" >
                <div class="form-row form-group">
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="coleDoctor">No. Colegiado: </label>
                            <div class="">
                                <input class="form-control" id="coleDoctor" type="text" name="coleDoctorText" placeholder="No. Colegiado">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="telDoctor">Telefono: </label>
                            <div class="">
                                <input class="form-control" id="telDoctor" type="text" name="telDoctorText" placeholder="Telefono">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label">Horario:</label>
                            <div class="form-inline">
                                <label for="inicioDoctor">Inicio: </label>
                                <div class="">
                                    <input class="form-control" id="inicioDoctor" type="time" name="inicioDoctorText" placeholder="HH:mm">
                                </div>
                                <label for="finDoctor">Fin: </label>
                                <div class="">
                                    <input class="form-control" id="finDoctor" type="time" name="finDoctorText" placeholder="HH:mm">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="nameDoctor">Nombre Doctor: </label>
                            <div class="">
                                <input class="form-control" id="nameDoctor" type="text" name="nameDoctorText" placeholder="Nombre doctor">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="DPIDoctor">DPI: </label>
                            <div class="">
                                <input class="form-control" id="DPIDoctor" type="text" name="DPIDoctorText" placeholder="DPI">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="incioTrabajo">Inicio de labores: </label>
                            <div class="">
                                <input class="form-control" id="incioTrabajo" type="date" name="incioTrabajo" placeholder="Fecha">
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-12">
                        <div class="form-group">
                            <label class="control-label" for="espeDoctor">Especialidad: </label><br>
                            <select multiple="multiple" class="form-control" name="espeDoctor" id="espeDoctor">                            
                            </select>
                        </div>
                    </div>
                    <div class="container form-group col-md-12">
                        <div class="container form-group row">
                            <div class="col-md-4">
                                <button class="form-group btn btn-danger" type="button" id="especialidadEliminar" onclick="eliminarEspecialidad();">Eliminar Seleccionado</button>
                            </div>
                            <div class="col-md-4">
                                <input class="form-control" type="text" id="ingresoEspecialidad" placeholder="Especialidad a agregar"/>
                            </div>
                            <div class="col-md-4">
                                <button class="btn btn-success" type="button" id="especialidadAgregar" onclick="agregarEspecialidad();" >Agregar</button>
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-12">
                        <div class="container" >
                            <div class="form-group">
                                <button class="btn btn-danger" type="submit" name="modificar" value="Ingresar">Modificar el Doctor</button>
                            </div>
                        </div>
                    </div>
                </div>            
            </form>
        </div>
        <br>
        <%
            String codigoDoc = request.getParameter("codeDoctor");
            System.out.println(codigoDoc);
            String[] valores = request.getParameterValues("espeDoctor");
            if (valores != null) {
                for (String var : valores) {
                    System.out.println(var);
                }
            }

        %>
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
