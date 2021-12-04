/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import Interfaz.Sistema;
import static Interfaz.Sistema.StringToDate;
import static Interfaz.Sistema.StringToTime;
import Medidores.Medidor;
import Modelo.Factura;
import Modelo.Horario_pico;
import Modelo.Plan_Energia;
import Provincia.Provincia;
import com.mycompany.proyectopoomaven.Correo;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author malav
 */
public class Administrador extends Usuario {

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
    public Administrador(String usuario, String contrasema) {
        super(usuario, contrasema);
    }

    public Administrador(String usuario, String contrasema, String nombreAbonado,
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
    public Administrador() {
    }

    public static void RegistrarPlan(ArrayList<Provincia> Provincias, Scanner sc) {
        System.out.println("\t Registro de Plan\n");

        String tipoPlan, validar,horaspc,horafin = "";

        ArrayList<Provincia> provinciasPlan = new ArrayList<>();
        ArrayList<Horario_pico> horas = new ArrayList<>();

        int nombrespro = 0;
        int numeroPro = 0;

        double costoKiloVatio, cargoBase = 0;

        LocalTime horaspico,horasfin;

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
        do{
            System.out.println("Ingrese el Inicio de la horapico (HH:MM:SS): ");
            horaspc = sc.nextLine();
            horaspico = StringToTime(horaspc);
            System.out.println("Ingrese el Fin de la horapico");
            horafin = sc.nextLine();
            horasfin = StringToTime(horafin);
            horas.add(new Horario_pico(horaspico,horasfin));
            System.out.println("Desea agregar mas horas(S/N):");
            validar = sc.nextLine().toUpperCase();
        }while(validar.equals("S"));
        System.out.println("\nRegistrando Plan...\n");
        Plan_Energia plan = new Plan_Energia(tipoPlan,cargoBase,costoKiloVatio,provinciasPlan,horas);
        Sistema.getPlanes().add(plan);
        System.out.println("\nRegistro Exitoso\n");
    }

    public static void RegistrarMedidor(Scanner sc) {
        String nombre,correo,cedula,contrasenia,direccion,tipoPlan,tipoMedidor = "";
        System.out.println("\n Registro Medidor");
        System.out.println("Ingrese el numero de cedula: ");
        cedula = sc.nextLine();
        Usuario ab = Sistema.buscarUsuario(cedula, Sistema.getUsuarios());
        if (ab != null) {

        } else {
            System.out.println("Ingrese el nombre del Abonado: ");
            nombre = sc.nextLine();
            System.out.println("Ingrese su correo electronico: ");
            correo = sc.nextLine();
            contrasenia = crearContrasenia();
            System.out.println("Ingresar direccion: ");
            direccion = sc.nextLine();
            System.out.println("Tipos de medidores\n1)INTELIGENTE\n2)ANALOGICO\nIngrese su opcion(1/2):");
            String tm = sc.nextLine();
            if("1".equals(tm)){tipoMedidor = "INTELIGENTE";}else if("2".equals(tm)){tipoMedidor="ANALOGICO";}
            System.out.println("Ingrese el tipo de plan:");
            tipoPlan = sc.nextLine();
            String contenido = "usuario: "+cedula+"\ncontraseña: "+contrasenia+"\nDirección del medidor: "+direccion
                    +"\nTipo de Medidor: "+tipoMedidor+"\nTipo de plan: "+tipoPlan;
            Correo.enviarEmail(correo, "DATOS MEDIDOR", contenido);
        }
    }

    public static void SimularMediciones(String fechaInicio, String fechaFin) {
        LocalDate i =StringToDate(fechaInicio);
        LocalDate f =StringToDate(fechaFin);
//        for(Medidor m: medidores){}
        
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
    
    
    public static String crearContrasenia(){
        String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String password = "";
        Random rnd = new Random();
        for (int i = 0; i < 8; i++) {
            int pos = rnd.nextInt(caracteres.length());
            password += caracteres.charAt(pos);
        }
        return password;
    }
}
