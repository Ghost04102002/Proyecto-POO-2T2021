/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;
import Medidores.*;
import Modelo.Sistema;
import Medidores.Medidor;
import Modelo.Factura;
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
    
    public void ConsultarFactura(String codigo){
        System.out.println("Facturas Asociadas");
        System.out.printf("%s%20s%20s%n","Número Factura","Fecha Emisión"
                , "Código Medidor");
        for(Factura fac: facturas){
            if(fac!=null){
                System.out.printf("%4d%20.2f%20s%n",fac.getCodigo(),
                        fac.getFecha_emision(),fac.getMedidor().getCodigo());
            }
        }
        Factura en = sis.buscarFactura(codigo);
        if(en!=null){
            en.toString();
        }else{
            System.out.println("Factura no encontrada");
        }
    }
    
    public void ConsultarHistoricoFacturado(String codigo){
        System.out.println("Medidores Asociados");
        System.out.printf("%s%20s%20s%n","Código Medidor","Tipo Medidor"
                ,"Nombre del Plan");
        for(Medidor med: medidores){
            if(med!=null){
                System.out.printf("4d%20.2f%20s%n",med.getCodigo(),
                        ((Med_digital)med).getMedidor(),med.getPlan().getNombre());       
            }
        }
        Medidor med = sis.buscarMedidor(codigo);
        if(med!=null){
            med.toString();
        }else{
            System.out.println("Medidor no encontrado");
        }
    } 
    
    public void ConsultarConsumoPorHora(){}        
}
