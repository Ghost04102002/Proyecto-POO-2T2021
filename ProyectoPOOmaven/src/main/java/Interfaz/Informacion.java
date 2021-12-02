/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Medidores.Med_analogico;
import Usuario.Abonados;
import Usuario.Administradores;
import Usuario.Operarios;

/**
 *
 * @author malav
 */
public class Informacion {
    
    public static Sistema informacionSistema(){
        Sistema sis = new Sistema();
        
        //Usuario1
        
        Administradores ad = new Administradores("admin","superadmin");
        
        //Usuario2
        
        Operarios ope1 = new Operarios("Sara","SL10");
        
        //Usuario3
        
        Operarios op2 = new Operarios("Larry","cns1");
        
        //Usuario4
        
        Abonados ab1 = new Abonados("Martha","ma21");
        
        //Usuario5
        
        Abonados ab2 = new Abonados("Pablo","rop2");
        
        //Medidor Analogicoç
        
        String codigo1 = "COM001";
        String direccion = "";
        
        Med_analogico med1 = new Med_analogico();
        
        
        return sis;
    }
}
