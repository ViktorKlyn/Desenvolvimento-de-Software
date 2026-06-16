package view;

import controller.FinanceiroController;

/**
 * View responsável por exibir o relatório financeiro.
 */
public class RelatorioView {
    private final FinanceiroController financeiroController;

    public RelatorioView(FinanceiroController financeiroController) {
        this.financeiroController = financeiroController;
    }

    public void exibirRelatorio() {
        financeiroController.gerarRelatorio();
    }
}
