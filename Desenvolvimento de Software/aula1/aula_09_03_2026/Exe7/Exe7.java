package aula_09_03_2026.Exe7;
import java.util.Scanner;

public class Exe7 {
    public static void main(String[] args) { 
        Scanner entrada = new Scanner(System.in);

        int numero;   // variável para armazenar cada número digitado
        int soma = 0; // acumulador da soma

        while (true) {
            System.out.print("Digite um número (0 para acabar): ");
            numero = entrada.nextInt(); // leitura correta

            if (numero == 0) {
                break; // encerra o laço quando o usuário digitar 0
            }

            soma += numero; // acumula na soma
        }

        System.out.println("\nA soma dos números digitados é: " + soma);

        entrada.close(); // boa prática: fechar o Scanner
    }
}
