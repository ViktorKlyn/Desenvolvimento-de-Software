package utils;

/**
 * Classe utilitária para validações simples de dados.
 */
public class Validacoes {

    public static boolean isCpfValido(String cpf) {
        return cpf != null && cpf.matches("\\d{11}");
    }

    public static boolean isTelefoneValido(String telefone) {
        return telefone != null && telefone.matches("\\d{10,11}");
    }

    public static boolean isValorPositivo(double valor) {
        return valor >= 0;
    }
}
