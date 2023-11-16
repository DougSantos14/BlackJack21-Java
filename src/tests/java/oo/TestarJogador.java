package src.tests.java.oo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.main.java.oo.models.Baralho;
import src.main.java.oo.models.Jogador;

public class TestarJogador {

    @Test
    public void testJogadorCriado() {
        Jogador jogador = new Jogador("Teste");
        assertEquals("Teste", jogador.getNome());
    }

    @Test
    public void testPegarCarta() {
        Jogador jogador = new Jogador("Teste");
        Baralho baralho = new Baralho(true);
        jogador.getMao().pegarCartaDoBaralho(baralho);
        assertEquals(1, jogador.getMao().size());
    }

}