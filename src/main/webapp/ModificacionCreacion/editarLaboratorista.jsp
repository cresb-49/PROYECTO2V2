<%-- 
    Document   : editarLaboratorista
    Created on : 28/09/2020, 14:14:50
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Laboratorista</title>
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
            <h3>Buscar Laboratorista:</h3>
        </div>
        <div class="container">
            <br>
            <form class="form-inline" action="#">
                <label class="control-label col-md-2" for="codigoLaboratorista">Codigo Laboratorista: </label>
                <div class="form-group">
                    <input class="form-control" id="codigoLaboratorista" type="text" name="codigoLaboratorista" placeholder="LAB-XXXX">
                </div>
                <div class="form-group col-md-2">
                    <button class="btn btn-primary" type="submit" name="buscar" >Buscar</button>
                </div>
            </form>
        </div>
        <div class="container">
            <div class="container">
                <br>
                <h3>Atributos del Laboratorista:</h3>
            </div>
            <br>
            <form class="container form-group" action="" onsubmit="return validarModificacionLaboratorista();" method="POST" >
                <div class="form-row form-group">
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="numeroRegistroSalud">No. Registro de Salud: </label>
                            <div class="">
                                <input class="form-control" id="numeroRegistroSalud" type="text" name="numeroRegistroSalud" placeholder="SALUD-XXXX">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="telefonoLaboratorista">Telefono: </label>
                            <div class="">
                                <input class="form-control" id="telefonoLaboratorista" type="number" name="telefonoLaboratorista" placeholder="Telefono">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="tipoDeExamenLaboratorista">Tipo de Examen: </label>
                            <div class="">
                                <input class="form-control" id="tipoDeExamenLaboratorista" type="text" name="tipoDeExamenLaboratorista" placeholder="Nombre de Examen">
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="nameLaboratorista">Nombre Laboratorista: </label>
                            <div class="">
                                <input class="form-control" id="nameLaboratorista" type="text" name="nameLaboratorista" placeholder="Nombre Laboratorista">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="DPILaboratorista">DPI: </label>
                            <div class="">
                                <input class="form-control" id="DPILaboratorista" type="text" name="DPILaboratorista" placeholder="DPI">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="incioTrabajoLaboratorista">Inicio de labores: </label>
                            <div class="">
                                <input class="form-control" id="incioTrabajoLaboratorista" type="date" name="incioTrabajoLaboratorista" placeholder="Fecha">
                            </div>
                        </div>
                        
                    </div>
                    <div class="container form-group col-md-12">
                        <div class="form-group">
                            <label class="control-label" for="diasSemanaLab">Dias de trabajo: </label><br>
                            <select multiple="" class="form-control" name="diasSemanaLab" id="diasSemanaLab">                            

                            </select>
                        </div>
                    </div>
                    <div class="container form-group col-md-12">
                        <div class="container form-group row">
                            <div class="col-md-4">
                                <button class="form-group btn btn-danger" type="button" id="especialidadEliminar" onclick="eliminarDiaTrabajo();">Eliminar Seleccionado</button>
                            </div>
                            <div class="col-md-4">
                                <select class="form-control" name="diaTrabajoLaboratorista" id="diaTrabajoLaboratorista">                            
                                    <option value="Lunes"  >Lunes</option>
                                    <option value="Martes" >Martes</option>
                                    <option value="Miercoles" >Miercoles</option>
                                    <option value="Jueves" >Jueves</option>
                                    <option value="Martes" >Viernes</option>
                                    <option value="Viernes" >Sabado</option>
                                    <option value="Domingo" >Domingo</option>
                                </select>
                            </div>
                            <div class="col-md-4">
                                <button class="btn btn-success" type="button" id="especialidadAgregar" onclick="agregarDiaTrabajo();" >Agregar</button>
                            </div>
                        </div>
                    </div>
                    <div class="container form-group col-md-12">
                        <div class="container" >
                            <div class="form-group">
                                <button class="btn btn-danger" type="submit" name="modificar" value="Ingresar">Modificar Laboratorista</button>
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