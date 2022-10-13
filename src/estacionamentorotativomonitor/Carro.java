package estacionamentorotativomonitor;

/**
 * Classe para objetos do tipo Carro. Possui um atributo identificador, um
 * objeto de Estacionamento, método run para executar ações do carro e métodos
 * para gerenciar atributos
 * @author Estéfani Ferlin e Gabrielle Brambilla
 */
public class Carro extends Thread {
    
    private String idCarro;
    private Estacionamento estacionamento;
    
    /**
     * Método Construtor da classe Carro que atribui valores para idCarro e
     * Estacionamento
     * @param idCarro String - identificador do Carro
     * @param estacionamento Estacionamento - associação com o objeto de
     * Estacionamento
     */
    public Carro(String idCarro, Estacionamento estacionamento) {
        this.idCarro = idCarro;
        this.estacionamento = estacionamento;
    }
    
    /**
     * Método herdado de Thread que chama os métodos de estacionar e retirar
     * carro de Estacionamento. Caso o Carro não tenha sido estacionado
     * (sem vagas livres) não irá tentar executar a retirada
     */
    @Override
    public void run() {
        
        System.out.println("Novo Carro " + this.idCarro);
        
        try {
            
            sleep((int) (Math.random() * 10) * 1000);
            if (this.estacionamento.getFuncionario().estacionaCarro(this.estacionamento, this)) {
                sleep((int) (Math.random() * 10) * 1000);
                this.estacionamento.getFuncionario().retiraCarro(this.estacionamento, this);
            }
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    
    /**
     * Método para retornar idCarro
     * @return idCarro String
     */
    public String getIdCarro() {
        return idCarro;
    }

    /**
     * Método para atribuir valor para idCarro
     * @param idCarro String
     */
    public void setIdCarro(String idCarro) {
        this.idCarro = idCarro;
    }
    
    /**
     * Método para retornar estacionamento
     * @return estacionamento Estacionamento
     */
    public Estacionamento getEstacionamento() {
        return estacionamento;
    }
    
    /**
     * Método para atribuir estacionamento
     * @param estacionamento Estacionamento
     */
    public void setEstacionamento(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
    }

}
