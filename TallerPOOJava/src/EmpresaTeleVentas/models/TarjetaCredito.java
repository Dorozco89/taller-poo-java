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

public class TarjetaCredito extends Pago {

    private final String numero;
    private final String titular;
    private final String fechaExp;
    private final int cvv;

    public TarjetaCredito(double monto, String numero, String titular, String fechaExp, int cvv) {
        super(monto);
        this.numero = numero;
        this.titular = titular;
        this.fechaExp = fechaExp;
        this.cvv = cvv;
    }

    @Override
    public boolean procesarPago() {
        if (numero.length() < 6) {
            estado = "RECHAZADO";
            return false;
        }
        estado = "APROBADO";
        return true;
    }
}
