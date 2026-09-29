package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import pokesal.Batalha;
import pokesal.Pokesal;
import pokesal.Treinador;
import pokesal.TipoElemen;

public class TestInstakill {

    @Test
    public void testInstakill() {

        TipoElemen tipo = new TipoElemen();

        Pokesal atacante = new Pokesal(
                100, 50, 40, 40, 100,
                tipo.getFogo(),
                "CharSal",
                false,
                false
        );

        Pokesal defensor = new Pokesal(
                100, 40, 40, 30, 100,
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
                new Batalha(
                        treinador1,
                        treinador2,
                        new Scanner("")
                );

        /*
         * Instakill acontece quando:
         *
         * random < 2
         *
         * Retornamos 0.
         */
        batalha.random = new java.util.Random() {
            @Override
            public int nextInt(int bound) {
                return 0;
            }
        };

        batalha.atacar(treinador1, treinador2);

        assertEquals(0, defensor.getHp());
        assertFalse(defensor.estarVivo());
    }
}