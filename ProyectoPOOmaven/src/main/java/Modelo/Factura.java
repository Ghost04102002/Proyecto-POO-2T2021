/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
    private String codigo;
    private Medidor medidor;
    private Plan_Energia Plan;
    private LocalDateTime ultimafechaCobrada;

    public LocalDateTime getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(LocalDateTime fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public LocalDateTime getUltimafechaCobrada() {
        return ultimafechaCobrada;
    }

    public void setUltimafechaCobrada(LocalDateTime ultimafechaCobrada) {
        this.ultimafechaCobrada = ultimafechaCobrada;
    }
    
    public Factura(Medidor medidor){
        this.fecha_emision = LocalDateTime.now();
    }
    
    public void FinalizarFactura(){
        this.fecha_emision = LocalDateTime.now();
        
    }
    
    @Override
    public String toString(){
        return "";
    }    
    
}
