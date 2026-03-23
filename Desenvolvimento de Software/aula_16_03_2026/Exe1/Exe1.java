public class Exe1 {
    
    // Método que altera o primeiro elemento do vetor
    static void alterarVetor(int[] vetor, int valor) {
        vetor[0] = valor;
    }

    public static void main(String[] args) {
    
        int[] numeros = {1, 2, 3, 4, 5};

        // Chamando o método correto
        alterarVetor(numeros, 7);

        System.out.println("Vetor após alteração:");
        for (int n : numeros) {
            System.out.print(n + " ");
        }
    }
}
