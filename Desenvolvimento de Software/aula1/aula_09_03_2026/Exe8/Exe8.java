package aula_09_03_2026.Exe8;
import java.util.Scanner;

public class Exe8 {
    public static void main (String[] args){ 

        Scanner entrada = new Scanner(System.in);

        int senha = 0;

        while (senha != 1234) {
            System.out.print("Digite a senha: ");
            senha = entrada.nextInt();
        }
        System.out.println("Acesso permitido!");
    }
}
