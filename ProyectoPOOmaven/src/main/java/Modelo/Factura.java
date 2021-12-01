/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Medidores.Medidor;
import java.time.*;
import java.time.temporal.ChronoUnit;

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
    private Lectura lecturaanterior;
    private Lectura lecturaactual;
   
    

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
    public long encontrarDiasFacturados(){
         return ChronoUnit.DAYS.between(fecha_emision,ultimafechaCobrada);
    }
    public double Consumo(){
        return lecturaactual.getKilovatios()-lecturaanterior.getKilovatios();
    }

    
    @Override
    public String toString(){
        return "Codigo Factura: "+codigo+"\nMedidor: "+medidor.getCodigo()+"\nNombre del Plan: "+Plan.getNombre()+
                "\nDesde: "+lecturaanterior.getFechaToma()+"\nHasta: "+lecturaactual.getFechaToma()+
                "\nDias Facturados: "+encontrarDiasFacturados()+"\nLectura Anterior: "+lecturaanterior.getKilovatios()+
                "\nLectura Actual: "+lecturaactual.getKilovatios()+"\nConsumo: "+Consumo()+"\nCargo Fijo: "+
                Plan.getCargo_base()+"\nTota a pagar: "+medidor.CalcularValorPagar(fecha_emision);
    }    
    //falta hacer bien lo de CalcularValorPagar()    
}
