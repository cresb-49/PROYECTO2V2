/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2v2.Objetos;

/**
 *
 * @author benjamin
 */
public class Consulta {
    private Long codigo;
    private String tipo;
    private Double costo;
    
    public Consulta(){
        
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public String toString() {
        return "Consulta{" + "codigo=" + codigo + ", tipo=" + tipo + ", costo=" + costo + '}';
    }

    
}
