package estacionamentorotativomonitor;

public class Vaga {
    
    private String numero;
    private Carro carro;
    
    public Vaga(String numero) {
        this.numero = numero;
        this.carro = null;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
    
}
