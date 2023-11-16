package src.main.java.oo.models;

public class Placar {

    private String nomeJogador;
    private String nomeJogador2;

    public Placar(String nomeJogador, String nomeJogador2) {
        this.nomeJogador = nomeJogador;
        this.nomeJogador2 = nomeJogador2;

    }

    public void exibirResultado(int vitoriasJogador1, int vitoriasJogador2, int empates) {

        System.out.println("..................................................................");
        System.out.println("|                               Placar                           |");
        System.out.println("..................................................................");
        System.out.println("| Vencer uma Rodada ganha 1 ponto. Derrota ou empate dá 0 pontos.|");
        System.out.println("  Vitorias do Jogador(a) " + nomeJogador + ": " + vitoriasJogador1 + " vitorias/pontos.");
        System.out.println("  Vitorias do Jogador(a) " + nomeJogador2 + ": " + vitoriasJogador2 + " vitorias/pontos.");
        System.out.println("  Empates: " + empates);
        
    }

}
