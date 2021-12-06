package Medidores;

import Usuarios.Operario;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Lectura {

    private LocalDateTime fechaToma;
    private double kilovatios;
    private boolean cobrado;
    private Operario operario;

    public Lectura(LocalDateTime fechaToma, double kilovatios) {
        this.fechaToma = fechaToma;
        this.kilovatios = kilovatios;
        this.cobrado = false;
    }

    public Lectura(Operario op, double kilovatios) {
        this.fechaToma = LocalDateTime.now();
        this.kilovatios = kilovatios;
        this.cobrado = false;
        this.operario = op;
    }

    public boolean isCobrado() {
        return cobrado;
    }

    public void setCobrado(boolean cobrado) {
        this.cobrado = cobrado;
    }

    public LocalDateTime getFechaToma() {
        return fechaToma;
    }

    public void setFechaToma(LocalDateTime fechaToma) {
        this.fechaToma = fechaToma;
    }

    public double getKilovatios() {
        return kilovatios;
    }

    public void setKilovatios(double kilovatios) {
        this.kilovatios = kilovatios;
    }
    public static Lectura createFromStr(String lectura) {
        String[] datosLectura = lectura.split(",");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime fechaHora = LocalDateTime.parse(datosLectura[0], formatter);
        double consumo = Double.parseDouble(datosLectura[1]);
        return new Lectura(fechaHora, consumo);
    }

    @Override
    public String toString() {
        return fechaToma + ", " + kilovatios;
    }

}
