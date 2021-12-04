/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import Medidores.Med_analogico;
import Medidores.Medidor;
import Interfaz.Sistema;
import static Interfaz.Sistema.buscarMedidor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author James Malavé
 */
public class Operarios extends Usuario {
    
    private String codigo;

    /**
     *
     * @return
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public Operarios(String nombre, String clave){
        super(nombre,clave);
    }
    
    public Operarios(){}
    
    /**
     *
     * @param medidores
     * @param codigo
     * @param lectura
     */
    public static void RegistrarMedicion(ArrayList<Medidor> medidores,String codigo, Scanner sc){
        Medidor med = buscarMedidor(medidores,codigo);
        double lectura = 0;
        if(med!=null){
            if(med instanceof Med_analogico){
                Med_analogico me = (Med_analogico)med;
                System.out.println("Medidor"+me.toString()+"a nombre de "+buscarNombre(Sistema.getUsuarios(),codigo).getNombre_usu());
                System.out.println("Ultima lectura realizada:" + me.getLecturas().get(me.getLecturas().size()-1).getFechaToma());
                System.out.println("Lectura Anterior: " + me.getLecturas().get(me.getLecturas().size()-1).getKilovatios());
                System.out.println("Ingrese la lectura:");
                lectura = sc.nextDouble();
                sc.nextLine();
                System.out.println("KiloVatios consumidos:"+ (lectura-me.getLecturas().get(me.getLecturas().size()-1).getKilovatios()));
            }
        }else{
            System.out.println("Medidor no encontrado en el sistema");
        }
    }
    
    public static Usuario buscarNombre(ArrayList<Usuario> usuarios,String codigo){
        for(Usuario us: usuarios){
            if(us!=null){
                if(us instanceof Abonado){
                    Abonado ab = (Abonado)us;
                    if(buscarMedidor(ab.getMedidores(),codigo).equals(codigo)){
                        return ab;
                    }
                }
            }
        }    
        return null;
    }
}
