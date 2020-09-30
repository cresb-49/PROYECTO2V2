package com.mycompany.proyecto2v2.DBManage;
import com.mycompany.proyecto2v2.Objetos.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DuplicidadDB {

    private Connection conexion;
    /**
     * CONSTRUCTOR VACIO
     */
    public DuplicidadDB() {

    }

    /**
     * Asigna la conexion
     *
     * @param conexion
     */
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * VERIFICA SI EXISTE UN YA EXISTE UN USUARIO EN LA BASE DE DATOS ,true = si
     * existe, false = no existe
     *
     * @param usuario
     * @return
     */
    public boolean existenciaDeRegistroUsuario(String usuario) {
        boolean respuesta = false;
        String consulta = "SELECT rol FROM USUARIO WHERE usuario = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, usuario);
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    respuesta = true;
                }
            } catch (Exception e) {
                System.out.println("Duplicidad usuario t1 " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Duplicidad usuario t2 " + e.getMessage());
        }
        return respuesta;
    }

    /**
     * VERIFICA SI EXISTE UN YA EXISTE UN USUARIO EN LA BASE DE DATOS ,true = si
     * existe, false = no existe
     *
     * @param codigo
     * @param dpi
     * @param email
     * @param telefono
     * @return
     */
    public String existenciaDePaciente(Paciente paciente) {
        String consulta = "SELECT * FROM PACIENTE WHERE codigo = ?";
        if (paciente.getCodigo() != null) {
            try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
                preSt.setLong(1, paciente.getCodigo());
                try (ResultSet result = preSt.executeQuery()) {
                    while (result.next()) {
                        return "Existe un paciente con el mismo codigo de referencia en la base de datos";
                    }
                } catch (Exception e) {
                    System.out.println("Duplicidad codigo paciente " + e.getMessage());
                }
            } catch (Exception e) {
                System.out.println("Duplicidad codigo paciente 2 " + e.getMessage());
            }
        }
        consulta = "SELECT * FROM PACIENTE WHERE dpi = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, paciente.getDPI());
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    return "Existe un paciente con el mismo DPI en la base de datos";
                }
            } catch (Exception e) {
                System.out.println("Duplicidad paciente dpi " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Duplicidad paciente dpi 2" + e.getMessage());
        }
        consulta = "SELECT * FROM PACIENTE WHERE email = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, paciente.getEmail());
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    return "Existe un paciente con el mismo email en la base de datos";
                }
            } catch (Exception e) {
                System.out.println("Duplicidad paciente email " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Duplicidad paciente email 2 " + e.getMessage());
        }
        consulta = "SELECT * FROM PACIENTE WHERE telefono = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, paciente.getTelefono());
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    return "Existe un paciente con el mismo telefono en la base de datos";
                }
            } catch (Exception e) {
                System.out.println("Duplicidad paceinte telefono " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Duplicidad paceinte telefono2 " + e.getMessage());
        }
        return "";
    }

    public String existenciaDoctor(Doctor doc) {
        String consulta = "";
        ///////////////////////////////////////////////////////////////////////
        consulta = "SELECT * MEDICO WHERE codigo=?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, doc.getCodigo());
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    return "Existe un medico con el mismo codigo de referencia en la base de datos";
                }
            } catch (Exception e) {
                System.out.println("Duplicidad codigo doctor " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Duplicidad codigo doctor 2 " + e.getMessage());
        }
        ///////////////////////////////////////////////////////////////////////
        consulta = "SELECT * MEDICO WHERE dpi=?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, doc.getDPI());
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    return "Existe un medico con el mismo codigo de referencia en la base de datos";
                }
            } catch (Exception e) {
                System.out.println("Duplicidad dpi doctor " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Duplicidad dpi doctor 2 " + e.getMessage());
        }
        consulta = "SELECT * MEDICO WHERE numero_colegiado=?";
        ///////////////////////////////////////////////////////////////////////
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, doc.getDPI());
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    return "Existe un medico con el mismo numero de colegiado en la base de datos";
                }
            } catch (Exception e) {
                System.out.println("Duplicidad dpi doctor " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Duplicidad dpi doctor 2 " + e.getMessage());
        }
        ///////////////////////////////////////////////////////////////////////
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, doc.getDPI());
            try (ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                    return "Existe un medico con el mismo codigo de referencia en la base de datos";
                }
            } catch (Exception e) {
                System.out.println("Duplicidad dpi doctor " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Duplicidad dpi doctor 2 " + e.getMessage());
        }
        return "";
    }
}
