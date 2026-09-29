package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;
import org.junit.jupiter.api.Test;
import pokesal.Batalha;
import pokesal.Pokesal;
import pokesal.TipoElemen;
import pokesal.Treinador;

/**
 * Classe para testar o dano.
 */
public class TestDanoBoundary {

  @Test
  public void testCalculoDanoBoundaryValues() {

    TipoElemen tipo = new TipoElemen();

    Pokesal atacante = new Pokesal(
          100, 0, 100, 40, 100,
          tipo.getPlanta(),
          "Atacante",
          false,
          false
    );

    Pokesal defensor = new Pokesal(
          100, 40, 100, 30, 100,
          tipo.getPlanta(),
          "Defensor",
          false,
          false
    );

    Treinador treinador1 =
          new Treinador("Treinador 1", atacante);

    Treinador treinador2 =
          new Treinador("Treinador 2", defensor);

    Batalha batalha =
          new Batalha(
            treinador1,
            treinador2,
            new Scanner("")
          );

    batalha.random = new java.util.Random() {
      @Override
      public int nextInt(int bound) {
        return 50;
      }
    };

    batalha.atacar(treinador1, treinador2);

    assertEquals(99, defensor.getHp());
  }
}