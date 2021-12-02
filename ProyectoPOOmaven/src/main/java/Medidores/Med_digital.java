/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Medidores;

import Modelo.Lectura;
import Modelo.TipoMedidor;
import java.time.LocalDateTime;
/**
 *
 * @author James Malavé
 */
public class Med_digital extends Medidor {
    
    private TipoMedidor medidor;

    public TipoMedidor getMedidor() {
        return medidor;
    }

    public void setMedidor(TipoMedidor medidor) {
        this.medidor = medidor;
    }
    
    public Med_digital(){}
    
    @Override
    public double CalcularValorPagar(LocalDateTime fechaAccion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarLecutra(Lectura lec) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
