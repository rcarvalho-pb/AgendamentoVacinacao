package view;

import java.util.List;

import controller.AgendamentoController;
import model.Agendamento;
import util.CapturadorDeEntrada;

public class MenuBuscarAgendamentoPeloID extends MenuAbstrato{

  private final AgendamentoController agendamentoController;

  public MenuBuscarAgendamentoPeloID(AgendamentoController agendamentoController) {
    super("BUSCAR AGENDAMENTO PELO ID");
    this.agendamentoController = agendamentoController;
  }

  @Override
  protected void acao() {
  
    List<Agendamento> agendamentos = agendamentoController.listarTodosOsAgendamentos();
    String id = CapturadorDeEntrada.capturarString("id");
    if (agendamentos.size() < 1) {
      System.out.println("Não há agendamentos. ");
      return;
    }

    if (agendamentoController.buscarAgendamentoPeloID(id) == null){
      System.out.println("Agendamento não encontrado. ");
      return;
    }
    System.out.println(agendamentoController.buscarAgendamentoPeloID(id));
    
  }
  
}
