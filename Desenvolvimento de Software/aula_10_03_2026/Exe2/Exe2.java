package aula_10_03_2026.Exe2;

import java.util.Scanner;

public class Exe2 {
    public static void main(String[] args) {
        Scanner numero = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int n1 = numero.nextInt();

        System.out.print("Digite o segundo numero: ");
        int n2 = numero.nextInt();

        System.out.print("\nEscolha a operação:\n \n1- Soma \n 2 - Subtração \n 3 - Multiplicação \n 4 - Divisão\n: ");
        int n3 = numero.nextInt();

        switch (n3) {
            case 1:
                System.out.println(n1 + n2);
                break;
            case 2:
                System.out.println(n1 - n2);
                break;
            case 3:
                System.out.println(n1 * n2);
                break;
            case 4:
                System.out.println(n1 / n2);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }
}
