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

import java.util.ArrayList;
import java.util.List;

public class OrdenCompra {

    private final int id;
    private final List<DetalleOrden> detalles;
    private String estado;

    public OrdenCompra(int id) {
        this.id = id;
        this.detalles = new ArrayList<>();
        this.estado = "CREADA";
    }

    public void agregarProducto(DetalleOrden detalle) {
        detalles.add(detalle);
    }

    public double calcularTotal() {
        double total = 0;
        total = detalles.stream().map((d) -> d.calcularSubtotal()).reduce(total, (accumulator, _item) -> accumulator + _item);
        return total;
    }

    public void confirmarOrden() {
        estado = "CONFIRMADA";
    }

    public void cancelarOrden() {
        estado = "CANCELADA";
    }
}