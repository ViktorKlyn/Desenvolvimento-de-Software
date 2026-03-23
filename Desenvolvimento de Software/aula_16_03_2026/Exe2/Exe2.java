public class Exe2 {

    public static void alterarNumero(int numero) {
        numero = 50;
        System.out.println("Valor dentro do método: " + numero);
    }

    public static void main(String[] args) {
        int x = 10;

        alterarNumero(x); 

        System.out.println("Valor no main: " + x);
    }
}
          