package Medidores;

import Sistema.PlanEnergia;
import Sistema.Provincia;
import java.time.Duration;
import java.time.LocalDateTime;

public class Inteligente extends Medidor {
    
    public Inteligente(String codigo, PlanEnergia plan, String direccion, Provincia provincia) {
        super(codigo, plan, direccion, provincia);
    }

    @Override
    public double CalcularValorPagar(LocalDateTime fechaAccion) {
        double total = getPlan().getCargoBase() + getPlan().getCostoKVporHora() * getConsumoNoPico() + 2 * getPlan().getCostoKVporHora() * getConsumoPico();
        return total;
    }

    public double getConsumoPico() {
        PlanEnergia plan = this.getPlan();
        long hpAlDia = Duration.between(plan.getHoraPicoI(), plan.getHoraPicoF()).toSecondsPart();
        double porcentaje = hpAlDia / 24*60*60;
        return getConsumo() * porcentaje;

    }

    public double getConsumoNoPico() {
        PlanEnergia plan = this.getPlan();
        long hpAlDia = Duration.between(plan.getHoraPicoI(), plan.getHoraPicoF()).toSecondsPart();
        double porcentaje = (1 - hpAlDia) / 26 * 60 * 60;
        return getConsumo() * porcentaje;
    }

    public void generarLecturas(int mediciones) {
        LocalDateTime inicial;
        if (getLecturas().isEmpty()) {
            inicial = LocalDateTime.now().minusHours(mediciones * 2);
        } else {
            inicial = getLecturas().get(getLecturas().size() - 1).getFechaToma();
        }
        for (int i = 0; i < mediciones; i++) {
            double kv = Math.random() * 2 + 0.1;
            Lectura l = new Lectura(LocalDateTime.now().plusMinutes(30 * i), this.getConsumo()+kv);
            this.getLecturas().add(l);
        }
    }

}
