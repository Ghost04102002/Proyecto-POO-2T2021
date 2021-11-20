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
 * @author malav
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
    
}
