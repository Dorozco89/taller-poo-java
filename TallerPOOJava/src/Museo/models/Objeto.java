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

public class Objeto extends ObraArte {

    public Objeto(int id, String titulo, double valor,
                  String fechaCreacion, String fechaIngreso,
                  Autor autor, Periodo periodo) {

        super(id, titulo, valor, fechaCreacion, fechaIngreso, autor, periodo);
    }

    @Override
    public double calcularValor() {
        return getValor();
    }
}