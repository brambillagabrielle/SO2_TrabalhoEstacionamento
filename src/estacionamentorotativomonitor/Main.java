package estacionamentorotativomonitor;

/**
 * Classe principal que cria as threads de carros, iniciando o processo de 
 * estacionar e retirar carros do estacionamento
 * @author Estéfani Ferlin e Gabrielle Brambilla
 */
public class Main {
    
    /**
     * Método instancia objetos de Funcionario e Estacionamento e uma quantidade
     * de objetos do tipo Carro e iniciando a execução das threads
     * @param args
     */
    public static void main(String[] args) {
        
        Funcionario funcionario = new Funcionario("João");
        Estacionamento estacionamento = new Estacionamento(12, funcionario);
        
        for(int i = 1; i <= 30; i++) {

            Carro carro = new Carro(Integer.toString(i), estacionamento);
            carro.start();

        }
        
    }
    
}
