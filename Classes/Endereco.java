package Classes;

/* Classe responsável ṕor armazenar um endereço.
 A classe Classes.Endereco é uma classe de apoio, que não será instanciada diretamente, mas sim por meio de uma instância de Classes.Proprietario ou Classes.Imovel.
*/
public class Endereco {
    private String cep;
    private Estados estado;
    private String cidade;
    private String rua;
    private int numero;

    public Endereco(String cep, String estado, String cidade, String rua, int numero) {
        this.rua = rua;
        this.cidade = cidade;
        this.estado = Estados.valueOf(estado);
        this.cep = cep;
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado.getNome();
    }

    public String getCep() {
        return cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = Estados.valueOf(estado);
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    // Possibilidade de atualização de endereço, para uso da classe Proprietário.
    public void setEndereco(String cep, String estado, String cidade, String rua, int numero) {
        this.cep = cep;
        this.estado = Estados.valueOf(estado);
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
    }

/* TESTE
    public static void main(String[] args) {
        Classes.Endereco endereco = new Classes.Endereco("12345678", "BA", "Salvador", "Rua 1", 1);
        System.out.println(endereco.getEstado());
        endereco.setEstado("SP");
        System.out.println(endereco.getEstado());
    }

 */
}