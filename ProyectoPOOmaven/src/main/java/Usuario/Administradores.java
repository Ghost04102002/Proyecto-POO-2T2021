/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import Interfaz.Sistema;
import Medidores.Medidor;
import Modelo.Factura;
import Modelo.Plan_Energia;
import Provincia.Provincia;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author malav
 */
public class Administradores extends Usuario {

    private String nombreAbonado;
    private String cedulaAbonado;
    private String correoAbonado;
    private String direccionInstalarMedidor;
    private Medidor tipoMedidor;
    private Plan_Energia tipoPlan;

    public String getNombreAbonado() {
        return nombreAbonado;
    }

    public void setNombreAbonado(String nombreAbonado) {
        this.nombreAbonado = nombreAbonado;
    }

    public String getCedulaAbonado() {
        return cedulaAbonado;
    }

    public void setCedulaAbonado(String cedulaAbonado) {
        this.cedulaAbonado = cedulaAbonado;
    }

    public String getCorreoAbonado() {
        return correoAbonado;
    }

    public void setCorreoAbonado(String correoAbonado) {
        this.correoAbonado = correoAbonado;
    }

    public String getDireccionInstalarMedidor() {
        return direccionInstalarMedidor;
    }

    public void setDireccionInstalarMedidor(String direccionInstalarMedidor) {
        this.direccionInstalarMedidor = direccionInstalarMedidor;
    }

    public Medidor getTipoMedidor() {
        return tipoMedidor;
    }

    public void setTipoMedidor(Medidor tipoMedidor) {
        this.tipoMedidor = tipoMedidor;
    }

    public Plan_Energia getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(Plan_Energia tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    /**
     * Constructor que inicializa las variables de instancia
     *
     * @param usuario
     * @param contrasema
     */
    public Administradores(String usuario, String contrasema) {
        super(usuario, contrasema);
    }

    public Administradores(String usuario, String contrasema, String nombreAbonado,
            String cedulaAbonado, String correoAbonado, String direccion) {
        this(usuario, contrasema);
        this.nombreAbonado = nombreAbonado;
        this.cedulaAbonado = cedulaAbonado;
        this.correoAbonado = correoAbonado;
        this.direccionInstalarMedidor = direccion;
    }

    /**
     * Constructor vacio
     */
    public Administradores() {
    }

    public static void RegistrarPlan(ArrayList<Provincia> Provincias, Scanner sc) {
        System.out.println("\t Registro de Plan\n");

        String tipoPlan, validar = "";

        ArrayList<Provincia> provinciasPlan = new ArrayList<>();

        int nombrespro = 0;
        int numeroPro = 0;

        double costoKiloVatio, cargoBase = 0;

        LocalTime horaspico;

        do {
            System.out.println("Ingrese el nombre del Plan: ");
            tipoPlan = sc.nextLine();
        } while (validarPlan(Sistema.getPlanes(), tipoPlan));

        System.out.println("Ingrese el costo del KiloVatioPorHora: ");
        costoKiloVatio = sc.nextDouble();
        sc.nextLine();
        System.out.println("Las Provincias del Ecuador");
        int contador = 1;
        for (Provincia s : Sistema.getProvincias()) {
            System.out.println(contador + "." + s.toString());
            contador++;
        }
        do {
            System.out.println("En cuantas provincias desee que este disponible: ");
            
                numeroPro = sc.nextInt();
                sc.nextLine();
            if (numeroPro < 0 || numeroPro > 24) {
                System.out.println("Valor no valido");
            }
        } while (numeroPro < 0 || numeroPro > 24);
        do {
            for(int i=1;i<=numeroPro;i++){
                System.out.println("Ingrese el indice de las provincias: ");
                nombrespro = sc.nextInt();
                if(0<=nombrespro && nombrespro<=24){
                    provinciasPlan.add(Sistema.getProvincias().get(nombrespro-1));
                }
                else{
                    System.out.println("Valores fuera de rango");
                }
            }
        } while (nombrespro < 0 || nombrespro > 24);
        
        System.out.println("Ingrese el cargo Base: ");
        cargoBase = sc.nextDouble();
        sc.nextLine();
        System.out.println("Ingrese las horas pico: ");
        
    }

    public static void RegistrarMedidor(Scanner sc) {
        System.out.println("\n Registro Medidor");
        System.out.println("Ingrese el numero de cedula: ");
        String cedula = sc.nextLine();
        Usuario ab = Sistema.buscarUsuario(cedula, Sistema.getUsuarios());
        if (ab != null) {

        } else {

        }
    }

    public static void SimularMediciones() {
    }

    public static void RealizarFacturacion() {
        for (Factura fac : Sistema.getFacturas()) {
            fac.FinalizarFactura();
        }
    }

    public static boolean validarPlan(ArrayList<Plan_Energia> planes, String tipoPlan) {
        for (Plan_Energia plan : planes) {
            if (plan != null) {
                if (plan.getNombre().equals(tipoPlan)) {
                    System.out.println("El nombre ingresado ya existe en el sistema");
                    return true;
                }
            }
        }
        return false;
    }

    public static Provincia buscarProvincia(ArrayList<Provincia> provincias, String provincia) {
        for (Provincia pro : provincias) {
            if (pro != null) {
                if (pro.toString().equals(provincia)) {
                    return pro;
                }
            }
        }
        return null;
    }
}
