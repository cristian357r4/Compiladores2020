package practica2FaseLexica;

import java.util.StringTokenizer;

public class Tokenizer{
    public static void main(String[] a){
        String msg = "http://10.123.10.43.67:80/";
        StringTokenizer st = new StringTokenizer(msg, ":/.");
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
}