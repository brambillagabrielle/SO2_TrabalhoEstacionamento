package estacionamentorotativomonitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe para objetos do tipo Estacionamento. Possui uma lista com objetos do
 * tipo Vaga, um atributo para definir capacidade (quantidade de vagas da lista)
 * e um Funcionário
 * @author Estéfani Ferlin e Gabrielle Brambilla
 */
public class Estacionamento {
    
    private List<Vaga> vagas;
    private int capacidade;
    private Funcionario funcionario;
    
    /**
     * Método Construtor da classe Estacionamento que atribui valores para capacidade,
     * Funcionário e chama método para inicializar as vagas
     * @param capacidade int - valor máximo de vagas
     * @param funcionario Funcionario - associação com o objeto de Funcionário
     */
    public Estacionamento(int capacidade, Funcionario funcionario) {
        this.capacidade = capacidade;
        this.funcionario = funcionario;
        iniciaVagas();
    }
    
    /**
     * Método para inicializar a lista de vagas com a capacidade definida no
     * método Construtor. Um laço é usado para adicionar objetos de Vaga na
     * lista
     */
    private void iniciaVagas() {
        
        this.vagas = new ArrayList<>(this.capacidade);
        
        for (int v = 1; v <= this.capacidade; v++)
            this.vagas.add(new Vaga(Integer.toString(v)));
        
    }
    
    /**
     * Método para mostrar as vagas do Estacionamento. Mostra o número da vaga
     * e, quando preenchida, o identificador do Carro que está nela
     */
    public void mostraVagas() {
        
        System.out.println("Vagas:");

        for (Vaga v : this.vagas)
            System.out.print(v.getNumero() + "\t");

        System.out.println();

        for (Vaga v : this.vagas) {
            if (v.getCarro() != null)
                System.out.print("[" + v.getCarro().getIdCarro() + "]\t");
            else
                System.out.print("[ ]\t");
        }
            
        System.out.println();
        
    }
    
    /**
     * Método para retornar lista de vagas
     * @return vagas List
     */
    public List<Vaga> getVagas() {
        return vagas;
    }
    
    /**
     * Método para atribuir uma lista de vagas
     * @param vagas List
     */
    public void setVagas(List<Vaga> vagas) {
        this.vagas = vagas;
    }
    
    /**
     * Método para retornar capacidade
     * @return capacidade int
     */
    public int getCapacidade() {
        return capacidade;
    }
    
    /**
     * Método para atribuir valor para capacidade
     * @param capacidade int
     */
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    
    /**
     * Método para retornar funcionario
     * @return funcionario Funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    /**
     * Método para atribuir um funcionario
     * @param funcionario Funcionario
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
       
}
