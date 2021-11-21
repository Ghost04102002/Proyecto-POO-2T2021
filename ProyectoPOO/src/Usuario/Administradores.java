/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import Medidores.Medidor;
import Modelo.Plan_Energia;

/**
 *
 * @author malav
 */
public class Administradores extends Usuario{
    
    private String nombreAbonado;
    private String cedulaAbonado;
    private String correoAbonado;
    private String direccionInstalarMedidor;
    private Medidor tipoMedidor;
    private Plan_Energia tipoPlan;

    public String getNombreAbonado() {
        return nombreAbonado;
    }

    public void setNombreAbonado(String nombreAbonado) {
        this.nombreAbonado = nombreAbonado;
    }

    public String getCedulaAbonado() {
        return cedulaAbonado;
    }

    public void setCedulaAbonado(String cedulaAbonado) {
        this.cedulaAbonado = cedulaAbonado;
    }

    public String getCorreoAbonado() {
        return correoAbonado;
    }

    public void setCorreoAbonado(String correoAbonado) {
        this.correoAbonado = correoAbonado;
    }

    public String getDireccionInstalarMedidor() {
        return direccionInstalarMedidor;
    }

    public void setDireccionInstalarMedidor(String direccionInstalarMedidor) {
        this.direccionInstalarMedidor = direccionInstalarMedidor;
    }

    public Medidor getTipoMedidor() {
        return tipoMedidor;
    }

    public void setTipoMedidor(Medidor tipoMedidor) {
        this.tipoMedidor = tipoMedidor;
    }

    public Plan_Energia getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(Plan_Energia tipoPlan) {
        this.tipoPlan = tipoPlan;
    }
    
    
    /**
     * Constructor que inicializa las variables de instancia
     * @param usuario
     * @param contrasema
     */
    public Administradores(String usuario, String contrasema){
        super(usuario,contrasema);
    }
    
    
    /**
     * Constructor vacio
     */
    public Administradores(){}
    
    
}
