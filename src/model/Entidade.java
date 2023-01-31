package model;

import java.time.LocalDate;

public abstract class Entidade {
  protected String id;

  public Entidade(String id) {
    this.id = id;
  }

  public String getID(){
    return id;
  }
}
