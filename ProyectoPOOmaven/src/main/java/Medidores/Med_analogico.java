/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Medidores;

import Modelo.Lectura;
import java.time.LocalDateTime;

/**
 *
 * @author James Malavé
 */
public class Med_analogico extends Medidor {

    @Override
    public double CalcularValorPagar(LocalDateTime fechaAccion) {
        double TotalPagar = 0;
        return TotalPagar;
    }

    @Override
    public void agregarLecutra(Lectura lec) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
