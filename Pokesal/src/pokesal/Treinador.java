package pokesal;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que mostra as mecanicas dos treinadores.
 */
public class Treinador {

  private int itemUsados = 0;
  private String nome;
  private Pokesal pokesal;

  /**
   * Construtor para iniciar o treinador.
   *
   * @param nome recebe o nome.
   * @param pokesal recebe o pokesal escolhido.
   */
  public Treinador(String nome, Pokesal pokesal) {
    this.nome = nome;
    this.pokesal = pokesal;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Pokesal getPokesal() {
    return pokesal;
  }

  /**
   * Metodo que explica o uso de item e o limite dele por batalha.
   *
   * @param itemEscolhido pelo treinador para ser utilizado na batalha.
   */
  public void usarItem(Item itemEscolhido) {
    if (itemUsados >= 2) {
      throw new IllegalStateException("Limite de items usados foi atingido!!");
    } else {
      itemUsados++;
      itemEscolhido.curarHp(this.pokesal);

    }

  }
}
