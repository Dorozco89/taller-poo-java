/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
/**
 *
 * @author USUARIO
 */
package museo.models;

public class Restauracion {

    private final String tipo;
    private final String fechaInicio;
    private String fechaFin;

    public Restauracion(String tipo, String fechaInicio) {
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
    }

    public void finalizar(String fechaFin) {
        this.fechaFin = fechaFin;
    }
}