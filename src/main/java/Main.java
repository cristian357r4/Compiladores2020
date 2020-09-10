import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        String codF = "public class Test(){ 8 }";
        StringTokenizer cadena = new StringTokenizer(codF, " ");
        String txtTemp= "";
        while(cadena.hasMoreElements()){
            txtTemp = cadena.nextToken();
            System.out.println(txtTemp);
        }
    }
}
