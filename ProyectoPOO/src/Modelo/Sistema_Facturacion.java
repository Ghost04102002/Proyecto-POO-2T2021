/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Medidores.Medidores;
import Usuario.Usuario;
import java.util.ArrayList;

/**
 *
 * @author James Malavé
 */
public class Sistema_Facturacion {
    /**
     * variables de intancia
     */
    private ArrayList<Plan_Energia> planes;
    private ArrayList<Medidores> medidores;
    private ArrayList<Usuario> usuarios;

    public ArrayList<Plan_Energia> getPlanes() {
        return planes;
    }

    public void setPlanes(ArrayList<Plan_Energia> planes) {
        this.planes = planes;
    }

    public ArrayList<Medidores> getMedidores() {
        return medidores;
    }

    public void setMedidores(ArrayList<Medidores> medidores) {
        this.medidores = medidores;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
        
    public Sistema_Facturacion(){}
    
    
    /**
     * Buscar el Usuario ingresado por parametro en el sistema
     * @param user
     * @return
     */
    public Usuario buscarUsuario(String user){
        for(Usuario us: usuarios){
            if(us.getNombre_usu().equals(user)){
                return us;
            }
        }
        return null;
    }
    
    /**
     * Buscar el Medidor ingresado por parametro en el sistema
     * @param codigo
     * @return
     */
    public Medidores buscarMedidor(String codigo){
        for(Medidores med : medidores){
            if(med.getCodigo().equals(codigo)){
                return med;
            }
        }
        return null;
    }
    
}
