package Medidores;

import Sistema.PlanEnergia;
import Sistema.Provincia;
import java.time.LocalDateTime;


public class Analogico extends Medidor{

    public Analogico(String codigo, PlanEnergia plan, String direccion, Provincia provincia) {
        super(codigo, plan, direccion, provincia);
    }
    
    @Override
    public double CalcularValorPagar(LocalDateTime fechaAccion) {
        double total = getPlan().getCargoBase() + getPlan().getCostoKVporHora() * getConsumo();
        return total;
    }

    public void agregarLectura(String lectura) {
        this.getLecturas().add(Lectura.createFromStr(lectura));
    }
    
}
