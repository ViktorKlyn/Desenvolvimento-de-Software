import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Veiculo {
    private String modelo;
    private double valorDiaria;

    public Veiculo(String modelo, double valorDiaria) {
        this.modelo = modelo;
        this.valorDiaria = valorDiaria;
    }

    public String getModelo() {
        return modelo;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public abstract double calcularAluguel(int dias);

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - Modelo: " + modelo + " | Diária: R$ " + String.format("%.2f", valorDiaria);
    }
}

class Carro extends Veiculo {
    private static final double TAXA_SEGURO = 50.0;

    public Carro(String modelo, double valorDiaria) {
        super(modelo, valorDiaria);
    }

    @Override
    public double calcularAluguel(int dias) {
        return getValorDiaria() * dias + TAXA_SEGURO;
    }
}

class Moto extends Veiculo {
    public Moto(String modelo, double valorDiaria) {
        super(modelo, valorDiaria);
    }

    @Override
    public double calcularAluguel(int dias) {
        return getValorDiaria() * dias;
    }
}

class Caminhao extends Veiculo {
    private static final double TAXA_CARGA = 150.0;

    public Caminhao(String modelo, double valorDiaria) {
        super(modelo, valorDiaria);
    }

    @Override
    public double calcularAluguel(int dias) {
        return getValorDiaria() * dias + TAXA_CARGA;
    }
}

class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + " | CPF: " + cpf;
    }
}

class Contrato {
    private Cliente cliente;
    private Veiculo veiculo;
    private int dias;
    private static final double DESCONTO_LONGA_PERMANENCIA = 0.10;

    public Contrato(Cliente cliente, Veiculo veiculo, int dias) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dias = dias;
    }

    public double calcularValorTotal() {
        double valorBase = veiculo.calcularAluguel(dias);
        if (dias > 7) {
            return valorBase - (valorBase * DESCONTO_LONGA_PERMANENCIA);
        }
        return valorBase;
    }

    public double getDesconto() {
        if (dias > 7) {
            return DESCONTO_LONGA_PERMANENCIA;
        }
        return 0.0;
    }

    public void mostrarResumo() {
        System.out.println("=== RESUMO DO CONTRATO ===");
        System.out.println(cliente);
        System.out.println("Veículo: " + veiculo);
        System.out.println("Dias de aluguel: " + dias);
        System.out.println("Descrição do cálculo: R$ " + String.format("%.2f", veiculo.getValorDiaria())
                + " x " + dias
                + (veiculo instanceof Carro ? " + taxa de seguro R$ 50" : "")
                + (veiculo instanceof Caminhao ? " + taxa de carga R$ 150" : "")
                + "");
        System.out.println("Desconto aplicado: " + String.format("%.0f%%", getDesconto() * 100));
        System.out.println("Valor total: R$ " + String.format("%.2f", calcularValorTotal()));
        System.out.println("===========================\n");
    }
}

public class Exe5 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Veiculo> veiculos = new ArrayList<>();
    private static final List<Cliente> clientes = new ArrayList<>();
    private static final List<Contrato> contratos = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro();
            switch (opcao) {
                case 1:
                    cadastrarVeiculo();
                    break;
                case 2:
                    listarVeiculos();
                    break;
                case 3:
                    removerVeiculo();
                    break;
                case 4:
                    cadastrarCliente();
                    break;
                case 5:
                    criarContrato();
                    break;
                case 6:
                    listarContratos();
                    break;
                case 7:
                    System.out.println("Encerrando sistema de locadora.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 7);
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n=== SISTEMA DE LOCADORA DE VEÍCULOS ===");
        System.out.println("1. Cadastrar veículo");
        System.out.println("2. Listar veículos disponíveis");
        System.out.println("3. Remover veículo da lista");
        System.out.println("4. Cadastrar cliente");
        System.out.println("5. Criar contrato de aluguel");
        System.out.println("6. Listar contratos");
        System.out.println("7. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarVeiculo() {
        System.out.print("Modelo do veículo: ");
        String modelo = scanner.nextLine();

        System.out.println("Tipo de veículo:");
        System.out.println("1. Carro (taxa de seguro R$ 50)");
        System.out.println("2. Moto (sem seguro)");
        System.out.println("3. Caminhão (taxa de carga R$ 150)");
        System.out.print("Escolha uma opção: ");
        int tipo = lerInteiro();

        System.out.print("Valor da diária: R$ ");
        double diaria = lerDoubleNaoNegativo();

        Veiculo veiculo;
        switch (tipo) {
            case 1:
                veiculo = new Carro(modelo, diaria);
                break;
            case 2:
                veiculo = new Moto(modelo, diaria);
                break;
            case 3:
                veiculo = new Caminhao(modelo, diaria);
                break;
            default:
                System.out.println("Tipo inválido. Veículo não cadastrado.");
                return;
        }
        veiculos.add(veiculo);
        System.out.println("Veículo cadastrado com sucesso!");
    }

    private static void listarVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo disponível.");
            return;
        }
        System.out.println("\n=== VEÍCULOS DISPONÍVEIS ===");
        for (int i = 0; i < veiculos.size(); i++) {
            System.out.println((i + 1) + ". " + veiculos.get(i));
        }
    }

    private static void removerVeiculo() {
        if (veiculos.isEmpty()) {
            System.out.println("Não há veículos para remover.");
            return;
        }
        listarVeiculos();
        System.out.print("Digite o número do veículo que deseja remover: ");
        int indice = lerInteiro();
        if (indice < 1 || indice > veiculos.size()) {
            System.out.println("Índice inválido.");
            return;
        }
        Veiculo removido = veiculos.remove(indice - 1);
        System.out.println("Veículo removido: " + removido.getModelo());
    }

    private static void cadastrarCliente() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine();
        clientes.add(new Cliente(nome, cpf));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void criarContrato() {
        if (veiculos.isEmpty()) {
            System.out.println("Não há veículos disponíveis para aluguel.");
            return;
        }
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados. Cadastre um cliente primeiro.");
            return;
        }

        System.out.println("\n=== CLIENTES CADASTRADOS ===");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i));
        }
        System.out.print("Escolha o cliente pelo número: ");
        int clienteIndex = lerInteiro();
        if (clienteIndex < 1 || clienteIndex > clientes.size()) {
            System.out.println("Índice de cliente inválido.");
            return;
        }
        Cliente cliente = clientes.get(clienteIndex - 1);

        listarVeiculos();
        System.out.print("Escolha o veículo pelo número: ");
        int veiculoIndex = lerInteiro();
        if (veiculoIndex < 1 || veiculoIndex > veiculos.size()) {
            System.out.println("Índice de veículo inválido.");
            return;
        }
        Veiculo veiculo = veiculos.remove(veiculoIndex - 1);

        System.out.print("Quantidade de dias de aluguel: ");
        int dias = lerInteiroNaoNegativo();
        if (dias == 0) {
            System.out.println("O aluguel deve ser de pelo menos 1 dia.");
            veiculos.add(veiculo);
            return;
        }

        Contrato contrato = new Contrato(cliente, veiculo, dias);
        contratos.add(contrato);
        System.out.println("Contrato criado com sucesso!");
        contrato.mostrarResumo();
    }

    private static void listarContratos() {
        if (contratos.isEmpty()) {
            System.out.println("Nenhum contrato registrado.");
            return;
        }
        System.out.println("\n=== CONTRATOS GERADOS ===");
        for (Contrato contrato : contratos) {
            contrato.mostrarResumo();
        }
    }

    private static int lerInteiro() {
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Digite um número inteiro: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    private static int lerInteiroNaoNegativo() {
        int valor = lerInteiro();
        while (valor < 0) {
            System.out.print("Valor inválido. Digite um número inteiro não negativo: ");
            valor = lerInteiro();
        }
        return valor;
    }

    private static double lerDoubleNaoNegativo() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Entrada inválida. Digite um número válido: ");
            scanner.next();
        }
        double valor = scanner.nextDouble();
        scanner.nextLine();
        while (valor < 0) {
            System.out.print("Valor inválido. Digite um número não negativo: ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Entrada inválida. Digite um número válido: ");
                scanner.next();
            }
            valor = scanner.nextDouble();
            scanner.nextLine();
        }
        return valor;
    }
}

