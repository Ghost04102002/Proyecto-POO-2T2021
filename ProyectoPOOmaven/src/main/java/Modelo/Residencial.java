/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import static Modelo.TipoPlan.RESIDENCIAL;
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

/**
 *
 * @author Eduart Macias
 */
public class  Residencial extends Plan_Energia {
    public Residencial(){
        super(RESIDENCIAL,15,10.44);
        getProvincias().add(LOSRIOS); 
        getProvincias().add(MANABI);
        getProvincias().add(MORONASANTIAGO);
        getProvincias().add(NAPO);
        getProvincias().add(ORELLANA);
        getProvincias().add(PASTAZA);
        getProvincias().add(PICHINCHA);
        getProvincias().add(SANTAELENA);
        getProvincias().add(SANTODOMINGODELOSTSACHILAS);
        getProvincias().add(SUCUMBIOS);
        getProvincias().add(TUNGURAHUA);
        getProvincias().add(ZAMORACHINCHIPE);  
    }  
}
