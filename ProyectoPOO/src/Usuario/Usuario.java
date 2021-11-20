/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

/**
 *
 * @author malav
 */
public abstract class Usuario {
    /**
     * Variables de instancia
     */
    
    private String nombre_usu;
    private String contrasema;
    
    /**
     * Constructores
     */
    
    public Usuario(String nombre_usu, String contrasema){
        this.nombre_usu = nombre_usu;
        this.contrasema = contrasema;
    }
    
    public Usuario(){}

    public String getNombre_usu() {
        return nombre_usu;
    }

    public void setNombre_usu(String nombre_usu) {
        this.nombre_usu = nombre_usu;
    }

    public String getContrasema() {
        return contrasema;
    }

    public void setContrasema(String contrasema) {
        this.contrasema = contrasema;
    }
}
