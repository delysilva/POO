package Classes;
/* Classe responsável por armazenar um proprietário. Que, por sua vez, possuirá imóveis. */
import java.util.ArrayList;
public class Proprietario {
    private String nome;

    //#############################################################################################################
    // como CPF, Identidade e CEP não serão parte de nenhuma operação matemática, considerei criá-los como variáveis do tipo String.
    // Além disso, todos podem começar com um "0" a esquerda, o que não seria possível para um tipo Int
    //#############################################################################################################


    private String cpf;
    private String identidade;
    private Endereco endereco;
    private ArrayList<Imovel> imoveis;


    public Proprietario(String nome, String cpf, String identidade, String cep, String estado, String cidade, String rua, int numero) {
        this.nome = nome;
        this.cpf = cpf;
        this.identidade = identidade;
        this.endereco = new Endereco(cep, estado, cidade, rua, numero);
        this.imoveis = new ArrayList<Imovel>();

    }


    /*
    Acredito que não exista a possibilidade de um objeto proprietário atualizar atributos como nome, cpf e identidade, uma vez que esses dados são fixos.
    E a atualização implica um novo proprietário, ou seja, ium novo objeto.
     */
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getIdentidade() {
        return identidade;
    }


    // Ainda não tenho certeza se seria melhor criar o objeto imóvel fora da chamada do addImovel, ou se é melhor criar o objeto dentro da chamada do addImovel.
    // De qualquer modo, tal implementação subentende que o imóvel não irá existir sem um proprietário(dentro do programa).
    public void addImovel(Imovel imovel) {
        this.imoveis.add(imovel);
    }

    //#############################################################################################################
    /*
    TALVEZ UMA ESTRUTURA DESSE TIPO TENHA UTILIDADE DEPOIS. FICA AQUI COMO REFERÊNCIA PARA O FUTURO.

    public void getEndereco() {
        System.out.println(this.endereco.getCep());
        System.out.println(this.endereco.getEstado());
        System.out.println(this.endereco.getCidade());
        System.out.println(this.endereco.getRua());
        System.out.println(this.endereco.getNumero());
    }
    //#############################################################################################################
*/

    // Possibilidade de atualização de endereço provavelmente será requisitada mais pra frente. Então, criei um método para isso.
    public void setEndereco(String cep, String estado, String cidade, String rua, int numero) {
        this.endereco.setEndereco(cep, estado, cidade, rua, numero);
    }
    /* Para que essa sobrecarga funcione, encontrar uma boa solução para o Enum.

    public void setEndereco(String cep, String rua, int numero) {
        this.endereco.setEndereco(cep, this.endereco.getEstado(), this.endereco.getCidade(), rua, numero);
    }
    */


    public Endereco getEndereco() {
        return endereco;
    }

    public void listaImoveis(String tipo) {
        int cnt = 1;
        System.out.println("\nImóveis do tipo " + tipo + " do proprietário " + this.nome + ":\n");
        System.out.println("--------------------------------------------------------------------------------------");
        for (Imovel imovel : imoveis) {
            if (imovel.getTipo().equals(tipo)) {
                System.out.println("Imóvel " + cnt++ + ":");
                System.out.println("Classes.Tipo: " + imovel.getTipo());
                System.out.println("CEP: " + imovel.getEndereco().getCep());
                System.out.println("Estado: " + imovel.getEndereco().getEstado());
                System.out.println("Cidade: " + imovel.getEndereco().getCidade());
                System.out.println("Rua: " + imovel.getEndereco().getRua());
                System.out.println("Número: " + imovel.getEndereco().getNumero());
                System.out.println("Utilidade: " + imovel.getUtilidade());
                System.out.println("IPTU: " + imovel.getIptu() + "\n");
                System.out.println("#################################################################################\n");
            }
        }
    }

    public ArrayList<Imovel> getImoveis() {
        return imoveis;
    }

/*
    public static void main(String[] args) {
        Classes.Proprietario proprietario = new Classes.Proprietario("João", "12345678901", "123456789", "12345678", "SP", "São Paulo", "Rua dos Bobos", 0);
        proprietario.addImovel(new Classes.Imovel("12345578", "SZ", "São Paulo", "Rua dos Bobos", 0, "Casa", "Estadia", 123.50F));
        proprietario.addImovel(new Classes.Imovel("12345578", "Rua dos Bobos", 0, "Casa", "Estadia", 123.50F));
        proprietario.addImovel(new Classes.Imovel("12345578", "SP", "São Paulo", "Rua dos Bobos", 0, "Apartamento", "Estadia", 123.50F));
        proprietario.listaImoveis("Casa");
    }
    */
}
