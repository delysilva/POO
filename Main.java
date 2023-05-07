import Classes.*;
public class Main {
    public static void main(String[] args) {
        Imovel imovel = new Imovel("40000-000", "Rua da Bahia", 123, "CASA", "Residencial", 1000);
        System.out.println(imovel.getTipo());
        System.out.println(imovel.getUtilidade());
        System.out.println(imovel.getIptu());
        System.out.println(imovel.getEndereco().getRua());
        System.out.println(imovel.getEndereco().getCidade());
        System.out.println(imovel.getEndereco().getEstado());
        System.out.println(imovel.getEndereco().getCep());
        System.out.println(imovel.getEndereco().getNumero());
        Proprietario proprietario = new Proprietario("João", "123456789", "12345678900", "12345678900", "BA", "Salvador", "Rua da Bahia", 123);
        System.out.println(proprietario.getNome());
        System.out.println(proprietario.getCpf());
        System.out.println(proprietario.getIdentidade());
        System.out.println(proprietario.getEndereco().getEstado());
        System.out.println(proprietario.getEndereco().getCidade());
        System.out.println(proprietario.getEndereco().getRua());
        System.out.println(proprietario.getEndereco().getNumero());
        System.out.println(proprietario.getEndereco().getCep());
        System.out.println("\nVai mudar agora: \n");
        proprietario.setEndereco("41950-130","BA", "Salvador", "Rua da Cidade", 777);
        System.out.println(proprietario.getEndereco().getEstado());
        System.out.println(proprietario.getEndereco().getCidade());
        System.out.println(proprietario.getEndereco().getRua());
        System.out.println(proprietario.getEndereco().getNumero());
        System.out.println(proprietario.getEndereco().getCep());
        proprietario.addImovel(imovel);
        Imovel imovel2 = new Imovel("489756-520", "BA", "Salvador", "Rua dos Campos", 123, "CASA", "Residencial", 1000);
        proprietario.addImovel(imovel2);
        proprietario.listaImoveis("Casa");

    }
}
