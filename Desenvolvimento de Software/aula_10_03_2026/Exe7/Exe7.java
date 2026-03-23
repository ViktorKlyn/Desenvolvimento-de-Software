package aula_10_03_2026.Exe7;
import java.util.Scanner;

public class Exe7 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int[] vetor = new int[5];

        // Leitura dos 5 números
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Digite o " + (i + 1) + "º número: ");
            vetor[i] = entrada.nextInt();
        }

        // Exibição dos números digitados
        System.out.println("\n--- Números digitados ---");
        for (int num : vetor) {
            System.out.println(num);
        }

        entrada.close();
    }
}