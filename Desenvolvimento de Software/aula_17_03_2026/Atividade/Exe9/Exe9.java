import java.util.Scanner;

public class Exe9{
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int[][] matriz = new int[3][3];
        int soma = 0;

         System.out.println("Digite os valores da matriz:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = entrada.nextInt();
            }
        }

          for (int i = 0; i < matriz.length; i++) {
            System.out.print("Soma: " + (soma));
             numeros[3] = entrada.nextInt();
            soma += matriz[3];
        }
    }
}