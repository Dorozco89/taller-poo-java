/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USUARIO
 */
package Museo.models;

public class Escultura extends ObraArte {

    private final String material;
    private final String estilo;

    public Escultura(int id, String titulo, double valor,
                     String fechaCreacion, String fechaIngreso,
                     Autor autor, Periodo periodo,
                     String material, String estilo) {

        super(id, titulo, valor, fechaCreacion, fechaIngreso, autor, periodo);
        this.material = material;
        this.estilo = estilo;
    }

    @Override
    public double calcularValor() {
        return getValor() * 1.3;
    }
}