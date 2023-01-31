package persistence;

import java.util.List;

import model.Agendamento;

public interface AgendamentoRepository extends Repository<Agendamento> {
  List<Agendamento> buscarAgendamentoPeloNome(String nome);
}
