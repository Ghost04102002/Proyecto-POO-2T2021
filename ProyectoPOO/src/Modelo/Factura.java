/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Medidores.Medidor;
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
    private Medidor medidor;
    private Plan_Energia Plan;
    private String codigo;

    public LocalDateTime getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(LocalDateTime fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Medidor getMedidor() {
        return medidor;
    }

    public void setMedidor(Medidor medidor) {
        this.medidor = medidor;
    }

    public Plan_Energia getPlan() {
        return Plan;
    }

    public void setPlan(Plan_Energia Plan) {
        this.Plan = Plan;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public Factura(Medidor medidor){
        this.fecha_emision = LocalDateTime.now();
    }
    
    public void FinalizarFactura(){
    
    }
    
    @Override
    public String toString(){
        return "";
    }
}
