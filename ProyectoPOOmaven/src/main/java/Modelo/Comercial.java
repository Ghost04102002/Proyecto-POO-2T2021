/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import static Modelo.TipoPlan.COMERCIAL;
import Provincia.Provincia;
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


import java.util.ArrayList;


/**
 *
 * @author Eduart Macias
 */

public class  Comercial extends Plan_Energia {
    public Comercial(ArrayList<Provincia> listacomercial,ArrayList<Horario_pico> horaspicocomer){
        super(COMERCIAL,listacomercial,10,7.99,horaspicocomer);
        listacomercial.add(AZUAY);
        listacomercial.add(CANIAR);
        listacomercial.add(CARCHI);
        listacomercial.add(CHIMBORAZO);
        listacomercial.add(COTOPAXI);
        listacomercial.add(ELORO);
        listacomercial.add(ESMERALDA);
        listacomercial.add(GALAPAGOS);
        listacomercial.add(GUAYAS);
        listacomercial.add(IMBABURA);
        listacomercial.add(LOJA);
        listacomercial.add(BOLIVAR);    
    }   
    public Comercial(){}
}
