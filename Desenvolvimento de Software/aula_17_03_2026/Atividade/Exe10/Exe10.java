public class Exe10 {
    static void alterar(int[] v) {
        v[0] = 50;
    }

    public static void main(String[] args) {
        int[] vetor = { 10, 20, 30 };
        alterar(vetor);
        System.out.println(vetor[0]);
    }
}