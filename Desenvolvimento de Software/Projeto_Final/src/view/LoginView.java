package view;

import controller.LoginController;
import java.util.Scanner;

/**
 * Interface de console para login do usuário.
 */
public class LoginView {
    private final LoginController loginController;
    private final Scanner scanner;

    public LoginView(LoginController loginController) {
        this.loginController = loginController;
        this.scanner = new Scanner(System.in);
    }

    public void exibirLogin() {
        loginController.carregarUsuario();
        while (true) {
            if (loginController.isExigeNovaSenha()) {
                System.out.println("Você excedeu o número de tentativas. Informe uma nova senha:");
                String novaSenha = scanner.nextLine();
                if (loginController.redefinirSenha(novaSenha)) {
                    System.out.println("Senha atualizada com sucesso. Faça login novamente.");
                } else {
                    System.out.println("Senha inválida ou já utilizada. Tente outra senha.");
                }
                continue;
            }

            System.out.print("Login: ");
            String login = scanner.nextLine();
            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            if (loginController.autenticar(login, senha)) {
                System.out.println("Login efetuado com sucesso.");
                break;
            }
            System.out.println("Login ou senha incorretos. Tentativas restantes: " + loginController.getTentativasRestantes());
        }
    }
}
