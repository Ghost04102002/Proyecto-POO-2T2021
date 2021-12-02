/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import Medidores.Medidor;
import Modelo.Factura;
import Modelo.Plan_Energia;
import Modelo.TipoPlan;
import static Modelo.TipoPlan.COMERCIAL;
import static Modelo.TipoPlan.RESIDENCIAL;
import Usuario.Usuario;
import java.util.ArrayList;

/**
 *
 * @author James Malavé
 */
public class Sistema {
    /**
     * variables de intancia
     */
    private static ArrayList<Plan_Energia> planes;
    private static ArrayList<Medidor> medidores;
    private static ArrayList<Factura> facturas;
    private static ArrayList<Usuario> usuarios;

    public static ArrayList<Plan_Energia> getPlanes() {
        return planes;
    }

    public static void setPlanes(ArrayList<Plan_Energia> planes) {
        Sistema.planes = planes;
    }

    public static ArrayList<Medidor> getMedidores() {
        return medidores;
    }

    public static void setMedidores(ArrayList<Medidor> medidores) {
        Sistema.medidores = medidores;
    }

    public static ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public static void setFacturas(ArrayList<Factura> facturas) {
        Sistema.facturas = facturas;
    }

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(ArrayList<Usuario> usuarios) {
        Sistema.usuarios = usuarios;
    }


    
    /**
     * Constructor vacio, inicializa las variables
     */
    public Sistema(){
        this.usuarios = new ArrayList<>();
        this.planes = new ArrayList<>();
        this.medidores = new ArrayList<>();
        this.facturas = new ArrayList<>();
    }
    
    
    /**
     * Buscar el Usuario ingresado por parametro en el sistema
     * @param user
     * @return
     */
    public static Usuario buscarUsuario(ArrayList<Usuario> usuarios,String user){
        for(Usuario us: usuarios){
            if(us!=null){
                if(us.getNombre_usu().equals(user)){
                    return us;
                }
            }
        }
        return null;
    }
    
    /**
     * Buscar el Medidor ingresado por parametro en el sistema
     * @param codigo
     * @return
     */
    public static Medidor buscarMedidor(ArrayList<Medidor> medidores,String codigo){
        for(Medidor med : medidores){
            if(med!=null){
                if(med.getCodigo().equals(codigo)){
                    return med;
                }    
            }
        }
        return null;
    }
    
    /**
     * Busca Factura ingresado por parametro en el sistema
     * @param codigo
     * @return
     */
    public static Factura buscarFactura(ArrayList<Factura> facturas,String codigo){
        for(Factura fac: facturas){
            if(fac!=null){
                if(fac.getCodigo().equals(codigo)){
                    return fac;
                }
            }
        }
        return null;
    }

    public static boolean validarInicio(Usuario user, String contrasena){
        if(user.getContrasema().equals(contrasena)){
            return true;
        }
        return false; 
    }
    
    
    public static Usuario loginSesion(ArrayList<Usuario> usuarios,String usuario, String contrasena){
        Usuario user = buscarUsuario(usuarios,usuario);
        if(user!=null){
            if(validarInicio(user,contrasena)){
                return user;
            }
        }
        return null;
    }
    
    public static boolean validarPlan(String tipoPlan){
        return false;
    }
}
