package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import pokesal.Batalha;
import pokesal.Pokesal;
import pokesal.Terreno;
import pokesal.Treinador;
import pokesal.TipoElemen;

public class TestEfeitoTerreno {

    @Test
    public void testEfeitoTerrenoEstacionamentoUCSal() {

        TipoElemen tipo = new TipoElemen();

        Pokesal pokesal = new Pokesal(
                50, 40, 40, 40, 100,
                tipo.getPlanta(),
                "BulbaSal",
                false,
                false
        );

        Pokesal outro = new Pokesal(
                100, 40, 40, 40, 100,
                tipo.getAgua(),
                "SquirtSal",
                false,
                false
        );

        Treinador treinador1 =
                new Treinador("Treinador 1", pokesal);

        Treinador treinador2 =
                new Treinador("Treinador 2", outro);

        Batalha batalha =
                new Batalha(treinador1, treinador2, new Scanner(""));

        Terreno terreno =
                new Terreno("Canteiro Central", 0, 0, 0.05);

        batalha.terreno = terreno;

        batalha.aplicarEfeitoTerreno(pokesal);

        // 5% de 100 = 5
        // 50 + 5 = 55
        assertEquals(55, pokesal.getHp());
    }
}
