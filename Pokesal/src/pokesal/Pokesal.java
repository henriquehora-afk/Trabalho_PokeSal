package pokesal;

/**
 * Representa um Pokesal com seus atributos de batalha.
 */
public class Pokesal {

  private String nome;
  private int hp;
  private int atk;
  private int def;
  private int spd;
  private int hpMax;
  private String tipo;
  private boolean queimado;
  private boolean paralizado;

  /**
   * Cria um Pokesal.
   *
   * @param hp    pontos de vida atuais
   * @param atk   pontos de ataque
   * @param def   pontos de defesa
   * @param spd   velocidade
   * @param hpMax pontos de vida máximos
   * @param tipo  tipo elemental
   * @param nome  nome do Pokesal
   */
  public Pokesal(int hp, int atk, int def, int spd, int hpMax, String tipo, String nome, boolean queimado,
                   boolean paralizado) {
    this.hp = hp;
    this.atk = atk;
    this.def = def;
    this.spd = spd;
    this.hpMax = hpMax;
    this.tipo = tipo;
    this.nome = nome;
    this.queimado = queimado;
    this.paralizado = paralizado;
  }

  /**
   * Retorna os pontos de vida atuais.
   *
   * @return pontos de vida
   */
  public int getHp() {

    return hp;
  }

  /**
   * Altera os pontos de vida.
   *
   * @param hp novos pontos de vida
   */
  public void setHp(int hp) {
        this.hp = hp;
    }

  /**

   * Retorna o ataque.
   *
   * @return ataque
   */
  public int getAtk() {
        return atk;
    }

  /**
   * Altera o ataque.
   *
   * @param atk novo ataque
   */
  public void setAtk(int atk) {
        this.atk = atk;
    }

  /**
   * Retorna a defesa.
   *
   * @return defesa
   */
  public int getDef() {
        return def;
    }


  /**
   * Altera a defesa.
   *
   * @param def nova defesa
   */
  public void setDef(int def) {
        this.def = def;
    }

  /**
   * Retorna a velocidade.
   *
   * @return velocidade
   */
  public int getSpd() {
        return spd;
    }

  /**
   * Altera a velocidade.
   *
   * @param spd nova velocidade
   */
  public void setSpd(int spd) {
        this.spd = spd;
    }

  /**
   * Retorna os pontos de vida máximos.
   *
   * @return pontos de vida máximos
   */
  public int getHpMax() {
        return hpMax;
    }

  /**
   * Altera os pontos de vida máximos.
   *
   * @param hpMax novos pontos de vida máximos.
   */
  public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    /**
     * Retorna o tipo elemental.
     *
     * @return tipo elemental
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Altera o tipo elemental.
     *
     * @param tipo novo tipo elemental
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna o nome do Pokesal.
     *
     * @return nome do Pokesal
     */
    public String getNome() {
        return nome;
    }

    /**
     * Altera o nome do Pokesal.
     *
     * @param nome novo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Aplica dano ao Pokesal.
     *
     * @param dano quantidade de dano recebido
     */
    public void danoRecebido(int dano) {
        hp -= dano;

        if (hp < 0) {
            hp = 0;
        }
    }

    /**
     * Recupera pontos de vida do Pokesal.
     *
     * @param quantidade quantidade de vida recuperada
     */
    public void curarHp(int quantidade) {
        hp += quantidade;

        if (hp > hpMax) {
            hp = hpMax;
        }
    }

    /**
     * Verifica se o Pokesal ainda está vivo.
     *
     * @return true se estiver vivo
     */
    public boolean estarVivo() {
        return hp > 0;
    }

    public boolean isQueimado() {
        return queimado;
    }

    public void setQueimado(boolean queimado) {
        this.queimado = queimado;
    }

    public boolean isParalizado() {
        return paralizado;
    }

    public void setParalizado(boolean paralizado) {
        this.paralizado = paralizado;
    }

}
