package Classes;

import java.util.ArrayList;

// essa classe vai armazenar todos os proprietários cadastrados no sistema. facilitando a busca por proprietários e consequentemente por imóveis.
public class BancoDeProprietarios {
    private ArrayList<Proprietario> proprietarios;

    public BancoDeProprietarios(){
        this.proprietarios = new ArrayList<Proprietario>();
    }

    public void addProprietario(Proprietario proprietario){
        this.proprietarios.add(proprietario);
    }

    public Proprietario getProprietario(String cpf){
        for(Proprietario proprietario : this.proprietarios){
            if(proprietario.getCpf().equals(cpf)){
                return proprietario;
            }
        }
        return null;
    }

    public void consultaImoveis(String estado, String cidade){
        for(Proprietario proprietario : this.proprietarios){
            ArrayList<Imovel> imoveis = proprietario.getImoveis();
            for(Imovel imovel : imoveis){
                if(imovel.getEndereco().getEstado().equals(estado) && imovel.getEndereco().getCidade().equals(cidade)){
                    System.out.println("Proprietário: " + proprietario.getNome());
                    System.out.println("Endereço: " + imovel.getEndereco().getRua() + ", " + imovel.getEndereco().getNumero());
                    System.out.println("Tipo: " + imovel.getTipo());
                    System.out.println("Utilidade: " + imovel.getUtilidade());
                    System.out.println("------------------------------------------------------------------");
                }
            }
        }

    }
}
