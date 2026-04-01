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

public class AgenteDeposito {

    private final int id;
    private final String nombre;

    public AgenteDeposito(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String prepararPedido(Pedido pedido) {
        return "Pedido preparado por " + nombre;
    }
}