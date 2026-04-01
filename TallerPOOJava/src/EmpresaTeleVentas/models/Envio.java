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

public class Envio {

    private final Pedido pedido;
    private final String direccion;
    private EmpresaTransporte empresa;

    public Envio(Pedido pedido, String direccion) {
        this.pedido = pedido;
        this.direccion = direccion;
    }

    public void asignarEmpresa(EmpresaTransporte empresa) {
        this.empresa = empresa;
    }

    public String enviar() {
        return empresa.entregarPedido();
    }
}