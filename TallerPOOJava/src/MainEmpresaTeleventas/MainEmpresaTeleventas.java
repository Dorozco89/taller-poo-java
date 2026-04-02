/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USUARIO
 */
package MainEmpresaTeleventas;

import empresateleventas.models.*;
import java.util.List;
import java.util.Scanner;

public class MainEmpresaTeleventas {

    private static final Catalogo catalogo = new Catalogo();
    private static final Cliente cliente =
            new Cliente(1, "David", "david@email.com", "Calle 123");

    private static OrdenCompra ordenActual = null;
    private static Pedido pedidoActual = null;

    private static final AgenteDeposito agente =
            new AgenteDeposito(1, "Diego");

    private static final GerenteRelaciones gerente =
            new GerenteRelaciones(1, "Paula", "paula@email.com");

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        inicializarDatos();

        while (true) {
            mostrarMenu();
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    verCatalogo();
                    break;
                case "2":
                    crearOrden();
                    break;
                case "3":
                    procesarPago();
                    break;
                case "4":
                    prepararYEnviarPedido();
                    break;
                case "5":
                    registrarQueja();
                    break;
                case "6":
                    cancelarOrden();
                    break;
                case "7":
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    // -------------------------
    // INICIALIZAR PRODUCTOS
    // -------------------------
    private static void inicializarDatos() {
        catalogo.agregarProducto(new Producto("001", "Laptop", 2000, 10));
        catalogo.agregarProducto(new Producto("002", "Mouse", 50, 100));
        catalogo.agregarProducto(new Producto("003", "Teclado", 150, 50));
    }

    // -------------------------
    private static void mostrarMenu() {
        System.out.println("\n===== EMPRESA TELEVENTAS =====");
        System.out.println("1. Ver catálogo");
        System.out.println("2. Crear orden");
        System.out.println("3. Procesar pago");
        System.out.println("4. Preparar y enviar pedido");
        System.out.println("5. Registrar queja");
        System.out.println("6. Cancelar orden");
        System.out.println("7. Salir");
        System.out.print("Seleccione: ");
    }

    // -------------------------
    private static void verCatalogo() {
        List<Producto> productos = catalogo.obtenerProductos();

        System.out.println("\n--- CATÁLOGO ---");
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            System.out.println((i + 1) + ". " +
                    p.getDescripcion() + " - $" + p.getPrecio());
        }
    }

    // -------------------------
    private static void crearOrden() {

        ordenActual = new OrdenCompra(1);

        while (true) {
            verCatalogo();
            System.out.print("Seleccione producto (0 para terminar): ");
            int opcion = Integer.parseInt(scanner.nextLine());

            if (opcion == 0) break;

            Producto producto = catalogo.obtenerProductos().get(opcion - 1);

            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine());

            DetalleOrden detalle = new DetalleOrden(producto, cantidad);
            ordenActual.agregarProducto(detalle);
        }

        double total = ordenActual.calcularTotal();
        System.out.println("Total de la orden: $" + total);

        ordenActual.confirmarOrden();
        System.out.println("Orden confirmada");
    }

    // -------------------------
    private static void procesarPago() {

        if (ordenActual == null) {
            System.out.println("Debe crear una orden primero");
            return;
        }

        double total = ordenActual.calcularTotal();

        System.out.print("Número tarjeta: ");
        String numero = scanner.nextLine();

        System.out.print("Titular: ");
        String titular = scanner.nextLine();

        TarjetaCredito pago =
                new TarjetaCredito(total, numero, titular, "12/30", 123);

        if (pago.procesarPago()) {
            System.out.println("Pago aprobado");
        } else {
            System.out.println("Pago rechazado");
        }
    }

    // -------------------------
    private static void prepararYEnviarPedido() {

        if (ordenActual == null) {
            System.out.println("No hay una orden creada");
            return;
        }

        pedidoActual = new Pedido(ordenActual);

        System.out.println(agente.prepararPedido(pedidoActual));

        Envio envio = new Envio(pedidoActual, cliente.getDireccion());

        EmpresaTransporte empresa =
                new EmpresaTransporte("DHL");

        envio.asignarEmpresa(empresa);

        System.out.println(envio.enviar());
    }

    // -------------------------
    private static void registrarQueja() {

        System.out.print("Ingrese descripción de la queja: ");
        String descripcion = scanner.nextLine();

        Queja queja = new Queja(descripcion);
        queja.registrarQueja();

        System.out.println(queja.notificarGerente(gerente));
    }

    // -------------------------
    private static void cancelarOrden() {

        if (ordenActual == null) {
            System.out.println("No hay orden activa");
            return;
        }

        ordenActual.cancelarOrden();
        System.out.println("Orden cancelada");
    }
}