/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
    
    private String nombre;
    private double cargo_base;
    private ArrayList<Provincia> provincias;
    private double costokwporhora;
    private ArrayList<Horario_pico> pico;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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


    
    
    public Plan_Energia(String nombre, double cargo_base,double costokwporhora){
        this.nombre = nombre;
        this.provincias = new ArrayList<>();
        this.cargo_base=cargo_base;
        this.costokwporhora=costokwporhora;
        this.pico=new ArrayList<>();
    } 
    
    public Plan_Energia(){}    
    
    public void agregarHoraPico(Horario_pico pic){
        getPico().add(pic);     
    }
}
