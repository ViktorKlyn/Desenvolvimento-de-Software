import java.util.Scanner;

public class Exe4 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite um numero: ");
        int numero = entrada.nextInt();

        if(numero >= 0){
            System.out.println("Numero Positivo!");
        } else{
            System.out.println("Numero Negativo!");
        }
    }
}