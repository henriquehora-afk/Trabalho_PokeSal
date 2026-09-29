package test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import pokesal.Item;
import pokesal.Pokesal;
import pokesal.TipoElemen;
import pokesal.Treinador;

/**
 * Classe para testar o limite de itens.
 */
public class TestLimiteItens {

  @Test
  public void testUsoLimiteDeItensExcedido() {

    TipoElemen tipo = new TipoElemen();

    Pokesal pokesal = new Pokesal(
          50, 40, 40, 40, 100,
          tipo.getPlanta(),
          "BulbaSal",
          false,
          false
    );

    Treinador treinador =
          new Treinador("Treinador", pokesal);

    Item item1 = new Item("Potion", 20);
    Item item2 = new Item("Potion", 20);
    Item item3 = new Item("Potion", 20);

    treinador.usarItem(item1);
    treinador.usarItem(item2);

    assertThrows(
          IllegalStateException.class,
          () -> treinador.usarItem(item3)
    );
  }
}