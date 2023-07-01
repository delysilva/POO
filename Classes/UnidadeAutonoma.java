package Classes;

public class UnidadeAutonoma extends Imovel{
    // entenda como a unidade padrão de medida o metro quadrado
    private float areaUtil;
    private float areaConstruida;

    public UnidadeAutonoma(String cep, String estado,String cidade,String rua, int numero, String tipo, String utilidade, float iptu, float areaUtil, float areaConstruida) {
        super(cep, estado, cidade, rua, numero, tipo, utilidade, iptu);
        this.areaUtil = areaUtil;
        this.areaConstruida = areaConstruida;
    }

    public UnidadeAutonoma(String cep, String rua, int numero, String tipo, String utilidade, float iptu, float areaUtil, float areaConstruida){
        super(cep,rua, numero, tipo, utilidade, iptu);
        this.areaUtil = areaUtil;
        this.areaConstruida = areaConstruida;
    }

    public float getAreaUtil() {
        return areaUtil;
    }

    public float getAreaConstruida() {
        return areaConstruida;
    }

    public void setAreaUtil(float areaUtil) {
        this.areaUtil = areaUtil;
    }

    public void setAreaConstruida(float areaConstruida) {
        this.areaConstruida = areaConstruida;
    }

    @Override
    public String toString() {
        return super.toString() + "\nÁrea útil: " + this.areaUtil + "\nÁrea construída: " + this.areaConstruida;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof UnidadeAutonoma){
            UnidadeAutonoma unidadeAutonoma = (UnidadeAutonoma) obj;
            return super.equals(obj) && this.areaUtil == unidadeAutonoma.areaUtil && this.areaConstruida == unidadeAutonoma.areaConstruida;
        }
        return false;
    }

    public float getValorIptu(){
        return super.getIptu();
    }

    public void bloquearData(int ano, int mes, int dia, int dias){
        super.bloquearData(ano, mes, dia, dias);
    }

    public void bloquearAgenda(){
        super.bloquearAgenda();
    }

    public boolean isDisponivel(int ano, int mes, int dia, int ano1, int mes1, int dia1){
        return super.isDisponivel(ano, mes, dia, ano1, mes1, dia1);
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

    public void alugar(int ano, int mes, int dia, int ano1, int mes1, int dia1){
        super.alugar(ano, mes, dia, ano1, mes1, dia1);
    }

    // de acordo com os valores de aluguel estabelecidos pela atividade
    public float valorAluguel(){
        return this.getAreaUtil() * 15;
    }

}
