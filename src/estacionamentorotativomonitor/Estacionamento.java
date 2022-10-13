package estacionamentorotativomonitor;

import java.util.List;

public class Estacionamento {
    
    private List<Vaga> vagas;
    private int capacidade;
    private Funcionario funcionario;
    
    public Estacionamento(int capacidade, Funcionario funcionario) {
        this.capacidade = capacidade;
        this.funcionario = funcionario;
    }

    public List<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(List<Vaga> vagas) {
        this.vagas = vagas;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
       
}
