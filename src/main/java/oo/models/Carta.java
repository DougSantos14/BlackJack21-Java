package src.main.java.oo.models;

public class Carta {
    private Tipo tipo;
    private Valor valor;

    private Carta(Tipo tipo, Valor valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    // criar uma carta a partir de uma carta existente
    private Carta(Carta carta) {
        this.tipo = carta.getTipo();
        this.valor = carta.getValor();
    }

    // factory method
    public static Carta criarCarta(Tipo tipo, Valor valor) {
        return new Carta(tipo, valor);
    }

    // factory method
    public static Carta novaCarta(Carta carta) {
        return new Carta(carta);

    }

    public Tipo getTipo() {
        return tipo;
    }

    public Valor getValor() {
        return valor;
    }

    // metodo para string da carta levando em conta as especifidades das carta AJQK
    public String toString() {
        String valorCarta;
        switch (valor) {
            case A:
                valorCarta = "A";
                break;
            case J:
                valorCarta = "J";
                break;
            case Q:
                valorCarta = "Q";
                break;
            case K:
                valorCarta = "K";
                break;
            default:
                valorCarta = String.valueOf(valor.valor);

        }
        return valorCarta + "-" + tipo;
    }

}
