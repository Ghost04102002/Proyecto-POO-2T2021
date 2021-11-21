/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;
import Modelo.Sistema_Facturacion;
import Medidores.Medidores;
import Modelo.Factura;
import java.util.ArrayList;


/**
 *
 * @author James Malavé
 */
public class Abonados extends Usuario{
    /**
     * Variables de Instancia
     */
    private ArrayList<Factura> facturas;
    private ArrayList<Medidores> medidores;

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }

    public ArrayList<Medidores> getMedidores() {
        return medidores;
    }

    public void setMedidores(ArrayList<Medidores> medidores) {
        this.medidores = medidores;
    }
    
    public void ConsultarFactura(String codigo){
        System.out.println("Facturas Asociadas");
        System.out.printf("%s%20s%20s%n","Número Factura","Fecha Emisión"
                , "Código Medidor");
        for(Factura fac: facturas){
            System.out.printf("%4d%20.2f%20s%n",fac.getCodigo(),
                    fac.getFecha_emision(),fac.getMedidor().getCodigo());
            if(fac.getCodigo().equals(codigo)){
                System.out.println(fac.toString());
            }else{
                System.out.println("Factura no encontrada");
            }
        }
    }
    
    public ArrayList<Factura> ConsultarHistoricoFacturado(){
        return null;
    } 
    
}
