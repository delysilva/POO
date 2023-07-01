package Classes;
import java.util.ArrayList;
import java.time.LocalDate;


/*
COMO USAR O LOCALDATE:

            YYYY-MM-DD

class Main {
    public static void main(String[] args) {

        LocalDate data = LocalDate.of(2020, 2, 20);

        System.out.println(data);
    }
 }
*/

//agenda que irá gerenciar a disponibilidade do imóvel
/*
*  A IDEIA AQUI É RELATIVAMENTE SIMPLES:
*     1 - CRIAMOS UM ARRAY LIST PARA AS DATAS EM QUE O IMÓVEL ESTÁ ALUGADO
*     2 - OUTRO ARRAY LIST PARA AS DATAS EM QUE O IMÓVEL ESTÁ BLOQUEADO
*     3 - E CONSIDERAMOS TODAS AS DATAS NÃO BLOQUEADAS/ALUGADAS COMO DISPONÍVEIS PARA ALUGAR
*     4 - PARA CONSULTAR AS DATAS DISPONÍVEIS, BASTA CHECAR SE A DATA NÃO ESTÁ EM NENHUM DOS DOIS ARRAY LISTS
*
*    (TALVEZ HAJA UMA IMPLEMENTAÇÃO MELHOR, MAS COMO NÃO ESTOU TÃO FAMILIARIZADO COM A CLASSE CALENDAR, ACHEI MELHOR FAZER ASSIM)
*
*
*   ############ ATUALIZAÇÃO ###################
*           AGORA ESTAMOS PASSANDO DUAS DATAS QUE CRIAM UM PERÍODO DE ESTADIA
*           PODEMOS PASSAR APENAS A DATA DE INÍCIO E QUANTOS DIAS QUEREMOS ALUGAR
*
*
* ##### IMPORTANTE ########
*
*  DATAS BLOQUEADAS SÃO DO TIPO LOCALDATE POIS FICA MAIS FÁCIL DE CONSULTAR? TALVEZ
 */
public class Agenda {
    private ArrayList<Periodo> datasAlugadas;
    private ArrayList<Periodo> datasBloqueadas;
    boolean bloquearAgenda;

    public Agenda() {
        this.datasAlugadas = new ArrayList<Periodo>();
        this.datasBloqueadas = new ArrayList<Periodo>();
        this.bloquearAgenda = false;
    }

    // você pode bloquear uma data/periodo
    public void bloquearData(int ano, int mes, int dia, int dias){
        LocalDate data = LocalDate.of(ano, mes, dia);
        for (Periodo periodo : this.datasAlugadas) {
            if((periodo.getInicio().isBefore(data) && periodo.getFim().isAfter(data)) || (periodo.getInicio().isAfter(data) && periodo.getFim().isBefore(data.plusDays(dias))) || (periodo.getFim().isAfter(data) && periodo.getFim().isBefore(data.plusDays(dias)))){
                this.datasAlugadas.remove(periodo);
                this.datasBloqueadas.add(periodo);
            }
        }
    }


    public void alugarData(int ano, int mes, int dia, int dias){
        // mesma verificação de antes para ver se o período de aluguel não está dentro de um período já alugado ou bloqueado
        if(isDisponivel(ano, mes, dia, dias)){
            this.datasAlugadas.add(new Periodo(ano, mes, dia, dias));
        }
    }

    public void alugarData(int ano, int mes, int dia, int ano1, int mes1, int dia1){
        // mesma verificação de antes para ver se o período de aluguel não está dentro de um período já alugado ou bloqueado
        if(isDisponivel(ano, mes, dia, ano1, mes1, dia1)){
            this.datasAlugadas.add(new Periodo(ano, mes, dia, ano1, mes1, dia1));
        }
    }
    // para enventuais cancelamentos, porém, precisa de melhoria para cancelar apenas a data, conservando o restante do período
    public void desalugarData(int ano, int mes, int dia){
        Periodo data = new Periodo(ano, mes, dia, 0);
        if(this.datasAlugadas.contains(data)){
            this.datasAlugadas.remove(data);
        }
    }
    // para consultar se um Período está disponível (funciona)
    public boolean isDisponivel(int ano, int mes, int dia, int dias){
        Periodo periodo = new Periodo(ano, mes, dia, dias);
        for (Periodo periodoAlugado : this.datasAlugadas) {
            if((periodo.getInicio().isAfter(periodoAlugado.getInicio()) && periodo.getInicio().isBefore(periodoAlugado.getFim())) || periodo.getFim().isAfter(periodoAlugado.getInicio()) && periodo.getFim().isBefore(periodoAlugado.getFim()) || (periodo.getInicio().isBefore(periodoAlugado.getInicio()) && periodo.getFim().isAfter(periodoAlugado.getFim()))){
                return false;
            }
        }
        for (Periodo periodoBloqueado : this.datasBloqueadas) {
            if((periodoBloqueado.getInicio().isBefore(periodo.getInicio()) && periodoBloqueado.getFim().isAfter(periodo.getFim())) || (periodoBloqueado.getFim().isBefore(periodo.getFim()) && periodoBloqueado.getFim().isAfter(periodo.getInicio())) || periodoBloqueado.getInicio().isBefore(periodo.getFim()) && periodoBloqueado.getInicio().isAfter(periodo.getInicio())){
                return false;
            }
        }
        return true;
    }

    public boolean isDisponivel(int ano, int mes, int dia, int ano1, int mes1, int dia1){
        Periodo periodo = new Periodo(ano, mes, dia, ano1, mes1, dia1);
        for (Periodo periodoAlugado : this.datasAlugadas) {
            if((periodo.getInicio().isAfter(periodoAlugado.getInicio()) && periodo.getInicio().isBefore(periodoAlugado.getFim())) || periodo.getFim().isAfter(periodoAlugado.getInicio()) && periodo.getFim().isBefore(periodoAlugado.getFim()) || (periodo.getInicio().isBefore(periodoAlugado.getInicio()) && periodo.getFim().isAfter(periodoAlugado.getFim()))){
                return false;
            }
        }
        for (Periodo periodoBloqueado : this.datasBloqueadas) {
            if((periodoBloqueado.getInicio().isBefore(periodo.getInicio()) && periodoBloqueado.getFim().isAfter(periodo.getFim())) || (periodoBloqueado.getFim().isBefore(periodo.getFim()) && periodoBloqueado.getFim().isAfter(periodo.getInicio())) || periodoBloqueado.getInicio().isBefore(periodo.getFim()) && periodoBloqueado.getInicio().isAfter(periodo.getInicio())){
                return false;
            }
        }
        return true;
    }


    // Esses últimos métodos são para "remover" o imóvel da disponibilidade de locação.


    private void limparAgenda(){
        this.datasAlugadas.clear();
        this.datasBloqueadas.clear();
    }
    // ao bloquear a agenda do imóvel, você não processa mais requisições futuras (isso pode ser mudado, caso atrapalhe a dinaâmica do programa)
    public void bloquearAgenda(){
        this.bloquearAgenda = true;
        this.limparAgenda();
    }

    public void desbloquearAgenda(){
        this.bloquearAgenda = false;
    }

    public boolean isAgendaBloqueada() {
        return this.bloquearAgenda;
    }
}
