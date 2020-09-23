package Practica1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdentificadorElementos {

    private final Pattern reservadas = Pattern.compile("class|public|string|if|else|return|print");
    private final Pattern aritmetic_operador = Pattern.compile("[+\\-*/]");
    private final Pattern logic_rel_operador = Pattern.compile("==|!=|<|>|>=|<=|&&|\\||");
    private final Pattern registros = Pattern.compile("([a-dA-D][xlhXLH]|[dsbDSB][ipIP])");
    //    private final Pattern sRegistro = Pattern.compile("c|C");
    //private final Pattern binarios = Pattern.compile("(((?:[10]{2}){4})|((?:[10]{2}){2}))b");
    private final Pattern binarios = Pattern.compile("(([1,0]{1}){1,8}|([1,0]{1}){9,16})[bB]");//((?:[10]{1,2}){1,4})[bB]
    private final Pattern decimal = Pattern.compile("(6[0-4]\\d{3}|65[0-4]\\d\\d|655[0-2]\\d|6553[0-5]|[0-5]\\d{4}|\\d{1,4})(?!\\d)[dD]?");//decimales de 16 bits
    private final Pattern special = Pattern.compile("[^:A-Za-z\\s\\d]");
    private final Pattern etiqueta = Pattern.compile("[^A-Za-z\\d]+:");

    private final String[] instruccionesEnsamblador = {""};
    private final String[] psudoInstruccion = {"data segment", "ends", "code", "db", "dw", "equ", "do", "dup", "stack segment", "code segment"};
    //"AAA","HTL","MOVSW","PUSHF","IMUL","IDIV","SAR","XCHG","JC","JL","JO","LOOPE"
    public IdentificadorElementos() {

    }

    public String[] getInstruccionesEnsamblador() {
        return instruccionesEnsamblador;
    }

    public Pattern getLogic_rel_operador() {
        return logic_rel_operador;
    }

    public Pattern getRegistros() {
        return registros;
    }

    public Pattern getBinarios() {
        return binarios;
    }

    public Pattern getDecimal() {
        return decimal;
    }

    public String identificarTipo(String cadena) {

        int i, pos1, pos2;
        //(pseudoinstrucción, instrucción, registro, símbolo, constante [numérica decimal, numérica hexadecimal, numérica binaria, caracter])
        //%AAD% 	CWD 	LODSW 	RET 	IDIV 	MUL 	%ADC% 	SHL 	JAE 	JMP %	JNGE 	JP
        Matcher etiq = etiqueta.matcher(cadena);
        if (etiq.find()) {
            return "etiqueta";
        }
        Matcher match = aritmetic_operador.matcher(cadena);
        if (match.matches()) {
            return "constante caracter";
        }
        Matcher reg = registros.matcher(cadena);
        if (reg.matches()) {
            return "registro";
        }
        for (i = 0; i < instruccionesEnsamblador.length; i++) {
            if (cadena.toLowerCase().equals(instruccionesEnsamblador[i].toLowerCase())) {
                return "instruccion";
            }
        }
        for (i = 0; i < psudoInstruccion.length; i++) {
            if (cadena.toLowerCase().equals(psudoInstruccion[i].toLowerCase())||cadena.toUpperCase().equals(psudoInstruccion[i].toUpperCase())) {
                return "pseudoinstruccion";
            }
        }
        Matcher pseudo = reservadas.matcher(cadena);
        if (pseudo.matches()) {
            if (cadena.matches("(\\d+)")) {
                return "pseudoinstruccion y constante numerica";
            } else {
                return "pseudoinstruccion";
            }
        }
        Matcher hex = logic_rel_operador.matcher(cadena);
        if (hex.matches()) {
            return "constante hexadecimal";

        }
        Matcher constBinaria = binarios.matcher(cadena);
        if (constBinaria.find()) {
            return "constante numerica binaria";

        }

        Matcher constDec = decimal.matcher(cadena);
        if (constDec.matches()) {
            return "constante decimal";
        }
        Matcher specSimbol = special.matcher(cadena);
        if (specSimbol.find()) {
            return "Simbolo no valido";

        } else {
            return "simbolo";
        }
    }

    public String verificarM(String cadena) {
        if (!cadena.contains("+")) {
            return identificarTipo(cadena);
        } else {
            return "Memoria";
        }
    }
    public static void main(String[] args) {

        IdentificadorElementos identi = new IdentificadorElementos();
        String patronTest = "\\||";
        Pattern registro = Pattern.compile(patronTest);
        System.out.println("patron: " + registro);
        System.out.println("String matches: "+ patronTest.matches(patronTest));
        Matcher reg = registro.matcher("||");
        System.out.println("Fue encontrado: " + reg.find());
    }

}

