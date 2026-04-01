/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USUARIO
 */
package empresateleventas.models;

public class GerenteRelaciones {

    private final int id;
    private final String nombre;
    private final String correo;

    public GerenteRelaciones(int id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String gestionarQueja(Queja queja) {
        return "Queja gestionada por " + nombre;
    }
}