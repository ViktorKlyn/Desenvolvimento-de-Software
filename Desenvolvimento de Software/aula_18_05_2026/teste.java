
import java.util.ArrayList;
import java.util.Scanner;

class Cliente {

    private String nome;
    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

abstract class Produto {

    private String nome;
    protected double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        if (preco >= 0) {
            this.preco = preco;
        } else {
            System.out.println("Preço Inválido!");
        }
    }

    abstract double calcularPrecoFinal();

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

class ProdutoFisico extends Produto {

    private double frete;

    public ProdutoFisico(String nome, double preco, double frete) {
        super(nome, preco);
        this.frete = frete;
    }

    @Override
    public double calcularPrecoFinal() {
        return preco + frete;
    }
}

class ProdutoDigital extends Produto {

    public ProdutoDigital(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double calcularPrecoFinal() {
        return preco;
    }
}

class ProdutoPromocional extends Produto {

    private double desconto;

    public ProdutoPromocional(String nome, double preco, double desconto) {
        super(nome, preco);
        this.desconto = desconto;
    }

    public double calcularPrecoFinal() {
        return preco - (preco * desconto / 100);
    }
}

class Carrinho {

    private ArrayList<Produto> produtos;

    public Carrinho() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println(produto.getNome() + "Adicionado ao carrinho");
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto p : produtos) {
            total += p.calcularPrecoFinal();
        }
        return total;
    }

    public void mostrarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Carrinho vazio.");
            return;
        }
        for (Produto p : produtos) {
            System.out.println(p.getNome() + " - R$" + p.calcularPrecoFinal());
        }
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
}

class Pedido {

    private Cliente cliente;
    private Carrinho carrinho;

    public Pedido(Cliente cliente, Carrinho carrinho) {
        this.cliente = cliente;
        this.carrinho = carrinho;
    }

    public void mostrarResumo() {
        System.out.println("\n=======RESUMO DO PEDIDO=======");
        System.out.println("CLiente" + cliente.getNome());
        System.out.println("\nProdutos");
        carrinho.mostrarProdutos();
        System.out.println("\nTotal: R$" + carrinho.calcularTotal());
    }
}

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = new Cliente(nomeCliente);
        Produto p1 = new ProdutoFisico("Notebook", 3000, 50);
        Produto p2 = new ProdutoDigital("Curso em JAVA", 300);
        Produto p3 = new ProdutoPromocional("Mouse", 150, 10);
        Carrinho carrinho = new Carrinho();
        boolean continuar = true;

        while (continuar) {
            System.out.println("---MENU---");
            System.out.println("1-Notebook");
            System.out.println("2-Curso de JAVA");
            System.out.println("3-Mouse");
            System.out.println("4-Mostrar Carrinho");
            System.out.println("0-Finalizar Compra");
            System.out.println("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    carrinho.adicionarProduto(p1);
                    break;
                case 2:
                    carrinho.adicionarProduto(p2);
                    break;
                case 3:
                    carrinho.adicionarProduto(p3);
                    break;
                case 4:
                    carrinho.mostrarProdutos();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("Finalizando compra...");
                    break;
                default:
                    System.out.println("Opção Inválido");
            }
        }
        Pedido pedido = new Pedido(cliente, carrinho);
        pedido.mostrarResumo();
    }
}
