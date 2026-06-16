package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um usuário do sistema com login e histórico de senhas.
 */
public class Usuario {
    private String login;
    private String senhaAtual;
    private List<String> historicoSenhas;

    public Usuario() {
        this.historicoSenhas = new ArrayList<>();
    }

    public Usuario(String login, String senhaAtual) {
        this.login = login;
        this.senhaAtual = senhaAtual;
        this.historicoSenhas = new ArrayList<>();
        this.historicoSenhas.add(senhaAtual);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenhaAtual() {
        return senhaAtual;
    }

    public void setSenhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

    public List<String> getHistoricoSenhas() {
        return historicoSenhas;
    }

    public void setHistoricoSenhas(List<String> historicoSenhas) {
        this.historicoSenhas = historicoSenhas;
    }

    public void adicionarSenhaAoHistorico(String senha) {
        this.historicoSenhas.add(senha);
        if (this.historicoSenhas.size() > 3) {
            this.historicoSenhas.remove(0);
        }
    }

    public boolean senhaJaUtilizada(String senha) {
        return historicoSenhas.contains(senha);
    }

    @Override
    public String toString() {
        return "Usuario{" + "Login='" + login + '\'' + ", SenhaAtual='" + senhaAtual + '\'' + ", HistoricoSenhas=" + historicoSenhas + '}';
    }
}
