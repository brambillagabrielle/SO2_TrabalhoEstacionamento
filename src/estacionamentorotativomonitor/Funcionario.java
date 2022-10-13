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
    
    public boolean estacionaCarro(Estacionamento estacionamento, Carro carro) {
        
        for (Vaga v : estacionamento.getVagas()) {

            if (v.getCarro() == null) {

                v.setCarro(carro);
                
                System.out.println("\nEstacionou o carro: " + carro.getIdCarro()
                        + " na vaga " + v.getNumero());
                
                estacionamento.mostraVagas();

                return true;

            } 

        }

        System.out.println("\nEstacionamento cheio! Carro " + carro.getIdCarro() + " foi embora");
        
        return false;
        
    }
    
    public boolean retiraCarro(Estacionamento estacionamento, Carro carro) {
        
        for (Vaga v : estacionamento.getVagas()) {

            if (v.getCarro() != null && v.getCarro().getIdCarro().equals(carro.getIdCarro())) {

                System.out.println("\nRetirou o carro: " + carro.getIdCarro()
                        + " da vaga " + v.getNumero());
                
                v.setCarro(null);
                        
                estacionamento.mostraVagas();
                                   
                return true;

            }
            
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
