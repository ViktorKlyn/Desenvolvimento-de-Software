import java.util.ArrayList;
import java.util.List;

abstract class FuncionarioHospital {

    private String nome;
    private double salarioBase;

    public FuncionarioHospital(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public abstract double calcularSalario();

    @Override
    public String toString() {
        return "Nome: " + nome + " | Salário: R$ " + String.format("%.2f", calcularSalario());
    }
}

class Medico extends FuncionarioHospital {

    private double adicionalPlantao;

    public Medico(String nome, double salarioBase, double adicionalPlantao) {
        super(nome, salarioBase);
        this.adicionalPlantao = adicionalPlantao;
    }

    public double getAdicionalPlantao() {
        return adicionalPlantao;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + adicionalPlantao;
    }
}

class Enfermeiro extends FuncionarioHospital {

    private double adicionalNoturno;

    public Enfermeiro(String nome, double salarioBase, double adicionalNoturno) {
        super(nome, salarioBase);
        this.adicionalNoturno = adicionalNoturno;
    }

    public double getAdicionalNoturno() {
        return adicionalNoturno;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + adicionalNoturno;
    }
}

class Recepcionista extends FuncionarioHospital {

    public Recepcionista(String nome, double salarioFixo) {
        super(nome, salarioFixo);
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase();
    }
}

public class Exe2 {

    public static void main(String[] args) {
        List<FuncionarioHospital> funcionarios = new ArrayList<>();

        funcionarios.add(new Medico("Dr. Silva", 5000, 1500));
        funcionarios.add(new Enfermeiro("Maria", 3000, 800));
        funcionarios.add(new Recepcionista("João", 2000));
        funcionarios.add(new Medico("Dra. Ana", 5500, 1200));
        funcionarios.add(new Enfermeiro("Pedro", 3200, 900));

        System.out.println("=== FUNCIONÁRIOS DO HOSPITAL ===\n");
        for (FuncionarioHospital f : funcionarios) {
            System.out.println(f);
        }

        FuncionarioHospital maiorSalario = funcionarios.get(0);
        for (FuncionarioHospital f : funcionarios) {
            if (f.calcularSalario() > maiorSalario.calcularSalario()) {
                maiorSalario = f;
            }
        }

        System.out.println("\n=== FUNCIONÁRIO COM MAIOR SALÁRIO ===");
        System.out.println(maiorSalario);
    }
}
