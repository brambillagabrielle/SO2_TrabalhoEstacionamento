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
    
    public synchronized boolean estacionaCarro(Estacionamento estacionamento, Carro carro) {
        
        try {
                
            while(this.trabalhando)
                wait();
                
            this.trabalhando = true;
            
            for (Vaga v : estacionamento.getVagas()) {

                if (v.getCarro() == null) {

                    v.setCarro(carro);

                    System.out.println("\nEstacionou o carro: " + carro.getIdCarro()
                            + " na vaga " + v.getNumero());

                    estacionamento.mostraVagas();
                    
                    this.trabalhando = false;
                    notify();

                    return true;

                } 

            }

            System.out.println("\nEstacionamento cheio! Carro " + carro.getIdCarro() + " foi embora");
            
            this.trabalhando = false;
            notify();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        return false;
        
    }
    
    public synchronized boolean retiraCarro(Estacionamento estacionamento, Carro carro) {
        
        try {
            
            while(this.trabalhando)
                wait();

            this.trabalhando = true;
        
            for (Vaga v : estacionamento.getVagas()) {

                if (v.getCarro() != null && v.getCarro().getIdCarro().equals(carro.getIdCarro())) {

                    System.out.println("\nRetirou o carro: " + carro.getIdCarro()
                            + " da vaga " + v.getNumero());

                    v.setCarro(null);

                    estacionamento.mostraVagas();
                    
                    this.trabalhando = false;
                        notify();

                    return true;

                }

            }
            
            this.trabalhando = false;
            notify();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        return false;
        
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
