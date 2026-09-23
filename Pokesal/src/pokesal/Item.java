package pokesal;

/**
 * Classe utilizada para criação de Items.
 */
public class Item {
  private String nomeItem;
  private int poderCura;

  /**
   * Construtor para receber o noem do item e o poder de cura.
   *
   * @param poderCura define o poder de cura.
   * @param nomeItem  define o nome do item.
   */
  public Item(String nomeItem, int poderCura) {
    this.nomeItem = nomeItem;
    this.poderCura = poderCura;

  }

  /**
   * Metodo utilizado para referenciar diretamente o podercura com o curar hp do pokesal.
   *
   * @param pokesal determina o poder de cura para p pokesal.
   */
  public void curarHp(Pokesal pokesal) {
    pokesal.curarHp(this.poderCura);

  }

  /**
   * Get do nome do item.
   *
   * @return nome do item.
   */
  public String getNomeItem() {

    return nomeItem;
  }

  /**
   * Get do poder da cura.
   *
   * @return poder da cura.
   */
  public int getPoderCura() {

    return poderCura;
  }
}


