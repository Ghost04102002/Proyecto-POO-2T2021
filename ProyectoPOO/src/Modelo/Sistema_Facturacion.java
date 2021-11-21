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
    
    
    
    public Usuario buscarUsuario(String user){
        return null;
    }
    
    public Medidores buscarMedidor(String codigo){
        return null;
    }
}
