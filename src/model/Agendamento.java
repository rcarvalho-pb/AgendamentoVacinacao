package model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;



public class Agendamento extends Entidade{
  Locale localBR = new Locale("pt", "BR");
  private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  private static final int meses = 3;

  private String nomePessoa;
  private List<LocalDate> datasVacinacao = new ArrayList<>();

  public Agendamento(LocalDate dataPrimeiraVacinacao, String id, String nomePessoa){
    super(id);
    this.nomePessoa = nomePessoa;
    for (int i = 0; i < meses; i++) {
      this.datasVacinacao.add(isWeekend(dataPrimeiraVacinacao.plusMonths(meses*i)));
    }
  }

  private LocalDate isWeekend(LocalDate data) {
    if (data.getDayOfWeek() == DayOfWeek.SATURDAY) return data.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
    if (data.getDayOfWeek() == DayOfWeek.SUNDAY) return data.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
    return data;
  }

  public String getNome(){
    return nomePessoa;
  }

  @Override
  public String toString() {
    return "ID: %s\nNome: %s\n1ª Vacinação: %s - %s\n2ª Vacinação: %s - %s\n3ª Vacinação: %s - %s\n".formatted(id, nomePessoa,
    datasVacinacao.get(0).getDayOfWeek().getDisplayName(TextStyle.FULL, localBR), datasVacinacao.get(0).format(df),
    datasVacinacao.get(1).getDayOfWeek().getDisplayName(TextStyle.FULL, localBR), datasVacinacao.get(1).format(df),
    datasVacinacao.get(2).getDayOfWeek().getDisplayName(TextStyle.FULL, localBR), datasVacinacao.get(2).format(df));
            
  }
}
