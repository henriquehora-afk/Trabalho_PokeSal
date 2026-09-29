package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;
import org.junit.jupiter.api.Test;
import pokesal.Batalha;
import pokesal.Pokesal;
import pokesal.TipoElemen;
import pokesal.Treinador;

/**
 * Classe para testar a ordem de ataque.
 */
public class TestOrdemDeAtaque {

  @Test
  public void testOrdemDeAtaquePorVelocidade() {

    TipoElemen tipo = new TipoElemen();

    Pokesal lento = new Pokesal(
         50, 100, 0, 20, 50,
         tipo.getPlanta(),
         "Lento",
         false,
         false
    );

    Pokesal rapido = new Pokesal(
          50, 100, 0, 40, 50,
          tipo.getPlanta(),
          "Rapido",
          false,
          false
    );

    Treinador treinador1 =
          new Treinador("Lento", lento);

    Treinador treinador2 =
          new Treinador("Rapido", rapido);

    Batalha batalha =
            new Batalha(
            treinador1,
            treinador2,
            new Scanner("1\n1\n")
    );

    batalha.random = new java.util.Random() {
      @Override
    public int nextInt(int bound) {
        return 50;
        }
    };

    batalha.executarTurno();

    assertEquals(0, lento.getHp());
  }
}