package Usuarios;

import Medidores.*;
import Sistema.*;
import Utiles.Correo;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Administrador extends Usuario {

    public Administrador(String username, String pswd) {
        super(username, pswd);
    }

    public void registrarPlan(Sistema s, String nombre, String prov, double cargoBase, double costokw, String horaInicio, String horaFinal) {
        ArrayList<Provincia> provinciasPlan = new ArrayList<>();

        LocalTime inicio = LocalTime.parse(horaInicio);
        LocalTime fin = LocalTime.parse(horaFinal);
        for (String p : prov.split(",")) {
            int i = Integer.parseInt(p);
            provinciasPlan.add(Provincia.values()[i - 1]);
        }
        PlanEnergia plan = new PlanEnergia(nombre, provinciasPlan, cargoBase, costokw, inicio, fin);
        s.getPlanes().add(plan);
    }

    public void registrarMedidor(Sistema s, String codigo, String tipoPlan, String direccion, String prov) {
        PlanEnergia plan = s.buscarPlan(tipoPlan);
        Provincia provincia = Provincia.intToAL(Integer.parseInt(prov)).get(0);
        Inteligente medidor = new Inteligente(codigo, plan, direccion, provincia);
        s.getMedidoresSistema().add(medidor);
    }

    public void simularMediciones(Sistema s, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        
        int c = 0;
        for(Medidor m: s.getMedidoresSistema()){
            if(m instanceof Inteligente){
                c++;
            }
        }
        System.out.println("Hay " + c + " medidor(es) inteligente(s):");
        for (Medidor m : s.getMedidoresSistema()) {
            if (m instanceof Inteligente) {
                System.out.println("Lecturas para medidor con código " + m.getCodigo() + " con valor actual " + m.getConsumo() + " kw");
                int mediciones = (int) Duration.between(fechaInicio, fechaFin).toMinutes() / 10;
                for (int i = 0; i <= mediciones; i++) {
                    double kv = Math.random() * 10;
                    Lectura lec = new Lectura(fechaInicio.plusMinutes(10 * i), m.getConsumo() + kv);
                    m.getLecturas().add(lec);
                    System.out.println(m.getCodigo() + "," + " " + lec);
                }
            }
        }
    }

    public void realizarFacturacion(Sistema s, Abonado ab) {
        for (Medidor m : ab.getMedidores()) {
            String codigo = s.generarCodigoFactura();
            Lectura lecturaAnterior = m.getLecturaUltimoCobro();
            Lectura lecturaActual = m.getLecturas().get(m.getLecturas().size() - 1);
            Factura f = new Factura(codigo, m, m.getPlan(), lecturaAnterior, lecturaActual);
            s.getFacturasSistema().add(f);
            Correo.enviarEmail(ab.getCorreo(), "Factura: "+codigo, f.toString());
        }
    }
}
