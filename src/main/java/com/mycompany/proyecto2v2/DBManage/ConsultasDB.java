package com.mycompany.proyecto2v2.DBManage;

import com.mycompany.proyecto2v2.Objetos.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.commons.codec.digest.DigestUtils;

public class ConsultasDB {
    Connection conexion;
    public ConsultasDB(Connection conexion){
        this.conexion=conexion;
    }
    public ConsultasDB(){
        
    }
    public boolean comprobarInformacion(){
        boolean resultado= false;
        String consulta = "SELECT * FROM USUARIO LIMIT 2";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            try (ResultSet result = preSt.executeQuery()){
                while (result.next()) {
                resultado=true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    /**
     * DEVULEVE EL ROL DEL USUARIO Y CONTRASENA INTRODUCIDOS
     * @param usuario
     * @param password
     * @return 
     */
    public usuarioSistema accesoUsuario(String usuario, String password){
        usuarioSistema respuesta= new usuarioSistema();
        String consulta = "SELECT id,usuario,rol FROM USUARIO WHERE usuario = ? AND password = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            password = DigestUtils.md5Hex(password);
            preSt.setString(1, usuario);
            preSt.setString(2, password);
            try (ResultSet result = preSt.executeQuery()){
                while (result.next()) {
                    respuesta.setCodigoReferencia(result.getLong(1));
                    respuesta.setEmail(result.getString(2));
                    respuesta.setRol(result.getString(3));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return respuesta;
    }
    /**
     * VERIFICA SI EXISTE UN YA EXISTE UN USUARIO EN LA BASE DE DATOS
     * ,true = si existe,
     * false = no existe
     * @param usuario
     * @return 
     */
    public boolean existenciaDeRegistroUsuario(String usuario){
        boolean respuesta= false;
        String consulta = "SELECT rol FROM USUARIO WHERE usuario = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, usuario);
            try (ResultSet result = preSt.executeQuery()){
                while (result.next()) {
                    respuesta=true;
                }
            } catch (Exception e) {
            }
        }catch(Exception e){
        }
        return respuesta;
    }
    /**
     * VERIFICA SI EXISTE UN YA EXISTE UN USUARIO EN LA BASE DE DATOS
     * ,true = si existe,
     * false = no existe
     * @param codigo
     * @param dpi
     * @param email
     * @param telefono
     * @return 
     */
    public String existenciaDePaciente(Long codigo,String dpi,String email,String telefono){
        String consulta = "SELECT * FROM PACIENTE WHERE codigo = ?";
        if(codigo!=null){
            try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
                preSt.setLong(1, codigo);
                try (ResultSet result = preSt.executeQuery()){
                    while (result.next()) {
                        return "Existe un paciente con el mismo codigo de referencia en la base de datos";
                    }
                } catch (Exception e) {
                }
            }catch(Exception e){
            }
        }
        consulta = "SELECT * FROM PACIENTE WHERE dpi = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, dpi);
            try (ResultSet result = preSt.executeQuery()){
                while (result.next()) {
                    return "Existe un paciente con el mismo DPI en la base de datos";
                }
            } catch (Exception e) {
            }
        }catch(Exception e){
        }
        consulta = "SELECT * FROM PACIENTE WHERE email = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, email);
            try (ResultSet result = preSt.executeQuery()){
                while (result.next()) {
                    return "Existe un paciente con el mismo email en la base de datos";
                }
            } catch (Exception e) {
            }
        }catch(Exception e){
        }
        consulta = "SELECT * FROM PACIENTE WHERE telefono = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, telefono);
            try (ResultSet result = preSt.executeQuery()){
                while (result.next()) {
                    return "Existe un paciente con el mismo telefono en la base de datos";
                }
            } catch (Exception e) {
            }
        }catch(Exception e){
        }
        return "";
    }
    /**
     * Obtiene un examen segun codigo del mismo examen
     * @param codigo
     * @return 
     */
    public Examen obtenerExamen(String codigo){
        Examen examen=null;
        String consulta="";
        consulta="SELECT nombre,orden,descripcion,costo,tipo_informe FROM EXAMEN WHERE codigo = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
                preSt.setString(1, codigo);
                try (ResultSet result = preSt.executeQuery()){
                    examen=new Examen();
                    while (result.next()) {
                        examen.setCodigo(Long.parseLong(codigo));
                        examen.setNombre(result.getString(1));
                        examen.setOrden(result.getBoolean(2));
                        examen.setDescripcion(result.getString(3));
                        examen.setCosto(result.getDouble(4));
                        examen.setInforme(result.getString(5));
                    }
                } catch (Exception e) {
                    System.out.println("Error en busqueda de examen"+e.getMessage());
                }
            }catch(Exception e){
                System.out.println("Error en busqueda de examen"+e.getMessage());
            }
        return examen;
    }
}
