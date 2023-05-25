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
 */
public class Agenda {
    private ArrayList<LocalDate> datasAlugadas;
    private ArrayList<LocalDate> datasBloqueadas;
    boolean bloquearAgenda;

    public Agenda() {
        this.datasAlugadas = new ArrayList<LocalDate>();
        this.datasBloqueadas = new ArrayList<LocalDate>();
        this.bloquearAgenda = false;
    }

    public void bloquearData(int ano, int mes, int dia){
        LocalDate data = LocalDate.of(ano, mes, dia);
        if(!this.datasBloqueadas.contains(data) && !this.bloquearAgenda) {
            this.datasBloqueadas.add(data);
            if(this.datasAlugadas.contains(data)){
                this.datasAlugadas.remove(data);
            }
        }
    }

    public void alugarData(int ano, int mes, int dia){
        LocalDate data = LocalDate.of(ano, mes, dia);
        if(!this.datasBloqueadas.contains(data) && !this.datasAlugadas.contains(data) && !this.bloquearAgenda){
            this.datasAlugadas.add(data);
        }
    }
    public void desbloquearData(int ano, int mes, int dia){
        LocalDate data = LocalDate.of(ano, mes, dia);
        if(this.datasBloqueadas.contains(data)){
            this.datasBloqueadas.remove(data);
        }
    }
    // para enventuais cancelamentos
    public void desalugarData(int ano, int mes, int dia){
        LocalDate data = LocalDate.of(ano, mes, dia);
        if(this.datasAlugadas.contains(data)){
            this.datasAlugadas.remove(data);
        }
    }
    // para consultar se uma data está disponível
    public boolean isDisponivel(int ano, int mes, int dia){
        LocalDate data = LocalDate.of(ano, mes, dia);
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
