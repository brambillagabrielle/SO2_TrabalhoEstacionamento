package estacionamentorotativomonitor;

public class Main {

    public static void main(String[] args) {
        
        Funcionario funcionario = new Funcionario("João");
        Estacionamento estacionamento = new Estacionamento(12, funcionario);
        
        for(int i = 1; i <= 30; i++) {

            Carro carro = new Carro(Integer.toString(i), estacionamento);
            carro.start();

        }
        
    }
    
}
