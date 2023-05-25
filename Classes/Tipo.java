package Classes;

public enum Tipo{
    Casa("Casa"),
    Apartamento("Apartamento"),
    Terreno("Terreno"),
    Quarto("Quarto"),
    Galpao("Galpão"),
    Chacara("Chácara"),
    Fazenda("Fazenda"),
    Sitio("Sítio"),
    Predio("Prédio"),
    Outro("Outro");

    private String nome;

    Tipo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
