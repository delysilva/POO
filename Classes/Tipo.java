package Classes;

public enum Tipo{
    CASA("Casa"),
    APARTAMENTO("Apartamento"),
    TERRENO("Terreno"),
    QUARTO("Quarto"),
    GALPAO("Galpão"),
    CHACARA("Chácara"),
    FAZENDA("Fazenda"),
    SITIO("Sítio"),
    PREDIO("Prédio"),
    OUTRO("Outro");

    private String nome;

    Tipo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
