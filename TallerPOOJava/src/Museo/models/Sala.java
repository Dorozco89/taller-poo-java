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

public class Sala {

    private final String nombre;
    private final List<ObraArte> obras;

    public Sala(String nombre) {
        this.nombre = nombre;
        this.obras = new ArrayList<>();
    }

    public void agregarObra(ObraArte obra) {
        obras.add(obra);
    }

    public List<ObraArte> listarObras() {
        return obras;
    }
}