package com.mycompany.proyecto2v2.Objetos;

public class usuarioSistema {
    private Long codigoReferencia;
    private String rol;
    private String email;
    private String password;
    //
    private String codigoEntidad;

    /**
     * Constructor vacio del usuario del sistema
     */
    public usuarioSistema() {

    }

    public Long getCodigoReferencia() {
        return codigoReferencia;
    }

    public void setCodigoReferencia(Long codigoReferencia) {
        this.codigoReferencia = codigoReferencia;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(String codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }
    
    @Override
    public String toString() {
        return "usuarioSistema{" + "codigoReferencia=" + codigoReferencia + ", rol=" + rol + ", email=" + email + ", password=" + password + '}';
    }
    
}
