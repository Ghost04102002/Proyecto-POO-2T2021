package Sistema;

import java.time.LocalTime;
import java.util.ArrayList;


public class PlanEnergia {
    private String nombre;
    private ArrayList<Provincia> provinciasVigentes;
    private double costoKVporHora;
    private double cargoBase;
    private LocalTime horaPicoI;
    private LocalTime horaPicoF;

    public PlanEnergia(String nombre, ArrayList<Provincia> provinciasVigentes,double cargoBase, double costoKVporHora, LocalTime horaPicoI, LocalTime horaPicoF) {
        this.nombre = nombre;
        this.provinciasVigentes = provinciasVigentes;
        this.cargoBase = cargoBase;
        this.costoKVporHora = costoKVporHora;
        this.horaPicoI = horaPicoI;
        this.horaPicoF = horaPicoF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Provincia> getProvinciasVigentes() {
        return provinciasVigentes;
    }

    public void setProvinciasVigentes(ArrayList<Provincia> provinciasVigentes) {
        this.provinciasVigentes = provinciasVigentes;
    }

    public double getCostoKVporHora() {
        return costoKVporHora;
    }

    public void setCostoKVporHora(double costoKVporHora) {
        this.costoKVporHora = costoKVporHora;
    }

    public double getCargoBase() {
        return cargoBase;
    }

    public void setCargoBase(double cargoBase) {
        this.cargoBase = cargoBase;
    }

    public LocalTime getHoraPicoI() {
        return horaPicoI;
    }

    public void setHoraPicoI(LocalTime horaPicoI) {
        this.horaPicoI = horaPicoI;
    }

    public LocalTime getHoraPicoF() {
        return horaPicoF;
    }

    public void setHoraPicoF(LocalTime horaPicoF) {
        this.horaPicoF = horaPicoF;
    }

    @Override
    public String toString() {
        return "PlanEnergia{" + "nombre=" + nombre + ", costoKVporHora=" + costoKVporHora + ", cargoBase=" + cargoBase + '}';
    }
    
    
    
}
