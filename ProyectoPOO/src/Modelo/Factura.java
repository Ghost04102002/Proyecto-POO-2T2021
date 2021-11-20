/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Medidores.Medidores;
import java.time.LocalDateTime;

/**
 *
 * @author malav
 */
public class Factura {
    
    /**
     * Variables de instancia
     */
    
    private LocalDateTime fecha_emision;
    private Medidores medidor;
    private Plan_Energia Plan; 
    
    public Factura(Medidores medidor){
        this.fecha_emision = LocalDateTime.now();
    }
    
    public void FinalizarFactura(){
    
    }
    
    @Override
    public String toString(){
        return "";
    }
}
