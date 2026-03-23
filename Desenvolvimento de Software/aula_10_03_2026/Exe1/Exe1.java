package aula_10_03_2026.Exe1;

import java.util.Scanner;

public class Exe1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite os números de 1 á 3: ");
        int numero = entrada.nextInt();

        switch (numero) {
            case 1:
                System.out.println("Java");
                break;
            case 2:
                System.out.println("Python");
                break;
            case 3:
                System.out.println("JavaScript");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }
}
