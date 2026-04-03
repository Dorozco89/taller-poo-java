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

public class Cuadro extends ObraArte {

    private final String tecnica;
    private final String estilo;

    public Cuadro(int id, String titulo, double valor,
                  String fechaCreacion, String fechaIngreso,
                  Autor autor, Periodo periodo,
                  String tecnica, String estilo) {

        super(id, titulo, valor, fechaCreacion, fechaIngreso, autor, periodo);
        this.tecnica = tecnica;
        this.estilo = estilo;
    }

    @Override
    public double calcularValor() {
        return getValor() * 1.2;
    }
}
