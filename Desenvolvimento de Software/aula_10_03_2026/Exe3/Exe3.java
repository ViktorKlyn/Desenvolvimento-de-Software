package aula_10_03_2026.Exe3;

import java.util.Scanner;

public class Exe3 {
    public static void main(String[] args) {
        Scanner notas = new Scanner(System.in);

        System.out.print("Nota 1: ");
        double n1 = notas.nextDouble();

        System.out.print("Nota 2: ");
        double n2 = notas.nextDouble();

        System.out.print("Nota 3: ");
        double n3 = notas.nextDouble();

        double media = (n1 + n2 + n3) / 3;

        if (media >= 7) {
            System.out.println("Aprovado!");
        } else if (media > 5) {
            System.out.println("Recuperação!");
        } else {
            System.out.println("Reprovado!");
        }

        notas.close();
    }
}
