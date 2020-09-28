<%-- 
    Document   : CitaLaboratorio
    Created on : 28/09/2020, 12:33:53
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cita Laboratorio</title>
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
                    <h3>Buscar Examen:</h3>
                    <br>
                </div>
                <div class="container form-group col-md-6">
                    <div class="form-group">
                        <label for="nombreDoctor">Nombre Doctor: </label>
                        <div class="form-group">
                            <input class="form-control" id="codeDoctor" type="text" name="nombreDoctorText" placeholder="Nombre Doctor">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inicioHorarioDoctor">Inicio Horario: </label>
                        <div class="form-group">
                            <input class="form-control" id="codeDoctor" type="time" name="inicioHorarioDoctorText" placeholder="inicio horario">
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
                            <input class="form-control" id="codeDoctor" type="text" name="especialidadDoctorText" placeholder="Especialidad Doctor">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="finHorarioDoctor">Fin Horario: </label>
                        <div class="form-group">
                            <input class="form-control" id="codeDoctor" type="time" name="finHorarioDoctorText" placeholder="fin horario">
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
                        <label for="codeDoctor" class="control-label">Codigo Doctor: </label>
                        <div class="">
                            <input class="form-control" id="codeDoctor" type="text" name="codeDoctorText" placeholder="codigo doctor">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="coleDoctor">Hora: </label>
                        <div class="">
                            <input class="form-control" id="coleDoctor" type="text" name="coleDoctorText" placeholder="No. Colegiado">
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
                        <label class="control-label" for="nameDoctor">Fecha: </label>
                        <div class="">
                            <input class="form-control" id="nameDoctor" type="text" name="nameDoctorText" placeholder="Nombre doctor">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="DPIDoctor">Especialidad: </label>
                        <div class="">
                            <input class="form-control" id="DPIDoctor" type="text" name="DPIDoctorText" placeholder="DPI">
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
