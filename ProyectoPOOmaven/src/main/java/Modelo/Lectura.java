/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDateTime;

/**
 *
 * @author malav
 */
public class Lectura {
    
    private LocalDateTime fechaToma;
    private double kilovatios;

    public LocalDateTime getFechaToma() {
        return fechaToma;
    }

    public void setFechaToma(LocalDateTime fechaToma) {
        this.fechaToma = fechaToma;
    }

    public double getKilovatios() {
        return kilovatios;
    }

    public void setKilovatios(double kilovatios) {
        this.kilovatios = kilovatios;
    }
    public Lectura(LocalDateTime fechaToma,double kilovatios){
        this.fechaToma=fechaToma;
        this.kilovatios=kilovatios;
    }
    public Lectura(){}    
}
