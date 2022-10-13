package estacionamentorotativomonitor;

/**
 * Classe para objetos do tipo Vaga que possui atributos número e carro que
 * está estacionado nela
 * @author Estéfani Ferlin e Gabrielle Brambilla
 */
public class Vaga {
    
    private String numero;
    private Carro carro;
    
    /**
     * Método Construtor da classe Vaga que atribui valor para número e inicializa
     * carro como null (vaga vazia)
     * @param numero String - número de identificação da vaga
     */
    public Vaga(String numero) {
        this.numero = numero;
        this.carro = null;
    }
    
    /**
     * Método para retornar número
     * @return numero String
     */
    public String getNumero() {
        return numero;
    }
    
    /**
     * Método para atribuir valor para número
     * @param numero String
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    /**
     * Método para retornar carro
     * @return carro Carro
     */
    public Carro getCarro() {
        return carro;
    }

    /**
     * Método para atribuir um carro
     * @param carro Carro
     */
    public void setCarro(Carro carro) {
        this.carro = carro;
    }
    
}
