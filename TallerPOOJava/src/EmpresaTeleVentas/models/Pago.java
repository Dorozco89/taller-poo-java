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

public abstract class Pago {

    protected double monto;
    protected String estado;

    public Pago(double monto) {
        this.monto = monto;
        this.estado = "PENDIENTE";
    }

    public abstract boolean procesarPago();
}