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

    // isso aqui tá dando erro. breve eu arrumo.
    public void consultaImoveis(String estado, String cidade){
        int contador = 1;
        for(Proprietario proprietario : this.proprietarios){
            ArrayList<Imovel> imoveis = proprietario.getImoveis();
            for(Imovel imovel : imoveis){
                if(String.valueOf(imovel.getEndereco().getEstado()).equals(estado) && imovel.getEndereco().getCidade().equals(cidade)){
                    System.out.println("Imóvel " + contador + ":");
                    System.out.println("Proprietário: " + proprietario.getNome());
                    System.out.println("Endereço: " + imovel.getEndereco().getRua() + ", " + imovel.getEndereco().getNumero());
                    System.out.println("Tipo: " + imovel.getTipo());
                    System.out.println("Utilidade: " + imovel.getUtilidade());
                    System.out.println("------------------------------------------------------------------");
                    contador++;
                }
            }
        }

    }

    public Imovel getImovel(String estado, String cidade, int index){
        for(Proprietario proprietario : this.proprietarios){
            ArrayList<Imovel> imoveis = proprietario.getImoveis();
            for(Imovel imovel : imoveis){
                if(String.valueOf(imovel.getEndereco().getEstado()).equals(estado) && imovel.getEndereco().getCidade().equals(cidade)){
                    if((index-1) == 0){
                        return imovel;
                    }
                    index--;
                }
            }
        }
        return null;
    }
}
