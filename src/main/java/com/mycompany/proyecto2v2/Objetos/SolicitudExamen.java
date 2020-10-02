package com.mycompany.proyecto2v2.Objetos;

import java.sql.Date;

public class SolicitudExamen extends Resultado {
    private Long codigoSolicitud;
    private Archivo ordenSolicitud = new Archivo();
    public SolicitudExamen(){
        
    }
    public SolicitudExamen(Long codigoSolicitud,Long codigoPaciente,Long codigoExamen,String codigoMedico,String codigoLaboratorista,Date fecha){
        super(null, codigoPaciente, codigoExamen, codigoMedico, codigoLaboratorista, null, null, fecha, null);
        this.codigoSolicitud=codigoSolicitud;
    }
    public Long getCodigoSolicitud() {
        return codigoSolicitud;
    }
    public void setCodigoSolicitud(Long codigoSolicitud) {
        this.codigoSolicitud = codigoSolicitud;
    }    
}
