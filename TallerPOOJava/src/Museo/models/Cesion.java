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

public class Cesion {

    private final String fechaInicio;
    private final String fechaFin;
    private final double importe;
    private final Museo museoDestino;

    public Cesion(String fechaInicio, String fechaFin,
                  double importe, Museo museoDestino) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.importe = importe;
        this.museoDestino = museoDestino;
    }

    public void iniciarCesion() {
    }

    public void finalizarCesion() {
    }
}