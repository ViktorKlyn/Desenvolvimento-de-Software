package aula_10_03_2026.Exe6;
import java.util.Scanner;

public class Exe6 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Vetor para armazenar os números
        int[] numeros = new int[10];

        // Leitura dos 10 números
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Digite o " + (i + 1) + "º número: ");
            numeros[i] = entrada.nextInt();
        }

        // Verificação de pares e ímpares
        System.out.println("\n--- Resultado ---");
        for (int num : numeros) {
            if (num % 2 == 0) {
                System.out.println(num + " é PAR");
            } else {
                System.out.println(num + " é ÍMPAR");
            }
        }

        entrada.close();
    }
}
