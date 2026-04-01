/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USUARIO
 */
package empresateleventas.models;

public class Queja {

    private final String descripcion;
    private String estado;

    public Queja(String descripcion) {
        this.descripcion = descripcion;
        this.estado = "NUEVA";
    }

    public void registrarQueja() {
        estado = "REGISTRADA";
    }

    public String notificarGerente(GerenteRelaciones gerente) {
        return gerente.gestionarQueja(this);
    }
}