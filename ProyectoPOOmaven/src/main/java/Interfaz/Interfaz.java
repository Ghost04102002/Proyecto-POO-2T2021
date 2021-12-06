/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Interfaz;

import Medidores.*;
import Sistema.*;
import Usuarios.*;
import Utiles.Correo;
import Utiles.Utiles;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Interfaz {

    private static Sistema sistema = new Sistema();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        cargarDatos();
        String opcion;

        do {
            System.out.println("PROGRAMA DE CONTROL ELÉCTRICO");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Salir");
            System.out.println("Elige una opción: ");
            opcion = sc.nextLine();
            switch (opcion) {
                case "1": {
                    opcion1();
                }
                case "2": {
                    System.out.println("Saliendo...");
                    System.out.println("Gracias por su tiempo, vuelva pronto");
                    break;
                }
                default: {
                    System.out.println("Opción no válida.");
                    break;
                }

            }
        } while (!"2".equals(opcion));
    }

    public static void opcion1() {
        do {
            System.out.println("Ingrese su usuario:");
            String usuario = sc.nextLine();
            System.out.println("Ingrese su contraseña:");
            String pswd = sc.nextLine();
            sistema.ingresar(usuario, pswd);
        } while (sistema.getUsuarioActivo() == null);
        Usuario ua = sistema.getUsuarioActivo();
        if (ua instanceof Administrador) {
            Administrador admin = (Administrador) sistema.getUsuarioActivo();
            opcionesAdministrador(admin);
        } else if (ua instanceof Operario) {
            Operario op = (Operario) sistema.getUsuarioActivo();
            opcionesOperario(op);
        } else if (ua instanceof Abonado) {
            Abonado ab = (Abonado) sistema.getUsuarioActivo();
            opcionesAbonado(ab);
        }
    }

    public static void opcionesAdministrador(Administrador admin) {
        String opcion = "0";
        while (!"5".equals(opcion)) {
            System.out.println("MENU ADMINISTRADOR");
            System.out.println("1. Registrar Plan");
            System.out.println("2. Registrar Medidor");
            System.out.println("3. Simular Mediciones");
            System.out.println("4. Realizar Facturación");
            System.out.println("5. Salir");
            System.out.println("Elija una opción: ");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1": {
                    registrarPlan(admin);
                    break;
                }
                case "2": {
                    registrarMedidor(admin);
                    break;
                }
                case "3": {
                    simularMediciones(admin);
                    break;
                }
                case "4": {
                    realizarFacturacion(admin);
                    break;
                }
                case "5": {
                    System.out.println("Volviendo al menú de ingreso...");
                    break;
                }
                default: {
                    System.out.println("Opción incorrecta.");
                    break;
                }
            }
        }
    }

    public static void opcionesOperario(Operario op) {
        String opcion;
        do {
            System.out.println("MENU OPERARIO");
            System.out.println("1. Registrar Medición");
            System.out.println("2. Salir");
            System.out.println("Elige una opción: ");
            opcion = sc.nextLine();
            switch (opcion) {
                case "1": {
                    registrarMedicion(op);
                }
                case "2": {
                    System.out.println("Volviendo al menú de ingreso...");
                    break;
                }
                default: {
                    System.out.println("Opción no válida.");
                    break;
                }
            }
        } while (!"2".equals(opcion));

    }

    public static void opcionesAbonado(Abonado abonado) {
        String opcion = "0";
        while (!"4".equals(opcion)) {
            System.out.println("MENU ABONADO");
            System.out.println("1. Consultar Factura.");
            System.out.println("2. Consultar histórico facturado.");
            System.out.println("3. Consultar consumos por hora.");
            System.out.println("4. Salir");
            System.out.println("Elija una opción: ");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1": {
                    consultarFactura(abonado);
                    break;
                }
                case "2": {
                    consultarHistoricoFacturado(abonado);
                    break;
                }
                case "3": {
                    consultarConsumosPorHora(abonado);
                    break;
                }
                case "4": {
                    System.out.println("Volviendo al menú de ingreso...");
                    break;
                }
                default: {
                    System.out.println("Opción incorrecta.");
                    break;
                }
            }
        }
    }

    public static String pedirProvincia(boolean varios) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Las Provincias del Ecuador:");
        for (Provincia p : Provincia.values()) {
            System.out.println(p.ordinal() + 1 + ". " + p.toString());
        }
        if (varios) {
            System.out.println("Ingrese los numeros de las provincias escogidas separados por comas:");
        } else {
            System.out.println("Ingrese el número de la provincia escogida:");
        }
        String prov = sc.nextLine();
        return prov;
    }

    public static void registrarPlan(Administrador admin) {
        System.out.println("\tRegistro de Plan\n");
        String nombre = "";
        do {
            if (sistema.verificarPrevio(nombre)) {
                System.out.println("Ya existe un plan con ese nombre.");
            }
            System.out.println("Ingrese el nombre del Plan: ");
            nombre = sc.nextLine();
        } while (sistema.verificarPrevio(nombre));
        double costokw = 0;
        boolean done = false;
        while (!done) {
            try {
                System.out.println("Ingrese el costo del kilovatio por hora en dólares:");
                costokw = sc.nextDouble();
                sc.nextLine();
                done = true;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Valor no valido");
            }
        }
        String prov = pedirProvincia(true);
        boolean validarCargo = false;
        double cargoBase = 0;
        while(!validarCargo){
            try{
                System.out.println("Ingrese cargo base para el plan:");
                cargoBase = sc.nextDouble();
                sc.nextLine();
                validarCargo = true;
            }catch(InputMismatchException e){
                sc.nextLine();
                System.out.println("Valor no valido");
            }
        }
        System.out.println("Ingrese el inicio de el horario pico:");
        String horaInicio = sc.nextLine();
        System.out.println("Ingrese el final de el horario pico:");
        String horaFinal = sc.nextLine();
        admin.registrarPlan(sistema, nombre, prov, cargoBase, costokw, horaInicio, horaFinal);
        System.out.println("Plan registrado exitosamente.");
        System.out.println(sistema.getPlanes());
    }

    public static void registrarMedidor(Administrador admin) {
        String nombre, correo, cedula, contrasenia, direccion, nombrePlan, tipoMedidor = "";
        System.out.println("\n Registro Medidor");
        System.out.println("Ingrese el numero de cedula: ");
        cedula = sc.nextLine();
        Abonado ab = sistema.buscarAbonado(cedula);
        if (ab == null) {
            System.out.println("Abonado no existe. Comienza registro.");
            System.out.println("Ingrese el nombre del Abonado: ");
            nombre = sc.nextLine();
            System.out.println("Ingrese su correo electronico: ");
            correo = sc.nextLine();
            contrasenia = Utiles.crearPswd();
            ab = new Abonado(nombre, contrasenia, cedula, correo);
            System.out.println("Abonado creado.\n");

        } else {
            System.out.println("Abonado ya registrado en el sistema.");
        }
        System.out.println("Registro de Medidor.");
        System.out.println("Ingresar direccion: ");
        direccion = sc.nextLine();
        System.out.println("Tipos de medidores\n1)INTELIGENTE\n2)ANALOGICO\nIngrese su opcion(1/2):");
        String tm = sc.nextLine();
        if ("1".equals(tm)) {
            tipoMedidor = "Inteligente";

        } else if ("2".equals(tm)) {
            tipoMedidor = "Analogico";
        }
        nombrePlan = "";
        System.out.println("Ingrese el tipo de plan:");
        nombrePlan = sc.nextLine();
        while (!sistema.verificarPrevio(nombrePlan)) {
            System.out.println("El plan ingresado no existe, intente nuevamente.");
            System.out.println("Ingrese el tipo de plan:");
            nombrePlan = sc.nextLine();
        }
        String cod = sistema.generarCodigoMedidor(tipoMedidor);
        String prov = pedirProvincia(false);
        admin.registrarMedidor(sistema, cod, nombrePlan, direccion, prov);
        System.out.println("Medidor registrado.");
        String contenido = "usuario: " + ab.getCedula() + "\ncontraseña: " + ab.getPswd() + "\nDirección del medidor: " + direccion
                + "\nTipo de Medidor: " + tipoMedidor + "\nTipo de plan: " + nombrePlan;
        Correo.enviarEmail(ab.getCorreo(), "DATOS MEDIDOR", contenido);
        System.out.println("Correo con los datos fue enviado.");
    }

    public static void simularMediciones(Administrador admin) {
        System.out.println("Fecha Inicio:");
        String fechaI = sc.nextLine();
        System.out.println("Fecha Fin:");
        String fechaF = sc.nextLine();
        admin.simularMediciones(sistema, fechaI, fechaF);
    }

    public static void realizarFacturacion(Administrador admin) {
        //codigo, medidor, plan, lecturaAnterior, lecturaActual
        for (Usuario u : sistema.getUsuarios()) {
            if (u instanceof Abonado) {
                Abonado ab = (Abonado) u;
                admin.realizarFacturacion(sistema, ab);
            }
        }
    }

    public static Object[] pedirCodigoMedidor() {
        System.out.println("Ingrese el código del medidor: ");
        String codigo = sc.nextLine();
        Object[] datos = sistema.buscarMedidor(codigo);
        while (datos != null) {
            System.out.println("El medidor con el código ingresado no existe.");
            System.out.println("Ingrese el código del medidor: ");
            codigo = sc.nextLine();
            datos = sistema.buscarMedidor(codigo);
        }
        return datos;
    }

    public static void registrarMedicion(Operario op) {
        Object[] datos = pedirCodigoMedidor();
        Abonado abonado = (Abonado) datos[0];
        Medidor medidor = (Medidor) datos[1];
        Lectura ultimaLectura = medidor.getLecturas().get(medidor.getLecturas().size() - 1);
        System.out.println("Medidor analógico a nombre de " + abonado.getUsername() + "\nÚltima lectura realizada en: " + ultimaLectura.getFechaToma()
                + "Lectura anterior: " + ultimaLectura.getKilovatios() + " kw");
        System.out.println("Ingrese la medida actual del medidor: ");
        String medida = sc.nextLine();
        op.registrarMedicion(sistema, abonado, medidor, medida, ultimaLectura);
    }

    public static void consultarFactura(Abonado ab) {
        ab.mostrarFacturasAsociadas();
        if (!ab.getFacturas().isEmpty()) {
            String codFactura = "";
            System.out.println("Ingrese código de factura:");
            codFactura = sc.nextLine();
            while (!ab.validarFactura(codFactura)) {
                System.out.println("No existe factura con el código ingresado");
                System.out.println("Ingrese código de factura:");
                codFactura = sc.nextLine();
            }
            Factura fAbonado = ab.getFactura(codFactura);
            System.out.println(fAbonado);
        }
    }

    public static void consultarHistoricoFacturado(Abonado ab) {
        ab.mostrarMedidoresAsociados();
        System.out.println("Ingrese el código del medidor a consultar:");
        String codMedidor = sc.nextLine();
        while (!ab.validarMedidor(codMedidor)) {
            System.out.println("No existe un medidor con ese código.");
            System.out.println("Ingrese el código del medidor a consultar:");
            codMedidor = sc.nextLine();
        }
        Medidor medidor = ab.getMedidor(codMedidor);
        ArrayList<Factura> facturasMedidor = ab.getFacturasMedidor(medidor, 3);
        if (!facturasMedidor.isEmpty()) {
            System.out.println("Consumo de las últimas 3 facturas:");
            System.out.println("Número Factura\t" + "Kw Consumidos" + "\t" + "Valor a Pagar");
            facturasMedidor.forEach(f -> {
                System.out.println(f.getCodigo() + "\t\t" + f.getConsumoFacturado() + f.getValorFactura());
            });
        } else {
            System.out.println("Aún no tiene facturas para ese medidor.");
        }

    }

    public static void consultarConsumosPorHora(Abonado ab) {
        ab.mostrarMedidoresInteligentesAsociados();
        System.out.println("Ingrese el código del medidor a consultar:");
        String codMedidor = sc.nextLine();
        while (!ab.validarMedidor(codMedidor)) {
            System.out.println("No existe un medidor con ese código.");
            System.out.println("Ingrese el código del medidor a consultar:");
            codMedidor = sc.nextLine();
        }
        Medidor medidor = ab.getMedidor(codMedidor);
        System.out.println("Fecha Inicio:");
        String fechaI = sc.nextLine();
        System.out.println("Fecha Fin:");
        String fechaF = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime fechaInicio = LocalDate.parse(fechaI, formatter).atStartOfDay();
        LocalDateTime fechaFin = LocalDate.parse(fechaF, formatter).atStartOfDay();
        long mediciones = Duration.between(fechaInicio, fechaFin).toHours();
        System.out.println("Hora" + "\t\t" + "Promedio Consumo");
        LocalDateTime fechaInicioRango = fechaInicio;
        ArrayList<Double> promedios = new ArrayList<>();
        promedios.add(0.);
        for (int i = 1; i <= mediciones; i++) {
            LocalDateTime fechaFinRango = fechaInicioRango.plusHours(1);
            ArrayList<Lectura> filtro = medidor.filtrarLecturas(fechaInicioRango, fechaFinRango);
            double total = 0;
            for (Lectura l : filtro) {
                total += l.getKilovatios();
            }
            double promedioI = total / filtro.size();
            double consumoAnterior = promedios.get(promedios.size() - 1);
            promedios.add(promedioI);
            double promedio = promedioI - consumoAnterior;
            System.out.println(fechaInicioRango + " - " + fechaFinRango + "\t\t" + promedio);
            fechaInicioRango = fechaFinRango;
        }

    }

    public static void cargarDatos() {
        Administrador admin = new Administrador("admin", "superadmin");
        Operario op1 = new Operario("operario1", "operario1");
        Operario op2 = new Operario("operario2", "operario2");
        PlanEnergia pe1 = new PlanEnergia("Premium", Provincia.intToAL(1, 2, 3, 4, 5), 15, 5, LocalTime.of(19, 00), LocalTime.of(23, 00));
        PlanEnergia pe2 = new PlanEnergia("Basic", Provincia.intToAL(6, 7, 8), 3, 2, LocalTime.of(14, 00), LocalTime.of(20, 00));
        Abonado ab1 = new Abonado("abonado1", "abonado1","0001");
        Abonado ab2 = new Abonado("abonado2", "abonado2","0002");
        Analogico m1ab1 = new Analogico("A001", pe1, "Colinas de la Alborada", Provincia.GUAYAS);
        Inteligente m2ab1 = new Inteligente("I001", pe2, "Calle Galápagos y 10 de agosto", Provincia.SANTAELENA);
        Analogico mab2 = new Analogico("A002", pe1, "Florida", Provincia.GUAYAS);
        m1ab1.agregarLectura("01-12-2021 15:30,75");
        m1ab1.agregarLectura("02-12-2021 00:30,87");
        m2ab1.generarLecturas(6);
        mab2.agregarLectura("01-12-2021 19:00,16");
        mab2.agregarLectura("02-12-2021 04:00,33");
        ab1.asignarMedidor(m1ab1);
        ab1.asignarMedidor(m2ab1);
        ab2.asignarMedidor(mab2);
        Usuario[] usuariosIniciales = {admin, op1, op2, ab1, ab2};
        sistema.getUsuarios().addAll(Arrays.asList(usuariosIniciales));
        sistema.getPlanes().add(pe1);
        sistema.getPlanes().add(pe2);
    }

}
