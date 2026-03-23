package aula_10_03_2026.Array;

public class Array {
    public static void main(String[] args) {
        int[] notas = new int[5];

        notas[0] = 7;
        notas[1] = 8;
        notas[2] = 9;
        notas[3] = 6;
        notas[4] = 10;

        for (int i = 0; i < 5; i++) {
            System.out.println("Nota: " + notas[i]);
        }
    }
}
