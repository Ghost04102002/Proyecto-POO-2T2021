package Sistema;

import Medidores.*;
import Usuarios.Abonado;
import Usuarios.Usuario;
import java.util.ArrayList;
import java.util.Arrays;

public class Sistema {

    public Usuario usuarioActivo;
    private ArrayList<PlanEnergia> planes;
    private ArrayList<Usuario> usuarios;

    public Sistema() {
        this.planes = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public boolean ingresar(String usuario, String pswd) {
        Usuario u = buscarUsuario(usuario);
        if (u != null) {
            if (u.getPswd().equals(pswd)) {
                this.usuarioActivo = u;
                return true;
            } else {
                return false;
            }

        }
        return false;
    }

    public Abonado buscarAbonado(String cedula) {
        for (Usuario us : usuarios) {
            if (us != null) {
            } else {
                if (us instanceof Abonado) {
                    Abonado ab = (Abonado) us;
                    if (ab.getCedula().equals(cedula)) {
                        return ab;
                    }
                }
            }
        }
        return null;
    }

    public Usuario buscarUsuario(String usuario) {
        for (Usuario u : usuarios) {
            if (usuario.equals(u.getUsername())) {
                return u;
            }
        }
        return null;
    }

    public Object[] buscarMedidor(String codigo) {
        Object[] datos = new Object[2];
        for (Usuario u : usuarios) {
            if (u instanceof Abonado) {
                Abonado abonado = (Abonado) u;
                for (Medidor m : abonado.getMedidores()) {
                    if (m.getCodigo().equals(codigo)) {
                        datos[0] = abonado;
                        datos[1] = m;
                        return datos;
                    }
                }
            }
        }
        return null;
    }

    public PlanEnergia buscarPlan(String nombrePlan) {
        for (PlanEnergia p : planes) {
            if (p.getNombre().equals(nombrePlan)) {
                return p;
            }
        }
        return null;
    }

    public String generarCodigoFactura() {
        String codigo = String.format("%09d", getFacturasSistema().size() + 1);
        return codigo;
    }

    public String generarCodigoMedidor(String tipoMedidor) {
        String codigo;
        ArrayList<Medidor> medidores = getMedidoresSistema();
        if (tipoMedidor.equals("Inteligente")) {
            int c = 0;
            for (Medidor m : medidores) {
                if (m instanceof Inteligente) {
                    c++;
                }
            }
            codigo = "I" + String.format("%04d", c);
        } else {
            int c = 0;
            for (Medidor m : medidores) {
                if (m instanceof Analogico) {
                    c++;
                }
            }
            codigo = "A" + String.format("%04d", c);
        }
        return codigo;
    }

    public boolean verificarPrevio(String plan) {
        return planes.stream().anyMatch(p -> (p.getNombre().equals(plan)));
    }

    public Usuario getUsuarioActivo() {
        return usuarioActivo;
    }

    public ArrayList<PlanEnergia> getPlanes() {
        return planes;
    }

    public ArrayList<Medidor> getMedidoresSistema() {
        ArrayList<Medidor> medidores = new ArrayList<>();
        for (Usuario u : usuarios) {
            if (u instanceof Abonado) {
                Abonado abonado = (Abonado) u;
                medidores.addAll(abonado.getMedidores());
            }
        }
        return medidores;
    }

    public ArrayList<Factura> getFacturasSistema() {
        ArrayList<Factura> facturas = new ArrayList<>();
        for (Usuario u : usuarios) {
            if (u instanceof Abonado) {
                Abonado abonado = (Abonado) u;
                facturas.addAll(abonado.getFacturas());
            }
        }
        return facturas;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

}
