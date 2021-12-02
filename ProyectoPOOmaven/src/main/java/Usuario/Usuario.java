/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

/**
 *
 * @author James Malavé
 */
public class Usuario {
    /**
     * Variables de instancia
     */
    
    private String nombre_usu;
    private String contrasema;

    /**
     * 
     * @return 
     */
    public String getNombre_usu() {
        return nombre_usu;
    }

    /**
     *
     * @param nombre_usu
     */
    public void setNombre_usu(String nombre_usu) {
        this.nombre_usu = nombre_usu;
    }

    /**
     *
     * @return
     */
    public String getContrasema() {
        return contrasema;
    }

    /**
     *
     * @param contrasema
     */
    public void setContrasema(String contrasema) {
        this.contrasema = contrasema;
    }
      
    /**
     * Constructores
     * @param nombre_usu
     * @param contrasema
     */
    
    public Usuario(String nombre_usu, String contrasema){
        this.nombre_usu = nombre_usu;
        this.contrasema = contrasema;
    }
    
    /**
     * Constructor vacio
     */
    public Usuario(){}    
    
}
