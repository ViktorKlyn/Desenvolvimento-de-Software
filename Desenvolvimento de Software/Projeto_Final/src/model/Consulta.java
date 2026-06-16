package model;

/**
 * Representa uma consulta realizada entre um paciente e um médico.
 * Implementa polimorfismo através do método calcularValor.
 */
public class Consulta {
    private String id;
    private String data;
    private double valor;
    private Paciente paciente;
    private Medico medico;

    public Consulta() {
    }

    public Consulta(String id, String data, double valor, Paciente paciente, Medico medico) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.paciente = paciente;
        this.medico = medico;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public double calcularValor() {
        return valor;
    }

    @Override
    public String toString() {
        String pacienteInfo = paciente != null ? paciente.getNome() : "N/A";
        String medicoInfo = medico != null ? medico.getNome() : "N/A";
        return "Consulta{" + "ID='" + id + '\'' + ", Data='" + data + '\'' + ", Valor=" + valor + ", Paciente='" + pacienteInfo + '\'' + ", Medico='" + medicoInfo + '\'' + '}';
    }
}
