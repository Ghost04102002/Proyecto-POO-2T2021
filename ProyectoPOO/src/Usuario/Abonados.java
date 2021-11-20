/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;
import Medidores.Medidores;
import Modelo.Factura;
import java.util.ArrayList;


/**
 *
 * @author malav
 */
public class Abonados extends Usuario{
    /**
     * Variables de Instancia
     */
    private Factura Factura;
    private Medidores Medidores;
    
    public Medidores MedidoresEnPosesion(){
        return Medidores;
    }
    
    public ArrayList<Factura> ConsultarFactura(){
        return null;
    }
    
    public ArrayList<Factura> ConsultarHistoricoFacturado(){
        return null;
    } 
    
}
