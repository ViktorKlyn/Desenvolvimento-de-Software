package model;

/**
 * Representa uma fatura gerada a partir de uma consulta.
 * Implementa polimorfismo através do método calcularValor.
 */
public class Fatura {
    private String id;
    private Consulta consulta;
    private double valorTotal;
    private String statusPagamento;

    public Fatura() {
    }

    public Fatura(String id, Consulta consulta, double valorTotal, String statusPagamento) {
        this.id = id;
        this.consulta = consulta;
        this.valorTotal = valorTotal;
        this.statusPagamento = statusPagamento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public double calcularValor() {
        return valorTotal;
    }

    @Override
    public String toString() {
        String consultaInfo = consulta != null ? consulta.getId() : "N/A";
        return "Fatura{" + "ID='" + id + '\'' + ", ConsultaID='" + consultaInfo + '\'' + ", ValorTotal=" + valorTotal + ", StatusPagamento='" + statusPagamento + '\'' + '}';
    }
}
