/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Medidores;

import Modelo.Lectura;
import Modelo.Plan_Energia;
import Modelo.TipoMedidor;
import static Modelo.TipoMedidor.ANALOGICO;
import Provincia.Provincia;
import java.time.LocalDateTime;

/**
 *
 * @author James Malavé
 */
public class Med_analogico extends Medidor {
    private TipoMedidor medidor;
    public TipoMedidor getMedidor() {
        return medidor;
    }
    public Med_analogico(String codigo, Plan_Energia plan,String direccion, Provincia provincia){
        super(codigo,plan,direccion,provincia);
        this.medidor=ANALOGICO;
    }
    public Med_analogico(){}

    @Override
    public double CalcularValorPagar(LocalDateTime fechaAccion) {
        double TotalPagar = 0;
        TotalPagar=getPlan().getCargo_base()+(getPlan().getCostokwporhora()*getConsumo());
        return TotalPagar;
    }

    @Override
    public void agregarLecutra(Lectura lec) {
        getLecturas().add(lec);
    }
}
