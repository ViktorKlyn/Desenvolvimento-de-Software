import java.util.ArrayList;

class Produto {
    String nome;
    double preco;

    Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}

class ProdutoFisico extends Produto {
    double peso;
    public ProdutoFisico(String nome, double preco, double peso) {
        super(nome, preco);
        this.peso = peso;
    }
}

class ProdutoDigital extends Produto {
    double tamanhoArquivo;
    public ProdutoDigital(String nome, double preco, double tamanhoArquivo) {
        super(nome, preco);
        this.tamanhoArquivo = tamanhoArquivo;
    }
}

class Carrinho {
    ArrayList<Produto> produtos = new ArrayList<>();
    class Cliente {
        String nome;

        Cliente(String nome) {
            this.nome = nome;
        }
    }

    class Pedido {
        int identificador;

        Pedido(int id) {
            this.identificador = id;
        }
    }

    void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    void listarProdutos() {
        System.out.println("Produtos no carrinho:");
        for (Produto p : produtos) {
            System.out.println("Nome: " + p.nome);
            System.out.println("Preço: R$" + p.preco);

            if (p instanceof ProdutoFisico) {
                ProdutoFisico pf = (ProdutoFisico) p;
                System.out.println("Peso: " + pf.peso + "kg");
            }

            if (p instanceof ProdutoDigital) {
                ProdutoDigital pd = (ProdutoDigital) p;
                System.out.println("Tamanho: " + pd.tamanhoArquivo + "MB");
            }

            System.out.println("----------------------");
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

public class Ecommerce {
    public static void main(String[] args) {
        ProdutoFisico p1 = new ProdutoFisico("Notebook", 3000, 2.5);
        
        ProdutoDigital p2 = new ProdutoDigital("Curso de Java", 500, 1500);

        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(p1);
        carrinho.adicionarProduto(p2);

        carrinho.listarProdutos();
        carrinho.calcularTotal();
    }
}