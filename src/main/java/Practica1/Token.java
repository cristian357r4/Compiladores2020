package Practica1;

public class Token {
    public byte tipo;
    public String cadena;

    public Token(byte tipo, String cadena) {
        this.tipo = tipo;
        this.cadena = cadena;
    }

    public final static byte
            IDENTIFICADOR = 0,
            TIPO = 1,
            PARENTESIS_IZQ = 2,
            PARENTESIS_DER = 3,
            RESERVADA = 4,
            ARIT_OPERADOR = 5,
            BEGGINCLASS = 6,
            ENDCLASS = 7,
            LOGIC_OPERADOR = 6;


}
