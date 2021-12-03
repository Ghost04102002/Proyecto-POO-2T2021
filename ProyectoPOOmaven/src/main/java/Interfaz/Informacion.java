/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Medidores.Med_analogico;
import Medidores.Med_digital;
import Modelo.Comercial;
import Modelo.Residencial;
import Provincia.Provincia;
import Usuario.Abonados;
import Usuario.Administradores;
import Usuario.Operarios;
import java.util.ArrayList;

/**
 *
 * @author malav
 */
public class Informacion {
    
    public static Sistema informacionSistema(){
        Sistema sis = new Sistema();
        
        Provincia[] pro = Provincia.values();
        for(int i=0; i < pro.length;i++){
            Sistema.getProvincias().add(pro[i]);
        }
        
        //Planes por defecto
        Comercial comercial = new Comercial();
        Sistema.getPlanes().add(comercial);
        Residencial residencial = new Residencial();
        Sistema.getPlanes().add(residencial);
        
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
        
        //Agregar Usuario
        Sistema.getUsuarios().add(ad);
        Sistema.getUsuarios().add(ope1);
        Sistema.getUsuarios().add(op2);
        Sistema.getUsuarios().add(ab1);
        Sistema.getUsuarios().add(ab2);
        
        //Medidor Analogico
        
        Med_analogico med1 = new Med_analogico();
        
        //Medidor Digital
        
        Med_digital med2 = new Med_digital();
        
        ab1.getMedidores().add(med1);
        ab1.getMedidores().add(med2);
        
        //Medidor Analogico
        
        Med_analogico med3 = new Med_analogico();
        ab2.getMedidores().add(med3);
        
        Sistema.getMedidores().add(med1);
        Sistema.getMedidores().add(med2);
        Sistema.getMedidores().add(med3);
        
        return sis;
    }
}
