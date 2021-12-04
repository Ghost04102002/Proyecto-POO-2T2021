/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;


import Medidores.Med_analogico;
import Medidores.Med_digital;
import Medidores.Medidor;
import Modelo.Comercial;
import Modelo.Factura;
import Modelo.Horario_pico;
import Modelo.Lectura;
import Modelo.Residencial;
import Provincia.Provincia;
import static Provincia.Provincia.AZUAY;
import static Provincia.Provincia.CARCHI;
import static Provincia.Provincia.PICHINCHA;
import Usuario.Abonado;
import Usuario.Administrador;
import Usuario.Operarios;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
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
        Horario_pico pico = new Horario_pico(LocalTime.of(8, 0, 0),LocalTime.of(9, 0, 0));
        Horario_pico pico2 = new Horario_pico(LocalTime.of(13, 0, 0),LocalTime.of(14, 0, 0));
        Sistema.getPlanes().add(comercial);
        Residencial residencial = new Residencial();
        Sistema.getPlanes().add(residencial);
        
        String nombre,contrasenia,correo,direccion="";
        
        //Usuario1
        
        Administrador ad = new Administrador("admin","superadmin");
        
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
        
        Abonado ab1 = new Abonado(nombre,contrasenia,correo,direccion);
        //Usuario5
        
        nombre = "Pablo";
        contrasenia = "rop2";
        correo = "";
        direccion = "";
        
        Abonado ab2 = new Abonado(nombre,contrasenia,correo,direccion);
        
        //Agregar Usuario
        Sistema.getUsuarios().add(ad);
        Sistema.getUsuarios().add(ope1);
        Sistema.getUsuarios().add(op2);
        Sistema.getUsuarios().add(ab1);
        Sistema.getUsuarios().add(ab2);
        
        //Medidor Analogico
        
        Med_analogico med1 = new Med_analogico("COOM001",Sistema.getPlanes().get(0),"CALLE ...",AZUAY);
        
        Med_digital med2 = new Med_digital("COOM002",Sistema.getPlanes().get(1),"CALLE...",PICHINCHA);
        
        ab1.getMedidores().add(med1);
        ab1.getMedidores().add(med2);
        
        //Medidor Analogico 
     
        Med_analogico med3 = new Med_analogico("COOM003",Sistema.getPlanes().get(0),"CALLE...",CARCHI);
        ab2.getMedidores().add(med3);
        
        Factura fac1 = new Factura("3575677",med1,med1.getPlan());
        ab1.getFacturas().add(fac1);
        Sistema.getFacturas().add(fac1);
        
        Sistema.getMedidores().add(med1);
        Sistema.getMedidores().add(med2);
        Sistema.getMedidores().add(med3);
        
        return sis;
    }
}
