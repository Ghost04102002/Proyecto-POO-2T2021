/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

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
    public static int generarMenuSistema(Scanner sc){
        System.out.println("Coorporacion Nacional De Electricidad");
        String op = "";
        do{
            System.out.println("1. Iniciar Sesion");
            System.out.println("2. Salir");
            op = sc.nextLine();
        }while(!op.equals("1") && !op.equals("2"));
        return Integer.parseInt(op);
    }
}
