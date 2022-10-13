package estacionamentorotativomonitor;

public class Funcionario {
    
    private String nome;
    private boolean trabalhando;
    private double salario;
    
    public Funcionario(String nome) {
        this.nome = nome;
        this.trabalhando = false;
        this.salario = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isTrabalhando() {
        return trabalhando;
    }

    public void setTrabalhando(boolean trabalhando) {
        this.trabalhando = trabalhando;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
 
}
