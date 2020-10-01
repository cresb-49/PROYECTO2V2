package com.mycompany.proyecto2v2.DBManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.mycompany.proyecto2v2.Objetos.*;
import com.mycompany.proyecto2v2.VerificarContenido.*;

public class ModificacionDB {

    private Connection conexion;
    private VerificarContenido verificar = new VerificarContenido();

    public ModificacionDB() {
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * REALIZA LA MODIFICACION DE LOS DATOS DEL ADMIN
     *
     * @param admin
     * @return
     */
    public String modificarAdmin(Admin admin) {
        String resultado = "";
        String consulta = "UPDATE ADMINISTRADOR SET nombre = ?,dpi = ? WHERE codigo = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {

            this.verificar.verificarAdminModificado(admin);
            preSt.setString(1, admin.getNombre());
            preSt.setString(2, admin.getDPI());
            preSt.setString(3, admin.getCodigo());
            preSt.executeUpdate();
        } catch (Exception e) {
            resultado = "Error en modificacion de datos del admistrador: " + e.getMessage();
            System.out.println(resultado);
        }
        return resultado;
    }

    /**
     * REALIZA LA MODIFICACION DEL DOCTOR INGRESADO
     *
     * @param doctor
     * @return
     */
    public String modificarDoctor(Doctor doctor) {
        String resultado = "";
        String consulta = "UPDATE MEDICO SET nombre = ?,dpi = ?,numero_colegiado = ?,inicio_horario=?,fin_horario = ?,inicio_labores = ? WHERE codigo = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {

            this.verificar.verificarDoctorModificado(doctor);
            preSt.setString(1, doctor.getNombre());
            preSt.setString(2, doctor.getDPI());
            preSt.setString(3, doctor.getColegiado());
            preSt.setString(4, doctor.getInicio().toString());
            preSt.setString(5, doctor.getFin().toString());
            preSt.setDate(6, doctor.getInicioTrabajo());
            preSt.setString(7, doctor.getCodigo());
            preSt.executeUpdate();
            //ELIMINACION DE LAS ESPECIALIDADES
            resultado = this.eliminarEspecialidades(doctor);
            //REGISTRO DE LAS ESPECIALIDADES NUEVAS
            RegistroDB registro = new RegistroDB();
            registro.setConexion(this.conexion);
            resultado = registro.registroEspecialidadDoctor(doctor);

        } catch (Exception e) {
            resultado = "Error en modificacion de datos del medico: " + e.getMessage();
            System.out.println(resultado);
        }
        return resultado;
    }

    /**
     * ELIMINA LAS ESPECIALIDADES DE UN DOCTOR SEGUN SU CODIGO
     *
     * @param doctor
     * @return
     */
    private String eliminarEspecialidades(Doctor doctor) {
        String resultado = "";
        String consulta = "DELETE FROM ESPECIALIDAD_MEDICO WHERE MEDICO_codigo = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {

            preSt.setString(1, doctor.getCodigo());
            preSt.executeUpdate();
        } catch (Exception e) {
            resultado = "Error en eliminacion de especailidades: " + e.getMessage();
            System.out.println(resultado);
        }
        return resultado;
    }

    public String modificarLaboratorista(Laboratorista labo) {
        String resultado = "";
        String consulta = "UPDATE LABORATORISTA SET nombre =?,dpi=?,telefono=?,numero_registro=?,inicio_labores=?,tipo_examen=? WHERE codigo = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            this.verificar.verificarLaboratoristaModificado(labo);
            preSt.setString(1, labo.getNombre());
            preSt.setString(2, labo.getDPI());
            preSt.setString(3, labo.getTelefono());
            preSt.setString(4, labo.getRegistro());
            preSt.setDate(5, labo.getInicioTrabajo());
            preSt.setString(6, labo.getExamen());
            preSt.setString(7, labo.getCodigo());
            preSt.executeUpdate();
            //ELIMINACION DE LOS DIAS DE TRABAJO
            resultado = this.eliminarDiasTrabajo(labo);
            RegistroDB registro = new RegistroDB();
            registro.setConexion(this.conexion);
            resultado = registro.registroDiasLaboratorista(labo);

        } catch (Exception e) {
            resultado = "Error en modificacion de datos del medico: " + e.getMessage();
            System.out.println(resultado);
        }
        return resultado;
    }

    /**
     * ELIMINACION DE LOS DIAS DE TRABAJO DEL LABORATORISTA
     *
     * @param labo
     * @return
     */
    private String eliminarDiasTrabajo(Laboratorista labo) {
        String resultado = "";
        String consulta = "DELETE FROM DIAS_TRABAJO WHERE LABORATORISTA_codigo = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, labo.getCodigo());
            preSt.executeUpdate();
        } catch (Exception e) {
            resultado = "Error en eliminacion de dias de trabajo: " + e.getMessage();
            System.out.println(resultado);
        }
        return resultado;
    }

    /**
     * MODIFICA LA INFORMACION DEL PACIENTE INGRESADO EN EL SISTEMA
     *
     * @param paciente
     * @return
     */
    public String modificarPaciente(Paciente paciente) {
        String resultado = "";
        String consulta = "UPDATE PACIENTE SET nombre = ?,dpi = ?,telefono=?,sexo=?,peso=?,tipo_sangre=?,fecha_nacimiento=? WHERE codigo = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {

            this.verificar.verificarPacienteModificado(paciente);
            preSt.setString(1, paciente.getNombre());
            preSt.setString(2, paciente.getDPI());
            preSt.setString(3, paciente.getTelefono());
            preSt.setString(4, paciente.getSexo());
            preSt.setDouble(5, paciente.getPeso());
            preSt.setString(6, paciente.getSangre());
            preSt.setDate(7, paciente.getCumple());
            preSt.setLong(8, paciente.getCodigo());
            preSt.executeUpdate();
        } catch (Exception e) {
            resultado = "Error en modificacion de datos del paciente: " + e.getMessage();
            System.out.println(resultado);
        }
        return resultado;
    }

    /**
     * MODIFICA UN EXAMEN SEGUN EL EXAMEN DE ENTRADA
     *
     * @param examen
     * @return
     */
    public String modificarExamen(Examen examen) {
        String resultado = "";
        String consulta = "";
        consulta = "UPDATE EXAMEN SET nombre=?,orden=?,descripcion=?,costo=?,tipo_informe=? WHERE codigo = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {

            this.verificar.verificarExamenModificado(examen);
            preSt.setString(1, examen.getNombre());
            preSt.setBoolean(2, examen.isOrden());
            preSt.setString(3, examen.getDescripcion());
            preSt.setDouble(4, examen.getCosto());
            preSt.setString(5, examen.getInforme());
            preSt.setLong(6, examen.getCodigo());

            preSt.executeUpdate();
        } catch (Exception e) {
            resultado = "Error en modificacion de datos del examen: " + e.getMessage();
            System.out.println(resultado);
        }
        return resultado;
    }

    /**
     * MODIFICACION DE LA CONSULTA DEPENDIENTO DE LA CONSULTA DE ENTRADA
     *
     * @param consulta
     * @return
     */
    public String modificarConsulta(Consulta consulta) {
        String resultado = "";
        String query = "";
        query = "UPDATE CONSULTA SET nombre=?,costo=? WHERE id=?";
        try (PreparedStatement preSt = conexion.prepareStatement(query)) {

            this.verificar.verificarConsulta(consulta);
            preSt.setString(1, consulta.getTipo());
            preSt.setDouble(2, consulta.getCosto());
            preSt.setLong(3, consulta.getCodigo());

            preSt.executeUpdate();
        } catch (Exception e) {
            resultado = "Error en modificacion de datos de consulta: " + e.getMessage();
            System.out.println(resultado);
        }
        return resultado;
    }

    /**
     * ELIMINAR EL USUARIO SEGUN EL ID DE REFERENCIA
     *
     * @param idRefrencia
     * @return
     */
    public String eliminarUsuario(Long idRefrencia) {
        String resultado = "";
        String consulta = "DELETE FROM USUARIO WHERE id = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setLong(1, idRefrencia);
            preSt.executeUpdate();
        } catch (Exception e) {
            resultado = "Error en eliminacion de dias de trabajo: " + e.getMessage();
            System.out.println(resultado);
        }
        return resultado;
    }
}
