package src.main.java.oo.models;

public class Carta {
    private Tipo tipo;
    private Valor valor;

    private Carta(Tipo tipo, Valor valor) {
        this.tipo = tipo;
        this.valor = valor;
    }
   
    // factory method
    public static Carta criarCarta(Tipo tipo, Valor valor) {
        return new Carta(tipo, valor);
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
