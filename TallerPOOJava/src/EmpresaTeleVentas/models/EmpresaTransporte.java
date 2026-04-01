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

public class EmpresaTransporte {

    private final String nombre;

    public EmpresaTransporte(String nombre) {
        this.nombre = nombre;
    }

    public String entregarPedido() {
        return "Pedido entregado por " + nombre;
    }
}
