/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import Medidores.Med_analogico;
import Medidores.Medidor;
import Interfaz.Sistema;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author James Malavé
 */
public class Operarios extends Usuario {
    
    private String codigo;
    private Sistema sis;

    /**
     *
     * @return
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    /**
     *
     * @param medidores
     * @param codigo
     * @param lectura
     */
    public void RegistrarMedicion(ArrayList<Medidor> medidores,String codigo, double lectura){
        Medidor med = sis.buscarMedidor(medidores,codigo);
        if(med!=null){
            if(med instanceof Med_analogico){
                Med_analogico me = (Med_analogico)med;
                System.out.println("Ingrese la lectura:");
                
            }
        }else{
            System.out.println("Medidor no encontrado en el sistema");
        }
    }        
}
