package view;

import controller.ConsultaController;
import controller.FinanceiroController;
import controller.LoginController;
import controller.MedicoController;
import controller.PacienteController;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import model.Consulta;
import model.Fatura;
import model.Medico;
import model.Paciente;
import model.Pagamento;

/**
 * View principal que apresenta o menu interativo e chama os controladores.
 */
public class MenuPrincipalView {
    private final LoginController loginController;
    private final PacienteController pacienteController;
    private final ConsultaController consultaController;
    private final FinanceiroController financeiroController;
    private final MedicoController medicoController;
    private final Scanner scanner;

    public MenuPrincipalView(LoginController loginController, PacienteController pacienteController,
                             ConsultaController consultaController, FinanceiroController financeiroController,
                             MedicoController medicoController) {
        this.loginController = loginController;
        this.pacienteController = pacienteController;
        this.consultaController = consultaController;
        this.financeiroController = financeiroController;
        this.medicoController = medicoController;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        loginController.carregarUsuario();
        new LoginView(loginController).exibirLogin();

        pacienteController.carregarPacientes();
        medicoController.carregarMedicos();
        List<Paciente> pacientes = pacienteController.getPacientes();
        List<Medico> medicos = medicoController.getMedicos();
        consultaController.carregarConsultas(pacientes, medicos);
        financeiroController.carregarFaturas(consultaController.getConsultas());
        financeiroController.carregarPagamentos();

        while (true) {
            exibirMenu();
            Integer opcao = lerOpcao();
            if (opcao == null) {
                continue;
            }
            if (!processarOpcao(opcao)) {
                break;
            }
        }
    }

    private void exibirMenu() {
        System.out.println("=== Menu Principal ===");
        System.out.println("1 - Login");
        System.out.println("2 - Gerenciar Pacientes");
        System.out.println("3 - Gerenciar Médicos");
        System.out.println("4 - Gerenciar Consultas");
        System.out.println("5 - Gerenciar Faturas");
        System.out.println("6 - Gerenciar Pagamentos");
        System.out.println("7 - Relatório Financeiro");
        System.out.println("8 - Salvar Dados");
        System.out.println("9 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private boolean processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                new LoginView(loginController).exibirLogin();
                break;
            case 2:
                gerenciarPacientes();
                break;
            case 3:
                gerenciarMedicos();
                break;
            case 4:
                gerenciarConsultas();
                break;
            case 5:
                gerenciarFaturas();
                break;
            case 6:
                gerenciarPagamentos();
                break;
            case 7:
                new RelatorioView(financeiroController).exibirRelatorio();
                break;
            case 8:
                salvarDados();
                break;
            case 9:
                System.out.println("Saindo do sistema.");
                return false;
            default:
                System.out.println("Opção inválida.");
        }
        return true;
    }

    private void gerenciarPacientes() {
        System.out.println("=== Gerenciar Pacientes ===");
        System.out.println("1 - Cadastrar paciente");
        System.out.println("2 - Consultar paciente");
        System.out.println("3 - Alterar paciente");
        System.out.println("4 - Excluir paciente");
        System.out.print("Escolha uma opção: ");
        Integer opcao = lerOpcao();
        if (opcao == null) {
            return;
        }
        switch (opcao) {
            case 1:
                cadastrarPaciente();
                break;
            case 2:
                consultarPaciente();
                break;
            case 3:
                alterarPaciente();
                break;
            case 4:
                excluirPaciente();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void cadastrarPaciente() {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Convênio: ");
        String convenio = scanner.nextLine();
        Paciente paciente = new Paciente(id, nome, cpf, telefone, convenio);
        pacienteController.adicionarPaciente(paciente);
        System.out.println("Paciente cadastrado com sucesso.");
    }

    private void consultarPaciente() {
        System.out.print("Digite o ID do paciente: ");
        String id = scanner.nextLine();
        Optional<Paciente> paciente = pacienteController.buscarPacientePorId(id);
        System.out.println(paciente.map(Paciente::toString).orElse("Paciente não encontrado."));
    }

    private void alterarPaciente() {
        System.out.print("Digite o ID do paciente: ");
        String id = scanner.nextLine();
        Optional<Paciente> existente = pacienteController.buscarPacientePorId(id);
        if (existente.isPresent()) {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Convênio: ");
            String convenio = scanner.nextLine();
            Paciente atualizado = new Paciente(id, nome, cpf, telefone, convenio);
            if (pacienteController.atualizarPaciente(atualizado)) {
                System.out.println("Paciente atualizado com sucesso.");
            } else {
                System.out.println("Falha ao atualizar paciente.");
            }
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    private void excluirPaciente() {
        System.out.print("Digite o ID do paciente: ");
        String id = scanner.nextLine();
        if (pacienteController.excluirPaciente(id)) {
            System.out.println("Paciente excluído com sucesso.");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    private void gerenciarMedicos() {
        System.out.println("=== Gerenciar Médicos ===");
        System.out.println("1 - Cadastrar médico");
        System.out.println("2 - Consultar médico");
        System.out.println("3 - Alterar médico");
        System.out.println("4 - Excluir médico");
        System.out.print("Escolha uma opção: ");
        Integer opcao = lerOpcao();
        if (opcao == null) {
            return;
        }
        switch (opcao) {
            case 1:
                cadastrarMedico();
                break;
            case 2:
                consultarMedico();
                break;
            case 3:
                alterarMedico();
                break;
            case 4:
                excluirMedico();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void cadastrarMedico() {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Salário: ");
        double salario;
        try {
            salario = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Valor de salário inválido. Retornando ao menu de médicos.");
            return;
        }
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();
        System.out.print("CRM: ");
        String crm = scanner.nextLine();
        Medico medico = new Medico(id, nome, cpf, telefone, matricula, salario, especialidade, crm);
        medicoController.adicionarMedico(medico);
        System.out.println("Médico cadastrado com sucesso.");
    }

    private void consultarMedico() {
        System.out.print("Digite o ID do médico: ");
        String id = scanner.nextLine();
        Optional<Medico> medico = medicoController.buscarMedicoPorId(id);
        System.out.println(medico.map(Medico::toString).orElse("Médico não encontrado."));
    }

    private void gerenciarConsultas() {
        System.out.println("=== Gerenciar Consultas ===");
        System.out.println("1 - Cadastrar consulta");
        System.out.println("2 - Consultar consultas");
        System.out.print("Escolha uma opção: ");
        Integer opcao = lerOpcao();
        if (opcao == null) {
            return;
        }
        switch (opcao) {
            case 1:
                cadastrarConsulta();
                break;
            case 2:
                consultarConsultas();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void cadastrarConsulta() {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Data: ");
        String data = scanner.nextLine();
        System.out.print("Valor: ");
        double valor;
        try {
            valor = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Valor de consulta inválido. Retornando ao menu de consultas.");
            return;
        }
        System.out.print("ID do paciente: ");
        String pacienteId = scanner.nextLine();
        System.out.print("ID do médico: ");
        String medicoId = scanner.nextLine();

        Optional<Paciente> paciente = pacienteController.buscarPacientePorId(pacienteId);
        if (paciente.isEmpty()) {
            System.out.println("Paciente não encontrado.");
            return;
        }
        Optional<Medico> medico = medicoController.buscarMedicoPorId(medicoId);
        if (medico.isEmpty()) {
            System.out.println("Médico não encontrado.");
            return;
        }
        consultaController.adicionarConsulta(new Consulta(id, data, valor, paciente.get(), medico.get()));
        System.out.println("Consulta cadastrada com sucesso.");
    }

    private void consultarConsultas() {
        for (Consulta consulta : consultaController.getConsultas()) {
            System.out.println(consulta);
        }
    }

    private void gerenciarFaturas() {
        System.out.println("=== Gerenciar Faturas ===");
        System.out.println("1 - Listar faturas");
        System.out.println("2 - Gerar fatura");
        System.out.print("Escolha uma opção: ");
        Integer opcao = lerOpcao();
        if (opcao == null) {
            return;
        }
        switch (opcao) {
            case 1:
                listarFaturas();
                break;
            case 2:
                gerarFatura();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void listarFaturas() {
        for (Fatura fatura : financeiroController.getFaturas()) {
            System.out.println(fatura);
        }
    }

    private void gerarFatura() {
        System.out.print("ID da fatura: ");
        String id = scanner.nextLine();
        System.out.print("ID da consulta: ");
        String consultaId = scanner.nextLine();
        Optional<Consulta> consulta = consultaController.buscarConsultaPorId(consultaId);
        if (consulta.isPresent()) {
            double valorTotal = consulta.get().calcularValor();
            Fatura fatura = new Fatura(id, consulta.get(), valorTotal, "PENDENTE");
            financeiroController.adicionarFatura(fatura);
            System.out.println("Fatura gerada com sucesso.");
        } else {
            System.out.println("Consulta não encontrada.");
        }
    }

    private void gerenciarPagamentos() {
        System.out.println("=== Gerenciar Pagamentos ===");
        System.out.println("1 - Registrar pagamento");
        System.out.println("2 - Consultar pagamentos");
        System.out.print("Escolha uma opção: ");
        Integer opcao = lerOpcao();
        if (opcao == null) {
            return;
        }
        switch (opcao) {
            case 1:
                registrarPagamento();
                break;
            case 2:
                consultarPagamentos();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void registrarPagamento() {
        System.out.print("ID do pagamento: ");
        String id = scanner.nextLine();
        System.out.print("ID da fatura: ");
        String faturaId = scanner.nextLine();
        System.out.print("Valor pago: ");
        double valorPago;
        try {
            valorPago = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Valor de pagamento inválido. Retornando ao menu de pagamentos.");
            return;
        }
        System.out.print("Data do pagamento: ");
        String dataPagamento = scanner.nextLine();

        Optional<Fatura> fatura = financeiroController.buscarFaturaPorId(faturaId);
        if (fatura.isPresent()) {
            Pagamento pagamento = new Pagamento(id, fatura.get(), valorPago, dataPagamento);
            financeiroController.adicionarPagamento(pagamento);
            System.out.println("Pagamento registrado com sucesso.");
        } else {
            System.out.println("Fatura não encontrada.");
        }
    }

    private void consultarPagamentos() {
        for (Pagamento pagamento : financeiroController.getPagamentos()) {
            System.out.println(pagamento);
        }
    }

    private void salvarDados() {
        pacienteController.salvarPacientes();
        consultaController.salvarConsultas();
        financeiroController.salvarFaturas();
        financeiroController.salvarPagamentos();
        medicoController.salvarMedicos();
        System.out.println("Dados salvos com sucesso.");
    }

    private Integer lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor insira um número válido.");
            return null;
        }
    }

    private void alterarMedico() {
        System.out.print("Digite o ID do médico: ");
        String id = scanner.nextLine();
        Optional<Medico> existente = medicoController.buscarMedicoPorId(id);
        if (existente.isPresent()) {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Matrícula: ");
            String matricula = scanner.nextLine();
            System.out.print("Salário: ");
            double salario;
            try {
                salario = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Valor de salário inválido. Retornando ao menu de médicos.");
                return;
            }
            System.out.print("Especialidade: ");
            String especialidade = scanner.nextLine();
            System.out.print("CRM: ");
            String crm = scanner.nextLine();
            Medico atualizado = new Medico(id, nome, cpf, telefone, matricula, salario, especialidade, crm);
            if (medicoController.atualizarMedico(atualizado)) {
                System.out.println("Médico atualizado com sucesso.");
            } else {
                System.out.println("Falha ao atualizar médico.");
            }
        } else {
            System.out.println("Médico não encontrado.");
        }
    }

    private void excluirMedico() {
        System.out.print("Digite o ID do médico: ");
        String id = scanner.nextLine();
        if (medicoController.excluirMedico(id)) {
            System.out.println("Médico excluído com sucesso.");
        } else {
            System.out.println("Médico não encontrado.");
        }
    }
}
