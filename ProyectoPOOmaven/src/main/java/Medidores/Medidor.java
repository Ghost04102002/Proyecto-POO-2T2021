/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Medidores;

import Modelo.Lectura;
import Modelo.Plan_Energia;
import Provincia.Provincia;
import java.time.LocalDateTime;
import java.util.*;
/**
 *
 * @author James Malavé
 */
public abstract class Medidor {
    /**
     * Variables de instancia
     */
    
    private String codigo;
    private String direccion;
    private Plan_Energia plan;
    private Provincia provincia;
    private double consumo;
    private ArrayList<Lectura> lecturas;
    private Date ultimaFechaCobrada;
    private Date consumoUltimaFecha;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Plan_Energia getPlan() {
        return plan;
    }

    public void setPlan(Plan_Energia plan) {
        this.plan = plan;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public ArrayList<Lectura> getLecturas() {
        return lecturas;
    }

    public void setLecturas(ArrayList<Lectura> lecturas) {
        this.lecturas = lecturas;
    }

    public Date getUltimaFechaCobrada() {
        return ultimaFechaCobrada;
    }

    public void setUltimaFechaCobrada(Date ultimaFechaCobrada) {
        this.ultimaFechaCobrada = ultimaFechaCobrada;
    }

    public Date getConsumoUltimaFecha() {
        return consumoUltimaFecha;
    }

    public void setConsumoUltimaFecha(Date consumoUltimaFecha) {
        this.consumoUltimaFecha = consumoUltimaFecha;
    }

    
    public Medidor(String codigo, String plan, Provincia provincia){}
    
    public Medidor(){}
    
    public abstract double CalcularValorPagar(LocalDateTime fechaAccion);   
}
