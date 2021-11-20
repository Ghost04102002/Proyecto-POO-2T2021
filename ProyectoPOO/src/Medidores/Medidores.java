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
 * @author malav
 */
public abstract class Medidores {
    /**
     * Variables de instancia
     */
    
    private String codigo;
    private Plan_Energia plan;
    private Provincia provincia;
    private double consumo;
    
    public abstract double CalcularValorPagar(LocalDateTime fechaAccion);
}
