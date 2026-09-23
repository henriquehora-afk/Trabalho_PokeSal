package pokesal;

/**
 * Classe utilizada para representar o terreno da batalha.
 */
public class Terreno {

    private String nome;
    private double bonusFogo;
    private double bonusAgua;
    private double curaPlanta;

    /**
     * Construtor para inicar os terrnos.
     *
     * @param nome       define o nome.
     * @param bonusFogo  define o bonus do fog.
     * @param bonusAgua  define o bonus da agua.
     * @param curaPlanta define a cura da planta.
     */
    public Terreno(String nome, double bonusFogo, double bonusAgua, double curaPlanta) {

        this.nome = nome;
        this.bonusFogo = bonusFogo;
        this.bonusAgua = bonusAgua;
        this.curaPlanta = curaPlanta;
    }

    /**
     * Get do nome.
     *
     * @return nome.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Get do bonus do fogo.
     *
     * @return bonus do fogo.
     */
    public double getBonusFogo() {
        return bonusFogo;
    }

    /**
     * Get do bonus da agua.
     *
     * @return bonus da agua.
     */
    public double getBonusAgua() {
        return bonusAgua;
    }

    /**
     * Get da cura da planta..
     *
     * @return cura da planta.
     */
    public double getCuraPlanta() {
        return curaPlanta;
    }
}
