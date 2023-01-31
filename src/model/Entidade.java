package model;

import java.time.LocalDate;

public abstract class Entidade {
  protected String id;
  protected LocalDate dataVacinacao;

  public Entidade(LocalDate dataVacinacao, String id) {
    this.dataVacinacao = dataVacinacao;
    this.id = id;
  }

  public String getID(){
    return id;
  }
}
