/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import static Interfaz.Informacion.informacionSistema;
import static Interfaz.Menu.menuSistema;
import Modelo.Comercial;
import Modelo.Horario_pico;
import Provincia.Provincia;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author James Malavé
 */
public class Interfaz {
    
    public static Sistema sistema;
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        sistema = new Sistema();
        sistema = informacionSistema();
        
    }
}
