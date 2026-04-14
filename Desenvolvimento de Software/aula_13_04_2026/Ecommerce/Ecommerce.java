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

class Produto {
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

    public void aplicarDesconto(double percentual) {
        if (percentual > 0) {
            preco = preco - (preco * percentual / 100);
        }
    }
}

class Carrinho {
    private ArrayList<Produto> produtos;

    public Carrinho() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        if (produto.getPreco() > 0) {
            produtos.add(produto);
            System.out.println(produto.getNome() + " adicionado ao carrinho!");
        } else {
            System.out.println("Produto inválido (preço <= 0).");
        }
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
        System.out.println(produto.getNome() + " removido do carrinho!");
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto p : produtos) {
            total += p.getPreco();
        }
        return total;
    }

    public void mostrarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Carrinho vazio!");
        } else {
            System.out.println("Produtos no carrinho:");
            for (Produto p : produtos) {
                System.out.println("- " + p.getNome() + " | R$ " + p.getPreco());
            }
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

    public Cliente getCliente() {
        return cliente;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void mostrarResumo() {
        System.out.println("===== RESUMO DO PEDIDO =====");
        System.out.println("Cliente: " + cliente.getNome());
        carrinho.mostrarProdutos();
        System.out.println("Total: R$ " + carrinho.calcularTotal());
    }
}

public class Ecommerce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = sc.nextLine();

        Cliente cliente = new Cliente(nomeCliente);
        Produto notebook = new Produto("Notebook", 3000);
        Produto mouse = new Produto("Mouse", 100);
        Produto teclado = new Produto("Teclado", 200);
        
        notebook.aplicarDesconto(10);
        Carrinho carrinho = new Carrinho();
        int opcao;
        
        do {
            System.out.println("===== MENU DE PRODUTOS =====");
            System.out.println("1 - Notebook - R$ " + notebook.getPreco());
            System.out.println("2 - Mouse - R$ " + mouse.getPreco());
            System.out.println("3 - Teclado - R$ " + teclado.getPreco());
            System.out.println("0 - Finalizar compra");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    carrinho.adicionarProduto(notebook);
                    break;
                case 2:
                    carrinho.adicionarProduto(mouse);
                    break;
                case 3:
                    carrinho.adicionarProduto(teclado);
                    break;
                case 0:
                    System.out.println("Finalizando compra...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        while (opcao != 0);
        Pedido pedido = new Pedido(cliente, carrinho);
        pedido.mostrarResumo();
        sc.close();
    }
}