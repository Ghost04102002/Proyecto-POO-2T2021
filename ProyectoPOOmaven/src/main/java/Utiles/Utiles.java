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

    public static boolean validarFecha(String fecha) {
        String[] fechaArr = fecha.split("-");
        if (fechaArr.length == 3) {
            boolean isNum1 = fechaArr[0].chars().allMatch(Character::isDigit);
            boolean isNum2 = fechaArr[1].chars().allMatch(Character::isDigit);
            boolean isNum3 = fechaArr[2].chars().allMatch(Character::isDigit);
            boolean valDay = fechaArr[0].length() == 2;
            boolean valMonth = fechaArr[1].length() == 2;
            boolean valYear = fechaArr[0].length() == 4;
            if (isNum1 && isNum2 && isNum3 && valDay && valMonth && valYear) {
                return true;
            }
        }
        return false;
    }
}
