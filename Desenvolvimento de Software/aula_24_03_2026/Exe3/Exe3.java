import java.util.ArrayList;

class Produto {
    String nome;
    double precoProduto;
}

class Pedido {
    String nomePedido;
    ArrayList<Produto> produtos = new ArrayList<>();

    void listarProdutos() {
        for (Produto p : produtos) {
            System.out.println(p.nome + " - R$" + p.precoProduto);
        }
    }
}

public class Exe3 {
    public static void main(String[] args) {
        Produto p1 = new Produto();
        p1.nome = "Monitor";
        p1.precoProduto = 1500.0;

        Produto p2 = new Produto();
        p2.nome = "Teclado";
        p2.precoProduto = 150.0;

        Pedido pedido = new Pedido();
        pedido.nomePedido = "Pedido #1";
        pedido.produtos.add(p1);
        pedido.produtos.add(p2);

        pedido.listarProdutos();
    }
}