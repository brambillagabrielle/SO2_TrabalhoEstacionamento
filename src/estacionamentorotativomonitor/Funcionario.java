package estacionamentorotativomonitor;

import java.text.NumberFormat;

/**
 * Classe para objetos do tipo Funcionário. Possui atributos nome e salário do
 * Funcionário e uma variável flag para registrar quando está ou não trabalhando
 * @author Estéfani Ferlin e Gabrielle Brambilla
 */
public class Funcionario {
    
    private String nome;
    private boolean trabalhando;
    private double salario;
    
    /**
     * Método Construtor da classe Funcionário que atribui um valor passado
     * como parâmetro para nome e inicializa os atributos trabalhando e salário
     * @param nome String - nome do funcionário
     */
    public Funcionario(String nome) {
        this.nome = nome;
        this.trabalhando = false;
        this.salario = 0;
    }
    
    /**
     * Método que estaciona um Carro em uma Vaga. Para isso, verifica todas as
     * vagas da lista de estacionamento e quando encontra a primeira vaga
     * disponível, a preenche com um carro. Caso todas as vagas estejam ocupadas
     * vai embora. Implementa monitores para quando o funcionário está ocupado
     * com outro Carro, os demais que querem ser atendidos entram em espera
     * @param estacionamento Estacionamento - contém a lista de vagas
     * @param carro Carro - carro para ser estacionado na vaga
     * @return boolean - true caso consiga estacionar e false caso não
     */
    public synchronized boolean estacionaCarro(Estacionamento estacionamento, Carro carro) {
        
        try {
                
            while(this.trabalhando)
                wait();
                
            this.trabalhando = true;
            
            double tempoInicial = System.currentTimeMillis();
            
            for (Vaga v : estacionamento.getVagas()) {

                if (v.getCarro() == null) {

                    v.setCarro(carro);

                    System.out.println("\nEstacionou o carro: " + carro.getIdCarro()
                            + " na vaga " + v.getNumero());

                    estacionamento.mostraVagas();
                    
                    calculaSalario(tempoInicial, System.currentTimeMillis());
                    
                    this.trabalhando = false;
                    notify();

                    return true;

                } 

            }

            System.out.println("\nEstacionamento cheio! Carro " + carro.getIdCarro() + " foi embora");
            
            calculaSalario(tempoInicial, System.currentTimeMillis());
            
            this.trabalhando = false;
            notify();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        return false;
        
    }
    
    /**
     * Método que retira um Carro de uma Vaga. Para isso, verifica todas as
     * vagas da lista de estacionamento procurando pela vaga ocupada pelo carro
     * que deseja sair. Quando encontra o carro com o mesmo idCarro, a vaga
     * é desocupada. Implementa monitores para quando o funcionário está ocupado
     * com outro Carro, os demais que querem ser atendidos entram em espera
     * @param estacionamento Estacionamento - contém a lista de vagas
     * @param carro Carro - carro para ser estacionado na vaga
     * @return boolean - true caso consiga retirar e false caso não
     */
    public synchronized boolean retiraCarro(Estacionamento estacionamento, Carro carro) {
        
        try {
            
            while(this.trabalhando)
                wait();

            this.trabalhando = true;
            
            double tempoInicial = System.currentTimeMillis();
        
            for (Vaga v : estacionamento.getVagas()) {

                if (v.getCarro() != null && v.getCarro().getIdCarro().equals(carro.getIdCarro())) {

                    System.out.println("\nRetirou o carro: " + carro.getIdCarro()
                            + " da vaga " + v.getNumero());

                    v.setCarro(null);

                    estacionamento.mostraVagas();
                    
                    calculaSalario(tempoInicial, System.currentTimeMillis());
                    
                    this.trabalhando = false;
                        notify();

                    return true;

                }

            }
            
            calculaSalario(tempoInicial, System.currentTimeMillis());
            
            this.trabalhando = false;
            notify();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        return false;
        
    }
    
    /**
     * Método que calcula o salário atual do Funcionário enquanto está trabalhando,
     * somando o tempo gasto para realizar as operações de estacionar e retirar
     * @param tempoInicial double - tempo em que o funcionário começou a trabalhar
     * @param tempoFinal double - tempo em que o funcionário terminou a trabalhar
     */
    private void calculaSalario(double tempoInicial, double tempoFinal) {
        
        NumberFormat dinheiro = NumberFormat.getCurrencyInstance();
        
        this.salario += (tempoFinal - tempoInicial) / 10;
        
        System.out.println("Salário atual do " + this.nome + ": " + dinheiro.format(this.salario));
        
    }
    
    /**
     * Método para retornar nome do funcionário
     * @return nome String
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Método para atribuir um nome ao funcionário
     * @param nome String
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Método para retornar se está trabalhando
     * @return trabalhando boolean
     */
    public boolean isTrabalhando() {
        return trabalhando;
    }
    
    /**
     * Método para atribuir valor ao trabalhando
     * @param trabalhando boolean
     */
    public void setTrabalhando(boolean trabalhando) {
        this.trabalhando = trabalhando;
    }
    
    /**
     * Método para retornar salario
     * @return salario double
     */
    public double getSalario() {
        return salario;
    }
    
    /**
     * Método para atribuir salario
     * @param salario double
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }
 
}
