package Classes;

// essa interface garante que todos os proprietários cadastrados no sistema possuem os métodos de consultaImoveis
public interface IProprietario {

    // adiciona um imóvel ao proprietário
    void addImovel(Imovel imovel);

    // lista os imóveis de modo geral
    void listaImoveis();

    // lista os imóveis por tipo
    void listaImoveis(String tipo);
}
