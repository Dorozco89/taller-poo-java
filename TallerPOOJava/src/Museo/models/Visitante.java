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

import java.util.List;

public class Visitante extends Usuario {

    public Visitante(int id, String nombre,
                     String correo, String password) {
        super(id, nombre, correo, password);
    }

    public List<ObraArte> consultarObras(Sala sala) {
        return sala.listarObras();
    }
}
