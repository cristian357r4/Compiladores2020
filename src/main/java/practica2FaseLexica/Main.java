package practica2FaseLexica;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            if (txtTemp.matches("(\\+)|(-)|(\\*)|(/)")) {
                System.out.println("Entro " + txtTemp);
                pc.tablaSimbolos[cont][0] = "Id del token";
                pc.tablaSimbolos[cont][1] = "Oper.Aritmético"; //columan 1 va el token
                pc.tablaSimbolos[cont][2] = txtTemp; //columan 2 va el lexema
                pc.tablaSimbolos[cont][3] = cont; //columan 3 va la linea en que encontro la palabra
                cont++;
            }
            if (txtTemp.matches("class|public")){
                System.out.println("Entro " + txtTemp);
                pc.tablaSimbolos[cont][0] = "Id del token";
                pc.tablaSimbolos[cont][1] = "Palabra Reservada"; //columan 1 va el token
                pc.tablaSimbolos[cont][2] = txtTemp; //columan 2 va el lexema
                pc.tablaSimbolos[cont][3] = cont; //columan 3 va la linea en que encontro la palabra
                cont++;
            }
//            Pattern if_statement = Pattern.compile("if");
//            Matcher m = if_statement.matcher(txtTemp);
            if (txtTemp.matches("if")) {
                System.out.println("Entro " + txtTemp);
                pc.tablaSimbolos[cont][0] = "Id del token";
                pc.tablaSimbolos[cont][1] = "if"; //columan 1 va el token
                pc.tablaSimbolos[cont][2] = txtTemp; //columan 2 va el lexema
                pc.tablaSimbolos[cont][3] = cont; //columan 3 va la linea en que encontro la palabra
                cont++;
            }

            if (txtTemp.matches(";")) {
                System.out.println("Entro " + txtTemp);
                pc.tablaSimbolos[cont][0] = "Id del token";
                pc.tablaSimbolos[cont][1] = "Semicolon"; //columan 1 va el token
                pc.tablaSimbolos[cont][2] = txtTemp; //columan 2 va el lexema
                pc.tablaSimbolos[cont][3] = cont; //columan 3 va la linea en que encontro la palabra
                cont++;
            }
            if (txtTemp.matches("return")) {
                System.out.println("Entro " + txtTemp);
                pc.tablaSimbolos[cont][0] = "Id del token";
                pc.tablaSimbolos[cont][1] = "if"; //columan 1 va el token
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
