import java.util.ArrayList;

class Produto {
    String nome;
    double preco;
}

class ProdutoFisico extends Produto {
    double peso;
}

class ProdutoDigital extends Produto {
    double tamanhoArquivo;
}

class Carrinho {
    ArrayList<Produto> produtos = new ArrayList<>();

    void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    void listarProdutos() {
        System.out.println("Produtos no carrinho:");
        for (Produto p : produtos) {

            System.out.printf("Nome: " + p.nome);
            System.out.println("Preço: " + p.preco);

            if (p instanceof ProdutoFisico) {
                ProdutoFisico pf = (ProdutoFisico) p;
                System.out.println("Peso: " + pf.peso + "kg");
            }

            if (p instanceof ProdutoDigital) {
                ProdutoDigital pd = (ProdutoDigital) p;
                System.out.println("Tamanho: " + pd.tamanhoArquivo + "MB");
            }
        }
    }

    void calcularTotal() {
        double total = 0;
        for (Produto p : produtos) {
            total += p.preco;
        }
        System.out.printf("Total da compra: R$ %.2f%n", total);
    }
}

public class Main {
    public static void main(String[] args) {
        ProdutoFisico p1 = new ProdutoFisico();
        p1.nome = "Notebook";
        p1.preco = 3000;
        p1.peso = 2;

        ProdutoDigital p2 = new ProdutoDigital();
        p2.nome = "Curso de Java";
        p2.preco = 200;
        p2.tamanhoArquivo = 1500;

        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(p1);
        carrinho.adicionarProduto(p2);

        carrinho.listarProdutos();
        carrinho.calcularTotal();
    }
}