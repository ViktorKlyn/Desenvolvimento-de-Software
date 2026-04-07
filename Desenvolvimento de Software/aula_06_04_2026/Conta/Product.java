 class Produto {
    String nome;
    double preco;

    Produto(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }
}

public class Product{
    public static void main(String[] args) {
        Produto p1 = new Produto("Arroz", 27);

        System.out.println("Produto: " + p1.nome);
        System.out.println("Preço: " + p1.preco);
    }
}