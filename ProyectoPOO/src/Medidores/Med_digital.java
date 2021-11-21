/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medidores;

import Modelo.TipoMedidor;
import java.time.LocalDateTime;

/**
 *
 * @author James Malavé
 */
public class Med_digital extends Medidor{
    
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

    
}
