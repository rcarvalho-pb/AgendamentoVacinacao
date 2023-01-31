package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import controller.AgendamentoController;
import model.Agendamento;
import util.CapturadorDeEntrada;

public class MenuAgendar extends MenuAbstrato {

  private final AgendamentoController agendamentoController;
  static final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public MenuAgendar(AgendamentoController agendamentoController) {
    super("AGENDAR VACINA");
    this.agendamentoController = agendamentoController;
  }

  @Override
  protected void acao() {
    String dataString = CapturadorDeEntrada.capturarString("data de agendamento (dd/mm/aaaa)");
    while(LocalDate.parse(dataString, df).isBefore(LocalDate.now())){
      System.out.println("Data inválida. Tente novamente.");
      dataString = CapturadorDeEntrada.capturarString("data de agendamento (dd/mm/aaaa)");
    }
    String nomeString = CapturadorDeEntrada.capturarString("nome");
    
    Agendamento agendamento = agendamentoController.agendar(dataString, nomeString);
    System.out.println("Agendamento realizado com sucesso.\nAgendamento: ");
    System.out.println(agendamento);
  }
  
}
