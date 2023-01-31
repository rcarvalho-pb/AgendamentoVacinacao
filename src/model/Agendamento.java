package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class Agendamento extends Entidade{
   static final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  private String nomePessoa;
  public Agendamento(LocalDate dataVacinacao, String id, String nomePessoa){
    super(dataVacinacao, id);
    this.nomePessoa = nomePessoa;
  }

  public String getNome(){
    return nomePessoa;
  }

  @Override
  public String toString() {
    return ""
            + "Data: " + dataVacinacao.format(df)
            + "\nNome: " + nomePessoa
            + "\nID: " + id;
  }
}
