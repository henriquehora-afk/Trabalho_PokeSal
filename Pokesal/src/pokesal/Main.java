package pokesal;

import java.util.Scanner;

/**
 * Classe main para rodar o programa.
 */
public class Main {
  /**
   * Mrtodo main para rodar o programa.
   *
   * @param args para receber dados digitados pelo usuario.
   */
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    TipoElemen tipo = new TipoElemen();

    System.out.println("BEM-VINDO AO POKESAL");
    System.out.println();

    Pokesal bulbaSal = new Pokesal(100, 45, 40, 35, 100, tipo.getPlanta(),
            "BulbaSal", false, false);
    Pokesal charSal = new Pokesal(95, 50, 35, 50, 95, tipo.getFogo(),
            "CharSal", false, false);
    Pokesal squirtSal = new Pokesal(105, 40, 50, 30, 105, tipo.getAgua(),
            "SquirtSal", false, false);
    Pokesal chikoSal = new Pokesal(100, 40, 45, 45, 100, tipo.getPlanta(),
            "ChikoSal", false, false);
    Pokesal cyndaSal = new Pokesal(90, 55, 30, 55, 90, tipo.getFogo(),
            "CyndaSal", false, false);
    Pokesal totoSal = new Pokesal(105, 45, 45, 40, 105, tipo.getAgua(),
            "TotoSal", false, false);
    System.out.println("TREINADOR 1");
    System.out.print("Digite seu nome: ");
    String nome1 = sc.nextLine();

    Pokesal escolhido1 = escolherPokesal(sc, bulbaSal, charSal, squirtSal,
            chikoSal, cyndaSal, totoSal);
    Treinador treinador1 = new Treinador(nome1, escolhido1);

    System.out.println();
    System.out.println("TREINADOR 2");
    System.out.print("Digite seu nome: ");
    String nome2 = sc.nextLine();

    Pokesal escolhido2 = escolherPokesal(sc, bulbaSal, charSal, squirtSal,
            chikoSal, cyndaSal, totoSal);
    Treinador treinador2 = new Treinador(nome2, escolhido2);

    Batalha batalha = new Batalha(treinador1, treinador2, sc);
    batalha.iniciarBatalha();

  }

  /**
   * Metodo para o jogador escolher o pokesal.
   *
   * @param sc recebe o scanner.
   * @param bulbaSal recbe um pokesal.
   * @param charSal recbe um pokesal.
   * @param squirtSal recbe um pokesal.
   * @param chikoSal recbe um pokesal.
   * @param cyndaSal recbe um pokesal.
   * @param totoSal recbe um pokesal.
   * @return retrona o pokesal escolhido.
   */
  public static Pokesal escolherPokesal(Scanner sc, Pokesal bulbaSal, Pokesal charSal,
                                        Pokesal squirtSal,
                                          Pokesal chikoSal, Pokesal cyndaSal, Pokesal totoSal) {

    while (true) {

      System.out.println();
      System.out.println("ESCOLHA SEU POKESAL");
      System.out.println("1 - BulbaSal [Planta]");
      System.out.println("2 - CharSal [Fogo]");
      System.out.println("3 - SquirtSal [Agua]");
      System.out.println("4 - ChikoSal [Planta]");
      System.out.println("5 - CyndaSal [Fogo]");
      System.out.println("6 - TotoSal [Agua]");
      System.out.print("Opcao: ");

      int opcao = sc.nextInt();
      sc.nextLine();

      if (opcao == 1) {
        return bulbaSal;
      } else if (opcao == 2) {
        return charSal;
      } else if (opcao == 3) {
        return squirtSal;
      } else if (opcao == 4) {
        return chikoSal;
      } else if (opcao == 5) {
        return cyndaSal;
      } else if (opcao == 6) {
        return totoSal;
      } else {
        System.out.println("Opcao invalida! Escolha de 1 a 6.");
      }
    }
  }
}