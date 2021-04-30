package com.dotech.core.db.util;

/**
 * Clase para manejar mensajes de las clases tipo services
 */
public class ServiceResponse {

    private boolean estatus;
    private String mensaje;

    public ServiceResponse() {
    }

    public ServiceResponse(boolean estatus, String mensaje) {
        this.estatus = estatus;
        this.mensaje = mensaje;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
