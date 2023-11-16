package src.main.java.oo.models;

import java.util.ArrayList;

public class Mao {

    private ArrayList<Carta> mao;

    public Mao() {
        mao = new ArrayList<Carta>();

    }

    public void pegarCartaDoBaralho(Baralho baralho) {
        mao.add(baralho.pegarCarta());
    }

    // somar o valor das cartas na mao
    public int calcularValor() {
        int valor = 0;
        int contagemAs = 0;

        for (Carta carta : mao) {
            valor += carta.getValor().valor;
            if (carta.getValor().valor == 11) {
                contagemAs++;
            }
        }

        // Se possuir um Às e o valor for maior que 21
        // O As passa a valer 1
        if (valor > 21 && contagemAs > 0) {
            while (contagemAs > 0 && valor > 21) {
                contagemAs--;
                valor -= 10;

            }

        }
        return valor;
    }

    public Carta getCarta(int indice) {
        return mao.get(indice);
    }

    public void devolverCartasProBaralho(Baralho baralhoDescarte) {
        baralhoDescarte.addCartas(mao);

        mao.clear();
    }

    public int size() {
        return this.mao.size();
    }

    public String toString() {
        String saida = "";
        for (Carta carta : mao) {
            saida += carta + "\n";

        }
        return saida;
    }

}
