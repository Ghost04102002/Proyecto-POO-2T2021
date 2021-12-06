package Sistema;

import Medidores.*;
import java.time.Duration;
import java.time.LocalDateTime;

public class Factura {

    private LocalDateTime fecha_emision;
    private String codigo;
    private Medidor medidor;
    private PlanEnergia plan;
    private LocalDateTime ultimafechaCobrada;
    private Lectura lecturaAnterior;
    private Lectura lecturaActual;
    private double valorFactura;

    public Factura(String codigo, Medidor medidor, PlanEnergia plan, Lectura lecturaAnterior, Lectura lecturaActual) {
        this.fecha_emision = LocalDateTime.now();
        this.codigo = codigo;
        this.medidor = medidor;
        this.plan = plan;
        this.ultimafechaCobrada = lecturaAnterior.getFechaToma();
        this.lecturaAnterior = lecturaAnterior;
        this.lecturaActual = lecturaActual;
        this.valorFactura = medidor.CalcularValorPagar(fecha_emision);
    }

    public double getValorFactura() {
        return valorFactura;
    }
    
    public long encontrarDiasFacturados() {
        return Math.abs(Duration.between(fecha_emision, ultimafechaCobrada).toDays());
    }

    public double getConsumoFacturado() {
        return lecturaActual.getKilovatios() - lecturaAnterior.getKilovatios();
    }

    public LocalDateTime getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(LocalDateTime fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Medidor getMedidor() {
        return medidor;
    }

    public void setMedidor(Medidor medidor) {
        this.medidor = medidor;
    }

    public PlanEnergia getPlan() {
        return plan;
    }

    public void setPlan(PlanEnergia plan) {
        this.plan = plan;
    }

    public LocalDateTime getUltimafechaCobrada() {
        return ultimafechaCobrada;
    }

    public void setUltimafechaCobrada(LocalDateTime ultimafechaCobrada) {
        this.ultimafechaCobrada = ultimafechaCobrada;
    }

    public Lectura getLecturaAnterior() {
        return lecturaAnterior;
    }

    public void setLecturaAnterior(Lectura lecturaAnterior) {
        this.lecturaAnterior = lecturaAnterior;
    }

    public Lectura getLecturaActual() {
        return lecturaActual;
    }

    public void setLecturaActual(Lectura lecturaActual) {
        this.lecturaActual = lecturaActual;
    }
    
    @Override

    public String toString() {

        return "Codigo Factura: " + codigo + "\nMedidor: " + medidor.getCodigo() + "\nNombre del Plan: " + plan.getNombre()
                + "\nDesde: " + lecturaAnterior.getFechaToma() + "\nHasta: " + lecturaActual.getFechaToma()
                + "\nDias Facturados: " + encontrarDiasFacturados() + "\nLectura Anterior: " + lecturaAnterior.getKilovatios()
                + "\nLectura Actual: " + lecturaActual.getKilovatios() + "\nConsumo: " + getConsumoFacturado() + "\nCargo Fijo: "
                + plan.getCargoBase() + "\nTotal a pagar: " + valorFactura;
    }
}
