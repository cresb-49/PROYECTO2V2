package com.mycompany.proyecto2v2.QueryObjets;

import com.mycompany.proyecto2v2.Objetos.Paciente;

public class QueryPaciente extends Paciente {
    private Long cantidadReportes;

    public QueryPaciente(Long cantidadReportes,String nombre, Long codigo){
         super(nombre, null, null, null, null, null, null, null, null);
         this.setCodigo(codigo);
         this.cantidadReportes=cantidadReportes;
    }

    public Long getCantidadReportes() {
        return cantidadReportes;
    }
    public void setCantidadReportes(Long cantidadReportes) {
        this.cantidadReportes = cantidadReportes;
    }

    @Override
    public String toString() {
        return "QueryPaciente{" + "cantidadReportes=" + cantidadReportes + "Nombre=" + this.getNombre() + "Codigo=" + this.getCodigo() +'}';
    }
}
