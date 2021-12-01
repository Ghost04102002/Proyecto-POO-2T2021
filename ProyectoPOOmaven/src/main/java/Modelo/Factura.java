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
    private LocalDateTime ultimaLecturaMasReciente;
    private double medidaUltimaLecturaCobrada;
    private double medidaLecturaActual;
    private double consumo;

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

    public LocalDateTime getUltimaLecturaMasReciente() {
        return ultimaLecturaMasReciente;
    }

    public void setUltimaLecturaMasReciente(LocalDateTime ultimaLecturaMasReciente) {
        this.ultimaLecturaMasReciente = ultimaLecturaMasReciente;
    }

    public double getMedidaUltimaLecturaCobrada() {
        return medidaUltimaLecturaCobrada;
    }

    public void setMedidaUltimaLecturaCobrada(double medidaUltimaLecturaCobrada) {
        this.medidaUltimaLecturaCobrada = medidaUltimaLecturaCobrada;
    }

    public double getMedidaLecturaActual() {
        return medidaLecturaActual;
    }

    public void setMedidaLecturaActual(double medidaLecturaActual) {
        this.medidaLecturaActual = medidaLecturaActual;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }
    
    public Factura(Medidor medidor){
        this.fecha_emision = LocalDateTime.now();
    }
    
    public void FinalizarFactura(){
        this.fecha_emision = LocalDateTime.now();
        
    }
    
    public int diasFacturados(LocalDateTime inicio, LocalDateTime fin){
        return 1;
    }
    
    public double consumo(double valorInicial,double valorFinal){
        return 1;
    }
    
    
    @Override
    public String toString(){
        return "Fecha de emisión: " + getFecha_emision()+
                "\nCodigo Medidor: " + getMedidor().getCodigo() + 
                "\nFecha lectura anterior: " + getUltimafechaCobrada() +
                "\nFecha lectura actual: " + getUltimaLecturaMasReciente()+
                "\nNumero de dias Facturados: " + diasFacturados(getUltimafechaCobrada(),getUltimaLecturaMasReciente())+
                "\nLectura Anterior: " + getMedidaUltimaLecturaCobrada()+
                "\nLectura Actual: " + getMedidaLecturaActual()+
                "\nConsumo KiloVatios: " + consumo(getMedidaUltimaLecturaCobrada(),getMedidaLecturaActual())+
                "\nCargo Fijo Plan"+
                "\nTotal a pagar:";
    }     
    
}
