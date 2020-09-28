
package com.mycompany.proyecto2v2.DBManage;

import com.mycompany.proyecto2v2.Objetos.*;
import com.mycompany.proyecto2v2.VerificarContenido.*;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *CLASE ENCARGADA DE MANEJAR EL REGISTRO DE LOS DATOS RECIBIDOS EN EL PROGRAMA EN LA BASE DE DATOS
 * @author benjamin
 */
public class RegistroDB {

    private Connection conexion;
    private VerificarContenido verificacion = new VerificarContenido();
    private ConsultasDB consulta;

    public RegistroDB(Connection conexion) {
        this.conexion = conexion;
        consulta = new ConsultasDB(conexion);
    }

    public String registroPaciente(Paciente paciente, String tipo) {
        String respuesta = "";
        String query = "";
        if (tipo.equals("exportado")) {
            query = "INSERT INTO PACIENTE (codigo,nombre,dpi,telefono,email,sexo,peso,tipo_sangre,fecha_nacimiento) VALUES (?,?,?,?,?,?,?,?,?)";
        }
        if (tipo.equals("nuevo")) {
            query = "INSERT INTO PACIENTE (nombre,dpi,telefono,email,sexo,peso,tipo_sangre,fecha_nacimiento) VALUES (?,?,?,?,?,?,?,?)";
        }
        //Asignacion de los datos de la variables
        try (PreparedStatement preSt = conexion.prepareStatement(query)) {
            //ASIGNACION DE VALORES PARA REALIZAR EL REGISTRO
            if (tipo.equals("exportado")) {
                //Verifica los datos de entrada
                this.verificacion.verificarPacienteExportado(paciente);
                preSt.setLong(1, paciente.getCodigo());
                preSt.setString(2, paciente.getNombre());
                preSt.setString(3, paciente.getDPI());
                preSt.setString(4, paciente.getTelefono());
                preSt.setString(5, paciente.getCorreo());
                preSt.setString(6, paciente.getSexo());
                preSt.setDouble(7, paciente.getPeso());
                preSt.setString(8, paciente.getSangre());
                preSt.setDate(9, paciente.getCumple());
            }
            if (tipo.equals("nuevo")) {
                //Verifica los datos de entrada
                this.verificacion.verificarPacienteCreado(paciente);
                preSt.setString(1, paciente.getNombre());
                preSt.setString(2, paciente.getDPI());
                preSt.setString(3, paciente.getTelefono());
                preSt.setString(4, paciente.getCorreo());
                preSt.setString(5, paciente.getSexo());
                preSt.setDouble(6, paciente.getPeso());
                preSt.setString(7, paciente.getSangre());
                preSt.setDate(8, paciente.getCumple());
            }
            //
            preSt.executeUpdate();
            preSt.close();
        } catch (Exception e) {
            respuesta = "Paciente: " + paciente.getCodigo() + " " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    /**
     * REALIZA EL REGISTRO DE USUARIOS PARA EL INGRESO AL SISTEMA
     *
     * @param usuario
     * @param tipo
     * @return
     */
    public String registroUsuario(Object usuario, String tipo) {
        String respuesta = "";
        String user = "";
        String password = "";
        String rol = "";
        String query = "INSERT INTO USUARIO (usuario,password,rol) VALUES (?,?,?)";
        if ((usuario instanceof Trabajador) || (usuario instanceof Paciente)) {
            try {
                if (usuario instanceof Paciente) {
                    user = ((Paciente) usuario).getCorreo();
                    password = ((Paciente) usuario).getPassword();
                    rol = "paciente";
                    if (tipo.equals("exportado")) {
                        this.verificacion.verificarPacienteExportado((Paciente) usuario);
                    }
                    if (tipo.equals("nuevo")) {
                        this.verificacion.verificarPacienteCreado((Paciente) usuario);
                    }

                }
                if (usuario instanceof Trabajador) {
                    if (usuario instanceof Admin) {
                        user = ((Admin) usuario).getCodigo();
                        this.verificacion.verificarAdmin((Admin) usuario);
                    } else {
                        user = ((Trabajador) usuario).getCorreo();
                        if (usuario instanceof Laboratorista) {
                            this.verificacion.verificarLaboratorista((Laboratorista) usuario);
                        }
                        if (usuario instanceof Doctor) {
                            this.verificacion.verificarDoctor((Doctor) usuario);
                        }
                    }
                    password = ((Trabajador) usuario).getPassword();
                    rol = ((Trabajador) usuario).getRol();
                }
                if (!consulta.existenciaDeRegistroUsuario(user)) {
                    try (PreparedStatement preSt = conexion.prepareStatement(query)) {
                        //Verificacion de los valores de usuario
                        this.verificacion.verificarUsuario(user, password, rol);
                        password = DigestUtils.md5Hex(password);
                        //ASIGNACION DE VALORES PARA REALIZAR EL REGISTRO
                        preSt.setString(1, user);
                        preSt.setString(2, password);
                        preSt.setString(3, rol);
                        //
                        preSt.executeUpdate();
                        preSt.close();
                    } catch (Exception e) {
                        respuesta = "-Usuario: " + user + " rol: " + rol + " " + e.getMessage();
                        System.out.println(respuesta);
                    }
                } else {
                    respuesta = "Usuario: " + user + " rol: " + rol + " el registro ya existe en la base de datos";
                }

            } catch (Exception e) {
                respuesta = "Usuario: " + user + " rol: " + rol + " " + e.getMessage();
                System.out.println(respuesta);
            }

        } else {
            return "El objeto que esta registrado no es un usuario";
        }
        return respuesta;
    }

    public String registroDoctor(Doctor doctor) {
        String respuesta = "";
        String query = "INSERT INTO MEDICO(codigo,dpi,email,fin_horario,inicio_horario,inicio_labores,nombre,numero_colegiado,telefono)values(?,?,?,?,?,?,?,?,?)";
        //Asignacion de los datos de la variables
        try (PreparedStatement preSt = conexion.prepareStatement(query)) {
            //Verificacion de la informacion de entrada
            this.verificacion.verificarDoctor(doctor);
            //ASIGNACION DE VALORES PARA REALIZAR EL REGISTRO
            preSt.setString(1, doctor.getCodigo());
            preSt.setString(2, doctor.getDPI());
            preSt.setString(3, doctor.getCorreo());
            preSt.setString(4, doctor.getFin().toString());
            preSt.setString(5, doctor.getInicio().toString());
            preSt.setDate(6, doctor.getInicioTrabajo());
            preSt.setString(7, doctor.getNombre());
            preSt.setString(8, doctor.getColegiado());
            preSt.setString(9, doctor.getTelefono());
            //
            preSt.executeUpdate();
            preSt.close();
            //Registro de la especialidades del doctor
            respuesta = this.registroEspecialidadDoctor(doctor);
        } catch (Exception e) {
            respuesta = "Medico: " + doctor.getNombre() + " codigo: " + doctor.getCodigo() + " " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    /**
     * REGISTRO DE ESPECIALIDAD DE DOCTOR EN BASE DE DATOS
     *
     * @param doctor
     * @return
     */
    public String registroEspecialidadDoctor(Doctor doctor) {
        String respuesta = "";
        String query = "INSERT INTO ESPECIALIDAD_MEDICO (nombre, MEDICO_codigo) values (?,?)";
        for (String especialidad : doctor.getEspecialidad()) {
            try (PreparedStatement preSt = conexion.prepareStatement(query)) {
                //ASIGNACION DE VALORES PARA REALIZAR EL REGISTRO
                preSt.setString(1, especialidad);
                preSt.setString(2, doctor.getCodigo());
                //
                preSt.executeUpdate();
                preSt.close();
            } catch (Exception e) {
                respuesta = "Medico: " + doctor.getNombre() + " codigo: " + doctor.getCodigo() + " Especialidad: " + especialidad + " " + e.getMessage();
                System.out.println(respuesta);
            }
        }
        return respuesta;
    }

    public String registroAdmin(Admin admin) {
        String respuesta = "";
        String query = "INSERT INTO ADMINISTRADOR (codigo,dpi,nombre) VALUES (?,?,?)";
        //Asignacion de los datos de la variables

        try (PreparedStatement preSt = conexion.prepareStatement(query)) {
            //VERIFICACION DE LA INFORMACION DE ENTRADA
            this.verificacion.verificarAdmin(admin);
            //ASIGNACION DE VALORES PARA REALIZAR EL REGISTRO
            preSt.setString(1, admin.getCodigo());
            preSt.setString(2, admin.getDPI());
            preSt.setString(3, admin.getNombre());
            //
            preSt.executeUpdate();
            preSt.close();
        } catch (Exception e) {
            respuesta = "Admin: " + admin.getNombre() + " codigo: " + admin.getCodigo() + e.getMessage();
            System.out.println(e.getMessage());
        }
        return respuesta;
    }

    /**
     * REGISTRO DE LOS LABORATORISTA DEL HOSPITAL
     *
     * @param laboratorista
     * @return
     */
    public String registroLaboratorista(Laboratorista laboratorista) {
        String respuesta = "";
        String query = "INSERT INTO LABORATORISTA (codigo, dpi, email, inicio_labores, nombre, numero_registro, telefono, tipo_examen) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        //Asignacion de los datos de la variables
        try (PreparedStatement preSt = conexion.prepareStatement(query)) {
            //Verificacion de la informacion de entrada
            this.verificacion.verificarLaboratorista(laboratorista);
            //ASIGNACION DE VALORES PARA REALIZAR EL REGISTRO
            preSt.setString(1, laboratorista.getCodigo());
            preSt.setString(2, laboratorista.getDPI());
            preSt.setString(3, laboratorista.getCorreo());
            preSt.setDate(4, laboratorista.getInicioTrabajo());
            preSt.setString(5, laboratorista.getNombre());
            preSt.setString(6, laboratorista.getRegistro());
            preSt.setString(7, laboratorista.getTelefono());
            preSt.setString(8, laboratorista.getExamen());
            //
            preSt.executeUpdate();
            preSt.close();
            respuesta = this.registroDiasLaboratorista(laboratorista);
        } catch (Exception e) {
            respuesta = "Laboratorista: " + laboratorista.getNombre() + " codigo: " + laboratorista.getCodigo() + " " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    /**
     * REGISTRO DE LOS DIAS DE TRABAJO DEL LABORATORISTA
     *
     * @param laboratorista
     * @return
     */
    public String registroDiasLaboratorista(Laboratorista laboratorista) {
        String respuesta = "";
        String query = "INSERT INTO DIAS_TRABAJO (dia, LABORATORISTA_codigo) values (?,?);";
        for (String dia : laboratorista.getDias()) {
            try (PreparedStatement preSt = conexion.prepareStatement(query)) {
                //ASIGNACION DE VALORES PARA REALIZAR EL REGISTRO
                preSt.setString(1, dia);
                preSt.setString(2, laboratorista.getCodigo());
                //
                preSt.executeUpdate();
                preSt.close();
            } catch (Exception e) {
                respuesta = "Laboratorista: " + laboratorista.getNombre() + " codigo: " + laboratorista.getCodigo() + " Dia: " + dia + " " + e.getMessage();
                System.out.println(respuesta);
            }
        }
        return respuesta;
    }

    /**
     * REGISTRO DE REPORTE tipo="exportado" traslado existente tipo="nuevo" de
     * nuevo ingreso
     *
     * @param reporte
     * @param tipo
     * @return
     */
    public String registroReporte(Reporte reporte, String tipo) {
        String respuesta = "";
        String query = "";
        if (tipo.equals("exportado")) {
            query = "INSERT INTO REPORTE (codigo, informe, fecha, hora, MEDICO_codigo, PACIENTE_codigo) VALUES (?,?,?,?,?,?)";
        }
        if (tipo.equals("nuevo")) {
            query = "INSERT into REPORTE (informe, fecha, hora, MEDICO_codigo, PACIENTE_codigo) VALUES (?,?,?,?,?)";
        }

        //Asignacion de los datos de la variables
        try (PreparedStatement preSt = conexion.prepareStatement(query)) {
            if (tipo.equals("exportado")) {
                //Verificacion de la informacion de entrada
                this.verificacion.verificarReporteExportado(reporte);
                //ASIGNACION DE VALORES PARA REALIZAR EL REGISTRO
                preSt.setLong(1, reporte.getCodigo());
                preSt.setString(2, reporte.getInformeMedico());
                preSt.setDate(3, reporte.getFecha());
                preSt.setString(4, reporte.getHora().toString());
                preSt.setString(5, reporte.getCodigoMedico());
                preSt.setLong(6, reporte.getCodigoPaciente());
            }
            if (tipo.equals("nuevo")) {
                //Verificacion de la informacion de entrada
                this.verificacion.verificarReporteCreado(reporte);
                //ASIGNACION DE VALORES PARA REALIZAR EL REGISTRO
                preSt.setString(1, reporte.getInformeMedico());
                preSt.setDate(2, reporte.getFecha());
                preSt.setString(3, reporte.getHora().toString());
                preSt.setString(4, reporte.getCodigoMedico());
                preSt.setLong(5, reporte.getCodigoPaciente());
            }
            //
            preSt.executeUpdate();
            preSt.close();
        } catch (Exception e) {
            respuesta = "Reporte codigo: " + reporte.getCodigo() + " " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;

    }

    public String registroCita(Cita cita, String tipo) {
        String respuesta = "";
        String query = "";
        if (tipo.equals("exportado")) {
            query = "INSERT INTO CITA (codigo, fecha, hora, MEDICO_codigo, PACIENTE_codigo, especialidad) VALUES (?,?,?,?,?,?)";
        }
        if (tipo.equals("nuevo")) {
            query = "INSERT INTO CITA (fecha, hora, MEDICO_codigo, PACIENTE_codigo, especialidad) VALUES (?,?,?,?,?)";
        }

        //Asignacion de los datos de la variables
        try (PreparedStatement preSt = conexion.prepareStatement(query)) {
            if (tipo.equals("exportado")) {
                //Verificacion de la informacion de entrada
                this.verificacion.verificarCitaEsportada(cita);
                //ASIGNACION DE VALORES PARA REALIZAR EL REGISTRO
                preSt.setLong(1, cita.getCodigo());
                preSt.setDate(2, cita.getFecha());
                preSt.setString(3, cita.getHora().toString());
                preSt.setString(4, cita.getCodigoMedico());
                preSt.setLong(5, cita.getCodigoPaciente());
                preSt.setString(6, cita.getEspecialidad());
            }
            if (tipo.equals("nuevo")) {
                //Verificacion de la informacion de entrada
                this.verificacion.verificarCitaCreada(cita);
                //ASIGNACION DE VALORES PARA REALIZAR EL REGISTRO
                preSt.setDate(1, cita.getFecha());
                preSt.setString(2, cita.getHora().toString());
                preSt.setString(3, cita.getCodigoMedico());
                preSt.setLong(4, cita.getCodigoPaciente());
                preSt.setString(5, cita.getEspecialidad());
            }
            //
            preSt.executeUpdate();
            preSt.close();
        } catch (Exception e) {
            respuesta = "Cita codigo: " + cita.getCodigo() + " Medico: " + cita.getCodigoMedico() + " " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    /**
     * REGISTRO DEL TIPO DE CONSULTAS QUE HAY EN EL HOSPITAL
     *
     * @param consulta
     * @return
     */
    public String registroConsulta(Consulta consulta) {
        String respuesta = "";
        String query = "INSERT INTO CONSULTA (nombre, costo) VALUES (?,?)";
        try (PreparedStatement preSt = conexion.prepareStatement(query)) {
            //ASIGNACION DE VALORES PARA REALIZAR EL REGISTRO
            this.verificacion.verificarConsulta(consulta);
            preSt.setString(1, consulta.getTipo());
            preSt.setDouble(2, consulta.getCosto());
            //
            preSt.executeUpdate();
            preSt.close();
        } catch (Exception e) {
            respuesta = "Consulta Nombre: " + consulta.getTipo() + " " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    /**
     * REGISTRO DEL TIPO DE EXAMENES QUE SUE PUEDEN REALIZAR EN EL HOSPITAL
     *
     * @param examen
     * @param tipo
     * @return
     */
    public String registroExamen(Examen examen, String tipo) {
        String respuesta = "";
        String query = "";
        if (tipo.equals("exportado")) {
            query = "INSERT INTO EXAMEN (codigo, nombre, orden, descripcion, costo, tipo_informe) VALUES (?,?,?,?,?,?)";
        }
        if (tipo.equals("nuevo")) {
            query = "INSERT INTO EXAMEN (nombre, orden, descripcion, costo, tipo_informe) VALUES (?,?,?,?,?)";
        }
        try (PreparedStatement preSt = conexion.prepareStatement(query)) {
            //ASIGNACION DE VALORES PARA REALIZAR EL REGISTRO
            if (tipo.equals("exportado")) {
                //Verificacion de la informacion de entrada
                this.verificacion.verificarExamenExportado(examen);
                //ASIGNACION DE VALORES PARA REALIZAR EL REGISTRO
                preSt.setLong(1, examen.getCodigo());
                preSt.setString(2, examen.getNombre());
                preSt.setBoolean(3, examen.isOrden());
                preSt.setString(4, examen.getDescripcion());
                preSt.setDouble(5, examen.getCosto());
                preSt.setString(6, examen.getInforme());
            }
            if (tipo.equals("nuevo")) {
                //Verificacion de la informacion de entrada
                this.verificacion.verificarExamenCreado(examen);
                //ASIGNACION DE VALORES PARA REALIZAR EL REGISTRO
                preSt.setString(1, examen.getNombre());
                preSt.setBoolean(2, examen.isOrden());
                preSt.setString(3, examen.getDescripcion());
                preSt.setDouble(4, examen.getCosto());
                preSt.setString(5, examen.getInforme());
            }
            //
            preSt.executeUpdate();
            preSt.close();
        } catch (Exception e) {
            respuesta = "Examen Nombre: " + examen.getNombre() + " " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    /**
     * REGISTRO DE LOS RESULTADO EMITIDOS POR EL HOSPITAL
     *
     * @param resultado
     * @param tipo
     * @return
     */
    public String registroResultado(Resultado resultado, String tipo) {
        String respuesta = "";
        String query = "";
        Examen examen = null;
        if (tipo.equals("exportado")) {
            query = "INSERT INTO RESULTADO (codigo, fecha, hora, nombre_orden, orden, nombre_informe, informe, MEDICO_codigo, LABORATORISTA_codigo, PACIENTE_codigo, EXAMEN_codigo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        }
        if (tipo.equals("nuevo")) {
            query = "INSERT INTO RESULTADO (fecha, hora, nombre_orden, orden, nombre_informe, informe, MEDICO_codigo, LABORATORISTA_codigo, PACIENTE_codigo, EXAMEN_codigo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        }
        try (PreparedStatement preSt = conexion.prepareStatement(query)) {
            //realiza la busqueda del examen de referencia en el resultado
            examen = this.consulta.obtenerExamen(resultado.getCodigoExamen().toString());
            //ASIGNACION DE VALORES PARA REALIZAR EL REGISTRO
            if (tipo.equals("exportado")) {
                //Verificacion de la informacion de entrada
                //this.verificacion.verificarResultadoExportado(resultado, examen);
                //ASIGNACION DE VALORES PARA REALIZAR EL REGISTRO
                this.verificacion.verificarResultadoExportado(resultado, examen);

                preSt.setLong(1, resultado.getCodigo());
                preSt.setDate(2, resultado.getFecha());
                preSt.setString(3, resultado.getHora().toString());
                //-----------------------------------------------

                preSt.setString(4, resultado.getNombreOrden());
                preSt.setBlob(5, resultado.getOrden().getDatos());

                //-----------------------------------------------
                preSt.setString(6, resultado.getNombreInforme());
                preSt.setBlob(7, resultado.getInforme().getDatos());
                preSt.setString(8, resultado.getCodigoMedico());
                preSt.setString(9, resultado.getCodigoLaboratorista());
                preSt.setLong(10, resultado.getCodigoPaciente());
                preSt.setLong(11, resultado.getCodigoExamen());
            }
            if (tipo.equals("nuevo")) {
                //Verificacion de la informacion de entrada
                this.verificacion.verificarResultadoCreado(resultado, examen);
                preSt.setDate(1, resultado.getFecha());
                preSt.setString(2, resultado.getHora().toString());
                preSt.setString(3, resultado.getNombreOrden());
                preSt.setBlob(4, resultado.getOrden().getDatos());
                preSt.setString(5, resultado.getNombreInforme());
                preSt.setBlob(6, resultado.getInforme().getDatos());
                preSt.setString(7, resultado.getCodigoMedico());
                preSt.setString(8, resultado.getCodigoLaboratorista());
                preSt.setLong(9, resultado.getCodigoPaciente());
                preSt.setLong(10, resultado.getCodigoExamen());
            }
            //
            preSt.executeUpdate();
            preSt.close();
        } catch (Exception e) {
            respuesta = "Resultado Codigo: " + resultado.getCodigo() + " Examen: " + resultado.getCodigoExamen() + " " + e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    /**
     * METODO DE INTROUCCION DE DATOS DEL HOSPITAL EN LA BASE DE DATOS
     *
     * @param hospital
     * @param archivos
     * @return
     * @throws java.io.FileNotFoundException
     */
    public ArrayList<String> trasladarDatosHospital(Hospital hospital, ArrayList<Archivo> archivos) throws FileNotFoundException {
        ///Buffer de resultados de cada registro
        String resultado = "";
        ArrayList<String> errores = new ArrayList<>();
        for (Admin admin : hospital.getAdmins()) {
            resultado = registroUsuario(admin, "exportado");
            if (!resultado.equals("")) {
                errores.add(resultado);
            } else {
                resultado = registroAdmin(admin);
                if (!resultado.equals("")) {
                    errores.add(resultado);
                }
            }
        }
        for (Paciente paciente : hospital.getPacientes()) {
            resultado = registroUsuario(paciente, "exportado");
            if (!resultado.equals("")) {
                errores.add(resultado);
            } else {
                resultado = registroPaciente(paciente, "exportado");
                if (!resultado.equals("")) {
                    errores.add(resultado);
                }
            }
        }
        for (Doctor doctor : hospital.getDoctores()) {
            resultado = registroUsuario(doctor, "exportado");
            if (!resultado.equals("")) {
                errores.add(resultado);
            } else {
                resultado = registroDoctor(doctor);
                if (!resultado.equals("")) {
                    errores.add(resultado);
                }
            }
        }
        for (Laboratorista lab : hospital.getLaboratoristas()) {
            resultado = registroUsuario(lab, "exportado");
            if (!resultado.equals("")) {
                errores.add(resultado);
            } else {
                resultado = registroLaboratorista(lab);
                if (!resultado.equals("")) {
                    errores.add(resultado);
                }
            }
        }
        for (Reporte reporte : hospital.getReportes()) {
            resultado = registroReporte(reporte, "exportado");
            if (!resultado.equals("")) {
                errores.add(resultado);
            }
        }
        for (Cita cita : hospital.getCitas()) {
            resultado = registroCita(cita, "exportado");
            if (!resultado.equals("")) {
                errores.add(resultado);
            }
        }
        for (Consulta consulta : hospital.getConsultas()) {
            resultado = registroConsulta(consulta);
            if (!resultado.equals("")) {
                errores.add(resultado);
            }
        }
        for (Examen examen : hospital.getExamenes()) {
            resultado = registroExamen(examen, "exportado");
            if (!resultado.equals("")) {
                errores.add(resultado);
            }
        }

        ArrayList<Archivo> docs = new ArrayList<>();
        for (Archivo file : archivos) {
            if (!file.getNombre().endsWith(".xml")) {
                docs.add(file);
            }
        }

        for (Archivo doc : docs) {
            for (Resultado res : hospital.getResultados()) {
                if (res.getNombreInforme().equals(doc.getNombre())) {
                    res.setInforme(doc);
                }
                if (res.getNombreOrden().equals(doc.getNombre())) {
                    res.setOrden(doc);
                }
            }
        }
        /*for (Resultado res : hospital.getResultados()) {
            System.out.println(res.toString());
        }*/
        for (Resultado res : hospital.getResultados()) {
            resultado = registroResultado(res, "exportado");
            if (!resultado.equals("")) {
                errores.add(resultado);
            }
        }
        System.out.println(errores.toString());
        return errores;
    }
}
