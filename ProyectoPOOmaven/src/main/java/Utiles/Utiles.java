/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utiles;

import Medidores.Medidor;
import Sistema.*;
import java.time.LocalDateTime;
import java.util.Random;


public class Utiles {
     public static String crearPswd() {
        String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String password = "";
        Random rnd = new Random();
        for (int i = 0; i < 8; i++) {
            int pos = rnd.nextInt(caracteres.length());
            password += caracteres.charAt(pos);
        }
        return password;
    }
}
