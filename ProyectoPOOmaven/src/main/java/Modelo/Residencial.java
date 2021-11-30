/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import static Modelo.TipoPlan.RESIDENCIAL;
import Provincia.Provincia;
import static Provincia.Provincia.LOSRIOS;
import static Provincia.Provincia.MANABI;
import static Provincia.Provincia.MORONASANTIAGO;
import static Provincia.Provincia.NAPO;
import static Provincia.Provincia.ORELLANA;
import static Provincia.Provincia.PASTAZA;
import static Provincia.Provincia.PICHINCHA;
import static Provincia.Provincia.SANTAELENA;
import static Provincia.Provincia.SANTODOMINGODELOSTSACHILAS;
import static Provincia.Provincia.SUCUMBIOS;
import static Provincia.Provincia.TUNGURAHUA;
import static Provincia.Provincia.ZAMORACHINCHIPE;
import java.util.ArrayList;

/**
 *
 * @author Eduart Macias
 */
public class  Residencial extends Plan_Energia {
    public Residencial(ArrayList<Provincia> listaresidencial,ArrayList<Horario_pico> horaspicoresi){
        super(RESIDENCIAL,listaresidencial,15,10.44,horaspicoresi);
        listaresidencial.add(LOSRIOS); 
        listaresidencial.add(MANABI);
        listaresidencial.add(MORONASANTIAGO);
        listaresidencial.add(NAPO);
        listaresidencial.add(ORELLANA);
        listaresidencial.add(PASTAZA);
        listaresidencial.add(PICHINCHA);
        listaresidencial.add(SANTAELENA);
        listaresidencial.add(SANTODOMINGODELOSTSACHILAS);
        listaresidencial.add(SUCUMBIOS);
        listaresidencial.add(TUNGURAHUA);
        listaresidencial.add(ZAMORACHINCHIPE);  
    }  
    public Residencial(){}
}
