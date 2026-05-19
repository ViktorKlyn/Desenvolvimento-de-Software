import java.util.ArrayList;

   abstract class Produto {

    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public abstract double calcularPrecoFinal();
}

class ProdutoFisico extends Produto {

    private double frete;

    public ProdutoFisico(String nome, double preco, double frete) {
        super(nome, preco);
        this.frete = frete;
    }

    @Override
    public double calcularPrecoFinal() {
        return getPreco() + frete;
    }
}

class ProdutoDigital extends Produto {

    public ProdutoDigital(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double calcularPrecoFinal() {
        return getPreco(); // sem frete
    }
}

class ProdutoPromocional extends Produto {

    private double desconto;

    public ProdutoPromocional(String nome, double preco, double desconto) {
        super(nome, preco);
        this.desconto = desconto;
    }

    @Override
    public double calcularPrecoFinal() {
        return getPreco() - (getPreco() * desconto);
    }
}

class Carrinho {

    private ArrayList<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto p) {
        produtos.add(p);
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto p : produtos) {
            total += p.calcularPrecoFinal();
        }
        return total;
    }

    public void mostrarProdutos() {
        for (Produto p : produtos) {
            System.out.println(p.getNome() + " - R$ " + p.calcularPrecoFinal());
        }
    }
}

public class Ecommerce {

    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();

        Produto notebook = new ProdutoFisico("Notebook", 3000, 50);
        Produto curso = new ProdutoDigital("Curso Java", 200);
        Produto mousePromo = new ProdutoPromocional("Mouse", 100, 0.10);

        carrinho.adicionarProduto(notebook);
        carrinho.adicionarProduto(curso);
        carrinho.adicionarProduto(mousePromo);

        carrinho.mostrarProdutos();
        System.out.println("Total: R$ " + carrinho.calcularTotal());
    }
}
