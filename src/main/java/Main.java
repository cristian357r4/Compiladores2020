import practica2FaseLexica.AnalisisLexico;


public class Main {
    public static void main(String[] args) throws Exception {
        AnalisisLexico anaizador = new AnalisisLexico();
        if (null != args[0] && args[0].length() > 5) {
            anaizador.iniciar(args[0]);
            // do more stuff
        } else {
            System.out.println("ingresa el nombre del archivo");
        }
    }
}
