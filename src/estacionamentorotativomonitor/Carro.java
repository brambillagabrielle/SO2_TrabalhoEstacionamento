package estacionamentorotativomonitor;

public class Carro extends Thread {
    
    private String idCarro;
    private Estacionamento estacionamento;
    
    public Carro(String idCarro, Estacionamento estacionamento) {
        this.idCarro = idCarro;
        this.estacionamento = estacionamento;
    }
    
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

    public String getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(String idCarro) {
        this.idCarro = idCarro;
    }

    public Estacionamento getEstacionamento() {
        return estacionamento;
    }

    public void setEstacionamento(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
    }

}
