package view;

public class MenuAgendamento extends MenuComSubmenus{

  public MenuAgendamento() {
    super("AGENDAMENTOS: ");
  }

  @Override
  public void acao(){
    super.acao();
    this.agir();
  }
  
}
