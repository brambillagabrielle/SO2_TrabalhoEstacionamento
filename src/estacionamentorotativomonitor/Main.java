package estacionamentorotativomonitor;

public class Main {

    public static void main(String[] args) {
        
        Funcionario funcionario = new Funcionario("João");
        Estacionamento estacionamento = new Estacionamento(12, funcionario);
        Carro carro = new Carro("1", estacionamento);
        
    }
    
}
