import java.util.ArrayList;

class Produto {
    String nome;
    double preco; // Corrigido: sem acento
}

class Carrinho {
    ArrayList<Produto> produtos = new ArrayList<>();

    void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    void listarProdutos() {
        System.out.println("Produtos no carrinho:");
        for (Produto p : produtos) {
            System.out.println(p.nome + " - R$ " + p.preco);
        }
    }

    void calcularTotal() {
        double total = 0;
        for (Produto p : produtos) {
            total += p.preco;
        }
        System.out.println("Total da compra: R$ " + total);
    }
}

public class Main {
    public static void main(String[] args) {
        Produto p1 = new Produto();
        p1.nome = "Notebook";
        p1.preco = 3000;

        Produto p2 = new Produto();
        p2.nome = "Mouse";
        p2.preco = 200;

        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(p1);
        carrinho.adicionarProduto(p2);

        carrinho.listarProdutos();
        carrinho.calcularTotal();
    }
}