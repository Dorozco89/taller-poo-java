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

public class Catalogo {

    private final List<Producto> productos;

    public Catalogo() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("Producto no válido");
        }
        productos.add(producto);
    }

    public List<Producto> obtenerProductos() {
        return productos;
    }
}
