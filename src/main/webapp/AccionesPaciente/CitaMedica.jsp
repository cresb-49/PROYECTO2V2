<%-- 
    Document   : CitaMedica
    Created on : 28/09/2020, 12:33:53
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cita Medica</title>
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
        <form class="container form-group" action="#" method="POST" >
            <div class="form-row form-group">
                <div class="container">
                    <br>
                    <h3>Buscar Doctor:</h3>
                    <br>
                </div>
                <div class="container form-group col-md-6">
                    <div class="form-group">
                        <label for="nombreDoctor">Nombre Doctor: </label>
                        <div class="form-group">
                            <input class="form-control" id="nombreDoctor" type="text" name="nombreDoctor" placeholder="Nombre Doctor">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inicioHorarioDoctor">Inicio Horario: </label>
                        <div class="form-group">
                            <input class="form-control" id="inicioHorarioDoctor" type="time" name="inicioHorarioDoctor" placeholder="inicio horario">
                        </div>
                    </div>
                    <div class="container" >
                        <div class="form-group">
                            <button class="btn btn-success" type="submit" name="Buscar" value="Buscar">Buscar</button>
                        </div>
                    </div>
                </div>
                <div class="container form-group col-md-6">
                    <div class="form-group">
                        <label for="especialidadDoctor">Especialidad: </label>
                        <div class="form-group">
                            <input class="form-control" id="especialidadDoctor" type="text" name="especialidadDoctor" placeholder="Especialidad Doctor">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="finHorarioDoctor">Fin Horario: </label>
                        <div class="form-group">
                            <input class="form-control" id="finHorarioDoctor" type="time" name="finHorarioDoctor" placeholder="fin horario">
                        </div>
                    </div>
                </div>
            </div>            
        </form>
        <div class="container">
            <div class="container">
                <br>
                <h3>Doctores encontrados:</h3>
                <br>
            </div>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Codigo</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Inicio Horario</th>
                        <th scope="col">Fin Horario</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>MED-123</td>
                        <td>Otto Juarez</td>
                        <td>12:00:00</td>
                        <td>19:00:00</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <form class="container form-group" action="#" method="POST" >
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
                            <input class="form-control" id="codigoDoctor" type="text" name="codigoDoctor" placeholder="Codigo doctor">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="horaCita">Hora: </label>
                        <div class="">
                            <input class="form-control" id="horaCita" type="time" name="horaCita" placeholder="Hora Cita">
                        </div>
                    </div>
                    <div class="container" >
                        <div class="form-group">
                            <button class="btn btn-secondary" type="submit" name="generarCita" value="generarCita">Generar Cita</button>
                        </div>
                    </div>
                </div>
                <div class="container form-group col-md-6">
                    <div class="form-group">
                        <label class="control-label" for="fechaCita">Fecha: </label>
                        <div class="">
                            <input class="form-control" id="fechaCita" type="date" name="fechaCita" placeholder="Fecha Cita">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="especilidadCita">Especialidad: </label>
                        <div class="">
                            <input class="form-control" id="especilidadCita" type="text" name="especilidadCita" placeholder="Especialidad">
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
