package persistence;

import java.util.List;

import model.Agendamento;

public class AgendamentoRepositoryEmMemoria extends AbstractRepository<Agendamento> implements AgendamentoRepository {

  @Override
  public List<Agendamento> buscarAgendamentoPeloNome(String nome) {
    return entidades.stream()
                    .filter(p -> p.getNome().toLowerCase().contains(nome))
                    .toList();
  }
  
}
