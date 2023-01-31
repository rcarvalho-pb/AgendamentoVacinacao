package view;

import util.CapturadorDeEntrada;

public class MenuEncerrar extends MenuAbstrato{

  public MenuEncerrar() {
    super("ENCERRAR");
  }

  @Override
  protected void acao() {
    CapturadorDeEntrada.encerrarCapturador();
    System.exit(0);
    
  }

  
}
