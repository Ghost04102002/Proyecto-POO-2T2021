/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import static Interfaz.Sistema.loginSesion;
import Usuario.*;
import Usuario.Usuario;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author James Malavé
 */
public class Menu {
    
    /**
     *  Carga la información de las opciones disponibles del programa.
     * @param sc Valor ingresado por consola
     * @return Devuelve la pcion escogida
     */
    public static int menuSistema(Scanner sc){
        System.out.println("Coorporacion Nacional De Electricidad");
        String op = "";
        do{
            System.out.println("1. Iniciar Sesion");
            System.out.println("2. Salir");
            op = sc.nextLine();
        }while(!op.equals("1") && !op.equals("2"));
        return Integer.parseInt(op);
    }
    
    /**
     *
     * @param usuarios
     * @param sc
     * @return
     */
    public static Usuario verificarInicioUsuario(ArrayList<Usuario> usuarios,Scanner sc){
        String us,contra = "";
        System.out.println("Ingrese su usuario: ");
        us = sc.nextLine();
        System.out.println("Ingrese su contrasenia: ");
        contra = sc.nextLine();
        return loginSesion(usuarios,us,contra);
    }
    
    public static void menuAdministrador(){
        System.out.println("\n Menu del Administrador");
        System.out.println("1. Registrar Plan");
        System.out.println("2. Registrar Medidor");
        System.out.println("3. Simular Mediciones");
        System.out.println("4. Realizar Facturacion");
        System.out.println("5. Regresar");
    }
    
    public static void menuOperario(){
        System.out.println("\n Menu Operario");
        System.out.println("1. Registrar Medicion");
        System.out.println("2. Regresar");
    }
    
    public static void menuAbonado(){
        System.out.println("\n Menu Abonado");
        System.out.println("1. Consultar factura");
        System.out.println("2. Consultar historico facturado");
        System.out.println("3. Consultar consumo por hora");
        System.out.println("4. Regresar");
        
    }
    
    public static void menuUsuario(Usuario us){
        if(us instanceof Administrador){
            menuAdministrador();
        }
        if(us instanceof Operario){
            menuOperario();
        }
        if(us instanceof Abonado){
            menuAbonado();
        }
    }
}
    
