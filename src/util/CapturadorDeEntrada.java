package util;

import java.util.List;
import java.util.Scanner;

public class CapturadorDeEntrada {
  private final static Scanner sc = new Scanner(System.in);

  public static String capturarString(String nomeDoCampo){
    System.out.printf("Informar o(a) %s: \n", nomeDoCampo);
    return sc.nextLine();
  }

  public static String capturarStringDentreOpcoes(String nomeDoCampo, List<String> possibilidades){
    String entrada = capturarString(nomeDoCampo + "[%s].".formatted(possibilidades));
    while(!possibilidades.contains(entrada)){
      System.out.printf("Entrada inválida. Apenas os valores [%s] são aceitos.".formatted(possibilidades));
    }
    return entrada;
  }

  public static void encerrarCapturador(){
    sc.close();
  }
}