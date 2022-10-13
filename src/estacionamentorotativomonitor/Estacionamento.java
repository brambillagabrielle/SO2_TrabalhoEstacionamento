package estacionamentorotativomonitor;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    
    private List<Vaga> vagas;
    private int capacidade;
    private Funcionario funcionario;
    
    public Estacionamento(int capacidade, Funcionario funcionario) {
        this.capacidade = capacidade;
        this.funcionario = funcionario;
        iniciaVagas();
    }
    
    private void iniciaVagas() {
        
        this.vagas = new ArrayList<>(this.capacidade);
        
        for (int v = 1; v <= this.capacidade; v++)
            this.vagas.add(new Vaga(Integer.toString(v)));
        
    }
    
    public void mostraVagas() {
        
        System.out.println("Vagas:");

        for (Vaga v : this.vagas)
            System.out.print(v.getNumero() + "\t");

        System.out.println();

        for (Vaga v : this.vagas) {
            if (v.getCarro() != null)
                System.out.print("[" + v.getCarro().getIdCarro() + "]\t");
            else
                System.out.print("[ ]\t");
        }
            
        System.out.println();
        
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
