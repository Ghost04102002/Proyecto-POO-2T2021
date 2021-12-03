/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import static Interfaz.Informacion.informacionSistema;
import static Interfaz.Menu.menuSistema;
import static Interfaz.Menu.menuUsuario;
import static Interfaz.Menu.verificarInicioUsuario;
import Modelo.Comercial;
import Modelo.Horario_pico;
import Provincia.Provincia;
import Usuario.Abonados;
import static Usuario.Administradores.RegistrarPlan;
import Usuario.Usuario;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author James Malavé
 */
public class Interfaz {

    public static Sistema sistema;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        Usuario nuevoUsuario = new Usuario();
        sistema = new Sistema();
        sistema = informacionSistema();

        int opcion = menuSistema(sc);
        boolean salirPrograma = false;
        boolean salirmenuAbonado = false;
        boolean salirmenuAdministrador = false;
        boolean salirmenuOperario = false;

        while (!salirPrograma) {
            switch (opcion) {
                case 1:
                    do {
                        salirmenuAbonado = false;
                        salirmenuAdministrador = false;
                        salirmenuOperario = false;
                        nuevoUsuario = verificarInicioUsuario(Sistema.getUsuarios(), sc);
                        System.out.println("Buscando Usuario...");
                        if (nuevoUsuario != null) {
                            cargarPrograma(salirmenuAbonado, salirmenuAdministrador, salirmenuOperario, nuevoUsuario, sc);
                        } else {
                            System.out.println("Usuario no encontrado");
                        }
                    } while (nuevoUsuario == null);
                    break;
                case 2:
                    System.out.println("Saliendo...");
                    System.out.println("Gracias por su tiempo, vuelva pronto");
                    break;
            }
        }
    }

    public static void cargarPrograma(boolean salirmenuAbonado, boolean salirmenuAdministrador, boolean salirmenuOperario, Usuario us, Scanner sc) {
        String opciones = "";

        if (us instanceof Abonados) {
            while (!salirmenuAbonado) {
                menuUsuario(us);
                opciones = sc.nextLine();
                if (!opciones.equalsIgnoreCase("1") && !opciones.equalsIgnoreCase("2")
                        && !opciones.equalsIgnoreCase("3") && !opciones.equalsIgnoreCase("4")) {
                    System.out.println("Opcion no valida");
                }

                switch (opciones) {
                    case "1":
                        Abonados ab = (Abonados)us;
                        ab.mostrarFacturasAsociadas();
                        System.out.println("Ingrese el codigo de la facutra");
                        String codigo = sc.nextLine();
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.println("\nVolviendo al Menu Principal...\n");
                        salirmenuAbonado = true;
                        break;
                }
                break;
            }
        }
    }

}
