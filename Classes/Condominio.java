package Classes;

import java.util.ArrayList;
import java.util.SplittableRandom;

public class Condominio {
    private Endereco endereco;
    private String nome;
    private ArrayList<String> itensDeLazer;

    // logicamente o endereço será o mesmo endereço do imóvel
    public Condominio(String nome, String cep, String estado, String cidade, String rua, int numero){
        this.endereco = new Endereco(cep, estado, cidade, rua, numero);
        this.nome = nome;
        this.itensDeLazer = new ArrayList<String>();
    }

    public int getQuantidadeDeItensDeLazer(){
        return this.itensDeLazer.size();
    }

    public void adicionarItemDeLazer(String item){
        this.itensDeLazer.add(item);
    }

    public void removerItemDeLazer(String item){
        this.itensDeLazer.remove(item);
    }

    public String getNome(){
        return this.nome;
    }

    public String toString(){
        return "Nome: " + this.nome + "\nItens de lazer: " + this.itensDeLazerToString();
    }

    public String itensDeLazerToString(){
        String itens = "";
        for(String item : this.itensDeLazer){
            itens += item + ", ";
        }
        return itens;
    }
}