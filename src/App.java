import controller.AgendamentoController;
import persistence.AgendamentoRepository;
import persistence.AgendamentoRepositoryEmMemoria;
import view.Menu;
import view.MenuAgendamentoFactory;

public class App {
  public static void main(String[] args) {

    AgendamentoRepository agendamentoRepository = new AgendamentoRepositoryEmMemoria();
    AgendamentoController agendamentoController = new AgendamentoController(agendamentoRepository);
    Menu menuAgendamentoFactory = new MenuAgendamentoFactory(agendamentoController).create();
    
    menuAgendamentoFactory.agir();
  }
}