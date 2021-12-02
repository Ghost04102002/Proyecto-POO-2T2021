/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;
import Medidores.*;
import Interfaz.Sistema;
import static Interfaz.Sistema.buscarFactura;
import static Interfaz.Sistema.buscarMedidor;
import Medidores.Medidor;
import Modelo.Factura;
import Modelo.Lectura;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author James Malavé
 */
public class Abonados extends Usuario {
    /**
     * Variables de Instancia
     */
    private ArrayList<Factura> facturas;
    private ArrayList<Medidor> medidores;
    private Sistema sis;

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
    
    public Abonados(String nombre, String clave){
        super(nombre,clave);
    }
    
    public Abonados(){}
    
    
    public void mostrarFacturasAsociadas(){
        System.out.println("Facturas Asociadas");
        System.out.printf("%s%20s%20s%n","Número Factura","Fecha Emisión"
                , "Código Medidor");
        for(Factura fac: facturas){
            if(fac!=null){
                System.out.printf("%4d%20.2f%20s%n",fac.getCodigo(),
                        fac.getFecha_emision(),fac.getMedidor().getCodigo());
            }
        }
    }
    
    
    public void ConsultarFactura(ArrayList<Factura> facturas,String codigo){
        Factura en = buscarFactura(facturas,codigo);
        if(en!=null){
            en.toString();
        }else{
            System.out.println("Factura no encontrada");
        }
    }
    
    public void mostrarMedidoresAsociados(){
        System.out.println("Medidores Asociados");
        System.out.printf("%s%20s%20s%n","Código Medidor","Tipo Medidor"
                ,"Nombre del Plan");
        for(Medidor med: medidores){
            if(med!=null){
                System.out.printf("4d%20.2f%20s%n",med.getCodigo(),
                        ((Med_digital)med).getMedidor(),med.getPlan().getNombre());       
            }
        }
    }
    
    public void ConsultarHistoricoFacturado(ArrayList<Medidor> medidores,String codigo){
        Medidor med = buscarMedidor(medidores,codigo);
        if(med!=null){
            
            System.out.println(med.toString()+"\nKiloVatios Consumidos:");
        }else{
            System.out.println("Medidor no encontrado");
        }

    } 
    

    public void mostrarMedidoresInteligentes(){
        System.out.println("Medidores Inteligentes Asociados");
        System.out.printf("%s%20s%20s%n","Código Medidor","Tipo Medidor"
                ,"Nombre del Plan");
        for(Medidor med: medidores){
            if(med!=null){
                if(med instanceof Med_analogico){
                    System.out.printf("4d%20.2f%20s%n",med.getCodigo(),
                            ((Med_digital)med).getMedidor(),
                            med.getPlan().getNombre());
                }
            }
        }
    }
    
    public void ConsultarConsumoPorHora(ArrayList<Medidor> medidores,String codigo,LocalDateTime Inicio, LocalDateTime fin){
        Medidor med = buscarMedidor(medidores,codigo);
        if(med instanceof Med_digital){
            Med_digital me = (Med_digital)med;
            ArrayList<Lectura> lecturas = me.getLecturas();
            System.out.println("Hora\tPromedio Consumo");
            for(Lectura lec : lecturas){
                if(lec!=null){
                System.out.println(lec.getFechaToma().minusHours(1));
                }
            }
        }
    }        
}
