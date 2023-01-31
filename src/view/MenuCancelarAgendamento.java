package view;

import java.util.List;

import controller.AgendamentoController;
import model.Agendamento;
import util.CapturadorDeEntrada;
import util.Constantes;

public class MenuCancelarAgendamento extends MenuAbstrato{

  private final AgendamentoController agendamentoController;

  public MenuCancelarAgendamento(AgendamentoController agendamentoController) {
    super("CANCELAR AGENDAMENTO");
    this.agendamentoController = agendamentoController;
  }

  @Override
  protected void acao() {
    String nome = CapturadorDeEntrada.capturarString("nome");
    List<Agendamento> agendamentos = agendamentoController.buscarPeloNome(nome);
    Agendamento agendamento = selecionarAgendamento(agendamentos);
    System.out.println(agendamento);
    if (!agendamentoController.cancelarAgendamento(agendamento)) {
      System.out.println("Cancelamento não realizado. Tente novamente mais tarde.");
      return;
    }
    System.out.println("Cancelamento realizado com sucesso. ");
  }

  private Agendamento selecionarAgendamento(List<Agendamento> agendamentos) {
    for (int i = Constantes.index; i < agendamentos.size() + Constantes.index; i++) {
      System.out.println("%s - %s".formatted(i, agendamentos.get(i)));
    }

    String opcao = CapturadorDeEntrada.capturarString("Opção");
    while(agendamentos.get(Integer.parseInt(opcao)) == null){
      System.out.println("Opcao inválida, tente novamente. ");
    }
    return agendamentos.get(Integer.parseInt(opcao));

  }
  
}
