package Usuarios;

import Medidores.*;
import Sistema.Factura;
import java.util.ArrayList;
import java.util.Collections;

public class Abonado extends Usuario {

    private ArrayList<Factura> facturas;
    private ArrayList<Medidor> medidores;
    private String correo;
    private String cedula;

    public Abonado(String username, String pswd) {
        super(username, pswd);
        this.facturas = new ArrayList<>();
        this.medidores = new ArrayList<>();
    }
    
    public Abonado(String username, String pswd, String cedula) {
        super(username, pswd);
        this.facturas = new ArrayList<>();
        this.medidores = new ArrayList<>();
        this.cedula = cedula;
    }

    public Abonado(String username, String pswd, String correo, String cedula) {
        super(username, pswd);
        this.facturas = new ArrayList<>();
        this.medidores = new ArrayList<>();
        this.correo = correo;
        this.cedula = cedula;
    }

    public void asignarMedidor(Medidor m) {
        medidores.add(m);
    }

    public void mostrarMedidoresInteligentesAsociados() {
        System.out.println("Facturas asociadas");
        System.out.println("Número Factura\tFecha Emisión\tCódigo Medidor");
        this.medidores.forEach(m -> {
            if (m instanceof Inteligente) {
                System.out.println(m.getCodigo() + "\t\tInteligente\t" + m.getPlan().getNombre());
            }
        });
    }

    public void mostrarMedidoresAsociados() {
        System.out.println("Facturas asociadas");
        System.out.println("Código Medidor\tTipo Medidor\tNombre del Plan");
        this.medidores.forEach(m -> {
            String tipo;
            if (m instanceof Analogico) {
                tipo = "Analogico";
            } else {
                tipo = "Inteligente";
            }
            System.out.println(m.getCodigo() + "\t\t" + tipo + "\t" + m.getPlan().getNombre());
        });
    }

    public ArrayList<Factura> getFacturasMedidor(Medidor m, int n) {
        ArrayList<Factura> facMedidor = new ArrayList<>();
        for (Factura f : facMedidor) {
            if (f.getMedidor().equals(m)) {
                facMedidor.add(f);
            }
        }
        if (!facMedidor.isEmpty()) {
            Collections.reverse(facMedidor);
            return (ArrayList<Factura>) facMedidor.subList(0, n - 1);
        } else {
            return facMedidor;
        }
    }

    public void mostrarFacturasAsociadas() {

        if (!facturas.isEmpty()) {
            System.out.println("Facturas asociadas");
            System.out.println("Número Factura\tFecha Emisión\tCódigo Medidor");
            for (Factura f : this.facturas) {
                System.out.println(f.getCodigo() + "\t\t" + f.getFecha_emision() + "\t" + f.getMedidor().getCodigo());
            }
        } else {
            System.out.println("No tiene facturas registradas.");
        }
    }

    public boolean validarFactura(String codFactura) {
        for (Factura f : this.facturas) {
            if (f.getCodigo().equals(codFactura)) {
                return true;
            }
        }
        return false;
    }

    public boolean validarMedidor(String cod) {
        for (Medidor m : this.medidores) {
            if (m.getCodigo().equals(cod)) {
                return true;
            }
        }
        return false;
    }

    public Medidor getMedidor(String codigo) {
        for (Medidor m : this.medidores) {
            if (m.getCodigo().equals(codigo)) {
                return m;
            }
        }
        return null;
    }

    public Factura getFactura(String codFactura) {
        for (Factura f : this.facturas) {
            if (f.getCodigo().equals(codFactura)) {
                return f;
            }
        }
        return null;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }

    public ArrayList<Medidor> getMedidores() {
        return medidores;
    }

    public void setMedidores(ArrayList<Medidor> medidores) {
        this.medidores = medidores;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

}
