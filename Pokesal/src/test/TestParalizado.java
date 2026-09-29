package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import pokesal.Batalha;
import pokesal.Pokesal;
import pokesal.TipoElemen;
import pokesal.Treinador;

/**
 * Classe para testar o segundo requisito autoral paralisado.
 */
public class TestParalizado {

  @Test
  public void testParalizado() {

    TipoElemen tipo = new TipoElemen();

    Pokesal atacante = new Pokesal(
        100, 40, 40, 40, 100,
        tipo.getAgua(),
        "SquirtSal",
        false,
        false
    );

    Pokesal defensor = new Pokesal(
        100, 40, 40, 30, 100,
        tipo.getFogo(),
        "CharSal",
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

    batalha.random = new Random() {

      private int contador = 0;

      @Override
      public int nextInt(int bound) {

        contador++;

        if (contador == 1) {
            return 50;
        }

            return 0;
      }
    };

    batalha.atacar(treinador1, treinador2);

    assertTrue(defensor.isParalizado());
  }
}