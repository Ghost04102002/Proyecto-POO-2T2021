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
public class Operario extends Usuario {
    
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
    
    public Operario(String nombre, String clave){
        super(nombre,clave);
    }
    
    public Operario(){}
    
    /**
     *
     * @param medidores
     * @param codigo
     * @param lectura
     */
    public void RegistrarMedicion(ArrayList<Medidor> medidores,String codigo, Scanner sc){
        Medidor med = buscarMedidor(medidores,codigo);
        double lectura = 0;
        if(med!=null){
            if(med instanceof Med_analogico){
                Med_analogico me = (Med_analogico)med;
                System.out.println(me.toString());
                System.out.println("Ingrese la lectura:");
                lectura = sc.nextDouble();
                sc.nextLine();
            }
        }else{
            System.out.println("Medidor no encontrado en el sistema");
        }
    }        
}
