package Medidores;

import Medidores.Lectura;
import Sistema.PlanEnergia;
import Sistema.Provincia;
import java.time.LocalDateTime;
import java.util.*;

/**
 *
 * @author James Malavé
 */
public abstract class Medidor {

    private String codigo;
    private String direccion;
    private PlanEnergia plan;
    private Provincia provincia;
    private double consumo;
    private ArrayList<Lectura> lecturas;

    public Medidor(String codigo, PlanEnergia plan, String direccion, Provincia provincia) {
        this.codigo = codigo;
        this.plan = plan;
        this.direccion = direccion;
        this.lecturas = new ArrayList<>();
        this.provincia = provincia;
        this.consumo = 0;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + "\nDireccion: " + direccion +
                "Plan: " + plan + "\nProvincia: " + provincia + "\nConsumo: " + consumo + "\nLecturas: " + lecturas;
    }
    public ArrayList<Lectura> filtrarLecturas(LocalDateTime fechaI,LocalDateTime fechaF){
        ArrayList<Lectura> filtradas = new ArrayList<>();
        lecturas.stream().filter(a->a.getFechaToma().isAfter(fechaI)&&a.getFechaToma().isBefore(fechaF)).forEach(l->filtradas.add(l));
        return filtradas;
    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public PlanEnergia getPlan() {
        return plan;
    }

    public void setPlan(PlanEnergia plan) {
        this.plan = plan;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public double getConsumo() {
        if (lecturas.isEmpty()) {
            return consumo;
        } else {
            consumo = lecturas.get(lecturas.size() - 1).getKilovatios();
            return consumo;
        }
    }

    public ArrayList<Lectura> getLecturas() {
        return lecturas;
    }

    public void setLecturas(ArrayList<Lectura> lecturas) {
        this.lecturas = lecturas;
    }

    public Lectura getLecturaUltimoCobro() {
        Lectura lUltimoC = lecturas.get(0);
        for(Lectura l: lecturas){
            if(l.isCobrado()){
                lUltimoC = l;
            }
        }
        return lUltimoC;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medidor other = (Medidor) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    public abstract double CalcularValorPagar(LocalDateTime fechaAccion);
}
