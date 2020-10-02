package com.mycompany.proyecto2v2.DBManage;

import com.mycompany.proyecto2v2.Conversiones.ConvercionesVariables;
import com.mycompany.proyecto2v2.Objetos.*;
import com.mycompany.proyecto2v2.QueryObjets.QueryCita;
import com.mycompany.proyecto2v2.QueryObjets.QueryPaciente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Request;

import org.apache.commons.codec.digest.DigestUtils;

public class ConsultasDB {

    private Connection conexion;
    private ConvercionesVariables conv = new ConvercionesVariables();

    public ConsultasDB() {
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean comprobarInformacion() {
        boolean resultado = false;
        String consulta = "SELECT * FROM USUARIO LIMIT 2";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    resultado = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    /**
     * DEVULEVE EL ROL DEL USUARIO Y CONTRASENA INTRODUCIDOS
     *
     * @param usuario
     * @param password
     * @return
     */
    public usuarioSistema accesoUsuario(String usuario, String password) {
        usuarioSistema respuesta = new usuarioSistema();
        String consulta = "SELECT id,usuario,rol FROM USUARIO WHERE usuario = ? AND password = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            password = DigestUtils.md5Hex(password);
            preSt.setString(1, usuario);
            preSt.setString(2, password);
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    respuesta.setCodigoReferencia(result.getLong(1));
                    respuesta.setEmail(result.getString(2));
                    respuesta.setRol(result.getString(3));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return respuesta;
    }

    /**
     * Obtiene un examen segun codigo del mismo examen
     *
     * @param codigo
     * @return
     */
    public Examen obtenerExamen(String codigo) {
        Examen examen = null;
        String consulta = "";
        consulta = "SELECT nombre,orden,descripcion,costo,tipo_informe FROM EXAMEN WHERE codigo = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, codigo);
            try (ResultSet result = preSt.executeQuery()) {
                examen = new Examen();
                while (result.next()) {
                    examen.setCodigo(Long.parseLong(codigo));
                    examen.setNombre(result.getString(1));
                    examen.setOrden(result.getBoolean(2));
                    examen.setDescripcion(result.getString(3));
                    examen.setCosto(result.getDouble(4));
                    examen.setInforme(result.getString(5));
                }
            } catch (Exception e) {
                System.out.println("Error en busqueda de examen" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error en busqueda de examen" + e.getMessage());
        }
        return examen;
    }

    /**
     * Obtiene una consulta segun nombre de la consulta
     *
     * @param nombre
     * @return
     */
    public Consulta obtenerConsulta(String nombre) {
        Consulta consulta = null;
        String query = "";
        query = "SELECT id,nombre,costo FROM CONSULTA WHERE nombre = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(query)) {
            preSt.setString(1, nombre);
            try (ResultSet result = preSt.executeQuery()) {
                consulta = new Consulta();
                while (result.next()) {
                    consulta.setCodigo(result.getLong(1));
                    consulta.setTipo(result.getString(2));
                    consulta.setCosto(result.getDouble(3));
                }
            } catch (Exception e) {
                System.out.println("Error en busqueda de consulta" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error en busqueda de consulta" + e.getMessage());
        }
        return consulta;
    }

    /**
     * REALIZA LA BUSQUEDA DE UN ADMINISTRADOR SEGUN CODIGO DE IDENTIFICACION
     *
     * @param codigoAdmin
     * @return
     */
    public Admin retornarAdmin(String codigoAdmin) {
        Admin admin = new Admin();

        String consulta = "";
        consulta = "SELECT nombre,dpi FROM ADMINISTRADOR WHERE codigo = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, codigoAdmin);
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    admin.setCodigo(codigoAdmin);
                    admin.setNombre(result.getString(1));
                    admin.setDPI(result.getString(2));
                }
            } catch (Exception e) {
                System.out.println("Error buesqueda admin" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error buesqueda admin" + e.getMessage());
        }

        return admin;
    }

    /**
     * OBTINENE EL DOCTOR RESULTANTE DEPENDIENDO DEL CODIGO INTRODUCIDO
     *
     * @param codigoMedico
     * @return
     */
    public Doctor retornarDoctor(String codigoMedico) {
        Doctor doctor = new Doctor();
        String consulta = "";
        consulta = "SELECT nombre,dpi,telefono,numero_colegiado,inicio_horario,fin_horario,inicio_labores FROM MEDICO WHERE codigo = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, codigoMedico);
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    doctor.setCodigo(codigoMedico);
                    doctor.setNombre(result.getString(1));
                    doctor.setDPI(result.getString(2));
                    doctor.setTelefono(result.getString(3));
                    doctor.setColegiado(result.getString(4));
                    doctor.setInicio(this.conv.stringToTime(result.getString(5)));
                    doctor.setFin(this.conv.stringToTime(result.getString(6)));
                    doctor.setInicioTrabajo(result.getDate(7));
                    doctor.setEspecialidad(this.obtenerEspecialidades(codigoMedico));
                }
            } catch (Exception e) {
                System.out.println("Error buesqueda doctor" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error buesqueda doctor" + e.getMessage());
        }
        return doctor;
    }

    /**
     * OBTIENE LAS ESPECIALIDADDES DE UN MEDICO SEGUN SU CODIGO DE
     * IDENTIFICACION
     *
     * @param codigoMedico
     * @return
     */
    private ArrayList<String> obtenerEspecialidades(String codigoMedico) {
        ArrayList<String> especialidades = new ArrayList<>();
        String consulta = "";
        consulta = "SELECT nombre FROM ESPECIALIDAD_MEDICO WHERE MEDICO_codigo = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, codigoMedico);
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    especialidades.add(result.getString(1));
                }
            } catch (Exception e) {
                System.out.println("Error buesqueda especilidad medico" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error buesqueda especilidad medico" + e.getMessage());
        }
        return especialidades;
    }

    public Laboratorista retornarLaboratorista(String codigoLab) {
        Laboratorista labo = new Laboratorista();
        String consulta = "";
        consulta = "SELECT nombre,dpi,telefono,numero_registro,inicio_labores,tipo_examen FROM LABORATORISTA WHERE codigo = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, codigoLab);
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    labo.setCodigo(codigoLab);
                    labo.setNombre(result.getString(1));
                    labo.setDPI(result.getString(2));
                    labo.setTelefono(result.getString(3));
                    labo.setRegistro(result.getString(4));
                    labo.setInicioTrabajo(result.getDate(5));
                    labo.setExamen(result.getString(6));
                    labo.setDias(this.obtenerDiasTrabajo(codigoLab));
                }
            } catch (Exception e) {
                System.out.println("Error buesqueda laboratorista" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error buesqueda laboratorista" + e.getMessage());
        }
        return labo;
    }

    /**
     * RETORNA LOS DIAS DE TRABAJO DEL LABORATORISTA
     *
     * @param codigoLab
     * @return
     */
    private ArrayList<String> obtenerDiasTrabajo(String codigoLab) {
        ArrayList<String> diasTrabajo = new ArrayList<>();
        String consulta = "SELECT dia FROM DIAS_TRABAJO WHERE LABORATORISTA_codigo = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, codigoLab);
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    diasTrabajo.add(result.getString(1));
                }
            } catch (Exception e) {
                System.out.println("Error buesqueda dia Laboratorista" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error buesqueda dia Laboratorista" + e.getMessage());
        }
        return diasTrabajo;
    }

    /**
     * RETORNA UN EXAMEN SEGUN EL CODIGO DE INGRESO
     *
     * @param codigoExamen
     * @return
     */
    public Examen retornarExamen(String codigoExamen) {
        Examen examen = new Examen();
        String consulta = "";
        consulta = "SELECT nombre,orden,descripcion,costo,tipo_informe FROM EXAMEN WHERE codigo = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, codigoExamen);
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    examen.setCodigo(this.conv.stringToLong(codigoExamen));
                    examen.setNombre(result.getString(1));
                    examen.setOrden(result.getBoolean(2));
                    examen.setDescripcion(result.getString(3));
                    examen.setCosto(result.getDouble(4));
                    examen.setInforme(result.getString(5));
                }
            } catch (Exception e) {
                System.out.println("Error buesqueda examen" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error buesqueda examen" + e.getMessage());
        }
        return examen;
    }

    /**
     * RETORNA LA CONSULTA SEGUN EL NOMBRE ASIGNADO
     *
     * @param nombreConsulta
     * @return
     */
    public Consulta retornaConsulta(String nombreConsulta) {
        Consulta consulta = new Consulta();
        String query = "";
        query = "SELECT id,nombre,costo FROM CONSULTA WHERE nombre = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(query)) {
            preSt.setString(1, nombreConsulta);
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    consulta.setCodigo(result.getLong(1));
                    consulta.setTipo(result.getString(2));
                    consulta.setCosto(result.getDouble(3));
                }
            } catch (Exception e) {
                System.out.println("Error buesqueda consulta" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error buesqueda consulta" + e.getMessage());
        }
        return consulta;
    }

    /**
     * RETORNA EL PACIENTE SEGUN EL CODIGO DEL PACIENTE
     *
     * @param codigoPaciente
     * @return
     */
    public Paciente retornarPaciente(String codigoPaciente) {
        Paciente paciente = new Paciente();
        String consulta = "";
        consulta = "SELECT codigo,dpi,fecha_nacimiento,nombre,peso,sexo,telefono,tipo_sangre FROM PACIENTE WHERE codigo = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, codigoPaciente);
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    paciente.setCodigo(result.getLong(1));
                    paciente.setDPI(result.getString(2));
                    paciente.setCumple(result.getDate(3));
                    paciente.setNombre(result.getString(4));
                    paciente.setPeso(result.getDouble(5));
                    paciente.setSexo(result.getString(6));
                    paciente.setTelefono(result.getString(7));
                    paciente.setSangre(result.getString(8));
                }
            } catch (Exception e) {
                System.out.println("Error buesqueda paciente" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error buesqueda paciente" + e.getMessage());
        }

        return paciente;
    }

    /**
     * Retorna el codigo dependiente de usuario segun su usuarioSistema
     *
     * @return
     */
    public usuarioSistema retornoCodigoDependiente(usuarioSistema usuario) {
        String consulta = "";
        if (usuario.getRol().equals("paciente")) {
            consulta = "SELECT codigo FROM PACIENTE WHERE id_USUARIO = ?";
            try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
                preSt.setLong(1, usuario.getCodigoReferencia());
                try (ResultSet result = preSt.executeQuery()) {
                    while (result.next()) {
                        usuario.setCodigoEntidad(result.getString(1));
                    }
                } catch (Exception e) {
                    System.out.println("Error asigancion de codigo" + e.getMessage());
                }
            } catch (Exception e) {
                System.out.println("Error asignacion de codigo" + e.getMessage());
            }
        }
        if (usuario.getRol().equals("doctor")) {
            consulta = "SELECT codigo FROM MEDICO WHERE id_USUARIO = ?";
            try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
                preSt.setLong(1, usuario.getCodigoReferencia());
                try (ResultSet result = preSt.executeQuery()) {
                    while (result.next()) {
                        usuario.setCodigoEntidad(result.getString(1));
                    }
                } catch (Exception e) {
                    System.out.println("Error asigancion de codigo" + e.getMessage());
                }
            } catch (Exception e) {
                System.out.println("Error asignacion de codigo" + e.getMessage());
            }
        }
        if (usuario.getRol().equals("laboratorista")) {
            consulta = "SELECT codigo FROM LABORATORISTA WHERE id_USUARIO = ?";
            try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
                preSt.setLong(1, usuario.getCodigoReferencia());
                try (ResultSet result = preSt.executeQuery()) {
                    while (result.next()) {
                        usuario.setCodigoEntidad(result.getString(1));
                    }
                } catch (Exception e) {
                    System.out.println("Error asigancion de codigo" + e.getMessage());
                }
            } catch (Exception e) {
                System.out.println("Error asignacion de codigo" + e.getMessage());
            }
        }
        if (usuario.getRol().equals("admin")) {
            usuario.setCodigoEntidad(usuario.getEmail());
        }
        return usuario;
    }

    ////---------------------------------------REPORTES DE MEDICO---------------------------
    /**
     * RETORNA LAS CITAS EN UN INTERVALO DE TIEMPO DETERMINADO SEGUN EL MEDICO
     * QEU REALIZA LA CONSULTA
     *
     * @param codigoMedico
     * @param fecha1
     * @param fecha2
     * @return
     */
    public List<QueryCita> citasAgendadasIntevaloTiempo(String codigoMedico, Date fecha1, Date fecha2) {
        List<QueryCita> citas = new ArrayList<>();
        String consulta = "SELECT CITA.codigo,PACIENTE.nombre,PACIENTE.codigo,CITA.hora,CITA.especialidad FROM CITA INNER JOIN PACIENTE ON MEDICO_codigo = ? AND CITA.PACIENTE_codigo=PACIENTE.codigo AND fecha BETWEEN ? AND ? ORDER BY hora ASC";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, codigoMedico);
            preSt.setDate(2, fecha1);
            preSt.setDate(3, fecha2);

            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    citas.add(new QueryCita(result.getLong(1), result.getString(2), result.getLong(3), this.conv.stringToTime(result.getString(4)), result.getString(5)));
                }
            } catch (Exception e) {
                System.out.println("1- Error en la recuperacion de citas por medico e intevalo fechas: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("2- Error en la recuperacion de citas por medico e intevalo fechas: " + e.getMessage());
            e.printStackTrace();
        }

        return citas;
    }

    /**
     * RETORNA LAS CITAS SEGUN LA FECHA Y EL CODIGO DEL MEDICO QUIEN REALIZA LA
     * CONSULTA
     *
     * @param codigoMedico
     * @param fecha
     * @return
     */
    public List<QueryCita> citasAgendadasDia(String codigoMedico, Date fecha) {
        List<QueryCita> citas = new ArrayList<>();
        String consulta = "SELECT CITA.codigo,PACIENTE.nombre,PACIENTE.codigo,CITA.hora,CITA.especialidad FROM CITA INNER JOIN PACIENTE ON MEDICO_codigo = ? AND CITA.PACIENTE_codigo=PACIENTE.codigo AND fecha = ? ORDER BY hora ASC";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, codigoMedico);
            preSt.setDate(2, fecha);
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    citas.add(new QueryCita(result.getLong(1), result.getString(2), result.getLong(3), this.conv.stringToTime(result.getString(4)), result.getString(5)));
                }
            } catch (Exception e) {
                System.out.println("1- Error en la recuperacion de citas por medico dia en curso: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("1- Error en la recuperacion de citas por medico dia en curso: " + e.getMessage());
            e.printStackTrace();
        }

        return citas;
    }

    /**
     * RETORNA LOS PACIENTES CON MAYOR CANTIDAD DE REPORTES MEDICOS EN UN
     * INTERVALO DE TIEMPO
     *
     * @param fecha1
     * @param fecha2
     * @return
     */
    public List<QueryPaciente> pacientesConMasReportes(Date fecha1, Date fecha2) {
        List<QueryPaciente> pacientes = new ArrayList<>();
        String consulta = "SELECT COUNT(PACIENTE_codigo) AS cantidad,PACIENTE.nombre,PACIENTE.codigo FROM REPORTE INNER JOIN PACIENTE ON PACIENTE.codigo = REPORTE.PACIENTE_codigo AND REPORTE.fecha BETWEEN ? AND ? GROUP BY PACIENTE.nombre ORDER BY cantidad DESC";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setDate(1, fecha1);
            preSt.setDate(2, fecha2);
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    pacientes.add(new QueryPaciente(result.getLong(1), result.getString(2), result.getLong(3)));
                }
            } catch (Exception e) {
                System.out.println("1- Error en la recuperacion de pacientes con mas reportes: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("1- Error en la recuperacion de pacientes con mas reportes: " + e.getMessage());
            e.printStackTrace();
        }
        return pacientes;
    }

    /**
     * RETORNA LAS CITAS DE UN PACIENTE EN ESPECIFICO SEGUN SU CODIGO DE
     * IDENTIFIACION EN LA BASE DE DATOS
     *
     * @param codigoPaciente
     * @return
     */
    public List<Cita> citasPacientes(String codigoPaciente) {
        List<Cita> citas = new ArrayList<>();
        String consulta = "SELECT CITA.codigo,CITA.MEDICO_codigo,CITA.fecha,CITA.especialidad FROM CITA WHERE PACIENTE_codigo = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, codigoPaciente);
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    citas.add(new Cita(result.getLong(1), this.conv.stringToLong(codigoPaciente), result.getString(2), result.getString(4), result.getDate(3), null));
                }
            } catch (Exception e) {
                System.out.println("1- Error en la recuperacion de citas paciente: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("1- Error en la recuperacion de citas paciente: " + e.getMessage());
            e.printStackTrace();
        }
        return citas;
    }

    /**
     * RETORNO DE LOS RESULTADOS DE UN PACIENTE EN ESPECIFICO EN EL SISTEMA
     *
     * @param codigoPaciente
     * @return
     */
    public List<Resultado> resultadosPaciente(String codigoPaciente) {
        List<Resultado> resultados = new ArrayList<>();
        String consulta = "SELECT R.codigo,R.LABORATORISTA_codigo,R.MEDICO_codigo,R.EXAMEN_codigo,R.fecha,R.nombre_informe,R.informe FROM RESULTADO AS R WHERE PACIENTE_codigo =?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, codigoPaciente);
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    Resultado temp = new Resultado(result.getLong(1), this.conv.stringToLong(codigoPaciente), result.getLong(4), result.getString(3), result.getString(2), null, result.getString(6), result.getDate(5), null);
                    temp.setInforme(new Archivo(result.getString(6), result.getBinaryStream(7)));
                    resultados.add(temp);
                }
            } catch (Exception e) {
                System.out.println("1- Error en la recuperacion de resultados paciente: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("1- Error en la recuperacion de resultados paciente: " + e.getMessage());
            e.printStackTrace();
        }
        return resultados;
    }

    /////////-------------------------CONSULTAS LABORATORISTA--------------------------
    /**
     * RECUPERA LA SOLICITUDES PARA PROCESAR
     *
     * @param codigoLab
     * @return
     */
    public List<SolicitudExamen> solicitudesExamen(String codigoLab, Date fecha) {
        List<SolicitudExamen> solicitudExamen = new ArrayList<>();
        String consulta = "SELECT * FROM SOLUCITUD_EXAMEN WHERE LABORATORISTA_codigo = ? AND fecha =?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, codigoLab);
            preSt.setDate(2, fecha);
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    SolicitudExamen temp = new SolicitudExamen(result.getLong(1), result.getLong(7), result.getLong(5), result.getString(8), result.getString(6), result.getDate(4));
                    temp.setOrden(new Archivo(result.getString(2), result.getBinaryStream(3)));
                    solicitudExamen.add(temp);
                }
            } catch (Exception e) {
                System.out.println("1- Error en la recuperacion de solicitudesExamen lab: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("1- Error en la recuperacion de solicitudesExamen lab: " + e.getMessage());
            e.printStackTrace();
        }
        return solicitudExamen;
    }

    /**
     * EXAMENES PROCESADOS SEGUN EL DIA Y LABORATORISTA DE ENTRADA
     *
     * @param codigoLab
     * @param fecha
     * @return
     */
    public List<Resultado> resultadosHechos(String codigoLab, Date fecha) {
        List<Resultado> resultados = new ArrayList<>();
        String consulta = "SELECT R.codigo,R.EXAMEN_codigo,R.PACIENTE_codigo,R.hora FROM RESULTADO AS R WHERE LABORATORISTA_codigo = ? AND fecha = ? ORDER BY hora ASC";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, codigoLab);
            preSt.setDate(2, fecha);
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    resultados.add(new Resultado(result.getLong(1), result.getLong(3), result.getLong(2), null, codigoLab, null, null, fecha, this.conv.stringToTime(result.getString(4))));
                }
            } catch (Exception e) {
                System.out.println("1- Error en la recuperacion de resultadosHechos lab: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("1- Error en la recuperacion de resultadosHechos lab: " + e.getMessage());
            e.printStackTrace();
        }
        return resultados;
    }

    /**
     * LAS 10 FECHAS CON MAS TRABAJO
     *
     * @param codigoLab
     * @return
     */
    public List<String[]> cantidadResultadosHechos(String codigoLab) {
        List<String[]> cantidad = new ArrayList<>();
        String consulta = "SELECT COUNT(fecha) AS cantidad,fecha FROM RESULTADO WHERE LABORATORISTA_codigo = ? GROUP BY fecha ORDER BY cantidad DESC LIMIT 10";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, codigoLab);
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    String[] temp = {result.getString(1), result.getString(2)};
                    cantidad.add(temp);
                }
            } catch (Exception e) {
                System.out.println("1- Error en la recuperacion de resultadosHechos lab: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("1- Error en la recuperacion de resultadosHechos lab: " + e.getMessage());
            e.printStackTrace();
        }
        return cantidad;
    }

    ///-------------------------------------------------------------PACIENTE
    /**
     *
     * @param codigoPaciente
     * @param fecha1
     * @param fecha2
     * @return
     */
    public List<String[]> CantidadExamenesRealizadosEnIntervalo(String codigoPaciente, Date fecha1, Date fecha2) {
        List<String[]> resultados = new ArrayList<>();
        String consulta = "SELECT COUNT(EXAMEN_codigo) AS ex,EXAMEN.nombre FROM RESULTADO INNER JOIN EXAMEN ON RESULTADO.EXAMEN_codigo = EXAMEN.codigo AND RESULTADO.PACIENTE_codigo= ? AND RESULTADO.fecha BETWEEN ? AND ? GROUP BY EXAMEN.codigo ORDER BY ex DESC";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, codigoPaciente);
            preSt.setDate(2, fecha1);
            preSt.setDate(3, fecha2);
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    String[] temp = {result.getString(1), result.getString(2)};
                    resultados.add(temp);
                }
            } catch (Exception e) {
                System.out.println("1- Error en la recuperacion de CantidadExamenesRealizadosEnIntervalo paciente: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("1- Error en la recuperacion de CantidadExamenesRealizadosEnIntervalo paciente: " + e.getMessage());
            e.printStackTrace();
        }
        return resultados;
    }

    /**
     * RETORNO DE LOS RESULTADOS DE UN PACIENTE EN ESPECIFICO EN EL SISTEMA
     *
     * @param codigoPaciente
     * @return
     */
    public List<Resultado> ultimos5ResultadosPaciente(String codigoPaciente) {
        List<Resultado> resultados = new ArrayList<>();
        String consulta = "SELECT R.codigo,R.LABORATORISTA_codigo,R.MEDICO_codigo,R.EXAMEN_codigo,R.fecha,R.nombre_informe,R.informe FROM RESULTADO AS R WHERE PACIENTE_codigo =? ORDER BY R.fecha DESC LIMIT 5";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, codigoPaciente);
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    Resultado temp = new Resultado(result.getLong(1), this.conv.stringToLong(codigoPaciente), result.getLong(4), result.getString(3), result.getString(2), null, result.getString(6), result.getDate(5), null);
                    temp.setInforme(new Archivo(result.getString(6), result.getBinaryStream(7)));
                    resultados.add(temp);
                }
            } catch (Exception e) {
                System.out.println("1- Error en la recuperacion de resultados paciente: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("1- Error en la recuperacion de resultados paciente: " + e.getMessage());
            e.printStackTrace();
        }
        return resultados;
    }

    /**
     * RETORNA LAS CITAS DE UN PACIENTE EN ESPECIFICO SEGUN SU CODIGO DE
     * IDENTIFIACION EN LA BASE DE DATOS
     *
     * @param codigoPaciente
     * @return
     */
    public List<Cita> ultimas5CitasPacientes(String codigoPaciente) {
        List<Cita> citas = new ArrayList<>();
        String consulta = "SELECT CITA.codigo,CITA.MEDICO_codigo,CITA.fecha,CITA.especialidad FROM CITA WHERE PACIENTE_codigo = ? ORDER BY CITA.fecha DESC LIMIT 5 ";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, codigoPaciente);
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    citas.add(new Cita(result.getLong(1), this.conv.stringToLong(codigoPaciente), result.getString(2), result.getString(4), result.getDate(3), null));
                }
            } catch (Exception e) {
                System.out.println("1- Error en la recuperacion de citas paciente: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("1- Error en la recuperacion de citas paciente: " + e.getMessage());
            e.printStackTrace();
        }
        return citas;
    }

    /**
     * CONSULTAS REALIZADAS CON UN MEDICO EN ESPECIFICO EN INTERVALO DE TIMEPO
     *
     * @param codigoPaciente
     * @return
     */
    public List<String[]> consultasConMedico(String codigoPaciente, Date fecha1, Date fecha2) {
        List<String[]> cantidadconsultas = new ArrayList<>();
        String consulta = "SELECT COUNT(CITA.MEDICO_codigo),MEDICO.nombre,MEDICO.codigo FROM CITA INNER JOIN MEDICO ON CITA.MEDICO_codigo = MEDICO.codigo AND CITA.PACIENTE_codigo = ? AND CITA.fecha BETWEEN ? AND ? GROUP BY MEDICO.codigo ORDER BY CITA.fecha DESC";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, codigoPaciente);
            preSt.setDate(2, fecha1);
            preSt.setDate(3, fecha2);
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    String temp[] = {result.getString(1), result.getString(2), result.getString(3)};
                    cantidadconsultas.add(temp);
                }
            } catch (Exception e) {
                System.out.println("1- Error en la recuperacion de citas paciente: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("1- Error en la recuperacion de citas paciente: " + e.getMessage());
            e.printStackTrace();
        }
        return cantidadconsultas;
    }

    ////-------------------------------------------REPORTES DE ADMIN
    /**
     * RETORNA LOS MEDICOS CON MAS INFROMES EN EL HOSPITAL
     *
     * @return
     */
    public List<String[]> diezMedicosMasInforme() {
        List<String[]> cantidadInformes = new ArrayList<>();
        String consulta = "SELECT COUNT(MEDICO.codigo) AS cantidad ,MEDICO.nombre,MEDICO.codigo FROM MEDICO INNER JOIN REPORTE ON REPORTE.MEDICO_codigo = MEDICO.codigo GROUP BY MEDICO.codigo ORDER BY cantidad DESC LIMIT 10";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    String temp[] = {result.getString(1), result.getString(2), result.getString(3)};
                    cantidadInformes.add(temp);
                }
            } catch (Exception e) {
                System.out.println("1- Error en la recuperacion de diezMedicosMasInforme admin: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("1- Error en la recuperacion de diezMedicosMasInforme admin: " + e.getMessage());
            e.printStackTrace();
        }
        return cantidadInformes;
    }

    /**
     * LOS 5 MEDICOS CON MENOR CANTIDAD DE CITAS
     */
    public List<String[]> cincoMedicosMenorCitas() {
        List<String[]> cantidadInformes = new ArrayList<>();
        String consulta = "SELECT COUNT(CITA.MEDICO_codigo) AS C,MEDICO.codigo,MEDICO.nombre FROM MEDICO INNER JOIN CITA WHERE MEDICO.codigo = CITA.MEDICO_codigo GROUP BY MEDICO.codigo ORDER BY C ASC LIMIT 5";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    String temp[] = {result.getString(1), result.getString(2), result.getString(3)};
                    cantidadInformes.add(temp);
                }
            } catch (Exception e) {
                System.out.println("1- Error en la recuperacion de cincoMedicosMenorCitas admin: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("1- Error en la recuperacion de cincoMedicosMenorCitas admin: " + e.getMessage());
            e.printStackTrace();
        }
        return cantidadInformes;
    }

    /**
     * LOS EMDICOS QUE DEMANDAN MAS EXAMENES
     *
     * @return
     */
    public List<String[]> medicosQueDemandanMasExamenes() {
        List<String[]> cantidadInformes = new ArrayList<>();
        String consulta = "SELECT COUNT(RESULTADO.MEDICO_codigo) AS C, MEDICO.codigo,MEDICO.nombre  FROM RESULTADO INNER JOIN MEDICO ON RESULTADO.MEDICO_codigo = MEDICO.codigo GROUP BY MEDICO.codigo ORDER BY C DESC";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    String temp[] = {result.getString(1), result.getString(2), result.getString(3)};
                    cantidadInformes.add(temp);
                }
            } catch (Exception e) {
                System.out.println("1- Error en la recuperacion de medicosQueDemandanMasExamenes admin: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("1- Error en la recuperacion de medicosQueDemandanMasExamenes admin: " + e.getMessage());
            e.printStackTrace();
        }
        return cantidadInformes;
    }

    /**
     * RETORNA LOS EXAMENES MAS DEMANDADOS EN UN INTERVALO DE TIEMPO
     *
     * @param fecha1
     * @param fecha2
     * @return
     */
    public List<String[]> examenesMasDemandadosEnTiempo(Date fecha1, Date fecha2) {
        List<String[]> cantidadInformes = new ArrayList<>();
        String consulta = "SELECT COUNT(RESULTADO.EXAMEN_codigo) AS C, EXAMEN.codigo, EXAMEN.nombre FROM RESULTADO INNER JOIN EXAMEN ON RESULTADO.EXAMEN_codigo = EXAMEN.codigo AND RESULTADO.fecha BETWEEN ? AND ? GROUP BY EXAMEN.codigo ORDER BY C DESC";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setDate(1, fecha1);
            preSt.setDate(2, fecha2);
            try (ResultSet result = preSt.executeQuery()) {
                preSt.setDate(1, fecha1);
                preSt.setDate(2, fecha2);
                while (result.next()) {
                    String temp[] = {result.getString(1), result.getString(2), result.getString(3)};
                    cantidadInformes.add(temp);
                }
            } catch (Exception e) {
                System.out.println("1- Error en la recuperacion de examenesMasDemandadosEnTiempo admin: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("1- Error en la recuperacion de examenesMasDemandadosEnTiempo admin: " + e.getMessage());
            e.printStackTrace();
        }
        return cantidadInformes;
    }

    /**
     * LOS TRES EXAMENES MAS DEMANDADOS ES UN INTERVALO DE TIEMPO
     *
     * @param fecha1
     * @param fecha2
     * @return
     */
    public List<String[]> TRESexamenesMasDemandadosEnTiempo(Date fecha1, Date fecha2) {
        List<String[]> cantidadInformes = new ArrayList<>();
        String consulta = "SELECT COUNT(RESULTADO.EXAMEN_codigo) AS C, EXAMEN.codigo, EXAMEN.nombre FROM RESULTADO INNER JOIN EXAMEN ON RESULTADO.EXAMEN_codigo = EXAMEN.codigo AND RESULTADO.fecha BETWEEN ? AND ? GROUP BY EXAMEN.codigo ORDER BY C DESC LIMIT 3";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setDate(1, fecha1);
            preSt.setDate(2, fecha2);
            try (ResultSet result = preSt.executeQuery()) {
                preSt.setDate(1, fecha1);
                preSt.setDate(2, fecha2);
                while (result.next()) {
                    String temp[] = {result.getString(1), result.getString(2), result.getString(3)};
                    cantidadInformes.add(temp);
                }
            } catch (Exception e) {
                System.out.println("1- Error en la recuperacion de examenesMasDemandadosEnTiempo admin: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("1- Error en la recuperacion de examenesMasDemandadosEnTiempo admin: " + e.getMessage());
            e.printStackTrace();
        }
        return cantidadInformes;
    }

}
