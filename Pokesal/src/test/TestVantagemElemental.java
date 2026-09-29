package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import pokesal.Batalha;
import pokesal.Pokesal;
import pokesal.Treinador;
import pokesal.TipoElemen;

public class TestVantagemElemental {

    @Test
    public void testVantagemElemental() {

        TipoElemen tipo = new TipoElemen();

        Pokesal atacante = new Pokesal(
                100, 50, 40, 50, 100,
                tipo.getPlanta(),
                "BulbaSal",
                false,
                false
        );

        Pokesal defensor = new Pokesal(
                100, 40, 20, 40, 100,
                tipo.getAgua(),
                "SquirtSal",
                false,
                false
        );

        Treinador treinador1 =
                new Treinador("Treinador 1", atacante);

        Treinador treinador2 =
                new Treinador("Treinador 2", defensor);

        Batalha batalha =
                new Batalha(treinador1, treinador2, new Scanner(""));

        // Evita que o teste dependa de sorte
        batalha.random = new java.util.Random() {
            @Override
            public int nextInt(int bound) {
                return 50;
            }
        };

        batalha.atacar(treinador1, treinador2);

        // Dano = (50 - 20/2) * 2 = 80
        // HP = 100 - 80 = 20
        assertEquals(20, defensor.getHp());
    }
}