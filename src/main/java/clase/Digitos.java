/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;

import static java.awt.Color.blue;

/**
 *
 * @author xazak
 */
public class Digitos {

    public static void main(String[] args) {
        String lexema = "10";
//        if (lexema.matches("[0-9]{5}")) {
//            System.out.println("Acepta");
//
//        } else {
//            System.out.println("Rechaza");
//        }
//
//        if (lexema.matches("([0-9]{5})+")) {
//            System.out.println("Acepta");
//
//        } else {
//            System.out.println("Rechaza");
//        }
//
//        if (lexema.matches("[0-9]{1,4}+")) {
//            System.out.println("Acepta");
//
//        } else {
//            System.out.println("Rechaza");
//        }

//        if (lexema.matches("[0-9]{7,}")) {
//            System.out.println("Acepta");
//
//        } else {
//            System.out.println("Rechaza");
//        }
//        
//        if (lexema.matches("^4\\d+")) {
//            System.out.println("Acepta");
//
//        } else {
//            System.out.println("Rechaza");
//        }

        //ER que no cominece con el numero 3, seguido de uno o mas numeros entre 0 y 9 pero que no termine con 9
        //implicitamente tiene longitud de 3
        if (lexema.matches("^([^3])(\\d)([^9])$")) {
            System.out.println("Acepta");

        } else {
            System.out.println("Rechaza");
        }
        

    }

}
