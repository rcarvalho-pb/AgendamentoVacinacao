package view;

import java.util.List;

import controller.AgendamentoController;
import model.Agendamento;

public class MenuListarAgendamento extends MenuAbstrato {

  private final AgendamentoController agendamentoController;

  public MenuListarAgendamento(AgendamentoController agendamentoController) {
    super("LISTAR AGENDAMENTOS");
    this.agendamentoController = agendamentoController;

  }

  @Override
  protected void acao() {
    List<Agendamento> agendamentos = agendamentoController.listarTodosOsAgendamentos();
    if (agendamentos.size() < 1) {
      System.out.println("Não há agendamentos. \n");
      return;
    }
    System.out.println("Agendamentos: \n");
    agendamentos.forEach(System.out::println);    
  }
  
}