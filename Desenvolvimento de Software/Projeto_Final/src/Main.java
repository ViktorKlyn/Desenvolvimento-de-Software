import controller.ConsultaController;
import controller.FinanceiroController;
import controller.LoginController;
import controller.MedicoController;
import controller.PacienteController;
import view.MenuPrincipalView;

public class Main {
    public static void main(String[] args) {
        System.out.println("Projeto Sistema de Gestão Hospitalar com Foco no Setor Financeiro");

        LoginController loginController = new LoginController();
        PacienteController pacienteController = new PacienteController();
        MedicoController medicoController = new MedicoController();
        ConsultaController consultaController = new ConsultaController();
        FinanceiroController financeiroController = new FinanceiroController();

        MenuPrincipalView menuPrincipalView = new MenuPrincipalView(
                loginController,
                pacienteController,
                consultaController,
                financeiroController,
                medicoController
        );
        menuPrincipalView.iniciar();
    }
}