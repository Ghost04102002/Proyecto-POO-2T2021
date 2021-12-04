/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import static Interfaz.Informacion.informacionSistema;
import static Interfaz.Menu.menuAdministrador;
import static Interfaz.Menu.menuOperario;
import static Interfaz.Menu.menuSistema;
import static Interfaz.Menu.menuUsuario;
import static Interfaz.Menu.verificarInicioUsuario;
import static Interfaz.Sistema.StringToDate;
import Modelo.Comercial;
import Modelo.Horario_pico;
import Provincia.Provincia;
import Usuario.Abonados;
import Usuario.Administradores;
import static Usuario.Administradores.RealizarFacturacion;
import static Usuario.Administradores.RegistrarMedidor;
import static Usuario.Administradores.RegistrarPlan;
import static Usuario.Administradores.SimularMediciones;
import Usuario.Operarios;
import Usuario.Usuario;
import java.time.LocalDateTime;
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

        
        int opcion = 0;
        boolean salirPrograma = false;
        boolean salirmenuAbonado = false;
        boolean salirmenuAdministrador = false;
        boolean salirmenuOperario = false;
        
        while (!salirPrograma) {
            opcion = menuSistema(sc);
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
        String opciones, codigo, fechaInicio,fechaFin = "";
        
        if (us instanceof Abonados) {
            Abonados ab = (Abonados) us;
            while (!salirmenuAbonado) {
                menuUsuario(us);
                opciones = sc.nextLine();
                if (!opciones.equalsIgnoreCase("1") && !opciones.equalsIgnoreCase("2")
                        && !opciones.equalsIgnoreCase("3") && !opciones.equalsIgnoreCase("4")) {
                    System.out.println("Opcion no valida");
                }
                
                switch (opciones) {
                    case "1":
                        ab.mostrarFacturasAsociadas();
                        System.out.println("Ingrese el codigo de la facutra: ");
                        codigo = sc.nextLine();
                        ab.ConsultarFactura(ab.getFacturas(), codigo);
                        break;
                    case "2":
                        ab.mostrarMedidoresAsociados();
                        System.out.println("Ingrese el código del medidor a consultar: ");
                        codigo = sc.nextLine();
                        ab.ConsultarHistoricoFacturado(ab.getMedidores(), codigo);
                        break;
                    case "3":
                        ab.mostrarMedidoresInteligentes();
                        System.out.println("Ingrese código medidor a consultar: ");
                        codigo = sc.nextLine();
                        System.out.println("Ingrese Fecha Inicio: ");
                        fechaInicio = sc.nextLine();
                        System.out.println("Ingrese Fecha Fin: ");
                        fechaFin = sc.nextLine();
                        ab.ConsultarConsumoPorHora(ab.getMedidores(), codigo, StringToDate(fechaInicio),StringToDate(fechaFin));
                        break;
                    case "4":
                        System.out.println("\nVolviendo al Menu Principal...\n");
                        salirmenuAbonado = true;
                        break;
                }
                break;
            }
        }
        
        if(us instanceof Administradores){
            Administradores ad = (Administradores)us;
            while(!salirmenuAdministrador){
                menuAdministrador();
                opciones = sc.nextLine();
                if (!opciones.equalsIgnoreCase("1") && !opciones.equalsIgnoreCase("2")
                        && !opciones.equalsIgnoreCase("3") && !opciones.equalsIgnoreCase("4") 
                        && !opciones.equalsIgnoreCase("5")) {
                    System.out.println("Opcion no valida");
                }
                
                switch(opciones){
                    case"1":
                        RegistrarPlan(Sistema.getProvincias(),sc);
                        break;
                    case "2":
                        RegistrarMedidor(sc);
                        break;
                    case "3":
                        SimularMediciones();
                        break;
                    case "4":
                        RealizarFacturacion();
                        break;
                    case "5":
                        System.out.println("\nVolviendo al Menu Prinicipal...\n");
                        salirmenuAdministrador = true;
                        break;
                }
                
                break;
                
            }
        }
        
        if(us instanceof Operarios){
            Operarios op = (Operarios)us;
            while(!salirmenuOperario){
                menuOperario();
                opciones = sc.nextLine();
                if (!opciones.equalsIgnoreCase("1") && 
                        !opciones.equalsIgnoreCase("2")) {
                    System.out.println("Opcion no valida");
                }
                
                switch(opciones){
                    case "1":
                        System.out.println("Ingrese el codigo del medidor: ");
                        codigo = sc.nextLine();
                        op.RegistrarMedicion(Sistema.getMedidores(), codigo, sc);
                        break;
                    case "2":
                        System.out.println("\nVolviendo al Menu Prinicipal...\n");
                        salirmenuOperario = true;
                        break;
                }
                
                break;
            }
        }
    }
    
}
