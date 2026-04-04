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

import java.util.ArrayList;
import java.util.List;

public abstract class ObraArte {

    private int id;
    private String titulo;
    private double valor;
    private String fechaCreacion;
    private String fechaIngreso;
    private String estado;
    private Autor autor;
    private Periodo periodo;
    private List<Restauracion> restauraciones;

    public ObraArte(int id, String titulo, double valor,
                     String fechaCreacion, String fechaIngreso,
                     Autor autor, Periodo periodo) {

        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }

        this.id = id;
        this.titulo = titulo;
        this.valor = valor;
        this.fechaCreacion = fechaCreacion;
        this.fechaIngreso = fechaIngreso;
        this.autor = autor;
        this.periodo = periodo;
        this.estado = "EXHIBICION";
        this.restauraciones = new ArrayList<>();
    }

    public void cambiarEstado(String estado) {
        this.estado = estado;
    }

    public void agregarRestauracion(Restauracion restauracion) {
        restauraciones.add(restauracion);
        cambiarEstado("RESTAURACION");
    }

    public List<Restauracion> obtenerRestauraciones() {
        return restauraciones;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getValor() {
        return valor;
    }

    public abstract double calcularValor();
}