package Sistema;

import java.util.ArrayList;

/**
 *
 * @author James Malavé
 */
public enum Provincia {
    AZUAY,
    BOLIVAR,
    CANIAR,
    CARCHI,
    CHIMBORAZO,
    COTOPAXI,
    ELORO,
    ESMERALDA,
    GALAPAGOS,
    GUAYAS,
    IMBABURA,
    LOJA,
    LOSRIOS,
    MANABI,
    MORONASANTIAGO,
    NAPO,
    ORELLANA,
    PASTAZA,
    PICHINCHA,
    SANTAELENA,
    SANTODOMINGODELOSTSACHILAS,
    SUCUMBIOS,
    TUNGURAHUA,
    ZAMORACHINCHIPE;

    public static ArrayList<Provincia> intToAL(int... args) {
        ArrayList<Provincia> provincias = new ArrayList<>();
        for (int i : args) {
            provincias.add(Provincia.values()[i-1]);
        }
        return provincias;
    }

    public static ArrayList<Provincia> stringToAL(String... args) {
        ArrayList<Provincia> provincias = new ArrayList<>();
        for (String s : args) {
            provincias.add(Provincia.valueOf(s));
        }
        return provincias;
    }
}
