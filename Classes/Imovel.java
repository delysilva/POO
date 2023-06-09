package Classes;

import Classes.*;

import java.time.LocalDate;

public abstract class Imovel {
    private Endereco endereco;
    private Tipo tipo;
    private String utilidade;
    private float iptu;
    private Agenda agenda;

    // estabeleci uma ordem lógica de passagem de atributos na chamada do construtor, reduzindo o nível do escopo de precisção do endereço (partindo de CEP, para Estado, Cidade, Rua e Número).
    public  Imovel(String cep, String estado,String cidade,String rua, int numero, String tipo, String utilidade, float iptu) {
        this.iptu = iptu;
        this.endereco = new Endereco(cep, estado, cidade, rua, numero);
        this.tipo = Tipo.valueOf(tipo);
        this.utilidade = utilidade;
        this.agenda = new Agenda();
    }
    public Imovel(String cep, String rua, int numero, String tipo, String utilidade, float iptu){
        this(cep, "BA", "Salvador", rua, numero, tipo, utilidade, iptu);
    }

    public float getIptu() {
        return iptu;
    }

    public String getTipo() {
        return tipo.getNome();
    }

    public String getUtilidade() {
        return utilidade;
    }
    public Endereco getEndereco() {
        return endereco;
    }

    public void setIptu(float iptu) {
        this.iptu = iptu;
    }

    public boolean getDisponibilidade(){
        return this.agenda.isAgendaBloqueada();
    }

    public void bloquearData(int ano, int mes, int dia, int dias){
        this.agenda.bloquearData(ano, mes, dia, dias);
    }

    public void bloquearAgenda(){
        this.agenda.bloquearAgenda();
    }

    public boolean isDisponivel(int ano, int mes, int dia, int ano1, int mes1, int dia1){
        return this.agenda.isDisponivel(ano, mes, dia, ano1, mes1, dia1);
    }

    public void alugar(int ano, int mes, int dia, int ano1, int mes1, int dia1){
        this.agenda.alugarData(ano, mes, dia, ano1, mes1, dia1);
    }
    public String toString() {
        return "Imovel:\n" + endereco.toString() + "\nTipo: " + this.tipo.getNome() + "\nUtilidade: " + this.utilidade + "\nIPTU: " + this.iptu;
    }

    // aluguel

    public abstract float valorAluguel();
}
