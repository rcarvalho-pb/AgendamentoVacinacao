package view;

import controller.AgendamentoController;

public class MenuAgendamentoFactory implements MenuFactory {
  private final AgendamentoController agendamentoController;

  public MenuAgendamentoFactory(AgendamentoController agendamentoController){
    this.agendamentoController = agendamentoController;
    
  }

  @Override
  public Menu create() {
    MenuComSubmenus menuAgendamento = new MenuAgendamento();

    MenuEncerrar menuEncerrar = new MenuEncerrar();
    menuAgendamento.adicionarSubmenus(menuEncerrar);

    MenuAgendar menuAgendar = new MenuAgendar(agendamentoController);
    menuAgendamento.adicionarSubmenus(menuAgendar);

    MenuBuscarAgendamentoPeloID menuBuscarAgendamento = new MenuBuscarAgendamentoPeloID(agendamentoController);
    menuAgendamento.adicionarSubmenus(menuBuscarAgendamento);

    MenuListarAgendamento menuListarAgendamento = new MenuListarAgendamento(agendamentoController);
    menuAgendamento.adicionarSubmenus(menuListarAgendamento);

    MenuCancelarAgendamento menuCancelarAgendamento = new MenuCancelarAgendamento(agendamentoController);
    menuAgendamento.adicionarSubmenus(menuCancelarAgendamento);

             
    return menuAgendamento;    
  }
  
}
