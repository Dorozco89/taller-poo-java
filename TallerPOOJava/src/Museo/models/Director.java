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

public class Director extends Usuario {

    public Director(int id, String nombre,
                    String correo, String password) {
        super(id, nombre, correo, password);
    }

    public double calcularValorTotal(Catalogo catalogo) {
        double total = 0;
        for (ObraArte o : catalogo.listarObras()) {
            total += o.calcularValor();
        }
        return total;
    }
}