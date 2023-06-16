package Classes;

public class UnidadeCompartilhada extends Imovel{
    private String identificacao;
    private Condominio condominio;

    public UnidadeCompartilhada(String nome, String cep, String estado,String cidade,String rua, int numero, String tipo, String utilidade, float iptu, String identificacao) {
        super(cep, estado, cidade, rua, numero, tipo, utilidade, iptu);
        this.identificacao = identificacao;
        this.condominio = new Condominio(nome, cep, estado, cidade, rua, numero);
    }

    @Override
    public String toString() {
        return super.toString() + "\nIdentificação: " + this.identificacao + "\nCondomínio: " + this.condominio;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof UnidadeCompartilhada){
            UnidadeCompartilhada unidadeCompartilhada = (UnidadeCompartilhada) obj;
            return super.equals(obj) && this.identificacao.equals(unidadeCompartilhada.identificacao) && this.condominio.equals(unidadeCompartilhada.condominio);
        }
        return false;
    }

    public String itensDeLazer(){
        return this.condominio.itensDeLazerToString();
    }

    public int getQuantidadeDeItensDeLazer(){
        return this.condominio.getQuantidadeDeItensDeLazer();
    }

    public float getValorIptu(){
        return super.getIptu();
    }

    public void bloquearData(int ano, int mes, int dia){
        super.bloquearData(ano, mes, dia);
    }

    public void bloquearAgenda(){
        super.bloquearAgenda();
    }

    public boolean isDisponivel(int ano, int mes, int dia){
        return super.isDisponivel(ano, mes, dia);
    }

    public boolean getDisponibilidade(){
        return super.getDisponibilidade();
    }

    public String getTipo() {
        return super.getTipo();
    }

    public String getUtilidade() {
        return super.getUtilidade();
    }

    public Endereco getEndereco() {
        return super.getEndereco();
    }

    public void setIptu(float iptu) {
        super.setIptu(iptu);
    }

    public void alugar(int ano, int mes, int dia){
        super.bloquearData(ano, mes, dia);
    }

    public float valorAluguel(){
        if(this.getQuantidadeDeItensDeLazer() > 0) {
            return super.getIptu() * this.getQuantidadeDeItensDeLazer();
        }
        return super.getIptu() * 0.9f;
    }

    public void addItensDeLazer(String item){
        this.condominio.adicionarItemDeLazer(item);
    }
}