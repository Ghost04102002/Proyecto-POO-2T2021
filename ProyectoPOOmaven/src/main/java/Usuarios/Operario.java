package Usuarios;

import Medidores.Lectura;
import Medidores.Medidor;
import Sistema.Sistema;

public class Operario extends Usuario {

    public Operario(String username, String pswd) {
        super(username, pswd);
    }

    public void registrarMedicion(Sistema s, Abonado abonado, Medidor medidor, double medida, Lectura ultimaLectura) {
        Lectura lec = new Lectura(this,medida);
        medidor.getLecturas().add(lec);
        double kwConsumidos = lec.getKilovatios() - ultimaLectura.getKilovatios();
        System.out.println("Kilovatios consumidos: " + kwConsumidos);
    }

}
