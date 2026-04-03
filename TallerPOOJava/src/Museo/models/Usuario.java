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

public abstract class Usuario {

    protected int id;
    protected String nombre;
    protected String correo;
    protected String password;

    public Usuario(int id, String nombre, String correo, String password) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    public boolean autenticar(String password) {
        return this.password.equals(password);
    }
}
