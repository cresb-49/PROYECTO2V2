
package com.mycompany.proyecto2v2.Objetos;
import java.sql.Date;
import java.sql.Time;

public class Resultado {
    
    private Long codigo;
    private Long codigoPaciente;
    private Long codigoExamen;
    private String codigoMedico;
    private String codigoLaboratorista;
    private String NombreOrden;
    private Archivo orden = new Archivo();
    private String NombreInforme;
    private Archivo informe = new Archivo();
    private Date fecha;
    private Time hora;
    
    public Resultado(){
        
    }
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(Long codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public Long getCodigoExamen() {
        return codigoExamen;
    }

    public void setCodigoExamen(Long codigoExamen) {
        this.codigoExamen = codigoExamen;
    }

    public String getCodigoLaboratorista() {
        return codigoLaboratorista;
    }

    public void setCodigoLaboratorista(String codigoLaboratorista) {
        this.codigoLaboratorista = codigoLaboratorista;
    }

    public String getNombreOrden() {
        return NombreOrden;
    }

    public void setNombreOrden(String Nombreorden) {
        this.NombreOrden = Nombreorden;
    }

    public Archivo getOrden() {
        return orden;
    }

    public void setOrden(Archivo orden) {
        this.orden = orden;
    }

    public String getNombreInforme() {
        return NombreInforme;
    }

    public void setNombreInforme(String Nombreinforme) {
        this.NombreInforme = Nombreinforme;
    }

    public Archivo getInforme() {
        return informe;
    }

    public void setInforme(Archivo informe) {
        this.informe = informe;
    }
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getCodigoMedico() {
        return codigoMedico;
    }

    public void setCodigoMedico(String codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

    @Override
    public String toString() {
        return "Resultado{" + "codigo=" + codigo + ", codigoPaciente=" + codigoPaciente + ", codigoExamen=" + codigoExamen + ", codigoMedico=" + codigoMedico + ", codigoLaboratorista=" + codigoLaboratorista + ", orden=" + orden + ", informe=" + informe + ", fecha=" + fecha + ", hora=" + hora + '}';
    }
}
