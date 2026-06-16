package model;

/**
 * Representa um pagamento feito para uma fatura.
 * Implementa polimorfismo através do método calcularValor.
 */
public class Pagamento {
    private String id;
    private Fatura fatura;
    private double valorPago;
    private String dataPagamento;

    public Pagamento() {
    }

    public Pagamento(String id, Fatura fatura, double valorPago, String dataPagamento) {
        this.id = id;
        this.fatura = fatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double calcularValor() {
        return valorPago;
    }

    @Override
    public String toString() {
        String faturaId = fatura != null ? fatura.getId() : "N/A";
        return "Pagamento{" + "ID='" + id + '\'' + ", FaturaID='" + faturaId + '\'' + ", ValorPago=" + valorPago + ", DataPagamento='" + dataPagamento + '\'' + '}';
    }
}
