package view;

import java.util.HashMap;
import java.util.Map;

import util.CapturadorDeEntrada;

public class MenuComSubmenus extends MenuAbstrato {
  private Map<String, Menu> submenus = new HashMap<>();

  public MenuComSubmenus(String descricao) {
    super(descricao);
  }

  @Override
  protected void acao() {
    exibirSubmenus();
    Menu menu = selecionarSubmenu();
    menu.agir();    
        
  }

  private void exibirSubmenus(){
    for (int i = 1; i < submenus.size(); i++){
      System.out.printf("%s. ", i);
      Menu menu = submenus.get(String.valueOf(i));
      menu.exibir();

    }
    System.out.print("0. ");
    submenus.get("0").exibir();
  }

  private Menu selecionarSubmenu(){
    String menuSelecionado = CapturadorDeEntrada.capturarString("MENU");
    Menu menu = submenus.get(menuSelecionado);

    while(menu == null){
      System.out.printf("Menu informado %s inválido, selecione um outro menu.".formatted(menuSelecionado));
      menuSelecionado = CapturadorDeEntrada.capturarString("MENU");
      menu = submenus.get(menuSelecionado);
    }
    return menu;
  }

  public void adicionarSubmenus(Menu menu){

    submenus.put(String.valueOf(submenus.size()), menu);
  }
}
