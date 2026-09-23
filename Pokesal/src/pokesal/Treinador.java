package pokesal;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que mostra as mecanicas dos treinadores.
 */
public class Treinador {

    private final int CURA_POTION = 20;
    private final int CURA_SUPERPOTION = 50;
    private int itemUsados = 0;
    private String nome;
    private Pokesal pokesal;
    private List<Item> mochila;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pokesal getPokesal() {
        return pokesal;
    }

    public Treinador(String nome, Pokesal pokesal) {
        this.nome = nome;
        this.pokesal = pokesal;
        this.mochila = new ArrayList<>();
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
            this.mochila.remove(itemEscolhido);
            itemEscolhido.curarHp(this.pokesal);

        }

    }
}
