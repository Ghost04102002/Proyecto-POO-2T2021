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
        
        String nombre,contrasenia,correo,direccion="";
        
        //Usuario1
        
        Administradores ad = new Administradores("admin","superadmin");
        
        //Usuario2
        nombre = "Sara";
        contrasenia="SL10";
        
        Operarios ope1 = new Operarios(nombre,contrasenia);
        
        //Usuario3
        
        Operarios op2 = new Operarios("Larry","cns1");
        
        //Usuario4
        
        nombre = "Martha";
        contrasenia = "ma21";
        correo = "";
        direccion = "";
        
        Abonados ab1 = new Abonados(nombre,contrasenia,correo,direccion);
        
        //Usuario5
        
        nombre = "Pablo";
        contrasenia = "rop2";
        correo = "";
        direccion = "";
        
        Abonados ab2 = new Abonados(nombre,contrasenia,correo,direccion);
        
        //Medidor Analogico
        
        Med_analogico med1 = new Med_analogico();
        
        
        return sis;
    }
}
