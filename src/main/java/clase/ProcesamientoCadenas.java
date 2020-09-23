package clase;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.StringTokenizer;

/**
 *
 * @author nelyplatacesar
 */
public class ProcesamientoCadenas {
     Object[][] tablaSimbolos = new Object[1000][4];     
    /*-----------------Procesamiento de cadenas----------------
     * Dada cualquier cadena con o sin saltos de ĺınea (Ćodigo fuente), 
     * identificar los operadores relacionales >=, <=, ! =
     */    
    public String EspaciadoCadena(String txt) {                
        txt = txt.replaceAll("\\{", " \\{ ").replaceAll("}", " \\} ")
                .replaceAll("\\(", " \\( ").replaceAll("\\)", " \\) ")
                .replaceAll("\\+", " \\+ ").replaceAll("-", " - ")
                .replaceAll("\\|\\|", " \\|\\| ").replaceAll("&&", " && ")
                .replaceAll(";", " ; ");  
        
        if (txt.contains("==")) {
            txt = txt.replaceAll("==", " == ");
        }
        if (txt.contains("!=")) {
            txt = txt.replaceAll("!=", " != ");
        }
        if (txt.contains("<=")) {
            txt = txt.replaceAll("<=", " <= ");
        }
        if (txt.contains(">=")) {
            txt = txt.replaceAll(">=", " >= ");
        }              
        return txt;
    }
    
//    public static void main(String[] args) {
//        String txt = "class abc2=4 public class{a==5if(a==0 &&a!=8||!3){{8+9<5;||&& a<=3;}";
//        System.out.println(txt);
//        System.out.println("\u001B[34m ---------------------------");
//
//
//        ProcesamientoCadenas pc=new ProcesamientoCadenas();
//        //incluye espacio en blanco antes y después de operadores relacionaes
//        String codFuente=pc.EspaciadoCadena(txt);
//        System.out.println(codFuente);
//        System.out.println("\u001B[34m ---------------------------");
//        //Comienza el procesamiento de las ER
//        StringTokenizer cad = new StringTokenizer(codFuente," ");
//        String txtTemp;
//        int cont=0;
//        while (cad.hasMoreElements()) {
//            txtTemp = cad.nextToken();
//            if (txtTemp.matches("(>=)|(<=)|(!=)|(==)")) {
//                System.out.println("Entro " + txtTemp);
//                pc.tablaSimbolos[cont][0] = "Id del token";
//                pc.tablaSimbolos[cont][1] = "Oper.Rel"; //columan 1 va el token
//                pc.tablaSimbolos[cont][2] = txtTemp; //columan 2 va el lexema
//                pc.tablaSimbolos[cont][3] = cont; //columan 3 va la linea en que encontro la palabra
//                cont++;
//            }
//             if (txtTemp.matches("(\\+)|(-)|(\\*)|(/)")) {
//                System.out.println("Entro " + txtTemp);
//                pc.tablaSimbolos[cont][0] = "Id del token";
//                pc.tablaSimbolos[cont][1] = "Oper.Aritmético"; //columan 1 va el token
//                pc.tablaSimbolos[cont][2] = txtTemp; //columan 2 va el lexema
//                pc.tablaSimbolos[cont][3] = cont; //columan 3 va la linea en que encontro la palabra
//                cont++;
//            }
//
//        }
//
//
//        //visualizar tabla de símbolos
//        System.out.println("\n \u001B[34m TABLA DE SIMBOLOS \n");
//        for (int k = 0; k < pc.tablaSimbolos.length; k++) {
//            if(pc.tablaSimbolos[k][2]!=(null))
//            System.out.println("\033[34m"+pc.tablaSimbolos[k][0] + "|" + pc.tablaSimbolos[k][1] + "|" + pc.tablaSimbolos[k][2] + "|" + pc.tablaSimbolos[k][3]);
//        }
//
//    }
    
}
