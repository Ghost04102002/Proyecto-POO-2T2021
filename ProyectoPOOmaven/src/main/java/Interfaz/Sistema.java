/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import Medidores.Medidor;
import Modelo.Factura;
import Modelo.Plan_Energia;
import Provincia.Provincia;
import Usuario.Abonados;
import Usuario.Usuario;
import com.mycompany.proyectopoomaven.Correo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author James Malavé
 */
public class Sistema {

    /**
     * variables de intancia
     */
    private static ArrayList<Plan_Energia> planes;
    private static ArrayList<Medidor> medidores;
    private static ArrayList<Factura> facturas;
    private static ArrayList<Usuario> usuarios;
    private static ArrayList<Provincia> provincias;

    public static ArrayList<Plan_Energia> getPlanes() {
        return planes;
    }

    public static void setPlanes(ArrayList<Plan_Energia> planes) {
        Sistema.planes = planes;
    }

    public static ArrayList<Medidor> getMedidores() {
        return medidores;
    }

    public static void setMedidores(ArrayList<Medidor> medidores) {
        Sistema.medidores = medidores;
    }

    public static ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public static void setFacturas(ArrayList<Factura> facturas) {
        Sistema.facturas = facturas;
    }

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(ArrayList<Usuario> usuarios) {
        Sistema.usuarios = usuarios;
    }

    public static ArrayList<Provincia> getProvincias() {
        return provincias;
    }

    public static void setProvincias(ArrayList<Provincia> provincias) {
        Sistema.provincias = provincias;
    }

    /**
     * Constructor vacio, inicializa las variables
     */
    public Sistema() {
        this.usuarios = new ArrayList<>();
        this.planes = new ArrayList<>();
        this.medidores = new ArrayList<>();
        this.facturas = new ArrayList<>();
        this.provincias = new ArrayList<>();
    }

    /**
     * Buscar el Usuario ingresado por parametro en el sistema
     *
     * @param user
     * @return
     */
    public static Usuario buscarUsuario(ArrayList<Usuario> usuarios, String user) {
        for (Usuario us : usuarios) {
            if (us != null) {
                if (us.getNombre_usu().equals(user)) {
                    return us;
                }
            }
        }
        return null;
    }

    public static Usuario buscarUsuario(String cedula, ArrayList<Usuario> usuarios) {
        for (Usuario us : usuarios) {
            if (us != null) {
                if (us instanceof Abonados) {
                    Abonados ab = (Abonados) us;
                    if (ab.getCedula().equals(cedula)) {
                        return ab;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Buscar el Medidor ingresado por parametro en el sistema
     *
     * @param codigo
     * @return
     */
    public static Medidor buscarMedidor(ArrayList<Medidor> medidores, String codigo) {
        for (Medidor med : medidores) {
            if (med != null) {
                if (med.getCodigo().equals(codigo)) {
                    return med;
                }
            }
        }
        return null;
    }

    /**
     * Busca Factura ingresado por parametro en el sistema
     *
     * @param codigo
     * @return
     */
    public static Factura buscarFactura(ArrayList<Factura> facturas, String codigo) {
        for (Factura fac : facturas) {
            if (fac != null) {
                if (fac.getCodigo().equals(codigo)) {
                    return fac;
                }
            }
        }
        return null;
    }

    public static boolean validarInicio(Usuario user, String contrasena) {
        if (user.getContrasema().equals(contrasena)) {
            return true;
        }
        return false;
    }

    public static Usuario loginSesion(ArrayList<Usuario> usuarios, String usuario, String contrasena) {
        Usuario user = buscarUsuario(usuarios, usuario);
        if (user != null) {
            if (validarInicio(user, contrasena)) {
                return user;
            }
        }
        return null;
    }


    /**
     *
     * @param fecha
     * @return
     */
    public static LocalDate StringToDate(String fecha) {
        DateTimeFormatter fec = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(fecha, fec);
    }
    
    public static LocalTime StringToTime(String hora){
        String[] formato = hora.split(":");
        return LocalTime.of(Integer.parseInt(formato[0]), Integer.parseInt(formato[1]), Integer.parseInt(formato[1]));
    }

    public static void enviarCorreo(String destinatario, String asunto, String contenido) {
        Correo.enviarEmail(destinatario, asunto, contenido);
    }



}
