/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USUARIO
 */
package MainMuseo;

import museo.models.Autor;
import museo.models.Periodo;
import museo.models.Cuadro;
import museo.models.Escultura;
import museo.models.Objeto;
import museo.models.Catalogo;
import museo.models.Restauracion;
import museo.models.Museo;
import museo.models.Cesion;
import museo.models.Sala;
import museo.models.Director;
import museo.models.RestauradorJefe;
import museo.models.EncargadoCatalogo;
import museo.models.Visitante;
import museo.models.ObraArte;

import Museo.services.Autenticacion;

import java.util.Scanner;

public class MainMuseo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEMA MUSEO ===\n");

        // -------------------------
        // DATOS INICIALES
        // -------------------------
        Autor autor = new Autor("Leonardo da Vinci", "Italia");
        Periodo periodo = new Periodo("Renacimiento", "Siglo XV");

        Cuadro cuadro = new Cuadro(1, "Mona Lisa", 1000,
                "1503", "2020", autor, periodo,
                "Óleo", "Renacimiento");

        Escultura escultura = new Escultura(2, "David", 2000,
                "1504", "2021", autor, periodo,
                "Mármol", "Renacimiento");

        Objeto objeto = new Objeto(3, "Vasija Antigua", 500,
                "1200", "2019", autor, periodo);

        Catalogo catalogo = new Catalogo();

        EncargadoCatalogo encargado =
                new EncargadoCatalogo(1, "Santiago",
                        "correo@mail.com", "123");

        encargado.registrarObra(catalogo, cuadro);
        encargado.registrarObra(catalogo, escultura);
        encargado.registrarObra(catalogo, objeto);

        Sala sala = new Sala("Sala Principal");
        sala.agregarObra(cuadro);
        sala.agregarObra(escultura);

        Visitante visitante =
                new Visitante(3, "Pedro", "visit@mail.com", "123");

        RestauradorJefe restaurador =
                new RestauradorJefe(2, "Maria",
                        "maria@mail.com", "123");

        Director director =
                new Director(4, "Alberto",
                        "alb@mail.com", "123");

        Autenticacion auth = new Autenticacion();

        // -------------------------
        // MENÚ INTERACTIVO
        // -------------------------
        while (true) {

            System.out.println("\n===== MENÚ MUSEO =====");
            System.out.println("1. Ver catálogo");
            System.out.println("2. Restaurar obra");
            System.out.println("3. Ver obras en sala");
            System.out.println("4. Ceder obra");
            System.out.println("5. Calcular valor total");
            System.out.println("6. Login");
            System.out.println("7. Salir");

            System.out.print("Seleccione: ");
            String opcion = scanner.nextLine();

            // -------------------------
            if (opcion.equals("1")) {

                System.out.println("\nObras en catálogo:");
                for (ObraArte obra : catalogo.listarObras()) {
                    System.out.println("- " + obra.getTitulo()
                            + " ($" + obra.getValor() + ")");
                }
            }

            // -------------------------
            else if (opcion.equals("2")) {

                Restauracion restauracion =
                        new Restauracion("Limpieza", "2024-01-01");

                cuadro.agregarRestauracion(restauracion);

                System.out.println("Restauración aplicada a: "
                        + cuadro.getTitulo());
            }

            // -------------------------
            else if (opcion.equals("3")) {

                System.out.println("\nObras en sala:");
                for (ObraArte obra : visitante.consultarObras(sala)) {
                    System.out.println("- " + obra.getTitulo());
                }
            }

            // -------------------------
            else if (opcion.equals("4")) {

                Museo museoExterno =
                        new Museo("Museo Louvre", "Francia");

                Cesion cesion = new Cesion(
                        "2025-01-01",
                        "2025-12-31",
                        10000,
                        museoExterno
                );

                cesion.iniciarCesion();

                System.out.println("Obra cedida a: "
                        + museoExterno.getNombre());
            }

            // -------------------------
            else if (opcion.equals("5")) {

                double total = director.calcularValorTotal(catalogo);

                System.out.println("Valor total del museo: " + total);
            }

            // -------------------------
            else if (opcion.equals("6")) {

                System.out.print("Password: ");
                String password = scanner.nextLine();

                boolean login = auth.login(director, password);

                System.out.println("Login correcto: " + login);
            }

            // -------------------------
            else if (opcion.equals("7")) {

                System.out.println("Saliendo del sistema...");
                break;
            }

            else {
                System.out.println("Opción inválida");
            }
        }

        scanner.close();
    }
}