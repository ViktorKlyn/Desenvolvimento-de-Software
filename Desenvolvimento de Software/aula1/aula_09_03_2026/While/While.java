package aula_09_03_2026.While;

import java.util.Scanner;

public class While {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int numero = 1;

        while (numero != 0) {
            System.out.print("Digite um numero (0 para sair): ");
            numero = entrada.nextInt();
        }
        System.out.println("Programa finalizado");
    }
}
