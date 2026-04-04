/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USUARIO
 */
package Museo.services;

import museo.models.Director;
import museo.models.Usuario;

public class Autenticacion {

    public boolean login(Usuario usuario, String password) {
        if (usuario == null || password == null) {
            throw new IllegalArgumentException("Datos inválidos");
        }
        return usuario.autenticar(password);
    }

    public boolean login(Director director, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}