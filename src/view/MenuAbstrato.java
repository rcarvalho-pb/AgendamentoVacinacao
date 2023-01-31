package view;

public abstract class MenuAbstrato implements Menu{
  
  protected final String descricao;

  public MenuAbstrato(String descricao){
    this.descricao = descricao;
  }

  @Override
  public void exibir(){
    System.out.println(descricao);
  }

  @Override
  public void agir(){
    exibirComSeparador();
    acao();

  }

  protected abstract void acao();

  public void exibirComSeparador(){
    exibirSeparador();
    exibir();
    exibirSeparador();
  }

  public void exibirSeparador(){
    System.out.println("---------------------");
  }
}
