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
 * @author James Malavé
 */
public class Factura {
    
    /**
     * Variables de instancia
     */
    
    private LocalDateTime fecha_emision;
    private Medidores medidor;
    private Plan_Energia Plan; 

    public LocalDateTime getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(LocalDateTime fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Medidores getMedidor() {
        return medidor;
    }

    public void setMedidor(Medidores medidor) {
        this.medidor = medidor;
    }

    public Plan_Energia getPlan() {
        return Plan;
    }

    public void setPlan(Plan_Energia Plan) {
        this.Plan = Plan;
    }
    
    
    
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
