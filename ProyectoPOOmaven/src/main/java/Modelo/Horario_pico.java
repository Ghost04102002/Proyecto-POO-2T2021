/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author James Malavé
 */
public class Horario_pico {
        
    /**
     * variables de instancia
     */
    
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private int consumopico;

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
    public int getConsumopico(){
        return consumopico;
    }
    public void setConsumopico(int consumopico){
        this.consumopico=consumopico;
    }
    
    public Horario_pico(LocalTime horaInicio,LocalTime horaFin, int consumopico){
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.consumopico=consumopico;
    }
    
    public Horario_pico(){}
}
