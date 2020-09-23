/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;

/**
 *
 * @author xazak
 */
public class Cadenas {
    
    public static void main(String[] args) {
        
        String lexema = "AhsdAD";
//        if (lexema.matches("[a-zA-Z]+")) {
//            System.out.println("Aceptar");            
//        }else{
//            System.out.println("Rechzada");
//        }
        
        if (lexema.matches("^(public)\\s\\w*")) {
            System.out.println("Aceptar");            
        }else{
            System.out.println("Rechzada");
        }
        
         if (lexema.matches("\\w*(end)$")) {
            System.out.println("Aceptar");            
        }else{
            System.out.println("Rechzada");
        }
    }
    
}
