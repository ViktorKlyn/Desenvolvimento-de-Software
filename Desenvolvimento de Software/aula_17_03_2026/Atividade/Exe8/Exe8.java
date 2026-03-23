import java.util.Scanner;

public class Exe8 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int[] numeros = new int[5];
        int maior, menor;

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Digite 5 numeros: ");
            numeros[i] = entrada.nextInt();
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

         System.out.println("Maior número = " + maior);
        System.out.println("Menor número = " + menor);

    }
}