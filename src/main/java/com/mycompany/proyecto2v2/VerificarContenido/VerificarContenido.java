package com.mycompany.proyecto2v2.VerificarContenido;

import com.mycompany.proyecto2v2.ExepcionesDePrograma.AtributosIncompletos;
import com.mycompany.proyecto2v2.ExepcionesDePrograma.FormatoArchivoIncorrecto;
import com.mycompany.proyecto2v2.Objetos.*;
import java.io.File;

public class VerificarContenido {

    public VerificarContenido() {

    }

    public boolean verificarTipoInforme(String cadena) {
        boolean respuesta = false;

        return respuesta;
    }

    public void archivoXML(File archivo) throws FormatoArchivoIncorrecto {
        if (!(archivo.getName().endsWith(".xml"))) {
            throw new FormatoArchivoIncorrecto("El archivo de entrada no es .XML");
        }
    }

    public void verificarUsuario(String user, String password, String rol) throws AtributosIncompletos {
        if (user == null || password == null || rol == null) {
            throw new AtributosIncompletos("El uuario no tiene parametros para el registro");
        }
        if (user.equals("") || password.equals("") || rol.equals("")) {
            throw new AtributosIncompletos("El usurio no tiene parametros para el registro");
        }
    }

    public void verificarDoctor(Doctor doctor) throws AtributosIncompletos {
        if (!(this.validarCodigoDoctor(doctor.getCodigo()))) {
            throw new AtributosIncompletos("El doctor no posee codigo de identificaion valido");
        }
        if (!(this.validarColegiado(doctor.getColegiado()))) {
            throw new AtributosIncompletos("El doctor no posee numero de colegiado valido");
        }
        if (!(this.validarCorreo(doctor.getEmail()))) {
            throw new AtributosIncompletos("El doctor no posee un correo electronico valido");
        }
        if (!(this.validarDPI(doctor.getDPI()))) {
            throw new AtributosIncompletos("El doctor no posee numero de DPI valido");
        }
        if (doctor.getEspecialidad() == null) {
            throw new AtributosIncompletos("El doctor no posee ninguna especialidad");
        }
        if (doctor.getEspecialidad().isEmpty()) {
            throw new AtributosIncompletos("El doctor no posee ninguna especialidad");
        }
        if (!doctor.getEspecialidad().isEmpty()) {
            for (String especialidad : doctor.getEspecialidad()) {
                if (!(this.validarTexto(especialidad))) {
                    throw new AtributosIncompletos("La especialidad del doctor no tiene nombre valido");
                }
            }
            int cont = 0;
            for (String especialidad : doctor.getEspecialidad()) {
                for (String espe : doctor.getEspecialidad()) {
                    if (especialidad.equals(espe)) {
                        cont++;
                        if (cont == 2) {
                            throw new AtributosIncompletos("El doctor tiene una especialidad repetida");
                        }
                    }
                }
                cont = 0;
            }
        }
        if (doctor.getFin() == null) {
            throw new AtributosIncompletos("El doctor no tiene asignada una hora de fin de turno");
        }
        if (doctor.getInicio() == null) {
            throw new AtributosIncompletos("El doctor no tiene asignada una hora de inicio de turno");
        }
        if (doctor.getInicioTrabajo() == null) {
            throw new AtributosIncompletos("El doctor no posee fecha de inicio de trabajo");
        }
        if (!(this.validarNombre(doctor.getNombre()))) {
            throw new AtributosIncompletos("El doctor no posee un nombre valido debe ser de la forma Juan Perez");
        }
        if (doctor.getPassword() == null) {
            throw new AtributosIncompletos("El doctor no tiene asignado una contraseña de ingreso al sistema");
        }
        if (!(this.verificarPassword(doctor.getPassword()))) {
            throw new AtributosIncompletos("El doctor no tiene un contraseña para ingresar al sistema");
        }
    }
    /**
     * VERIFICA SI ESTA CORRECTA LA MODIFICACION DEL MEDICO
     * @param doctor
     * @throws AtributosIncompletos
     */
    public void verificarDoctorModificado(Doctor doctor) throws AtributosIncompletos {
        if (!(this.validarCodigoDoctor(doctor.getCodigo()))) {
            throw new AtributosIncompletos("El doctor no posee codigo de identificaion valido");
        }
        if (!(this.validarColegiado(doctor.getColegiado()))) {
            throw new AtributosIncompletos("El doctor no posee numero de colegiado valido");
        }
        if (!(this.validarDPI(doctor.getDPI()))) {
            throw new AtributosIncompletos("El doctor no posee numero de DPI valido");
        }
        if (doctor.getEspecialidad() == null) {
            throw new AtributosIncompletos("El doctor no posee ninguna especialidad");
        }
        if (doctor.getEspecialidad().isEmpty()) {
            throw new AtributosIncompletos("El doctor no posee ninguna especialidad");
        }
        if (!doctor.getEspecialidad().isEmpty()) {
            for (String especialidad : doctor.getEspecialidad()) {
                if (!(this.validarTexto(especialidad))) {
                    throw new AtributosIncompletos("La especialidad del doctor no tiene nombre valido");
                }
            }
            int cont = 0;
            for (String especialidad : doctor.getEspecialidad()) {
                for (String espe : doctor.getEspecialidad()) {
                    if (especialidad.equals(espe)) {
                        cont++;
                        if (cont == 2) {
                            throw new AtributosIncompletos("El doctor tiene una especialidad repetida");
                        }
                    }
                }
                cont = 0;
            }
        }
        if (doctor.getFin() == null) {
            throw new AtributosIncompletos("El doctor no tiene asignada una hora de fin de turno");
        }
        if (doctor.getInicio() == null) {
            throw new AtributosIncompletos("El doctor no tiene asignada una hora de inicio de turno");
        }
        if (doctor.getInicioTrabajo() == null) {
            throw new AtributosIncompletos("El doctor no posee fecha de inicio de trabajo");
        }
        if (!(this.validarNombre(doctor.getNombre()))) {
            throw new AtributosIncompletos("El doctor no posee un nombre valido debe ser de la forma Juan Perez");
        }
    }

    public void verificarPacienteExportado(Paciente paciente) throws AtributosIncompletos {
        if (!(this.validarCodigoPaciente(paciente.getCodigo()))) {
            throw new AtributosIncompletos("el paciente no tiene un codigo valido solo deben ser numeros");
        }
        if (!(this.validarNombre(paciente.getNombre()))) {
            throw new AtributosIncompletos("El paciente no tiene un nombre valido debe ser de la forma Juan Perez");
        }
        if (!(this.validarSexo(paciente.getSexo()))) {
            throw new AtributosIncompletos("El paciente no tiene un sexo valido");
        }
        if (paciente.getCumple() == null) {
            throw new AtributosIncompletos("El paciente no tiene una fecha de cumpleaños valida");
        }
        if (!(this.validarDPI(paciente.getDPI()))) {
            throw new AtributosIncompletos("El paciente no tiene numero de DPI valido");
        }
        if (!(this.validarTelefono(paciente.getTelefono()))) {
            throw new AtributosIncompletos("El paciente no tiene numero de telefono valido");
        }
        if (!(this.validarPeso(paciente.getPeso()))) {
            throw new AtributosIncompletos("");
        }
        if (!(this.validarTipoSangre(paciente.getSangre()))) {
            throw new AtributosIncompletos("El paciente no tiene un tipo de sangre valido");
        }
        if (!(this.validarCorreo(paciente.getEmail()))) {
            throw new AtributosIncompletos("El paciente no tine un correo valido");
        }
        if (!(this.verificarPassword(paciente.getPassword()))) {
            throw new AtributosIncompletos("El paciente no tine una contrasela para ingresar al sistema");
        }
    }

    public void verificarPacienteCreado(Paciente paciente) throws AtributosIncompletos {
        if (!(this.validarNombre(paciente.getNombre()))) {
            throw new AtributosIncompletos("El paciente no tiene un nombre valido debe ser de la forma Juan Perez");
        }
        if (!(this.validarSexo(paciente.getSexo()))) {
            throw new AtributosIncompletos("El paciente no tiene un sexo valido");
        }
        if (paciente.getCumple() == null) {
            throw new AtributosIncompletos("El paciente no tiene una fecha de cumpleaños valida");
        }
        if (!(this.validarDPI(paciente.getDPI()))) {
            throw new AtributosIncompletos("El paciente no tiene numero de DPI valido");
        }
        if (!(this.validarTelefono(paciente.getTelefono()))) {
            throw new AtributosIncompletos("El paciente no tiene numero de telefono valido");
        }
        if (!(this.validarPeso(paciente.getPeso()))) {
            throw new AtributosIncompletos("");
        }
        if (!(this.validarTipoSangre(paciente.getSangre()))) {
            throw new AtributosIncompletos("El paciente no tiene un tipo de sangre valido");
        }
        if (!(this.validarCorreo(paciente.getEmail()))) {
            throw new AtributosIncompletos("El paciente no tine un correo valido");
        }
        if (!(this.verificarPassword(paciente.getPassword()))) {
            throw new AtributosIncompletos("El paciente no tine una contrasela para ingresar al sistema");
        }
    }

    public void verificarPacienteModificado(Paciente paciente) throws AtributosIncompletos {
        if (!(this.validarCodigoPaciente(paciente.getCodigo()))) {
            throw new AtributosIncompletos("el paciente no tiene un codigo valido solo deben ser numeros");
        }
        if (!(this.validarNombre(paciente.getNombre()))) {
            throw new AtributosIncompletos("El paciente no tiene un nombre valido debe ser de la forma Juan Perez");
        }
        if (!(this.validarSexo(paciente.getSexo()))) {
            throw new AtributosIncompletos("El paciente no tiene un sexo valido");
        }
        if (paciente.getCumple() == null) {
            throw new AtributosIncompletos("El paciente no tiene una fecha de cumpleaños valida");
        }
        if (!(this.validarDPI(paciente.getDPI()))) {
            throw new AtributosIncompletos("El paciente no tiene numero de DPI valido");
        }
        if (!(this.validarTelefono(paciente.getTelefono()))) {
            throw new AtributosIncompletos("El paciente no tiene numero de telefono valido");
        }
        if (!(this.validarPeso(paciente.getPeso()))) {
            throw new AtributosIncompletos("");
        }
        if (!(this.validarTipoSangre(paciente.getSangre()))) {
            throw new AtributosIncompletos("El paciente no tiene un tipo de sangre valido");
        }
    }

    public void verificarLaboratorista(Laboratorista laboratorista) throws AtributosIncompletos {
        if (!(this.validarCodigoLabora(laboratorista.getCodigo()))) {
            throw new AtributosIncompletos("El laboratorista no posee un codigo de identificacion valido");
        }
        if (!(this.validarNombre(laboratorista.getNombre()))) {
            throw new AtributosIncompletos("El laboratorista no posee un nombre valido debe ser de la forma Juan Perez");
        }
        if (!(this.validarRegistroSalud(laboratorista.getRegistro()))) {
            throw new AtributosIncompletos("El laboratorista no posee un numero de registro valido debe ser SALUD-XXXX");
        }
        if (!(this.validarDPI(laboratorista.getDPI()))) {
            throw new AtributosIncompletos("El laboratorista no posee un numero de DPI valido");
        }
        if (!(this.validarTelefono(laboratorista.getTelefono()))) {
            throw new AtributosIncompletos("El laboratorista no posee un numero de telefono valido");
        }
        if (!(this.validarTexto(laboratorista.getExamen()))) {
            throw new AtributosIncompletos("El nombre del examen asignado al laboratorista no el valido");
        }
        if (!(this.validarCorreo(laboratorista.getEmail()))) {
            throw new AtributosIncompletos("El correo del laboratorista no es valido");
        }
        if (laboratorista.getDias() == null) {
            throw new AtributosIncompletos("El laboratorista no tiene dias de trabajo");
        }
        if (laboratorista.getDias().isEmpty()) {
            throw new AtributosIncompletos("El laboratorista no tiene dias de trabajo");
        }
        if (!(laboratorista.getDias().isEmpty())) {
            for (String dia : laboratorista.getDias()) {
                if (!(this.validarDia(dia))) {
                    throw new AtributosIncompletos("El laboratorista tiene error en la definicion de dia de trabajo");
                }
            }
            int cont = 0;
            for (String dia : laboratorista.getDias()) {
                for (String dial : laboratorista.getDias()) {
                    if (dia.equals(dial)) {
                        cont++;
                        if (cont == 2) {
                            throw new AtributosIncompletos("El laboratorista tiene dias repetidos en asistencia de trabajo");
                        }
                    }
                }
                cont = 0;
            }
        }
        if (laboratorista.getInicioTrabajo() == null) {
            throw new AtributosIncompletos("El laboratorista no tine asignado un dia de inicio de labores");
        }
        if (!(this.verificarPassword(laboratorista.getPassword()))) {
            throw new AtributosIncompletos("El laboratorista no tiene una password para ingresar al sistema");
        }
    }

    public void verificarLaboratoristaModificado(Laboratorista laboratorista) throws AtributosIncompletos {
        if (!(this.validarCodigoLabora(laboratorista.getCodigo()))) {
            throw new AtributosIncompletos("El laboratorista no posee un codigo de identificacion valido");
        }
        if (!(this.validarNombre(laboratorista.getNombre()))) {
            throw new AtributosIncompletos("El laboratorista no posee un nombre valido debe ser de la forma Juan Perez");
        }
        if (!(this.validarRegistroSalud(laboratorista.getRegistro()))) {
            throw new AtributosIncompletos("El laboratorista no posee un numero de registro valido debe ser SALUD-XXXX");
        }
        if (!(this.validarDPI(laboratorista.getDPI()))) {
            throw new AtributosIncompletos("El laboratorista no posee un numero de DPI valido");
        }
        if (!(this.validarTelefono(laboratorista.getTelefono()))) {
            throw new AtributosIncompletos("El laboratorista no posee un numero de telefono valido");
        }
        if (!(this.validarTexto(laboratorista.getExamen()))) {
            throw new AtributosIncompletos("El nombre del examen asignado al laboratorista no el valido");
        }
        if (laboratorista.getDias() == null) {
            throw new AtributosIncompletos("El laboratorista no tiene dias de trabajo");
        }
        if (laboratorista.getDias().isEmpty()) {
            throw new AtributosIncompletos("El laboratorista no tiene dias de trabajo");
        }
        if (!(laboratorista.getDias().isEmpty())) {
            for (String dia : laboratorista.getDias()) {
                if (!(this.validarDia(dia))) {
                    throw new AtributosIncompletos("El laboratorista tiene error en la definicion de dia de trabajo");
                }
            }
            int cont = 0;
            for (String dia : laboratorista.getDias()) {
                for (String dial : laboratorista.getDias()) {
                    if (dia.equals(dial)) {
                        cont++;
                        if (cont == 2) {
                            throw new AtributosIncompletos("El laboratorista tiene dias repetidos en asistencia de trabajo");
                        }
                    }
                }
                cont = 0;
            }
        }
        if (laboratorista.getInicioTrabajo() == null) {
            throw new AtributosIncompletos("El laboratorista no tine asignado un dia de inicio de labores");
        }
    }

    public void verificarAdmin(Admin admin) throws AtributosIncompletos {
        if (!(this.validarNombre(admin.getNombre()))) {
            throw new AtributosIncompletos("El administrador no tiene asignado un nombre valido debe ser de la forma Juan Perez");
        }
        if (!(this.validarCodigoAdmin(admin.getCodigo()))) {
            throw new AtributosIncompletos("El administrador no tiene asignado un codigo de identificacion valido para la base de datos debe ser ADMINXX");
        }
        if (!(this.validarDPI(admin.getDPI()))) {
            throw new AtributosIncompletos("El administrador no tiene un numeo de DPI valido debe de tener 13 digitos");
        }
        if (admin.getPassword() == null) {
            throw new AtributosIncompletos("El administrador no tiene una contraseña para el ingreso al sistema");
        }
        if (admin.getPassword().equals("")) {
            throw new AtributosIncompletos("El administrador no tiene una contraseña para el ingreso al sistema");
        }

    }

    /**
     * VERIFICA SI LOS ATRIBUTOS ESTAN CORRECTOS EN LA MODIFICACION DEL ADMINISTRADOR
     * @param admin
     * @throws AtributosIncompletos
     */
    public void verificarAdminModificado(Admin admin) throws AtributosIncompletos {
        if (!(this.validarNombre(admin.getNombre()))) {
            throw new AtributosIncompletos("El administrador no tiene asignado un nombre valido debe ser de la forma Juan Perez");
        }
        if (!(this.validarCodigoAdmin(admin.getCodigo()))) {
            throw new AtributosIncompletos("El administrador no tiene asignado un codigo de identificacion valido para la base de datos debe ser ADMINXX");
        }
        if (!(this.validarDPI(admin.getDPI()))) {
            throw new AtributosIncompletos("El administrador no tiene un numeo de DPI valido debe de tener 13 digitos");
        }
    }

    public void verificarReporteExportado(Reporte reporte) throws AtributosIncompletos {
        if (!this.validarCodigoNumerico(reporte.getCodigo())) {
            throw new AtributosIncompletos("El reporte debe tener un codigo numerico");
        }
        if (!this.validarCodigoPaciente(reporte.getCodigoPaciente())) {
            throw new AtributosIncompletos("El reporte tiene codigo de paciente no valido debe ser un codigo numerico");
        }
        if (!this.validarCodigoDoctor(reporte.getCodigoMedico())) {
            throw new AtributosIncompletos("El reporte tiene codigo de medico no valido debe ser MED-XXX");
        }
        if (reporte.getInformeMedico() == null) {
            throw new AtributosIncompletos("El reporte no tiene informe medico");
        }
        if (reporte.getInformeMedico().equals("")) {
            throw new AtributosIncompletos("El reporte no tiene informe medico");
        }
        if (reporte.getFecha() == null) {
            throw new AtributosIncompletos("El reporte no tiene fecha de generacion correcta");
        }
        if (reporte.getHora() == null) {
            throw new AtributosIncompletos("El reporte no tiene gora de generacion correcta");
        }
    }

    public void verificarReporteCreado(Reporte reporte) throws AtributosIncompletos {
        if (!this.validarCodigoPaciente(reporte.getCodigoPaciente())) {
            throw new AtributosIncompletos("El reporte tiene codigo de paciente no valido debe ser un codigo numerico");
        }
        if (!this.validarCodigoDoctor(reporte.getCodigoMedico())) {
            throw new AtributosIncompletos("El reporte tiene codigo de medico no valido debe ser MED-XXX");
        }
        if (reporte.getInformeMedico() == null) {
            throw new AtributosIncompletos("El reporte no tiene informe medico");
        }
        if (reporte.getInformeMedico().equals("")) {
            throw new AtributosIncompletos("El reporte no tiene informe medico");
        }
        if (reporte.getFecha() == null) {
            throw new AtributosIncompletos("El reporte no tiene fecha de generacion correcta");
        }
        if (reporte.getHora() == null) {
            throw new AtributosIncompletos("El reporte no tiene gora de generacion correcta");
        }
    }

    public void verificarCitaEsportada(Cita cita) throws AtributosIncompletos {
        if (!this.validarCodigoNumerico(cita.getCodigo())) {
            throw new AtributosIncompletos("La cita no tine un codigo valido, el codigo solo debe ser numerico");
        }
        if (cita.getFecha() == null) {
            throw new AtributosIncompletos("La cita no tiene fecha asignada");
        }
        if (cita.getHora() == null) {
            throw new AtributosIncompletos("La cita no tiene hora asignada");
        }
        if (!this.validarCodigoDoctor(cita.getCodigoMedico())) {
            throw new AtributosIncompletos("La cita no tiene un codigo de medico valido debe ser MED-xxxx");
        }
        if (!this.validarCodigoPaciente(cita.getCodigoPaciente())) {
            throw new AtributosIncompletos("La cita no tiene un codigo de paciente correcto solo deben de ser numeros");
        }
        if (!this.validarTexto(cita.getEspecialidad())) {
            throw new AtributosIncompletos("La cita no tiene la especialidad con caracteres correctos");
        }
    }

    public void verificarCitaCreada(Cita cita) throws AtributosIncompletos {
        if (cita.getFecha() == null) {
            throw new AtributosIncompletos("La cita no tiene fecha asignada");
        }
        if (cita.getHora() == null) {
            throw new AtributosIncompletos("La cita no tiene hora asignada");
        }
        if (!this.validarCodigoDoctor(cita.getCodigoMedico())) {
            throw new AtributosIncompletos("La cita no tiene un codigo de medico valido debe ser MED-xxxx");
        }
        if (!this.validarCodigoPaciente(cita.getCodigoPaciente())) {
            throw new AtributosIncompletos("La cita no tiene un codigo de paciente correcto solo deben de ser numeros");
        }
        if (!this.validarTexto(cita.getEspecialidad())) {
            throw new AtributosIncompletos("La cita no tiene la especialidad con caracteres correctos");
        }
    }

    public void verificarConsulta(Consulta consulta) throws AtributosIncompletos {
        if (!this.validarTexto(consulta.getTipo())) {
            throw new AtributosIncompletos("La consulta no tiene un nombre valido posee simbolos incorrectos");
        }
        if (!this.validarCosto(consulta.getCosto())) {
            throw new AtributosIncompletos("La consulta no tiene un formato de costo valido");
        }
    }

    public void verificarExamenExportado(Examen examen) throws AtributosIncompletos {
        if (!this.validarCodigoNumerico(examen.getCodigo())) {
            throw new AtributosIncompletos("El examen no tiene un codigo correcto solo deben de ser numeros");
        }
        if (!this.validarTexto(examen.getNombre())) {
            throw new AtributosIncompletos("El examen no tiene un nombre valido, posee caracteres no admitidos");
        }
        if (examen.isOrden() == null) {
            throw new AtributosIncompletos("El examen no tine asignado un estado de orden");
        }
        if (examen.getDescripcion() == null) {
            throw new AtributosIncompletos("El examen no tiene un descripcion asigna");
        }
        if (examen.getDescripcion().equals("")) {
            throw new AtributosIncompletos("El examen no tine una descirpcion asignada");
        }
        if (!this.validarCosto(examen.getCosto())) {
            throw new AtributosIncompletos("El examen no tiene un costo valido");
        }
        if (!this.validarTipoInforme(examen.getInforme())) {
            throw new AtributosIncompletos("El examen no tiene un formato de informe valido");
        }
    }

    public void verificarExamenCreado(Examen examen) throws AtributosIncompletos {
        if (!this.validarTexto(examen.getNombre())) {
            throw new AtributosIncompletos("El examen no tiene un nombre valido, posee caracteres no admitidos");
        }
        if (examen.isOrden() == null) {
            throw new AtributosIncompletos("El examen no tine asignado un estado de orden");
        }
        if (examen.getDescripcion() == null) {
            throw new AtributosIncompletos("El examen no tiene un descripcion asigna");
        }
        if (examen.getDescripcion().equals("")) {
            throw new AtributosIncompletos("El examen no tine una descirpcion asignada");
        }
        if (!this.validarCosto(examen.getCosto())) {
            throw new AtributosIncompletos("El examen no tiene un costo valido");
        }
        if (!this.validarTipoInforme(examen.getInforme())) {
            throw new AtributosIncompletos("El examen no tiene un formato de informe valido");
        }
    }
    public void verificarExamenModificado(Examen examen) throws AtributosIncompletos {
        if (!this.validarTexto(examen.getNombre())) {
            throw new AtributosIncompletos("El examen no tiene un nombre valido, posee caracteres no admitidos");
        }
        if (examen.isOrden() == null) {
            throw new AtributosIncompletos("El examen no tine asignado un estado de orden");
        }
        if (examen.getDescripcion() == null) {
            throw new AtributosIncompletos("El examen no tiene un descripcion asigna");
        }
        if (examen.getDescripcion().equals("")) {
            throw new AtributosIncompletos("El examen no tine una descirpcion asignada");
        }
        if (!this.validarCosto(examen.getCosto())) {
            throw new AtributosIncompletos("El examen no tiene un costo valido");
        }
        if (!this.validarTipoInforme(examen.getInforme())) {
            throw new AtributosIncompletos("El examen no tiene un formato de informe valido");
        }
    }
    /**
     * PARA REALIZAR LA VERIFICACION DE LA INFORMACION EN NECESARIO SABER A QUE TIPO DE EXAMEN HACEMOS REFERENCIA
     * @param resultado
     * @param examen 
     * @throws com.hospital.proyecto2.exepcionesDePrograma.AtributosIncompletos 
     */
    public void verificarResultadoExportado(Resultado resultado, Examen examen) throws AtributosIncompletos{
        if(examen==null){
            throw new AtributosIncompletos("No existe un examen en el hospital con el codigo enlazado al resultado");
        }
        if(!this.validarCodigoNumerico(resultado.getCodigo())){
            throw new AtributosIncompletos("El Resultado no tine un codigo de referencia no valido solo deben ser numeros");
        }
        if(!this.validarCodigoPaciente(resultado.getCodigo())){
            throw new AtributosIncompletos("El resultado no tiene un codigo de paciente no valido solo deben ser numeros");
        }
        if(resultado.getCodigoMedico()!=null){
            if(!resultado.getCodigoMedico().isEmpty()){
                if(!this.validarCodigoDoctor(resultado.getCodigoMedico())){
                    throw new AtributosIncompletos("El resultado no tiene un codigo de medico no valido debe ser MED-XXX");
                }
            }
        }
        if(!this.validarCodigoNumerico(resultado.getCodigoExamen())){
            throw new AtributosIncompletos("El resultado tiene un codigo de examen no valido deben ser solo numeros");
        }
        if(!this.validarCodigoLabora(resultado.getCodigoLaboratorista())){
            throw new AtributosIncompletos("El resultado no tine un codigo de laboratorista valido debe ser de la forma LAB-XXX");
        }
        if(examen.isOrden()==true&& resultado.getOrden().getDatos()==null){
            throw new AtributosIncompletos("El resultado segun el tipo de examen requiere orden");
        }
        if(examen.isOrden()==false && resultado.getOrden().getDatos()!=null){
            throw new AtributosIncompletos("El resultado segun el tipo de examen no necesita orden");
        }
        if(resultado.getInforme().getDatos()==null){
            throw new AtributosIncompletos("El resultado no tiene un informe");
        }
        if(!resultado.getNombreInforme().endsWith(".pdf")&&examen.getInforme().equals("PDF")){
            throw new AtributosIncompletos("El resultado necesita de un informe en formato PDF");
        }
        if(resultado.getNombreInforme().endsWith(".pdf")&&examen.getInforme().equals("IMG")){
            throw new AtributosIncompletos("El resultado necesita de un informe en formato IMG");
        }
        if(resultado.getFecha()==null){
            throw new AtributosIncompletos("El resultado no tiene asignada un fecha");
        }
        if(resultado.getHora()==null){
            throw new AtributosIncompletos("El resultado no tiene asignado un hora");
        }
    }
    /**
     * PARA REALIZAR LA VERIFICACION DE LA INFORMACION EN NECESARIO SABER A QUE TIPO DE EXAMEN HACEMOS REFERENCIA
     * @param resultado
     * @param examen 
     */
    public void verificarResultadoCreado(Resultado resultado, Examen examen) throws AtributosIncompletos{
        if(!this.validarCodigoPaciente(resultado.getCodigo())){
            throw new AtributosIncompletos("El resultado no tiene un codigo de paciente no valido solo deben ser numeros");
        }
        if(resultado.getCodigoMedico()!=null){
            if(!resultado.getCodigoMedico().isEmpty()){
                if(!this.validarCodigoDoctor(resultado.getCodigoMedico())){
                    throw new AtributosIncompletos("El resultado no tiene un codigo de medico no valido debe ser MED-XXX");
                }
            }
        }
        if(!this.validarCodigoNumerico(resultado.getCodigoExamen())){
            throw new AtributosIncompletos("El resultado tiene un codigo de examen no valido deben ser solo numeros");
        }
        if(!this.validarCodigoLabora(resultado.getCodigoLaboratorista())){
            throw new AtributosIncompletos("El resultado no tine un codigo de laboratorista valido debe ser de la forma LAB-XXX");
        }
        if(examen.isOrden()==true&& resultado.getOrden().getDatos()==null){
            throw new AtributosIncompletos("El resultado segun el tipo de examen requiere orden");
        }
        if(examen.isOrden()==false && resultado.getOrden().getDatos()!=null){
            throw new AtributosIncompletos("El resultado segun el tipo de examen no necesita orden");
        }
        if(!resultado.getNombreInforme().endsWith(".pdf")&&examen.getInforme().equals("PDF")){
            throw new AtributosIncompletos("El resultado necesita de un informe en formato PDF");
        }
        if(resultado.getNombreInforme().endsWith(".pdf")&&examen.getInforme().equals("IMG")){
            throw new AtributosIncompletos("El resultado necesita de un informe en formato IMG");
        }
        if(resultado.getInforme().getDatos()==null){
            throw new AtributosIncompletos("El resultado no tiene un informe");
        }
        if(resultado.getFecha()==null){
            throw new AtributosIncompletos("El resultado no tiene asignada un fecha");
        }
        if(resultado.getHora()==null){
            throw new AtributosIncompletos("El resultado no tiene asignado un hora");
        }
    }

    public void validarSolicitudExamen(SolicitudExamen solicitud,Boolean aceptacionOrden) throws AtributosIncompletos {
        if(!this.validarCodigoNumerico(solicitud.getCodigoExamen())){
            throw new AtributosIncompletos("La solicitud no tiene un codigo de examen valido");
        }
        if(solicitud.getCodigoMedico()!=null){
            if(!solicitud.getCodigoMedico().isEmpty()){
                if(this.validarCodigoDoctor(solicitud.getCodigoMedico())){
                    throw new AtributosIncompletos("La solicitud no tiene un codigo de medico valido");
                }
            }
        }
        if(!this.validarCodigoLabora(solicitud.getCodigoLaboratorista())){
            throw new AtributosIncompletos("La solicitud no tiene un codigo de medico valido");
        }
        if(aceptacionOrden==true && solicitud.getOrden().getDatos()==null){
            throw new AtributosIncompletos("La solicitud debe de tener una orden de examen");
        }
        if(aceptacionOrden==false && solicitud.getOrden().getDatos()!=null){
            throw new AtributosIncompletos("La solicitud no debe de tener una orden de examen");
        }
        if(solicitud.getFecha()==null){
            throw new AtributosIncompletos("La solicitud no tiene un fecha aceptada");
        }
        if(!solicitud.getOrden().getContentType().endsWith("pdf")){
            throw new AtributosIncompletos("La orden de la solicitud debe de ser de formato pdf");
        }
    }

    /**
     * VERIFICA SI HAY UNA PASSWORD EXISTENTE
     * @param password
     * @return 
     */
    private boolean verificarPassword(String password) {
        if (password == null) {
            return false;
        } else if (password.equals("")) {
            return false;
        } else {
            return true;
        }
    }

    private boolean validarNombre(String nombre) {
        if (nombre == null) {
            return false;
        } else {
            return nombre.matches("^[A-ZÀ-ÿ\\u00d1a-zÀ-ÿ\\u00f1]+([\\s][A-ZÀ-ÿ\\u00d1a-zÀ-ÿ\\u00f1]+){1,5}$");
        }
    }

    private boolean validarCorreo(String correo) {
        if (correo == null) {
            return false;
        } else {
            return correo.matches("^[a-zA-Z0-9_-]+@[a-zA-z]+\\.[a-z]+$");
        }
    }

    private boolean validarTelefono(String telefono) {
        if (telefono == null) {
            return false;
        } else {
            return telefono.matches("^[0-9]{8}$");
        }
    }

    private boolean validarDPI(String DPI) {
        if (DPI == null) {
            return false;
        } else {
            return DPI.matches("^[0-9]{13}$");
        }
    }

    private boolean validarCodigoDoctor(String codigo) {
        if (codigo == null) {
            return false;
        } else {
            return codigo.matches("^[M][E][D][-][0-9]+$");
        }

    }

    private boolean validarCodigoNumerico(Long codigo) {
        if (codigo == null) {
            return false;
        } else {
            return codigo.toString().matches("^[0-9]+$");
        }
    }

    private boolean validarCodigoPaciente(Long codigo) {
        if (codigo == null) {
            return false;
        } else {
            return codigo.toString().matches("^[0-9]+$");
        }
    }

    private boolean validarCodigoLabora(String codigo) {
        if (codigo == null) {
            return false;
        } else {
            return codigo.matches("^[L][A][B][-][0-9]+$");
        }
    }

    private boolean validarCodigoAdmin(String codigo) {
        if (codigo == null) {
            return false;
        } else {
            return codigo.matches("^[A][D][M][I][N][0-9]+$");
        }

    }

    private boolean validarColegiado(String colegiado) {
        if (colegiado == null) {
            return false;
        } else {
            return colegiado.matches("^[0-9]+$");
        }
    }

    private boolean validarTexto(String texto) {
        if (texto == null) {
            return false;
        } else {
            return texto.matches("^[A-ZÀ-ÿ\\u00d1a-z\\u00f1-]+$");
        }
    }

    private boolean validarSexo(String sexo) {
        if (sexo == null) {
            return false;
        } else {
            sexo = sexo.toLowerCase();
            if (sexo.equals("hombre") || sexo.equals("mujer")) {
                return true;
            } else {
                return false;
            }
        }
    }

    private boolean validarPeso(Double peso) {
        if (peso == null) {
            return false;
        } else {
            return peso.toString().matches("^(([0-9]+\\.[0-9]+)|([0-9]+))$");
        }
    }

    private boolean validarCosto(Double costo) {
        if (costo == null) {
            return false;
        } else {
            return costo.toString().matches("^(([0-9]+\\.[0-9]+)|([0-9]+))$");
        }
    }

    public boolean validarTipoSangre(String tipoSangre) {
        if (tipoSangre == null) {
            return false;
        }
        switch (tipoSangre) {
            case "A":
            case "A+":
            case "A-":
            case "B":
            case "B+":
            case "B-":
            case "AB":
            case "AB+":
            case "AB-":
            case "O":
            case "O+":
            case "O-":
                return true;
            default:
                return false;
        }
    }

    private boolean validarRegistroSalud(String registro) {
        if (registro == null) {
            return false;
        } else {
            return registro.matches("^[S][A][L][U][D][-][0-9]+$");
        }
    }

    private boolean validarDia(String dia) {
        if (dia == null) {
            return false;
        } else {
            dia = dia.toLowerCase();
            if (dia.equals("lunes") || dia.equals("martes") || dia.equals("miercoles") || dia.equals("jueves") || dia.equals("viernes") || dia.equals("sabado") || dia.equals("domingo")) {
                return true;
            } else {
                return false;
            }
        }
    }

    private boolean validarTipoInforme(String tipoInforme) {
        if (tipoInforme == null) {
            return false;
        } else {
            tipoInforme = tipoInforme.toLowerCase();
            if (tipoInforme.equals("img") || tipoInforme.equals("pdf")) {
                return true;
            } else {
                return false;
            }
        }
    }
}
