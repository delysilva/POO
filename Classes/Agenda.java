package Classes;
import java.util.ArrayList;
import java.util.Calendar;


//agenda que irá gerenciar a disponibilidade do imóvel
/*
*  A IDEIA AQUI É RELATIVAMENTE SIMPLES:
*     1 - CRIAMOS UM ARRAY LIST PARA AS DATAS EM QUE O IMÓVEL ESTÁ ALUGADO
*     2 - OUTRO ARRAY LIST PARA AS DATAS EM QUE O IMÓVEL ESTÁ BLOQUEADO
*     3 - E CONSIDERAMOS TODAS AS DATAS NÃO BLOQUEADAS/ALUGADAS COMO DISPONÍVEIS PARA ALUGAR
*     4 - PARA CONSULTAR AS DATAS DISPONÍVEIS, BASTA CHECAR SE A DATA NÃO ESTÁ EM NENHUM DOS DOIS ARRAY LISTS
*
*    (TALVEZ HAJA UMA IMPLEMENTAÇÃO MELHOR, MAS COMO NÃO ESTOU TÃO FAMILIARIZADO COM A CLASSE CALENDAR, ACHEI MELHOR FAZER ASSIM)
 */
public class Agenda {
    private ArrayList<Calendar> datasAlugadas;
    private ArrayList<Calendar> datasBloqueadas;
    boolean bloquearAgenda;

    public Agenda() {
        this.datasAlugadas = new ArrayList<Calendar>();
        this.datasBloqueadas = new ArrayList<Calendar>();
        this.bloquearAgenda = false;
    }

    public void bloquearData(Calendar data){
        if(!this.datasBloqueadas.contains(data) && !this.bloquearAgenda) {
            this.datasBloqueadas.add(data);
            if(this.datasAlugadas.contains(data)){
                this.datasAlugadas.remove(data);
            }
        }
    }

    public void alugarData(Calendar data){
        if(!this.datasBloqueadas.contains(data) && !this.datasAlugadas.contains(data) && !this.bloquearAgenda){
            this.datasAlugadas.add(data);
        }
    }
    public void desbloquearData(Calendar data){
        if(this.datasBloqueadas.contains(data)){
            this.datasBloqueadas.remove(data);
        }
    }
    // para enventuais cancelamentos
    public void desalugarData(Calendar data){
        if(this.datasAlugadas.contains(data)){
            this.datasAlugadas.remove(data);
        }
    }
    // para consultar se uma data está disponível
    public boolean isDisponivel(Calendar data) {
        if (this.datasBloqueadas.contains(data) || this.datasAlugadas.contains(data)) {
            return false;
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
