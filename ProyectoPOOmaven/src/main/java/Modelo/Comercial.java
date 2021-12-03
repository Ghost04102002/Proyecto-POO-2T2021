/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import static Modelo.TipoPlan.COMERCIAL;
import static Provincia.Provincia.AZUAY;
import static Provincia.Provincia.BOLIVAR;
import static Provincia.Provincia.CANIAR;
import static Provincia.Provincia.CARCHI;
import static Provincia.Provincia.CHIMBORAZO;
import static Provincia.Provincia.COTOPAXI;
import static Provincia.Provincia.ELORO;
import static Provincia.Provincia.ESMERALDA;
import static Provincia.Provincia.GALAPAGOS;
import static Provincia.Provincia.GUAYAS;
import static Provincia.Provincia.IMBABURA;
import static Provincia.Provincia.LOJA;

/**
 *
 * @author Eduart Macias
 */

public class  Comercial extends Plan_Energia {
    public Comercial(){
        super(COMERCIAL.toString(),10,7.99);
        getProvincias().add(AZUAY);
        getProvincias().add(CANIAR);
        getProvincias().add(CARCHI);
        getProvincias().add(CHIMBORAZO);
        getProvincias().add(COTOPAXI);
        getProvincias().add(ELORO);
        getProvincias().add(ESMERALDA);
        getProvincias().add(GALAPAGOS);
        getProvincias().add(GUAYAS);
        getProvincias().add(IMBABURA);
        getProvincias().add(LOJA);
        getProvincias().add(BOLIVAR);    
    }   
}
