package Usuarios;

import Medidores.Medidor;
import java.util.ArrayList;

public class Usuario {
    private String username;
    private String pswd;

    public Usuario(String username, String pswd) {
        this.username = username;
        this.pswd = pswd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }
}
