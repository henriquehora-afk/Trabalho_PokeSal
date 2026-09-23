package pokesal;

import java.util.Random;
import java.util.Scanner;

/**
 * Classe para realização da batalha.
 */
public class Batalha {

  Random random = new Random();
  Scanner sc;

  private Treinador treinador1;
  private Treinador treinador2;
  private Terreno terreno;

  /**
   * Construtor para iniciar a batalha.
   *
   * @param treinador1 inicia o treinador 1.
   * @param treinador2 inicia o treinador 2.
   * @param sc inicia o scanner.
   */
  public Batalha(Treinador treinador1, Treinador treinador2, Scanner sc) {
    this.treinador1 = treinador1;
    this.treinador2 = treinador2;
    this.sc = sc;
    escolherTerreno();
  }

  /**
   * Metodo para inicar a batalha.
   */
  public void iniciarBatalha() {
    Pokesal pokesal1 = treinador1.getPokesal();
    Pokesal pokesal2 = treinador2.getPokesal();

    System.out.println("A BATALHA COMEÇOOOU!!!");
    System.out.println(treinador1.getNome() + " jogou: " + pokesal1.getNome());
    System.out.println(treinador2.getNome() + " jogou: " + pokesal2.getNome());
    System.out.println();

    while (pokesal1.estarVivo() && pokesal2.estarVivo()) {
      executarTurno();
    }

    if (pokesal1.estarVivo()) {
      System.out.println(treinador1.getNome() + " venceu!");
    } else {
      System.out.println(treinador2.getNome() + " venceu!");
    }
  }

  /**
   * Metodo para iniciar o turno.
   */
  public void executarTurno() {
    Pokesal pokesal1 = treinador1.getPokesal();
    Pokesal pokesal2 = treinador2.getPokesal();

    System.out.println("Novo turno");

    if (pokesal1.getSpd() > pokesal2.getSpd()) {
      System.out.println(treinador1.getNome() + " joga primeiro!");
      escolherAcao(treinador1, treinador2, sc);

      if (pokesal2.estarVivo()) {
        if (pokesal2.isParalizado()) {
          System.out.println(pokesal2.getNome() + " ficou paralizado e perdeu o turno!");
        } else {
          escolherAcao(treinador2, treinador1, sc);
        }
      }

    } else {
      System.out.println(treinador2.getNome() + " joga primeiro!");
      escolherAcao(treinador2, treinador1, sc);

      if (pokesal1.estarVivo()) {
        if (pokesal1.isParalizado()) {
          System.out.println(pokesal1.getNome() + " ficou paralizado e perdeu o turno!");
        } else {
          escolherAcao(treinador1, treinador2, sc);
        }
      }
    }

    aplicarQueimadura(pokesal1);
    aplicarQueimadura(pokesal2);
    aplicarEfeitoTerreno(pokesal1);
    aplicarEfeitoTerreno(pokesal2);

    pokesal1.setParalizado(false);
    pokesal2.setParalizado(false);
  }

  /**
   * Metodo para escolher a ação.
   *
   * @param atacante recebe o atacante.
   * @param defensor recebe o defensor.
   * @param sc recebe o scanner.
   */
  public void escolherAcao(Treinador atacante, Treinador defensor, Scanner sc) {
    System.out.println(atacante.getNome() + " escolha sua ação:");
    System.out.println("1 - Atacar");
    System.out.println("2 - Item");

    int opcao = sc.nextInt();

    if (opcao == 1) {
      System.out.println("Sua opção foi atacar!!!");
      atacar(atacante, defensor);
    } else if (opcao == 2) {
      System.out.println("Escolheu utilizar o item!!!");
      escolherItem(atacante);
    } else {
      throw new IllegalArgumentException("Escolha uma opção válida!!!");
    }
  }

  /**
   * Metodo para realizar o ataque.
   *
   * @param atacante recebe o atacante.
   * @param defensor recebe o defensor.
   */
  public void atacar(Treinador atacante, Treinador defensor) {
    Pokesal pokesalAtacante = atacante.getPokesal();
    Pokesal pokesalDefensor = defensor.getPokesal();
    TipoElemen tipo = new TipoElemen();

    int chanceInstakill = random.nextInt(100);

    if (chanceInstakill < 2) {
      pokesalDefensor.danoRecebido(pokesalDefensor.getHp());
      System.out.println(pokesalAtacante.getNome() + " conseguiu um Instakill!!");
      return;
    }

    int dano = pokesalAtacante.getAtk() - (pokesalDefensor.getDef() / 2);

    if (dano < 1) {
      dano = 1;
    }

    if (pokesalAtacante.getTipo().equals(tipo.getFogo())
            && pokesalDefensor.getTipo().equals(tipo.getPlanta())) {
      dano = (int) (dano * 2.0);
      System.out.println("Ataque super efetivo! Fogo tem vantagem contra Planta!");
    } else if (pokesalAtacante.getTipo().equals(tipo.getFogo())
            && pokesalDefensor.getTipo().equals(tipo.getAgua())) {
      dano = (int) (dano * 0.5);
      System.out.println("Ataque pouco efetivo!"
              + " Fogo tem desvantagem contra Agua!");
    } else if (pokesalAtacante.getTipo().equals(tipo.getFogo())
            && pokesalDefensor.getTipo().equals(tipo.getFogo())) {
      dano = (int) (dano * 0.5);
      System.out.println("Ataque pouco efetivo! Fogo tem desvantagem contra Fogo!");
    } else if (pokesalAtacante.getTipo().equals(tipo.getAgua())
            && pokesalDefensor.getTipo().equals(tipo.getFogo())) {
      dano = (int) (dano * 2.0);
      System.out.println("Ataque super efetivo!"
              + " Agua tem vantagem contra Fogo!");
    } else if (pokesalAtacante.getTipo().equals(tipo.getAgua())
            && pokesalDefensor.getTipo().equals(tipo.getPlanta())) {
      dano = (int) (dano * 0.5);
      System.out.println("Ataque pouco efetivo! Agua tem desvantagem contra Planta!");
    } else if (pokesalAtacante.getTipo().equals(tipo.getAgua())
            && pokesalDefensor.getTipo().equals(tipo.getAgua())) {
      dano = (int) (dano * 0.5);
      System.out.println("Ataque pouco efetivo! Agua tem desvantagem contra Agua!");
    } else if (pokesalAtacante.getTipo().equals(tipo.getPlanta())
            && pokesalDefensor.getTipo().equals(tipo.getAgua())) {
      dano = (int) (dano * 2.0);
      System.out.println("Ataque super efetivo! Planta tem vantagem contra Agua!");
    } else if (pokesalAtacante.getTipo().equals(tipo.getPlanta())
            && pokesalDefensor.getTipo().equals(tipo.getFogo())) {
      dano = (int) (dano * 0.5);
      System.out.println("Ataque pouco efetivo! Planta tem desvantagem contra Fogo!");
    } else if (pokesalAtacante.getTipo().equals(tipo.getPlanta())
            && pokesalDefensor.getTipo().equals(tipo.getPlanta())) {
      dano = (int) (dano * 0.5);
      System.out.println("Ataque pouco efetivo! Planta tem desvantagem contra Planta!");
    }

    if (pokesalAtacante.getTipo().equals(tipo.getFogo()) && terreno.getBonusFogo() > 0) {
      dano = (int) (dano * (1 + terreno.getBonusFogo()));
      System.out.println("O Asfalto quente aumentou o dano de Fogo!");
    }

    if (pokesalAtacante.getTipo().equals(tipo.getAgua()) && terreno.getBonusAgua() > 0) {
      dano = (int) (dano * (1 + terreno.getBonusAgua()));
      System.out.println("A Poca de chuva aumentou o dano de Agua!");
    }

    if (dano < 1) {
      dano = 1;
    }

    pokesalDefensor.danoRecebido(dano);

    System.out.println(pokesalAtacante.getNome() + " causou " + dano + " de dano!!!!");
    System.out.println(pokesalDefensor.getNome() + " ficou com " + pokesalDefensor.getHp() + " HP");

    if (pokesalAtacante.getTipo().equals(tipo.getFogo())) {
      int chanceBurn = random.nextInt(100);

      if (chanceBurn < 15) {
        pokesalDefensor.setQueimado(true);
        System.out.println(pokesalDefensor.getNome() + " foi queimado!");
      }
    }

    int chanceDeParalizar = random.nextInt(100);

    if (chanceDeParalizar < 15) {
      pokesalDefensor.setParalizado(true);
      System.out.println(pokesalDefensor.getNome() + " ficou paralizado!");
    }
  }

  /**
   * Metdodo para aplicar a queimadura.
   *
   * @param pokesal recebe um pokesal.
   */
  public void aplicarQueimadura(Pokesal pokesal) {
    if (pokesal.isQueimado() && pokesal.estarVivo()) {
      pokesal.danoRecebido(2);
      System.out.println(pokesal.getNome() + " tomou dois de dano por causa da queimadura!");
      System.out.println(pokesal.getNome() + " ficou com " + pokesal.getHp() + " HP");
    }
  }

  /**
   * Metodo para aplicar o efeito do terreno.
   *
   * @param pokesal recbe o pokesal.
   */
  public void aplicarEfeitoTerreno(Pokesal pokesal) {
    TipoElemen tipo = new TipoElemen();

    if (terreno.getCuraPlanta() > 0 && pokesal.getTipo().equals(tipo.getPlanta())
            && pokesal.estarVivo()) {
      int cura = (int) (pokesal.getHpMax() * terreno.getCuraPlanta());
      pokesal.curarHp(cura);
      System.out.println(pokesal.getNome() + " recuperou " + cura
              + " HP por causa do Canteiro Central!");
      System.out.println(pokesal.getNome() + " ficou com " + pokesal.getHp() + " HP");
    }
  }

  /**
   * Metodo para escolher item.
   *
   * @param treinador recebe o treinador.
   */
  public void escolherItem(Treinador treinador) {
    System.out.println("1 - Potion");
    System.out.println("2 - Super Potion");
    System.out.println("3 - Antídoto");

    int opcao = sc.nextInt();
    Item itemEscolhido = null;

    switch (opcao) {
      case 1:
        itemEscolhido = new Item("Potion", 20);
        break;
      case 2:
        itemEscolhido = new Item("Super Potion", 50);
        break;
      case 3:
        itemEscolhido = new Item("Antídoto", 0);
        break;
      default:
        System.out.println("Item inválido!");
        return;
    }

    if (itemEscolhido.getNomeItem().equals("Antídoto")) {
      if (treinador.getPokesal().isQueimado()) {
        treinador.getPokesal().setQueimado(false);
        System.out.println("Antídoto utilizado!");
        System.out.println(treinador.getPokesal().getNome() + " não está mais queimado!");
      } else {
        System.out.println("O Pokémon não está queimado!");
      }
    } else {
      treinador.usarItem(itemEscolhido);
      System.out.println(itemEscolhido.getNomeItem() + " utilizado!");
      System.out.println(treinador.getPokesal().getNome() + " ficou com "
              + treinador.getPokesal().getHp() + " HP");
    }
  }

  /**
   * Metodo para escolher o terreno.
   */
  public void escolherTerreno() {
    int opcao = random.nextInt(3);

    if (opcao == 0) {
      terreno = new Terreno("Asfalto quente", 0.15, 0, 0);
    } else if (opcao == 1) {
      terreno = new Terreno("Poça de chuva", 0, 0.10, 0);
    } else {
      terreno = new Terreno("Canteiro Central", 0, 0, 0.05);
    }

    System.out.println("Terreno escolhido: " + terreno.getNome());
  }
}