package aula_10_03_2026.Exe5;

import java.util.Scanner;

public class Exe5 {
    public static void main(String[] args) {

        Scanner numeros = new Scanner(System.in);

        int soma = 0;
        int quantidade = 5;

        for (int i = 1; i <= quantidade; i++) {
            System.out.print("Digite o " + i + "º número: ");
            soma += numeros.nextInt();
        }

        System.out.println("A soma é: " + soma);

        numeros.close();
    }
}