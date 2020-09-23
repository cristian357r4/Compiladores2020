package practica2FaseLexica;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class Main {
    Object[][] tablaSimbolos = new Object[1000][4];

    public static String readFileAsString(String fileName) throws Exception {
        String data;
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static String removeBlankLine(String data) {
        data = data.replaceAll("(?m)^[ \\t]*\\r?\\n", "");
        return data;
    }

    public static String removeComments(String data) {
        data = data.replaceAll("(/\\*)(.|\\r|\\n)*?(\\*/)", "");
        return data;
    }

    public static String espaciado(String data) {
        data = data.replaceAll("\\{", " \\{ ").replaceAll("}", " \\} ")
                .replaceAll("\\(", " \\( ").replaceAll("\\)", " \\) ")
                .replaceAll("\\+", " \\+ ").replaceAll("-", " - ")
                .replaceAll("\\|\\|", " \\|\\| ").replaceAll("&&", " && ")
                .replaceAll(";", " ; ")
                .replaceAll("/", " / ")
                .replaceAll("\\*", " * ");

        if (data.contains("==")) {
            data = data.replaceAll("==", " == ");
        }
//        if (data.contains("[0-9]+")) {
//            data = data.replaceAll("[0-9]+", " [0-9]+ ");
//        }
//TODO h=!==54 preguntar como hacer la separacion != o ==
        if (data.contains("!=")) {
            data = data.replaceAll("!=", " != ");
        }
        if (data.contains("<=")) {
            data = data.replaceAll("<=", " <= ");
        }
        if (data.contains(">=")) {
            data = data.replaceAll(">=", " >= ");
        }
//        if (data.contains("<")) {
//            data = data.replaceAll("<", " < ");
//        }
//        if (data.contains(">")){
//            data = data.replaceAll(">", " > ");
//        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        Main pc = new Main();
        String data = readFileAsString("C:\\Users\\xazak\\IdeaProjects\\ProyectoCompiladores\\src\\main\\java\\practica2FaseLexica\\codigo.txt");
        data = removeComments(data);
        data = removeBlankLine(data);
        data = espaciado(data);
        System.out.println("------------------Begin Codigo Preprocesado-----------------");
        System.out.println(data);
        System.out.println("------------------End Codigo Preprocesado-----------------");
        StringTokenizer cad = new StringTokenizer(data, " /\n\t\r");
        String[] lines = data.split("\\s");
        for (String line : lines) {
            System.out.println("Elemento de array: " + line);
        }
        String txtTemp;
        int cont = 0;
        while (cad.hasMoreElements()) {
            txtTemp = cad.nextToken();
            System.out.println("-" + txtTemp + "-");
            if (txtTemp.matches("[<>=!]=?")) {
                System.out.println("Entro " + txtTemp);
                pc.tablaSimbolos[cont][0] = "Id del token";
                pc.tablaSimbolos[cont][1] = "Oper.Rel"; //columan 1 va el token
                pc.tablaSimbolos[cont][2] = txtTemp; //columan 2 va el lexema
                pc.tablaSimbolos[cont][3] = cont; //columan 3 va la linea en que encontro la palabra
                cont++;
            }
            if (txtTemp.matches("\\|\\||\\&\\&")){
                System.out.println("Entro " + txtTemp);
                pc.tablaSimbolos[cont][0] = "Id del token";
                pc.tablaSimbolos[cont][1] = "Oper.Logicos"; //columan 1 va el token
                pc.tablaSimbolos[cont][2] = txtTemp; //columan 2 va el lexema
                pc.tablaSimbolos[cont][3] = cont; //columan 3 va la linea en que encontro la palabra
                cont++;
            }
            if (txtTemp.matches("[0-9]+")){
                System.out.println("Entro " + txtTemp);
                pc.tablaSimbolos[cont][0] = "Id del token";
                pc.tablaSimbolos[cont][1] = "Numero"; //columan 1 va el token
                pc.tablaSimbolos[cont][2] = txtTemp; //columan 2 va el lexema
                pc.tablaSimbolos[cont][3] = cont; //columan 3 va la linea en que encontro la palabra
                cont++;
            }
            if (txtTemp.matches("(\\+)|(-)|(\\*)|(/)")) {
                System.out.println("Entro " + txtTemp);
                pc.tablaSimbolos[cont][0] = "Id del token";
                pc.tablaSimbolos[cont][1] = "Oper.Aritmético"; //columan 1 va el token
                pc.tablaSimbolos[cont][2] = txtTemp; //columan 2 va el lexema
                pc.tablaSimbolos[cont][3] = cont; //columan 3 va la linea en que encontro la palabra
                cont++;
            }
            if (txtTemp.matches("class|public|if|return|int|string|else|print")){
                System.out.println("Entro " + txtTemp);
                pc.tablaSimbolos[cont][0] = "Id del token";
                pc.tablaSimbolos[cont][1] = "Palabra Reservada"; //columan 1 va el token
                pc.tablaSimbolos[cont][2] = txtTemp; //columan 2 va el lexema
                pc.tablaSimbolos[cont][3] = cont; //columan 3 va la linea en que encontro la palabra
                cont++;
            }

            if (txtTemp.matches(";")) {
                System.out.println("Entro " + txtTemp);
                pc.tablaSimbolos[cont][0] = "Id del token";
                pc.tablaSimbolos[cont][1] = "Punto y coma"; //columan 1 va el token
                pc.tablaSimbolos[cont][2] = txtTemp; //columan 2 va el lexema
                pc.tablaSimbolos[cont][3] = cont; //columan 3 va la linea en que encontro la palabra
                cont++;
            }
//            if (txtTemp.matches("\\b(?!public|class|string|int|^[A-Z]\\w+\\b|\\d)[a-zA-Z_]+([a-zA-Z0-9_]*)\\b")) {
//                System.out.println("Entro " + txtTemp);
//                pc.tablaSimbolos[cont][0] = "Id del token";
//                pc.tablaSimbolos[cont][1] = "Identificador"; //columan 1 va el token
//                pc.tablaSimbolos[cont][2] = txtTemp; //columan 2 va el lexema
//                pc.tablaSimbolos[cont][3] = cont; //columan 3 va la linea en que encontro la palabra
//                cont++;
//            }

            if (txtTemp.matches("[()]")) {
                System.out.println("Entro " + txtTemp);
                pc.tablaSimbolos[cont][0] = "Id del token";
                pc.tablaSimbolos[cont][1] = txtTemp.matches("\\(")?"Parentesis A":"Parentesis C";
                pc.tablaSimbolos[cont][2] = txtTemp; //columan 2 va el lexema
                pc.tablaSimbolos[cont][3] = cont; //columan 3 va la linea en que encontro la palabra
                cont++;
            }
            if (txtTemp.matches("[{}]")) {
                System.out.println("Entro " + txtTemp);
                pc.tablaSimbolos[cont][0] = "Id del token";
                pc.tablaSimbolos[cont][1] = txtTemp.matches("\\{")?"LLave A":"LLave C";
                pc.tablaSimbolos[cont][2] = txtTemp; //columan 2 va el lexema
                pc.tablaSimbolos[cont][3] = cont; //columan 3 va la linea en que encontro la palabra
                cont++;
            }
            if (txtTemp.matches("[A-Z][a-z]+")){
                System.out.println("Entro " + txtTemp);
                pc.tablaSimbolos[cont][0] = "Id del token";
                pc.tablaSimbolos[cont][1] = "Class Name"; //columan 1 va el token
                pc.tablaSimbolos[cont][2] = txtTemp; //columan 2 va el lexema
                pc.tablaSimbolos[cont][3] = cont; //columan 3 va la linea en que encontro la palabra
                cont++;
            }
        }
        System.out.println("\n \u001B[34m TABLA DE SIMBOLOS \n");
        for (int k = 0; k < pc.tablaSimbolos.length; k++) {
            if (pc.tablaSimbolos[k][2] != (null))
                System.out.println("\033[34m" + pc.tablaSimbolos[k][0] + "|" + pc.tablaSimbolos[k][1] + "|" + pc.tablaSimbolos[k][2] + "|" + pc.tablaSimbolos[k][3]);
        }
    }
}
