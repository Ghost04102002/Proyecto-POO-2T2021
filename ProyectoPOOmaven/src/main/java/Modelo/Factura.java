/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Medidores.Med_analogico;
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
    public Lectura getLecturaanterior(){
        return lecturaanterior;
    }
    public void setLecturaanterior(Lectura lecturaanterior){
        this.lecturaanterior=lecturaanterior;
    }
    public Lectura getLecturaactual(){
        return lecturaactual;
    }
    public void setLecturaactual(Lectura lecturaactual){
        this.lecturaactual=lecturaactual;
    }
    
    public Factura(String string, Medidor med1, Plan_Energia plan) {
       this.fecha_emision = LocalDateTime.now();
        this.codigo = codigo;
        this.Plan = plan;
        this.medidor = medidor;
    }
    
    public Factura(String codigo, Medidor medidor,Plan_Energia plan,LocalDateTime ultimafechaCobrada,Lectura lecturaanterior,Lectura lecturaactual){
        this.fecha_emision = LocalDateTime.now();
        this.codigo = codigo;
        this.Plan = plan;
        this.ultimafechaCobrada = ultimafechaCobrada;
        this.medidor = medidor;
        this.lecturaanterior = lecturaanterior;
    }
    
    public Factura(){}
    
    public long encontrarDiasFacturados(){
         return ChronoUnit.DAYS.between(fecha_emision,ultimafechaCobrada);
    }
    public double Consumo(){
        return getLecturaactual().getKilovatios()-getLecturaanterior().getKilovatios();
    }


    @Override
    public String toString(){

        return "Codigo Factura: "+getCodigo()+"\nMedidor: "+getMedidor().getCodigo()+"\nNombre del Plan: "+getPlan().getNombre()+
                "\nDesde: "+getLecturaanterior().getFechaToma()+"\nHasta: "+getLecturaactual().getFechaToma()+
                "\nDias Facturados: "+encontrarDiasFacturados()+"\nLectura Anterior: "+getLecturaanterior().getKilovatios()+
                "\nLectura Actual: "+getLecturaactual().getKilovatios()+"\nConsumo: "+Consumo()+"\nCargo Fijo: "+
                Plan.getCargo_base()+"\nTota a pagar: "+getMedidor().CalcularValorPagar(fecha_emision);
    }    
    //falta hacer bien lo de CalcularValorPagar()    
}     
