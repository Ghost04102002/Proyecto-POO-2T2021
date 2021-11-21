/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medidores;

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
    private Plan_Energia plan;
    private Provincia provincia;
    private double consumo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
    
    public Medidor(String codigo, String plan, Provincia provincia){}
    
    public Medidor(){}
    
    public abstract double CalcularValorPagar(LocalDateTime fechaAccion);
}
