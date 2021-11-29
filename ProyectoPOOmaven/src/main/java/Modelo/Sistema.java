/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Medidores.Medidor;
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
    private ArrayList<Plan_Energia> planes;
    private ArrayList<Medidor> medidores;
    private ArrayList<Factura> facturas;
    private ArrayList<Usuario> usuarios;

    public ArrayList<Plan_Energia> getPlanes() {
        return planes;
    }

    public void setPlanes(ArrayList<Plan_Energia> planes) {
        this.planes = planes;
    }

    public ArrayList<Medidor> getMedidores() {
        return medidores;
    }

    public void setMedidores(ArrayList<Medidor> medidores) {
        this.medidores = medidores;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
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
    public Usuario buscarUsuario(String user){
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
    public Medidor buscarMedidor(String codigo){
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
    public Factura buscarFactura(String codigo){
        for(Factura fac: facturas){
            if(fac!=null){
                if(fac.getCodigo().equals(codigo)){
                    return fac;
                }
            }
        }
        return null;
    }

    public boolean validarInicio(Usuario user, String contrasena){
        if(user.getContrasema().equals(contrasena)){
            return true;
        }
        return false; 
    }
    
    
    public Usuario loginSesion(String usuario, String contrasena){
        Usuario user = buscarUsuario(usuario);
        if(user!=null){
            if(validarInicio(user,contrasena)){
                return user;
            }
        }
        return null;
    }
    
    
    
}
