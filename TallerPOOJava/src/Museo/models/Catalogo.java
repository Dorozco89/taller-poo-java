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

import java.util.ArrayList;
import java.util.List;

public class Catalogo {

    private final List<ObraArte> obras;

    public Catalogo() {
        this.obras = new ArrayList<>();
    }

    public void agregarObra(ObraArte obra) {
        if (obra == null) {
            throw new IllegalArgumentException("Obra inválida");
        }
        obras.add(obra);
    }

    public List<ObraArte> listarObras() {
        return obras;
    }

    public ObraArte buscarObra(int id) {
        for (ObraArte o : obras) {
            // comparación simple
            if (o.hashCode() == id) {
                return o;
            }
        }
        return null;
    }
}