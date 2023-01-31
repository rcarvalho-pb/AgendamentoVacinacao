package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import model.Agendamento;
import persistence.AgendamentoRepository;
import util.CapturadorDeEntrada;


public class AgendamentoController {
static final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  private final AgendamentoRepository agendamentoRepository;
  private static long idCounter = 0;

  public AgendamentoController(AgendamentoRepository agendamentoRepository) {
    this.agendamentoRepository = agendamentoRepository;
  }

  public Agendamento agendar(String dataString, String nomeString) {
    
    var data = LocalDate.parse(dataString, df);
    while (data.isBefore(LocalDate.now())) {
      System.out.println("Data inválida. Tente novamente.");
      var novaData = CapturadorDeEntrada.capturarString("data");
      data = LocalDate.parse(novaData, df);
    }
    Agendamento agendamento = new Agendamento(data, createID(), nomeString);
    agendamentoRepository.save(agendamento);
    return agendamento;
  }

  public static synchronized String createID() {
    return String.valueOf(++idCounter);
  }

  public List<Agendamento> listarTodosOsAgendamentos(){
    return agendamentoRepository.listarTodos();
  }

  public List<Agendamento> buscarPeloNome(String nome){
    return agendamentoRepository.buscarAgendamentoPeloNome(nome);
  }

  public boolean cancelarAgendamento(Agendamento agendamento) {
    if(!agendamentoRepository.listarTodos().contains(agendamento)) return false;
    agendamentoRepository.remove(agendamento);
    return true;

  }

  public Agendamento buscarAgendamentoPeloID(String id) {
    return agendamentoRepository.buscarPorId(id);
  }
}
