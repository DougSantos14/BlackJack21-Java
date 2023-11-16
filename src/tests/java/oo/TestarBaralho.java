package src.tests.java.oo;

import src.main.java.oo.models.Baralho;
import src.main.java.oo.models.Carta;
import src.main.java.oo.models.Tipo;
import src.main.java.oo.models.Valor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestarBaralho {

    @Test
    public void testCriarCarta() {
        Carta carta = Carta.criarCarta(Tipo.C, Valor.DOIS);
        assertEquals(Tipo.C, carta.getTipo());
        assertEquals(Valor.DOIS, carta.getValor());
    }

    @Test
    public void testAddCarta() {
        Baralho baralho = new Baralho(false);
        Carta carta = Carta.criarCarta(Tipo.C, Valor.DOIS);
        baralho.addCarta(carta);
        assertEquals(1, baralho.getCartas().size());
        assertEquals(carta, baralho.getCartas().get(0));
    }

    @Test
    public void testBaralho() {
        Baralho baralho = new Baralho(true);
        assertEquals(52, baralho.cartasRestantes());
    }

    @Test
    public void testPegarCarta() {
        Baralho baralho = new Baralho(true);
        Carta carta = baralho.pegarCarta();
        assertNotNull(carta);
        assertEquals(51, baralho.cartasRestantes());
    }

}