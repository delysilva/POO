package Classes;

import java.time.LocalDate;

public class Periodo {
    private LocalDate inicio;
    private LocalDate fim;

    public Periodo(int anoInicio, int mesInicio, int diaInicio, int anoFim, int mesFim, int diaFim){
        this.inicio = LocalDate.of(anoInicio, mesInicio, diaInicio);
        this.fim = LocalDate.of(anoFim, mesFim, diaFim);
    }

    // essa sobrecarga permite que o usuário passe apenas a data de início e a quantidade de dias que deseja alugar o imóvel
    public Periodo(int anoInicio, int mesInicio, int diaInicio, int dias){
        this.inicio = LocalDate.of(anoInicio, mesInicio, diaInicio);
        this.fim = this.inicio.plusDays(dias);
    }

    public LocalDate getInicio(){
        return this.inicio;
    }

    public LocalDate getFim(){
        return this.fim;
    }
}
