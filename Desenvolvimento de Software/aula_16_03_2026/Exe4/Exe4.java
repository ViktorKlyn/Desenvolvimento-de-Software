import java.util.Scanner;

public class Exe4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float[] numeros = new float[10];
        float soma = 0;
        float maior, menor;

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Digite o " + (i + 1) + "º número: ");
            numeros[i] = sc.nextFloat();
            soma += numeros[i];
        }

        maior = numeros[0];
        menor = numeros[0];

        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maior) {
                maior = numeros[i];
            }
            if (numeros[i] < menor) {
                menor = numeros[i];
            }
        }

        float media = soma / numeros.length;

        System.out.println("\nNúmeros digitados:");
        for (float n : numeros) {
            System.out.print(n + " - ");
        }

        System.out.println("\n\nSoma = " + soma);
        System.out.println("Média = " + media);
        System.out.println("Maior número = " + maior);
        System.out.println("Menor número = " + menor);

        sc.close();
    }
}
