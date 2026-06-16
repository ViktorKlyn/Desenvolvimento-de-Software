package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;
import persistence.ArquivoManager;

/**
 * Controlador responsável pelo login do usuário e gerenciamento de senhas.
 */
public class LoginController {
    private static final int MAX_TENTATIVAS = 3;
    private final ArquivoManager arquivoManager;
    private Usuario usuario;
    private int tentativasRestantes;
    private boolean exigeNovaSenha;

    public LoginController() {
        this.arquivoManager = new ArquivoManager("usuarios.txt");
        this.tentativasRestantes = MAX_TENTATIVAS;
        this.exigeNovaSenha = false;
        this.usuario = new Usuario("admin", "admin123");
    }

    public void carregarUsuario() {
        try {
            List<String> linhas = arquivoManager.carregarDados();
            if (linhas.size() >= 2) {
                String login = linhas.get(0);
                String senhaAtual = linhas.get(1);
                List<String> historico = new ArrayList<>();
                for (int i = 2; i < linhas.size(); i++) {
                    historico.add(linhas.get(i));
                }
                usuario = new Usuario(login, senhaAtual);
                usuario.setHistoricoSenhas(historico);
            } else {
                salvarUsuario();
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar usuário: " + e.getMessage());
        }
    }

    public void salvarUsuario() {
        try {
            List<String> linhas = new ArrayList<>();
            linhas.add(usuario.getLogin());
            linhas.add(usuario.getSenhaAtual());
            linhas.addAll(usuario.getHistoricoSenhas());
            arquivoManager.atualizarDados(linhas);
        } catch (IOException e) {
            System.err.println("Erro ao salvar usuário: " + e.getMessage());
        }
    }

    public boolean autenticar(String login, String senha) {
        if (exigeNovaSenha) {
            return false;
        }
        if (!usuario.getLogin().equals(login) || !usuario.getSenhaAtual().equals(senha)) {
            tentativasRestantes--;
            if (tentativasRestantes <= 0) {
                exigeNovaSenha = true;
            }
            return false;
        }
        tentativasRestantes = MAX_TENTATIVAS;
        return true;
    }

    public boolean isExigeNovaSenha() {
        return exigeNovaSenha;
    }

    public int getTentativasRestantes() {
        return tentativasRestantes;
    }

    public boolean redefinirSenha(String novaSenha) {
        if (usuario.senhaJaUtilizada(novaSenha)) {
            return false;
        }
        usuario.setSenhaAtual(novaSenha);
        usuario.adicionarSenhaAoHistorico(novaSenha);
        salvarUsuario();
        tentativasRestantes = MAX_TENTATIVAS;
        exigeNovaSenha = false;
        return true;
    }
}
