package aula_10_03_2026.Exe4;
import java.util.Scanner;

public class Exe4 {
    public static void main(String[] args) {
        Scanner numero = new Scanner(System.in);

        System.out.print("Digite um numero: ");
        int n1 = numero.nextInt();

        for(int i = n1; i >=0; i--){
            System.out.println(i);
        }
        numero.close();
    }
}
