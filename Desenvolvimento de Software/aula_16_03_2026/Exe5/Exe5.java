import java.util.Scanner;

public class Exe5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Entrada da dimensão
        System.out.print("Digite a dimensão N da matriz: ");
        int N = sc.nextInt();

        int[][] matriz = new int[N][N];

        // Preenchendo a matriz
        System.out.println("Digite os valores da matriz:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }

        // Calcula a soma da primeira linha como referência
        int somaReferencia = 0;
        for (int j = 0; j < N; j++) {
            somaReferencia += matriz[0][j];
        }

        boolean quadradoMagico = true;

        // Verifica linhas
        for (int i = 1; i < N; i++) {
            int somaLinha = 0;
            for (int j = 0; j < N; j++) {
                somaLinha += matriz[i][j];
            }
            if (somaLinha != somaReferencia) {
                quadradoMagico = false;
                break;
            }
        }

        // Verifica colunas
        if (quadradoMagico) {
            for (int j = 0; j < N; j++) {
                int somaColuna = 0;
                for (int i = 0; i < N; i++) {
                    somaColuna += matriz[i][j];
                }
                if (somaColuna != somaReferencia) {
                    quadradoMagico = false;
                    break;
                }
            }
        }

        // Verifica diagonal principal
        if (quadradoMagico) {
            int somaDiagonalPrincipal = 0;
            for (int i = 0; i < N; i++) {
                somaDiagonalPrincipal += matriz[i][i];
            }
            if (somaDiagonalPrincipal != somaReferencia) {
                quadradoMagico = false;
            }
        }

        // Verifica diagonal secundária
        if (quadradoMagico) {
            int somaDiagonalSecundaria = 0;
            for (int i = 0; i < N; i++) {
                somaDiagonalSecundaria += matriz[i][N - 1 - i];
            }
            if (somaDiagonalSecundaria != somaReferencia) {
                quadradoMagico = false;
            }
        }

        // Resultado
        if (quadradoMagico) {
            System.out.println("QUADRADO MÁGICO");
        } else {
            System.out.println("QUADRADO NÃO MÁGICO");
        }

        sc.close();
    }
}