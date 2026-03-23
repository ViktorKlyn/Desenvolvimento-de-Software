import java.util.Scanner;

public class Cubo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a dimensão da matriz: ");
        int n = scanner.nextInt();

        // Validação da dimensão
        if (n <= 0) {
            System.out.println("Dimensão inválida!");
            return;
        }

        int[][] matriz = new int[n][n];

        // Leitura da matriz
        System.out.println("Digite os valores da matriz:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }
        int somaReferencia = 0;

        // Soma da primeira linha (valor de referência)
        for (int j = 0; j < n; j++) {
            somaReferencia += matriz[0][j];
        }
        boolean ehMagico = true;

        // Verificar soma das linhas
        for (int i = 0; i < n; i++) {
            int somaLinha = 0;
            for (int j = 0; j < n; j++) {
                somaLinha += matriz[i][j];
            }
            if (somaLinha != somaReferencia) {
                ehMagico = false;
                break;
            }
        }
        // Verificar soma das colunas
        for (int j = 0; j < n && ehMagico; j++) {
            int somaColuna = 0;
            for (int i = 0; i < n; i++) {
                somaColuna += matriz[i][j];
            }
            if (somaColuna != somaReferencia) {
                ehMagico = false;
                break;
            }
        }

        // Verificar diagonal principal
        int somaDiagonalPrincipal = 0;
        for (int i = 0; i < n; i++) {
            somaDiagonalPrincipal += matriz[i][i];
        }
        if (somaDiagonalPrincipal != somaReferencia) {
            ehMagico = false;
        }
        
        // Verificar diagonal secundária
        int somaDiagonalSecundaria = 0;
        for (int i = 0; i < n; i++) {
            somaDiagonalSecundaria += matriz[i][n - 1 - i];
        }
        if (somaDiagonalSecundaria != somaReferencia) {
            ehMagico = false;
        }
        // Resultado
        if (ehMagico) {
            System.out.println("Quadrado magico");
        } else {
            System.out.println("Quadrado NAO magico");
        }
        scanner.close();
    }
}
