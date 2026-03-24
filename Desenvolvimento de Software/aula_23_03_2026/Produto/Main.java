class Produto {
    String nome;
    double preco;
    double quantidade;
}

public class Main {
    public static void main(String[] args) {
        Produto produto1 = new Produto();

        produto1.nome = "Notebook";
        produto1.quantidade = 0.5;
        produto1.preco = 5000;

        System.out.println("Produto: " + produto1.nome);
        System.out.println("Quantidade: " + produto1.quantidade);
        System.out.println("Preço: " + produto1.preco);
    }
}
