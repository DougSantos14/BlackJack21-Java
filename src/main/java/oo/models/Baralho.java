package src.main.java.oo.models;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Baralho {

    private ArrayList<Carta> baralho;

    // inicializando lista vazia
    public Baralho() {
        baralho = new ArrayList<Carta>();

    }

    // cria o baralho com base nos tipo e valores possiveis
    public Baralho(boolean criarBaralho) {
        baralho = new ArrayList<Carta>();
        if (criarBaralho) {

            for (Tipo tipo : Tipo.values()) {
                for (Valor valor : Valor.values()) {
                    baralho.add(Carta.criarCarta(tipo, valor));

                }
            }
        }
    }

    public void addCarta(Carta carta) {
        baralho.add(carta);
    }

    public void Embaralhar() {
        Collections.shuffle(baralho, new Random());
    }

    // pegar a primeira carta do baralho
    public Carta pegarCarta() {
        Carta cartaEscolhida = Carta.novaCarta(baralho.get(0));
        baralho.remove(0);
        return cartaEscolhida;
    }

    public boolean temCartas() {
        return !baralho.isEmpty();
    }

    public void addCartas(ArrayList<Carta> cartas) {
        baralho.addAll(cartas);
    }

    public int cartasRestantes() {
        return baralho.size();
    }

    // esvaziar o baralho
    public void baralhoVazio() {
        baralho.clear();
    }

    public void reporBaralhoUsandoDescartes(Baralho descarte) {
        this.addCartas(descarte.getCartas());
        this.Embaralhar();
        descarte.baralhoVazio();
        System.out.println("Acabaram as cartas, montando outro baralho com as cartas que foram descartadas.");

    }

    public ArrayList<Carta> getCartas() {
        return baralho;
    }

    public String toString() {
        String saida = "";

        for (Carta carta : baralho) {
            saida += carta;
            saida += "\n";
        }
        return saida;
    }
}
