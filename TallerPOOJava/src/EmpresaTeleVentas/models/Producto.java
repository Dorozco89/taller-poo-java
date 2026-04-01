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

public class Producto {

    private String codigo;
    private String descripcion;
    private double precio;
    private int cantidadDisponible;

    public Producto(String codigo, String descripcion, double precio, int cantidadDisponible) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe de ser mayor a 0");
        }

        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }
}
