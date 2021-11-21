/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Provincia.Provincia;
import java.util.ArrayList;

/**
 *
 * @author James Malavé
 */
public class Plan_Energia {
    /**
     * variables de instancia
     */
    
    private TipoPlan nombre;
    private double cargo_base;
    private ArrayList<Provincia> provincias;
    private double costokwporhora;
    private ArrayList<Horario_pico> pico;

    public double getCargo_base() {
        return cargo_base;
    }

    public void setCargo_base(double cargo_base) {
        this.cargo_base = cargo_base;
    }

    public ArrayList<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(ArrayList<Provincia> provincias) {
        this.provincias = provincias;
    }

    public double getCostokwporhora() {
        return costokwporhora;
    }

    public void setCostokwporhora(double costokwporhora) {
        this.costokwporhora = costokwporhora;
    }

    public ArrayList<Horario_pico> getPico() {
        return pico;
    }

    public void setPico(ArrayList<Horario_pico> pico) {
        this.pico = pico;
    }
    
    public Plan_Energia(TipoPlan nombre, ArrayList<Provincia> provincias){
        this.nombre = nombre;
        this.provincias = provincias;
    }
    
    public Plan_Energia(){}
    
    
    
}
