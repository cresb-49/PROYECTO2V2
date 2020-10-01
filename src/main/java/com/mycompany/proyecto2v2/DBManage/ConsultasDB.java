package com.mycompany.proyecto2v2.DBManage;

import com.mycompany.proyecto2v2.Conversiones.ConvercionesVariables;
import com.mycompany.proyecto2v2.Objetos.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
     * @return
     */
    public usuarioSistema retornoCodigoDependiente(usuarioSistema usuario){
        String consulta="";
        if(usuario.getRol().equals("paciente")){
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
        if(usuario.getRol().equals("doctor")){
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
        if(usuario.getRol().equals("laboratorista")){
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
        if(usuario.getRol().equals("admin")){
            usuario.setCodigoEntidad(usuario.getEmail());
        }
        return usuario;
    }
}
